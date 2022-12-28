import sbt.Keys._
import sbt.{Def, _}

import java.time.format.DateTimeFormatter
import java.time.{LocalDate, LocalTime}

object commonSettings {

  val snapShotVersion: String = s".${LocalDate.now.format(DateTimeFormatter.ofPattern("ddMMyyyy"))}-${LocalTime.now().toSecondOfDay}"

  val OC2_ADA_GITLAB_REALM = "gitlab"
  val OC2_ADA_GITLAB_HOST = "git.opencanarias.com"
  val OC2_ADA_GITLAB_PROJECT_ID = 930
  val ACCESS_TOKEN_NAME = "Private-Token"
  val ACCESS_TOKEN_VALUE = "Ysvouoybx1kWHUFfXdQ1"
  val oc2adaGitRepository = s"https://git.opencanarias.com/api/v4/projects/$OC2_ADA_GITLAB_PROJECT_ID/packages/maven"
  val gitlabCredentials = (sys.env.get("GITLAB_REPO_REALM")
    , sys.env.get("GITLAB_REPO_HOST")
    , sys.env.get("GITLAB_REPO_USER_NAME")
    , sys.env.get("GITLAB_REPO_PASSWORD")) match {
    case (Some(realm), Some(host), Some(userName), Some(password)) => Credentials(realm, host, userName, password)
    case _ => Credentials(OC2_ADA_GITLAB_REALM, OC2_ADA_GITLAB_HOST, ACCESS_TOKEN_NAME, ACCESS_TOKEN_VALUE)
  }

  val settings: Seq[Def.Setting[_]] = Seq(
    organization := "com.oc2",
    //RESOLVERS
    resolvers += "OC2 ADA Git Repository Registry" at oc2adaGitRepository,
    externalResolvers := Resolver.combineDefaultResolvers(resolvers.value.toVector, mavenCentral = true),
    // PUBLISH Artifactory OpenCanarias
    publishTo := Some("OC2 ADA Git Repository Registry publish to" at oc2adaGitRepository),
    credentials += gitlabCredentials,
    publishMavenStyle := true
  )
}

