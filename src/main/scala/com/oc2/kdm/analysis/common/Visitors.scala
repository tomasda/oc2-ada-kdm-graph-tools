package com.oc2.kdm.analysis.common

import com.oc2.kdm.action.util.ActionSwitch
import com.oc2.kdm.action.{ActionElement, BlockUnit}
import com.oc2.kdm.code._
import com.oc2.kdm.code.util.CodeSwitch
import com.oc2.kdm.data.DataSegment
import com.oc2.kdm.data.util.DataSwitch
import com.oc2.kdm.source.SourceRef
import com.oc2.kdm.source.util.SourceSwitch
import com.oc2.kdm.visitor.AbstractKdmVisitor

/** Action Switch */
object ActionElementVisitor extends ActionSwitch[ActionElement] with AbstractKdmVisitor[ActionElement]  {
  override def caseActionElement(`object`: ActionElement): ActionElement = `object`
}
object BlockUnitVisitor extends ActionSwitch[BlockUnit] with AbstractKdmVisitor[BlockUnit] {
  override def caseBlockUnit(blockUnit: BlockUnit): BlockUnit = blockUnit match {
    case impl: BlockUnit => impl
    case _ => null
  }
}

/** Source Switch */
object SourceRefVisitor extends SourceSwitch[SourceRef] with AbstractKdmVisitor[SourceRef]{
  override def caseSourceRef(`object`: SourceRef): SourceRef = `object`
}

/** Code Switch */
object StorableUnitVisitor extends CodeSwitch[StorableUnit] with AbstractKdmVisitor[StorableUnit] {
  override def caseStorableUnit(storableUnit: StorableUnit): StorableUnit = storableUnit
}
object ImportVisitor extends CodeSwitch[Imports] with AbstractKdmVisitor[Imports]{
  override def caseImports(imports: Imports): Imports = imports
}
object CompilationUnitVisitor extends CodeSwitch[CompilationUnit] with AbstractKdmVisitor[CompilationUnit]{
  override def caseCompilationUnit(compilationUnit: CompilationUnit): CompilationUnit = compilationUnit
}
object SharedUnitVisitor extends CodeSwitch[SharedUnit] with AbstractKdmVisitor[SharedUnit]{
  override def caseSharedUnit(sharedUnit: SharedUnit): SharedUnit = sharedUnit
}
object ViewsVisitor extends CodeSwitch[StorableUnit] with AbstractKdmVisitor[StorableUnit]{
  override def caseStorableUnit(storableUnit: StorableUnit): StorableUnit = storableUnit match {
    case impl: StorableUnit if impl.getExt != null && impl.getExt.equals("VIEW") => impl
    case _ => null
  }
}
object CodeElementVisitor extends CodeSwitch[CodeElement] with AbstractKdmVisitor[CodeElement]{
  override def caseCodeElement(codeElement: CodeElement): CodeElement = codeElement
}

/** Data Switch */
object DataSegmentVisitor extends DataSwitch[DataSegment] with AbstractKdmVisitor[DataSegment]{
  override def caseDataSegment(dataSegment: DataSegment):DataSegment = dataSegment
}

