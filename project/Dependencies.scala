import sbt._

object Dependencies {

  val commonDependencies: Seq[ModuleID] = Seq(
    "commons-io" % "commons-io" % "2.11.0",
    "commons-cli" % "commons-cli" % "1.4",
    "org.apache.commons" % "commons-text" % "1.9",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "org.scalatest" %% "scalatest-flatspec" % "3.2.14" % Test,
    "com.liferay" % "org.apache.logging.log4j" % "2.17.1.LIFERAY-PATCHED-1",

    "com.oc2.parsers" % "natural-parser-composition" % "0.0.113-SNAPSHOT",
    "com.oc2" %% "natural-parsing-utils" % "1.0.25.20221123-33285",
    "com.oc2" % "com.oc2.kdm" % "0.1.6-SNAPSHOT",
    "com.oc2" % "com-oc2-kdm-utils_2.12" % "0.1.2.09032022-47694",
    "com.oc2" %% "idioms2kdm" % "0.1.28",
    "com.oc2" % "com-oc2-patterns_2.12" % "0.1.0.15032022-39490",


    "org.eclipse.emf" % "org.eclipse.emf.ecore" % "2.28.0",
    "org.eclipse.emf" % "org.eclipse.emf.ecore.xmi" % "2.17.0",
    "org.eclipse.emf" % "org.eclipse.emf.common" % "2.24.0",
    "org.eclipse.emf" % "org.eclipse.emf.ecore.change" % "2.14.0",
    "org.eclipse.emf" % "org.eclipse.emf.edit" % "2.17.0",
    "org.eclipse.lsp4j" % "org.eclipse.lsp4j" % "0.19.0",
    "org.eclipse.elk" % "org.eclipse.elk.alg.layered" % "0.8.1",
    "org.eclipse.jetty" % "jetty-util" % "9.4.43.v20210629",
    "org.eclipse.jetty.websocket" % "javax-websocket-server-impl" % "9.4.49.v20220914",
    "org.eclipse.lsp4j" % "org.eclipse.lsp4j.websocket" % "0.19.0",
    "junit" % "junit" % "4.13.2" % Test,
    "org.junit.jupiter" % "junit-jupiter-api" % "5.9.1" % Test,
    "org.junit.jupiter" % "junit-jupiter-params" % "5.9.1" % Test,
    "com.google.code.gson" % "gson" % "2.10",
    "com.google.inject" % "guice" % "5.1.0"

  )
  val excludedDependencies = Seq(
    "org.slf4j" % "slf4j-log4j12"
  )
}