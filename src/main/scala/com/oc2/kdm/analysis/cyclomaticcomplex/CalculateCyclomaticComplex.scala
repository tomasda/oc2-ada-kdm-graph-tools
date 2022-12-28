package com.oc2.kdm.analysis.cyclomaticcomplex

import com.oc2.kdm.action.{ActionElement, BlockUnit}
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit}
import com.oc2.kdm.analysis.common.{ActionElementVisitor, Params, Tools}
import com.oc2.kdm.analysis.graphs.{ConcreteDirectedGraph, GraphTypes}
import org.eclipse.emf.common.util.EList

class CalculateCyclomaticComplex {

  val graph: ConcreteDirectedGraph = new ConcreteDirectedGraph
  var nCurrent: graph.NodeImpl = graph.addNode()

  class levelNodes{
    var nCode: graph.Node = _
    var nElse: graph.Node = _
    var nOutput: graph.Node = _
    var nInput: graph.Node = _
  }

  def execute(actions: Seq[ActionElement]): ConcreteDirectedGraph = {
    calculateCC(actions)
    graph
  }

  def calculateCC(actions: Seq[ActionElement]): Unit = {
    // Creación del Nodo Inicial
    val initial = graph.addNode()
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
      level_1.nOutput = graph.addNode()
      level_1.nInput.nodeName=x.getName

      val actions = Tools.getActionElements(x.getCodeElement).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
      if (actions.nonEmpty)
        calculateCC(actions)

    }
  }

  def nodeLoop(actionElements: Seq[ActionElement]): Unit = {

    actionElements.foreach{ x =>
      val level_1 = new levelNodes()
      level_1.nInput = nCurrent
      level_1.nOutput = graph.addNode()
      nCurrent = logic(x, level_1)
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
      val level_loop = new levelNodes()
      level_loop.nInput = nCurrent
      level_loop.nOutput = graph.addNode()
      nCurrent = logic(x, level_loop)
    }
    nCurrent
  }

  def logic(x: ActionElement, nNode: levelNodes): graph.Node ={
    if (x.getKind != null && x.getKind.equals("statement") && x.getName != null && x.getName.equals("INPUT")) {
      nNode.nCode = graph.addNode()
      nNode.nCode.nodeType = GraphTypes.INPUT
      nNode.nCode.nodeName = x.getName
      nNode.nCode.nodeCode = x.getSource.get(0).getSnippet
    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.matches("""TODO.*""")){
      nNode.nInput.nodeType = GraphTypes.CALL
      nNode.nInput.nodeCode = x.getName
      nNode.nInput.nodeName = x.getName
      nNode.nInput.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_TRUE)
    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("USING MAP")){
      nNode.nInput.nodeType = GraphTypes.CALL
      nNode.nInput.nodeCode = x.getName
      nNode.nInput.nodeName = x.getName
      nNode.nInput.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_TRUE)
    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("PERFORM")){
      nNode.nInput.nodeType = GraphTypes.CALL
      nNode.nInput.nodeCode = x.getName
      nNode.nInput.nodeName = x.getName
      nNode.nInput.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_TRUE)
    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("CALLNAT")){
      nNode.nCode = graph.addNode()
      nNode.nCode.nodeType = GraphTypes.CALL
      if (!x.getAttribute.isEmpty){
        nNode.nCode.nodeCode = x.getName.concat(" ").concat(x.getAttribute.get(0).getValue)
        nNode.nCode.nodeName = x.getName
      }else{
        nNode.nCode.nodeCode = x.getName
        nNode.nCode.nodeName = x.getName
      }
      nNode.nInput.connectWith(nNode.nCode,vertexType=GraphTypes.EDGE_TRUE)
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("REPEAT")){
      nNode.nCode = graph.addNode()
      nNode.nInput.nodeType = GraphTypes.REPEAT
      nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
      nNode.nCode = loop(internalConditions,nNode,hasElse = false)
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.EDGE_TRUE)

    }
    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("FOR")){
      nNode.nCode = graph.addNode()
      nNode.nInput.nodeType = GraphTypes.FOR
      nNode.nInput.connectWith(nNode.nCode,vertexType=GraphTypes.EDGE_TRUE)
      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
      nNode.nCode = loop(internalConditions,nNode,hasElse = false)
      nNode.nCode.nodeType = GraphTypes.CODE
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.EDGE_TRUE)
    }
