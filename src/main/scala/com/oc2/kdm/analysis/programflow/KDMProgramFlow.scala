package com.oc2.kdm.analysis.programflow

import com.oc2.kdm.action.{ActionElement, BlockUnit}
import com.oc2.kdm.analysis.common.{ActionElementVisitor, CompilationUnitVisitor, Params, Tools}
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit, StorableUnit}
import com.oc2.kdm.analysis.graphs.{ConcreteDirectedGraph, GraphTypes}
import com.oc2.kdm.kdm.Segment
import org.eclipse.emf.common.util.EList

import scala.util.matching.Regex

class KDMProgramFlow {

  val graph: ConcreteDirectedGraph = new ConcreteDirectedGraph
  var nCurrent: graph.NodeImpl = graph.addNode()
  var callables: Option[Seq[CallableUnit]] = None
  var g_printStatments: Regex = """""".r
  var g_printCodeBoxes = false

  def execute(kdmNaturalModel: Segment, printSubprograms:Boolean, printStatments: Regex, printCodeBoxes: Boolean): ConcreteDirectedGraph = {
    g_printStatments = printStatments
    g_printCodeBoxes = printCodeBoxes

    /** Obtención del KDM los StorableUnit y ActionElement de nivel "root" */
    val codeElement: EList[AbstractCodeElement] = CompilationUnitVisitor.visit(kdmNaturalModel).head.getCodeElement
    val storables: Seq[StorableUnit] = Tools.getStorableUnits(codeElement)
    storables.head
    val actions: Seq[ActionElement] = Tools.getActionElements(codeElement).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
    actions.head
    callables = Tools.getCallableElements(codeElement)
    genFlowGraph(actions)
    if (printSubprograms)
      addCallables(callables)
    graph.name = kdmNaturalModel.getName.substring(0,kdmNaturalModel.getName.indexOf(".")).concat("_PF")
    graph
  }
  def execute(actions: Seq[ActionElement], printStatments: Regex): ConcreteDirectedGraph = {
    g_printStatments = printStatments
    genFlowGraph(actions)
    graph
  }

  class levelNodes{
    var nCode: graph.Node = _
    var nElse: graph.Node = _
    var nOutput: graph.Node = _
    var nInput: graph.Node = _
  }

  def genFlowGraph(actions: Seq[ActionElement]): Unit = {
    // Creación del Nodo Inicial
    val initial = nCurrent
    nCurrent = graph.addNode()
    initial.nodeType = GraphTypes.INITIAL
    initial.nodeName = "Initial"
    initial.connectWith(nCurrent,GraphTypes.EDGE_TRUE)

    nodeLoop(actions)
  }

  def addCallables(callables: Option[Seq[CallableUnit]]):Unit = {
    val c = callables.get

    c.foreach{ x =>
      nCurrent = graph.addNode()
      val level_1 = new levelNodes()
      level_1.nInput = nCurrent
      level_1.nInput.nodeName=x.getName

      val actions = Tools.getActionElements(x.getCodeElement).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
      genFlowGraph(actions)
    }
  }

  def nodeLoop(actionElements: Seq[ActionElement]): Unit = {
    actionElements.foreach{ x =>
      val internalActions = ActionElementVisitor.visit(x)
//      if (internalActions != null && internalActions.nonEmpty && internalActions.filter(_.getName!=null).exists(_.getName.matches(g_printStatments.regex)) || x.getName.matches(g_printStatments.regex)) {

        val level_1 = new levelNodes()
        level_1.nInput = nCurrent
        level_1.nOutput = graph.addNode()
        nCurrent = logic(x, level_1)
//      }
    }
    val ending = graph.addNode()
    ending.nodeType = GraphTypes.ENDING
    ending.nodeName = "Ending"
    nCurrent.connectWith(ending,GraphTypes.EDGE_TRUE)

  }

  def loop(actionElements: Seq[ActionElement], nNode: levelNodes, hasElse: Boolean): graph.Node = {
    if (hasElse){
      nCurrent = nNode.nElse
    }else{
      nCurrent = nNode.nCode
    }
    actionElements.foreach{ x =>
      val internalActions = ActionElementVisitor.visit(x)
      if (internalActions != null && internalActions.nonEmpty && internalActions.filter(_.getName!=null).exists(_.getName.matches(g_printStatments.regex))) {
        val level_loop = new levelNodes()
        level_loop.nInput = nCurrent
        level_loop.nOutput = graph.addNode()
        nCurrent = logic(x, level_loop)
      }
    }
    nCurrent
  }

