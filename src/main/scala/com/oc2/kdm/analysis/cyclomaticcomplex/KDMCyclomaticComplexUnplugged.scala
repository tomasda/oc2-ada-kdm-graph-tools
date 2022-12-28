package com.oc2.kdm.analysis.cyclomaticcomplex

import com.oc2.kdm.action.ActionElement
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit, StorableUnit}
import com.oc2.kdm.analysis.common.{CompilationUnitVisitor, Params, Tools}
import com.oc2.kdm.analysis.graphs.ConcreteDirectedGraph
import com.oc2.kdm.kdm.Segment
import org.eclipse.emf.common.util.EList

class KDMCyclomaticComplexUnplugged {

  def execute(kdmNaturalModel: Segment): Seq[ConcreteDirectedGraph] = {
    /** Obtención del KDM los StorableUnit y ActionElement de nivel "root" */
    var kdmcc = new CalculateCyclomaticComplex
    val codeElement: EList[AbstractCodeElement] = CompilationUnitVisitor.visit(kdmNaturalModel).head.getCodeElement
    val storables: Seq[StorableUnit] = Tools.getStorableUnits(codeElement)
    storables.head
    val actions: Seq[ActionElement] = Tools.getActionElements(codeElement).filter(x => x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
    actions.head

    val name = kdmNaturalModel.getName.substring(0,kdmNaturalModel.getName.indexOf(".")).concat("_CC")
    val graph: ConcreteDirectedGraph = kdmcc.execute(actions)
    graph.name = name
    var graphs: Seq[ConcreteDirectedGraph] = Seq()
    graphs = graphs :+ graph
    val callables: Option[Seq[CallableUnit]] = Tools.getCallableElements(codeElement)

    if (callables.isDefined){
      callables.get.foreach(callable => {
        kdmcc = new CalculateCyclomaticComplex
        val actions = Tools.getActionElements(callable.getCodeElement).filter(x => x.getName.matches(Params.STATEMENTS.regex) || x.getName.matches(Params.CALLS.regex))
          val graph = kdmcc.execute(actions)
          graph.name = name.concat("_").concat(callable.getName)
          graphs = graphs :+ graph
      })
    }
    graphs
  }

}