//    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("IF")){
//      nNode.nCode = graph.addNode()
//      nNode.nCode.nodeType = GraphTypes.CODE
//      if (x.getSource.get(0).getSnippet.contains("\n")){
//        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet.substring(0, x.getSource.get(0).getSnippet.indexOf("\n"))
//      }else{
//        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet
//      }
//      nNode.nInput.nodeType=GraphTypes.IF
//
//      val bu: Seq[BlockUnit] = Tools.getBlockUnits(x.getCodeElement)
//      val aeParenthesis: ActionElement = Tools.getActionElements(x.getCodeElement).head
//      val ae: Seq[ActionElement] = Tools.getActionElements(aeParenthesis.getCodeElement)
//
//      val logicalOperators: List[ActionElement] = ActionElementVisitor.visit(x.getCodeElement.get(0)).filter(_.getKind!=null).filter(_.getKind.matches(Params.NATURAL_LOGICAL_OPERATORS.regex))
//      val hasElse: Boolean = bu.size==ae.size+1
//      if (hasElse)
//        if (nNode.nElse==null)
//          nNode.nElse = graph.addNode()
//
//      var lastOperator: String = ""
//
//      if (logicalOperators.nonEmpty){
//        /** TODO */
//        // El if tiene varios operadores
//        logicalOperators.foreach { lo =>
//          if (lo.getKind.contains("AND")){
//            if (lastOperator.equals("OR")){
//              nNode.nCode = nodeAndIfPreviousIsOr(nNode.nCode,nNode.nOutput, hasElse)
//            }else{
//              nCurrent = nodeAnd(nNode.nElse ,nNode.nOutput, hasElse)
//            }
//            lastOperator = "AND"
//          }
//          if (lo.getKind.contains("OR")){
//            if (lastOperator.equals("AND")){
//              //nOr = nOutput
//              nNode.nOutput = nodeOrIfPreviousIsAnd(nNode.nCode,nNode.nOutput, hasElse)
//            }else {
//              nCurrent = nodeOr(nNode.nCode, hasElse)
//            }
//            lastOperator = "OR"
//          }
//        }
//        val ae = Tools.getActionElements(bu.head.getCodeElement)
//        val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(x => x.getName.matches(Params.STATEMENTS.regex) )
//        val internalCalls: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(x => x.getName.matches(Params.CALLS.regex))
//
//        if (internalConditions.nonEmpty){
//
//          nCurrent.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
//          nCurrent.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
//          nNode.nCode = loop(internalConditions,nNode,hasElse = false)
//          nNode.nCode.connectWith(nNode.nOutput,vertexType = GraphTypes.EDGE_TRUE)
//          if (internalCalls.nonEmpty){
//            addNodeCalls(internalCalls, nNode)
//          }
//
//        }else {
//          if (internalCalls.nonEmpty){
//            addNodeCalls(internalCalls, nNode)
//          }
//          nCurrent = nodoEnd(nNode, hasElse)
//        }
//
//        if(hasElse)
//          nNode.nCode
//
//      }else{
//        // El If tiene una sola condición
//        nCurrent.connectWith(nNode.nCode,vertexType=GraphTypes.EDGE_TRUE)
//
//        // If
//        val ae = Tools.getActionElements(bu.head.getCodeElement)
//        val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(x => x.getName.matches(Params.STATEMENTS.regex))
//        val internalCalls: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(x => x.getName.matches(Params.CALLS.regex))
//        if (internalConditions.nonEmpty){
//          // Tiene Bloque de Código
//          if (!hasElse) { nCurrent.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE) }
//          nNode.nCode = loop(internalConditions,nNode,hasElse = false)
//          if (internalCalls.nonEmpty){
//            val nNext = graph.addNode()
//            nNode.nCode.connectWith(nNext, vertexType = GraphTypes.EDGE_TRUE)
//            nNode.nCode = nNext
//            addNodeCalls(internalCalls, nNode)
//          }
//          nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
//        }else {
//          // NO Tiene Bloque de Código
//          if (!hasElse)
//            nCurrent.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_TRUE)
//          nNode.nCode.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_TRUE)
//          if (internalCalls.nonEmpty){
//            addNodeCalls(internalCalls, nNode)
//          }
//        }
//
//        if(hasElse){
//          // El If tiene Else
//          nCurrent = nNode.nInput
//          val ae = Tools.getActionElements(bu(1).getCodeElement)
//          val internalConditions = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
//          if (internalConditions.nonEmpty){
//            // Tiene Bloque de Código
//            nNode.nInput.connectWith(nNode.nElse,vertexType=GraphTypes.EDGE_FALSE)
//            nNode.nElse = loop(internalConditions,nNode,hasElse = true)
//            // TODO Revisar si esta conexión va en este punto
//            nNode.nElse.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_FALSE)
//          }else{
//            // NO Tiene Bloque de Código
//            nNode.nInput.connectWith(nNode.nElse,vertexType=GraphTypes.EDGE_FALSE)
//            nNode.nElse.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_FALSE)
//          }
//        }
//
//      }
//    }

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

      // Incorporación de los nodos de complejidad de la instrucción.
      val logicalOperators: List[ActionElement] = ActionElementVisitor.visit(x.getCodeElement.get(0)).filter(_.getKind!=null).filter(_.getKind.matches(Params.NATURAL_LOGICAL_IF_OPERATORS.regex))
      var lastOperator: String = ""
      if (logicalOperators.nonEmpty) {
        // El if tiene varios operadores
        logicalOperators.foreach { lo =>
          if (lo.getKind.contains("AND")) {
            if (lastOperator.equals("OR")) {
              nNode.nCode = nodeAndIfPreviousIsOr(nNode.nCode, nNode.nOutput, hasElse)
            } else {
              // Sí el operador es el primer elemento, current/Input se conecta con output.
              if (logicalOperators.head.equals(lo)){
                nCurrent.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE)
              }
              nCurrent = nodeAnd(nNode, hasElse)
            }
            lastOperator = "AND"
          }
          if (lo.getKind.contains("OR")) {
            if (lastOperator.equals("AND")) {
              //nOr = nOutput
              nNode.nOutput = nodeOrIfPreviousIsAnd(nNode.nCode, nNode.nOutput, hasElse)
            } else {
              // Sí el operador es el primer elemento, current/Input se conecta con code.
              if (logicalOperators.head.equals(lo)){
                nCurrent.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE)
              }
              nCurrent = nodeOr(nNode.nCode, hasElse)
            }
            lastOperator = "OR"
          }

          if (logicalOperators.last.equals(lo)) {
            //Sí el último operador es un And lo conecta al nodo Codigo
            if (lastOperator.equals("AND")) {
              nCurrent.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE)
            } else {
            //Sí el último operador es un Or lo conecta al nodo Output
              nCurrent.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE)
            }
          }
        }
      }
      nNode.nCode.nodeType = GraphTypes.CODE

      //RUTA PRINCIPAL del IF.
      val internalConditions: Seq[ActionElement] = bu.head.getCodeElement.toArray.toSeq.asInstanceOf[Seq[ActionElement]].filter(_.getKind.matches("statement")).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
      if (internalConditions.nonEmpty) {
        //Sí el if no tiene else crea el vértice que implica que la condición no se cumple.
        if (!hasElse) {
            nNode.nInput.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
        }
        //Bucle que recorre todas los statements encontrados
        var isFirstActionElement = true
        internalConditions.foreach { lo =>
          // Si el action element es de tipo call !!!
          if(lo.getName.matches(Params.CALLS.regex)){
            // Filtra los statements que se quieren mostrar en el grafo
//            if (lo.getName.matches(g_printStatments.regex)) {
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
                } else {
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
                // Sí ya se han creado los nodos de los operadores lógicos
                // no es necesario crear la conexión entre nInput y nCode.
                if (logicalOperators.isEmpty)
                  nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
              }
              if (internalConditions.last.equals(lo)) {
                nNode.nCode = callNode
              }
//            }
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
        //TODO : Esta opción se cambió al modificar el bucle de opciones if
        if (logicalOperators.isEmpty)
          nNode.nInput.connectWith(nNode.nCode, vertexType = GraphTypes.EDGE_TRUE)
        //nNode.nInput.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      }
      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.EDGE_TRUE)
      // RUTA ELSE
      if (hasElse){
        // Cálculo de condiciones
        val internalConditions: Seq[ActionElement] = bu(1).getCodeElement.toArray.toSeq.asInstanceOf[Seq[ActionElement]].filter(_.getKind.matches("statement")).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
        if (internalConditions.nonEmpty) {
          nNode.nElse = graph.addNode()
          nNode.nInput.connectWith(nNode.nElse, vertexType = GraphTypes.EDGE_FALSE)
          //Bucle que recorre todas los statements encontrados
          var isFirstActionElement = true
          internalConditions.foreach { lo =>
            // Si el action element es de tipo call !!!
            if(lo.getName.matches(Params.CALLS.regex)){
              // Filtra los statements que se quieren mostrar
//              if (lo.getName.matches(g_printStatments.regex)) {
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
//              }
              // El action element es de otro tipo que no sea call
              // IF | FOR | REPEAT ....
            }else{
              if (isFirstActionElement) {
                isFirstActionElement = false
                //nCurrent.connectWith(nNode.nElse, vertexType = GraphTypes.EDGE_SEQ)
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

  def addNodeCalls(internalCalls: Seq[ActionElement], nNode: levelNodes):Unit = {
    internalCalls.foreach{c =>
      val nNext = graph.addNode()
      if (c.getAttribute == null || c.getAttribute.isEmpty){
        nNext.nodeCode = c.getName //.concat(" ").concat(c.getAttribute.get(0).getValue)
        nNext.nodeName = c.getName
      }else{
        nNext.nodeCode = c.getName.concat(" ").concat(c.getAttribute.get(0).getValue)
        nNext.nodeName = c.getName
      }
      nNext.nodeType = GraphTypes.CALL
      nNode.nCode.connectWith(nNext,vertexType = GraphTypes.EDGE_TRUE)
    }
  }

  def nodeAndIfPreviousIsOr(nCode: graph.NodeImpl, nOutput: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
    var vertexType = GraphTypes.EDGE
    if (hasElse)
      vertexType = GraphTypes.EDGE_FALSE
    //nCurrent.connectWith(nCode,vertexType)
    nCurrent.connectWith(nOutput,vertexType)
    nCurrent = nCode
    val nNext = graph.addNode()
    nNext
  }
  def nodeOrIfPreviousIsAnd(nCode: graph.NodeImpl, nOutput: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
    var vertxType = GraphTypes.EDGE
    if (hasElse)
      vertxType = GraphTypes.EDGE_FALSE
    val nNext = nOutput
    nCurrent.connectWith(nNext,vertxType)
    nCurrent.connectWith(nCode,vertxType)
    nCurrent = nNext
    graph.addNode()
  }

  def nodeOneOperation(nNode: levelNodes, hasElse:Boolean, codeElement: EList[AbstractCodeElement],typ: String): Unit = {
    val ae = Tools.getActionElements(codeElement)
    val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
    nCurrent.connectWith(nNode.nCode,typ)
    if (!hasElse)
      nCurrent.connectWith(nNode.nOutput,typ)
    if (internalConditions.nonEmpty){
      loop(internalConditions, nNode,hasElse = true)
    }else {
      nNode.nCode.connectWith(nNode.nOutput,typ)
    }
  }

  def nodeOneOperationElse(nNode: levelNodes, codeElement: EList[AbstractCodeElement],typ: String): Unit = {
    val ae = Tools.getActionElements(codeElement)
    val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(Params.STATEMENTS.regex))
    //val nCode = g.addNode
    //nCode = g.addNode
    //nInput.connectWith(nElse)
    if (internalConditions.nonEmpty){
      internalConditions.foreach{x =>
        logic(x,nNode)
      }
    }else{
      nNode.nElse.connectWith(nNode.nOutput,typ)
    }
  }

  def nodeAnd(nNodo: levelNodes, hasElse:Boolean): graph.NodeImpl = {
    val nNext = graph.addNode()
    nCurrent.connectWith(nNext,vertexType=GraphTypes.EDGE_TRUE)
    if(hasElse){
      nNext.connectWith(nNodo.nElse,vertexType=GraphTypes.EDGE_FALSE)
    }else{
      nNext.connectWith(nNodo.nOutput,vertexType=GraphTypes.EDGE_TRUE)
    }
    nNext
  }

  def nodeOr(nCode: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
    //nCurrent.connectWith(nCode,vertexType = GraphTypes.EDGE_TRUE)
    val nNext = graph.addNode()
    nCurrent.connectWith(nNext, vertexType = GraphTypes.EDGE_TRUE)
    nNext.connectWith(nCode,vertexType = GraphTypes.EDGE_TRUE)

    nNext
  }

  def nodoEnd(nNode: levelNodes, hasElse: Boolean): graph.NodeImpl = {
    nCurrent.connectWith(nNode.nCode,vertexType=GraphTypes.EDGE_TRUE)
    if (hasElse){
      nCurrent.connectWith(nNode.nElse,vertexType=GraphTypes.EDGE_FALSE)
      nNode.nElse.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_FALSE)
    }else{
      nCurrent.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_FALSE)
    }
    nNode.nCode.connectWith(nNode.nOutput,vertexType=GraphTypes.EDGE_FALSE)
    nNode.nOutput
  }

}
