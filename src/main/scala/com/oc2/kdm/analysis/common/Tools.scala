package com.oc2.kdm.analysis.common

import com.oc2.kdm.action.{ActionElement, BlockUnit}
import com.oc2.kdm.code.{AbstractCodeElement, CallableUnit, StorableUnit}
import org.eclipse.emf.common.util.EList

object Tools {
  def getStorableUnits(codeElement: EList[AbstractCodeElement]): Seq[StorableUnit] = {
    codeElement.toArray().filter(_.isInstanceOf[StorableUnit]).toSeq.asInstanceOf[Seq[StorableUnit]]
  }

  def getActionElements(codeElement: EList[AbstractCodeElement]): Seq[ActionElement] = {
    codeElement.toArray().filter(_.isInstanceOf[ActionElement]).filter(!_.isInstanceOf[BlockUnit]).toSeq.asInstanceOf[Seq[ActionElement]]
  }

  def getBlockUnits(codeElement: EList[AbstractCodeElement]): Seq[BlockUnit] = {
    codeElement.toArray().filter(_.isInstanceOf[BlockUnit]).toSeq.asInstanceOf[Seq[BlockUnit]]
  }

  def getCallableElements(codeElement: EList[AbstractCodeElement]): Option[Seq[CallableUnit]] = {
    Some(codeElement.toArray().filter(_.isInstanceOf[CallableUnit]).toSeq.asInstanceOf[Seq[CallableUnit]])
  }

}
