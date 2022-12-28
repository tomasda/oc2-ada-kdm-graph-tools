package com.oc2.kdm.analysis.common

import scala.util.matching.Regex

object Params {
  val NATURAL_LOGICAL_CONDITIONS: Regex = """((EQ)|(=)|(EQUAL)|(EQUAL TO)|(NE)|(^=)|(<>)|(NOT =)|(NOT EQ)|(NOTEQUAL)|(NOT EQUAL)|(NOT EQUAL TO)|(LT)|(LESS THAN)|(<)|(GE)|(GREATER EQUAL)|(>=)|(NOT <)|(NOT LT)|(GT)|(GREATER THAN)|(>)|(LE)|(LESS EQUAL)|(<=)|(NOT >)|(NOT GT))+( logical expression)""".r
  val NATURAL_LOGICAL_OPERATORS: Regex = """((\\(\\))|(NOT)|(!)|(=)|(==)|(!=)|(<>)|(>)|(>=)|(<)|(<=)|(AND)|(&)|(&&)|(OR)|(NE)|(\\|))+( logical .* expression)""".r
  val NATURAL_LOGICAL_IF_OPERATORS: Regex = """((AND)|(&)|(&&)|(OR))+( logical .* expression)""".r
  val STATEMENTS: Regex = """(IF|REPEAT|FOR|INPUT)""".r
  val CALLS: Regex = """(CALLNAT|USING MAP|PERFORM|INPUT)""".r //TODO.*|MOVE.*
}
