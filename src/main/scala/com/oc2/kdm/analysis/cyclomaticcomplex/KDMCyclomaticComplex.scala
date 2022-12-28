package com.oc2.kdm.analysis.cyclomaticcomplex

import com.oc2.kdm.action.{ActionElement, BlockUnit}
import com.oc2.kdm.analysis.graphs.{ConcreteDirectedGraph, GraphTypes}
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit, StorableUnit}
import com.oc2.kdm.analysis.common.{ActionElementVisitor, CompilationUnitVisitor, Params, Tools}
import com.oc2.kdm.kdm.Segment
import org.eclipse.emf.common.util.EList

import scala.util.matching.Regex

class KDMCyclomaticComplex {

  val NATURAL_LOGICAL_CONDITIONS: Regex = """((EQ)|(=)|(EQUAL)|(EQUAL TO)|(NE)|(^=)|(<>)|(NOT =)|(NOT EQ)|(NOTEQUAL)|(NOT EQUAL)|(NOT EQUAL TO)|(LT)|(LESS THAN)|(<)|(GE)|(GREATER EQUAL)|(>=)|(NOT <)|(NOT LT)|(GT)|(GREATER THAN)|(>)|(LE)|(LESS EQUAL)|(<=)|(NOT >)|(NOT GT))+( logical expression)""".r
  val NATURAL_LOGICAL_OPERATORS: Regex = """((\\(\\))|(NOT)|(!)|(=)|(==)|(!=)|(<>)|(>)|(>=)|(<)|(<=)|(AND)|(&)|(&&)|(OR)|(\\|))+( logical operator expression)""".r

  val graph: ConcreteDirectedGraph = new ConcreteDirectedGraph
  var nCurrent: graph.NodeImpl = graph.addNode()

  class levelNodes{
    var nCode: graph.Node = _
    var nElse: graph.Node = _
    var nOutput: graph.Node = _
    var nInput: graph.Node = _
  }

