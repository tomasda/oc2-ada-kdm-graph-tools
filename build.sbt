ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.8"


import sbt.{file, project}
import com.gilcloud.sbt.gitlab.{GitlabCredentials, GitlabPlugin}
GitlabPlugin.autoImport.gitlabDomain :=  commonSettings.OC2_ADA_GITLAB_HOST
GitlabPlugin.autoImport.gitlabProjectId :=  Option(commonSettings.OC2_ADA_GITLAB_PROJECT_ID)
GitlabPlugin.autoImport.gitlabCredentials := Option(GitlabCredentials(commonSettings.ACCESS_TOKEN_NAME,commonSettings.ACCESS_TOKEN_VALUE))

lazy val projectSettings = Seq(
  //scalaVersion := "2.12.8", //"2.13.9", //"2.12.8",
  //version := "1.0.0",
  maintainer := "opencanarias.com",
  libraryDependencies ++= Dependencies.commonDependencies,
  excludeDependencies ++= Dependencies.excludedDependencies
)

lazy val root = (project in file("."))
  .in(file("."))
  .settings(commonSettings.settings: _*)
  .settings(projectSettings: _*)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(GitlabPlugin)
  .settings(
    Seq(name := "oc2-ada-cyclomatic-complexity"),
      useCoursier := false
  )