  def logic(x: ActionElement, nNode: levelNodes): graph.Node = {

    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.matches(Params.CALLS.regex)) {
      nodoCall(x, nNode)
    }
    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.equals("INPUT")) {
      nNode.nCode = graph.addNode()
      nNode.nCode.nodeType = GraphTypes.INPUT
      nNode.nCode.nodeName = x.getName
      nNode.nCode.nodeCode = x.getSource.get(0).getSnippet
    }
    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.equals("REPEAT")) {
      nNode.nCode = graph.addNode()
      nNode.nInput.nodeType = GraphTypes.REPEAT
      nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
      nNode.nCode = loop(internalConditions, nNode, hasElse = false)
      nNode.nCode.connectWith(nNode.nOutput, GraphTypes.EDGE_TRUE)
      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.EDGE_TRUE)
    }
    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.equals("FOR")) {
      nNode.nCode = graph.addNode()
      nNode.nInput.nodeType = GraphTypes.FOR
      nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
      nNode.nCode = loop(internalConditions, nNode, hasElse = false)
      nNode.nCode.nodeType = GraphTypes.CODE
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.EDGE_TRUE)
    }
    // Gestión de ciclos IF
    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.equals("IF")) {
      // Cálculo de parámetros y propiedades del if.
      val bu: Seq[BlockUnit] = Tools.getBlockUnits(x.getCodeElement)
      val aeParenthesis: ActionElement = Tools.getActionElements(x.getCodeElement).head
      val ae: Seq[ActionElement] = Tools.getActionElements(aeParenthesis.getCodeElement)
      var hasElse: Boolean = false
      if (ae.nonEmpty) hasElse = bu.size == ae.size + 1

      // Creación del Nodo y sus atributos.
      nNode.nCode = graph.addNode()
      //TODO Snippet de IF
      if (x.getSource.get(0).getSnippet.contains("\n")){
        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet.substring(0, x.getSource.get(0).getSnippet.indexOf("\n"))
      }else{
        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet
      }
      nNode.nInput.nodeType = GraphTypes.IF

      //RUTA PRINCIPAL del IF.
      val internalConditions: Seq[ActionElement] = bu.head.getCodeElement.toArray.toSeq.asInstanceOf[Seq[ActionElement]].filter(_.getKind.matches("statement")).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
      val hasItemsToPrint: Boolean = internalConditions.flatMap(ActionElementVisitor.visit(_)).exists(x => x.getName != null && x.getName.matches(g_printStatments.regex)) || internalConditions.exists(_.getName.matches(g_printStatments.regex))
      if (internalConditions.nonEmpty && hasItemsToPrint) {
        //Sí el if no tiene else crea el vértice que implica que la condición no se cumple.
        if (!hasElse)
          nNode.nInput.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
        //Bucle que recorre todas los statements encontrados
        var isFirstActionElement = true
        internalConditions.foreach { lo =>
          // Si el action element es de tipo call !!!
          if(lo.getName.matches(Params.CALLS.regex)){
            // Filtra los statements que se quieren mostrar en el grafo
            if (lo.getName.matches(g_printStatments.regex)) {
              var callNode: graph.Node = null
              // Crea el call node en caso de no ser el primer objeto de la lista.
              // Sí es el primer objeto, se sustituye por el nodo Code que viene de la acción anterior.
              if (internalConditions.head.equals(lo)) {
                callNode = nNode.nCode
              } else {
                // Sí el call node es posterior a otro if statement se obtiene el nodo current.
                if (isFirstActionElement) {
                  isFirstActionElement = false
                  callNode = graph.addNode()
                  nCurrent.connectWith(callNode, vertexType = GraphTypes.EDGE_TRUE)
                }else{
                  callNode = nCurrent
                }
              }
              callNode.nodeName = lo.getName
              if (lo.getName.equals("INPUT")) {
                callNode.nodeType = GraphTypes.INPUT
                callNode.nodeCode = lo.getSource.get(0).getSnippet
              }else{
                callNode.nodeType = GraphTypes.CALL
                callNode.nodeCode = lo.getAttribute.get(0).getValue
              }
              nCurrent = callNode
              if (!internalConditions.head.equals(lo)) {
                //nCurrent.connectWith(callNode, vertexType = GraphTypes.EDGE_TRUE)
              } else {
                nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
              }
              if (internalConditions.last.equals(lo)) {
                nNode.nCode = callNode
              }
            }
            // El action element es de otro tipo que no sea call
            // IF | FOR | REPEAT ....
          }else{
            isFirstActionElement = false
            nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
            nCurrent = nNode.nCode
            nNode.nCode = loop(Seq(lo), nNode, hasElse = false)
          }
        }
      }else{
        nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
      }
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      // RUTA ELSE
      if (hasElse){
        // Cálculo de condiciones
        val internalConditions: Seq[ActionElement] = bu(1).getCodeElement.toArray.toSeq.asInstanceOf[Seq[ActionElement]].filter(_.getKind.matches("statement")).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
        val hasItemsToPrint = internalConditions.flatMap(ActionElementVisitor.visit(_)).exists(x => x.getName!= null && x.getName.matches(g_printStatments.regex)) || internalConditions.exists(_.getName.matches(g_printStatments.regex))
        if (internalConditions.nonEmpty && hasItemsToPrint) {
          nNode.nElse = graph.addNode()
          nNode.nInput.connectWith(nNode.nElse, vertexType = GraphTypes.EDGE_FALSE)
          //Bucle que recorre todas los statements encontrados
          var isFirstActionElement = true
          internalConditions.foreach { lo =>
            // Si el action element es de tipo call !!!
            if(lo.getName.matches(Params.CALLS.regex)){
              // Filtra los statements que se quieren mostrar
              if (lo.getName.matches(g_printStatments.regex)) {
                var callNode: graph.Node = null
                // Crea el call node en caso de no ser el primer objeto de la lista.
                // Sí es el primer objeto, se sustituye por el nodo Code que viene de la acción anterior.
                if (internalConditions.head.equals(lo)) {
                  callNode = nNode.nElse
                } else {
                  // Sí el call node es posterior a otro if statement se obtiene el nodo current.
                  if (isFirstActionElement) {
                    isFirstActionElement = false
                    callNode = graph.addNode()
                  }else{
                    callNode = nCurrent
                  }
                }
                callNode.nodeName = lo.getName
                if (lo.getName.equals("INPUT")) {
                  callNode.nodeType = GraphTypes.INPUT
                  callNode.nodeCode = lo.getSource.get(0).getSnippet
                }else{
                  callNode.nodeType = GraphTypes.CALL
                  callNode.nodeCode = lo.getAttribute.get(0).getValue
                }
                nCurrent = callNode
                if (!internalConditions.head.equals(lo)) {
                  //nCurrent.connectWith(callNode, vertexType = GraphTypes.EDGE_TRUE)
                } else {
                  //nNode.nInput.connectWith(nNode.nElse, vertexType = GraphTypes.EDGE_SEQ)
                }
                // Sí el último elemento de la lista es un call lo devuelve al nodo Else
                if (internalConditions.last.equals(lo)) {
                  nNode.nElse = callNode
                }
              }
              // El action element es de otro tipo que no sea call
              // IF | FOR | REPEAT ....
            }else{
              if (isFirstActionElement) {
                isFirstActionElement = false
                nNode.nElse = graph.addNode()
                nCurrent.connectWith(nNode.nElse, vertexType = GraphTypes.EDGE_FALSE)
              }
              nCurrent = nNode.nElse
              nNode.nElse = loop(Seq(lo), nNode, hasElse = true)
            }
          }
          nNode.nElse.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_FALSE)
        }else{
          // El action element no tiene contenido que generar.
          // Se salta al siguiente elemento y se establece la conexión con el nodo de salida.
          nNode.nInput.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_FALSE)
        }
      }
    }

    nNode.nOutput.nodeType = GraphTypes.OUTPUT
    nNode.nOutput
  }

  def nodoCall(x: ActionElement, nNode: levelNodes): Unit = {
    nNode.nCode = nNode.nInput
    nNode.nCode.nodeType = GraphTypes.CALL
    if (!x.getAttribute.isEmpty){
      nNode.nCode.nodeName=x.getName
      nNode.nCode.nodeCode = x.getAttribute.get(0).getValue
    }else{
      if (x.getName.matches("""TODO.*""")){
        nNode.nCode.nodeName=x.getName.substring(0,5)
        nNode.nCode.nodeCode=x.getSource.get(0).getSnippet
      }else if (x.getName.matches("""MOVE.*""")){
        nNode.nCode.nodeName=x.getName.substring(0,5)
      }else{
        nNode.nCode.nodeName=x.getName
        nNode.nCode.nodeCode=x.getAttribute.get(0).getValue
      }
    }
    nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
  }

}