  def execute(kdmNaturalModel: Segment): ConcreteDirectedGraph = {
    /** Obtención del KDM los StorableUnit y ActionElement de nivel "root" */
    var kdmcc: CalculateCyclomaticComplex = new CalculateCyclomaticComplex
    val codeElement: EList[AbstractCodeElement] = CompilationUnitVisitor.visit(kdmNaturalModel).head.getCodeElement
    val storables: Seq[StorableUnit] = Tools.getStorableUnits(codeElement)
    storables
    val actions: Seq[ActionElement] = Tools.getActionElements(codeElement).filter(x => x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
    actions
    val callables: Option[Seq[CallableUnit]] = Tools.getCallableElements(codeElement)

    var graph: ConcreteDirectedGraph = kdmcc.execute(actions)
    graph.name = kdmNaturalModel.getName.substring(0,kdmNaturalModel.getName.indexOf(".")).concat("_CC")
    graph = addCallables(callables, graph, kdmcc)

    graph
  }

  def addCallables(callables: Option[Seq[CallableUnit]], graph: ConcreteDirectedGraph,kdmcc: CalculateCyclomaticComplex):ConcreteDirectedGraph = {
    val c = callables.get
    //val nodes = graph.nodes.filter(_.nodeCode.equals(""))
//    c.foreach{ x =>
//      nCurrent = graph.addNode()
//
//      val level_1 = new levelNodes()
//      level_1.nInput = nCurrent
//      level_1.nOutput = graph.addNode()
//      level_1.nInput.nodeName=x.getName
//
//      val actions = Tools.getActionElements(x.getCodeElement).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
//      //calculateCC(actions)
//      kdmcc.execute(actions)
//
//    }
  graph
  }
//
//  def nodeLoop(actionElements: Seq[ActionElement]): Unit = {
//
//    actionElements.foreach{ x =>
//      val level_1 = new levelNodes()
//      level_1.nInput = nCurrent
//      level_1.nOutput = graph.addNode()
//      nCurrent = logic(x, level_1)
//    }
//    val ending = graph.addNode()
//    ending.nodeType = GraphTypes.ENDING
//    ending.nodeName = "Ending"
//    nCurrent.connectWith(ending,GraphTypes.EDGE)
//  }
//
//  def loop(actionElements: Seq[ActionElement], nNode: levelNodes, hasElse: Boolean): graph.Node = {
//    if (hasElse){
//      nCurrent = nNode.nElse
//    }else{
//      nCurrent = nNode.nCode
//    }
//
//    actionElements.foreach{ x =>
//      val level_loop = new levelNodes()
//      level_loop.nInput = nCurrent
//      level_loop.nOutput = graph.addNode()
//      nCurrent = logic(x, level_loop)
//    }
//    nCurrent
//  }
//
//  def logic(x: ActionElement, nNode: levelNodes): graph.Node ={
//    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("REPEAT")){
//      nNode.nCode = graph.addNode()
//      nNode.nInput.nodeType = GraphTypes.REPEAT
//      nNode.nInput.connectWith(nNode.nCode,vertexType=GraphTypes.IF)
//      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
//      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//      nNode.nOutput = loop(internalConditions,nNode,hasElse = false)
//      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.IF)
//    }
//    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("FOR")){
//      nNode.nCode = graph.addNode()
//      nNode.nInput.nodeType = GraphTypes.FOR
//      nNode.nInput.connectWith(nNode.nCode,vertexType=GraphTypes.IF)
//      val ae = Tools.getActionElements(Tools.getBlockUnits(x.getCodeElement).head.getCodeElement)
//      val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//      nNode.nCode = loop(internalConditions,nNode,hasElse = false)
//      nNode.nCode.nodeType = GraphTypes.CODE
//      nNode.nCode.connectWith(nNode.nOutput, vertexType = GraphTypes.IF)
//      nNode.nOutput.connectWith(nNode.nInput, vertexType = GraphTypes.IF)
//    }
//    // Gestión de ciclos IF
//    if (x.getKind!=null && x.getKind.equals("statement") && x.getName!=null && x.getName.equals("IF")){
//      nNode.nCode = graph.addNode()
//      nNode.nCode.nodeType = GraphTypes.CODE
//      if (x.getSource.get(0).getSnippet.contains("\n")){
//        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet.substring(0, x.getSource.get(0).getSnippet.indexOf("\n"))
//      }else{
//        nNode.nInput.nodeCode = x.getSource.get(0).getSnippet
//      }
//      nNode.nInput.nodeType=GraphTypes.INPUT
//
//
//      val bu: Seq[BlockUnit] = Tools.getBlockUnits(x.getCodeElement)
//      val aeParenthesis: ActionElement = Tools.getActionElements(x.getCodeElement).head
//      val ae: Seq[ActionElement] = Tools.getActionElements(aeParenthesis.getCodeElement)
//      /* TODO */
//      val logicalOperators = ActionElementVisitor.visit(x.getCodeElement.get(0)).filter(_.getKind!=null).filter(_.getKind.matches(NATURAL_LOGICAL_OPERATORS.regex))
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
//        val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//        // nCurrent = nodoEnd(nOutput, nCode)
//
//        //if(hasElse)
//        //nodeOneOperationElse(nInput, nOutput, nElse, bu(1).getCodeElement)
//
//        if (internalConditions.nonEmpty){
//          //calculateCC(internalConditions)
//          nNode.nCode = loop(internalConditions,nNode,hasElse = false)
//        }else {
//          nCurrent = nodoEnd(nNode.nOutput, nNode.nCode, nNode.nElse, hasElse)
//          //nCode.connectWith(nOutput)
//        }
//
//        if(hasElse)
//          nNode.nCode
//
//      }else{
//        // El If tiene una sola condición
//        nCurrent.connectWith(nNode.nCode,vertexType=GraphTypes.IF)
//
//        // If
//        val ae = Tools.getActionElements(bu.head.getCodeElement)
//        val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//        if (internalConditions.nonEmpty){
//          // Tiene Bloque de Código
//          if (!hasElse) { nCurrent.connectWith(nNode.nOutput, vertexType = GraphTypes.IF) }
//          nNode.nCode = loop(internalConditions,nNode,hasElse = false)
//          // TODO Esta conexión puede que no vaya aquí....
//          nNode.nCode.connectWith(nNode.nOutput, vertexType = "IF")
//        }else {
//          // NO Tiene Bloque de Código
//          if (!hasElse)
//            nCurrent.connectWith(nNode.nOutput,vertexType=GraphTypes.IF)
//          nNode.nCode.connectWith(nNode.nOutput,vertexType=GraphTypes.IF)
//        }
//
//        if(hasElse){
//          // El If tiene Else
//          nCurrent = nNode.nInput
//          val ae = Tools.getActionElements(bu(1).getCodeElement)
//          val internalConditions = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//          if (internalConditions.nonEmpty){
//            // Tiene Bloque de Código
//            nNode.nInput.connectWith(nNode.nElse,vertexType=GraphTypes.ELSE)
//            nNode.nElse = loop(internalConditions,nNode,hasElse = true)
//            // TODO Revisar si esta conexión va en este punto
//            nNode.nElse.connectWith(nNode.nOutput,vertexType=GraphTypes.ELSE)
//          }else{
//            // NO Tiene Bloque de Código
//            nNode.nInput.connectWith(nNode.nElse,vertexType=GraphTypes.ELSE)
//            nNode.nElse.connectWith(nNode.nOutput,vertexType=GraphTypes.ELSE)
//          }
//        }
//
//      }
//    }
//    nNode.nOutput
//  }
//
//  def nodeAndIfPreviousIsOr(nCode: graph.NodeImpl, nOutput: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
//    var vertexType = GraphTypes.IF
//    if (hasElse)
//      vertexType = GraphTypes.ELSE
//    nCurrent.connectWith(nCode,vertexType)
//    nCurrent.connectWith(nOutput,vertexType)
//    nCurrent = nCode
//    val nNext = graph.addNode()
//    nNext
//  }
//  def nodeOrIfPreviousIsAnd(nCode: graph.NodeImpl, nOutput: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
//    var vertxType = GraphTypes.IF
//    if (hasElse)
//      vertxType = GraphTypes.ELSE
//    val nNext = nOutput
//    nCurrent.connectWith(nNext,vertxType)
//    nCurrent.connectWith(nCode,vertxType)
//    nCurrent = nNext
//    graph.addNode()
//  }
//
//  def nodeOneOperation(nNode: levelNodes, hasElse:Boolean, codeElement: EList[AbstractCodeElement],typ: String): Unit = {
//    val ae = Tools.getActionElements(codeElement)
//    val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//    nCurrent.connectWith(nNode.nCode,typ)
//    if (!hasElse)
//      nCurrent.connectWith(nNode.nOutput,typ)
//    if (internalConditions.nonEmpty){
//      loop(internalConditions, nNode,hasElse = true)
//    }else {
//      nNode.nCode.connectWith(nNode.nOutput,typ)
//    }
//  }
//
//  def nodeOneOperationElse(nNode: levelNodes, codeElement: EList[AbstractCodeElement],typ: String): Unit = {
//    val ae = Tools.getActionElements(codeElement)
//    val internalConditions: Seq[ActionElement] = ae.filter(_.getKind.matches("statement")).filter(_.getName.matches(STATEMENTS.regex))
//    //val nCode = g.addNode
//    //nCode = g.addNode
//    //nInput.connectWith(nElse)
//    if (internalConditions.nonEmpty){
//      internalConditions.foreach{x =>
//        logic(x,nNode)
//      }
//    }else{
//      nNode.nElse.connectWith(nNode.nOutput,typ)
//    }
//  }
//
//  def nodeAnd(nElse: graph.Node, nOutput: graph.Node, hasElse:Boolean): graph.NodeImpl = {
//    val nNext = graph.addNode()
//    nCurrent.connectWith(nNext,vertexType=GraphTypes.IF)
//    if(hasElse){
//      nCurrent.connectWith(nElse,vertexType=GraphTypes.ELSE)
//    }else{
//      nCurrent.connectWith(nOutput,vertexType=GraphTypes.IF)
//    }
//    nNext
//  }
//
//  def nodeOr(nCode: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
//    val typ = GraphTypes.IF
//    nCurrent.connectWith(nCode,typ)
//    val nNext = graph.addNode()
//    nCurrent.connectWith(nNext,typ)
//    nNext
//  }
//
//  def nodoEnd(nOutput: graph.NodeImpl, nCode: graph.NodeImpl, nElse: graph.NodeImpl, hasElse: Boolean): graph.NodeImpl = {
//    nCurrent.connectWith(nCode,vertexType=GraphTypes.IF)
//    if (hasElse){
//      nCurrent.connectWith(nElse,vertexType=GraphTypes.ELSE)
//      nElse.connectWith(nOutput,vertexType=GraphTypes.ELSE)
//    }else{
//      nCurrent.connectWith(nOutput,vertexType=GraphTypes.ELSE)
//    }
//    nCode.connectWith(nOutput,vertexType=GraphTypes.ELSE)
//    nOutput
//  }

}
