package com.oc2.kdm.analysis.programflow

import com.oc2.kdm.action.ActionElement
import com.oc2.kdm.analysis.common.{CompilationUnitVisitor, Params, Tools}
import com.oc2.kdm.analysis.graphs.ConcreteDirectedGraph
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit, StorableUnit}
import com.oc2.kdm.kdm.Segment
import org.eclipse.emf.common.util.EList

import scala.util.matching.Regex

class KDMProgramFlowUnplugged {

  val graph: ConcreteDirectedGraph = new ConcreteDirectedGraph
  var nCurrent: graph.NodeImpl = graph.addNode()
  var callables: Option[Seq[CallableUnit]] = None
  var g_printStatments: Regex = """""".r
  var g_printCodeBoxes = false

  def execute(kdmNaturalModel: Segment, printSubprograms:Regex): Seq[ConcreteDirectedGraph] = {
      /** Obtención del KDM los StorableUnit y ActionElement de nivel "root" */
      var kdmcc = new KDMProgramFlow
      val codeElement: EList[AbstractCodeElement] = CompilationUnitVisitor.visit(kdmNaturalModel).head.getCodeElement
      val storables: Seq[StorableUnit] = Tools.getStorableUnits(codeElement)
      storables.head
      val actions: Seq[ActionElement] = Tools.getActionElements(codeElement).filter(x =>x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
      actions.head

      val name = kdmNaturalModel.getName.substring(0,kdmNaturalModel.getName.indexOf(".")).concat("_PF")
      val graph: ConcreteDirectedGraph = kdmcc.execute(actions,printSubprograms)
      graph.name = name
      var graphs: Seq[ConcreteDirectedGraph] = Seq()
      graphs = graphs :+ graph
      val callables: Option[Seq[CallableUnit]] = Tools.getCallableElements(codeElement)
      if (callables.isDefined){
        callables.get.foreach(callable => {
          kdmcc = new KDMProgramFlow
          val actions = Tools.getActionElements(callable.getCodeElement).filter(x => x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
          val graph = kdmcc.execute(actions,g_printStatments)
          graph.name = name.concat("_").concat(callable.getName)
          graphs = graphs :+ graph
        })
      }
      graphs
    }
}
