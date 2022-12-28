logLevel := Level.Warn

//addSbtPlugin("org.xerial.sbt" % "sbt-pack" % "0.14")                    // packing
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.9.4")
//addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.18")     // packing for docker.
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.5.1")               // Test results
addSbtPlugin("com.gilcloud" % "sbt-gitlab" % "0.0.6")                   // Gitlab dependencies manager

addSbtPlugin("org.jetbrains" % "sbt-ide-settings" % "1.1.0")
