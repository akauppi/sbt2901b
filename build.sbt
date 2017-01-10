import sbt.ProjectRef
// build.sbt
//
name := "sbt2901b"
scalaVersion := "2.11.8"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "utf8",
  "-feature",
  "-unchecked",
  "-language", "postfixOps"
)

// Note:
//  'sbt2901a' has two tags:
//    "0.0.0" where Scala 2.12 is the default
//    "0.0.0-2.11" where Scala 2.11 is the default
//
val tag = "0.0.0"
val sbt2901aUri = uri(s"https://github.com/akauppi/sbt2901a.git#tags/$tag")

dependsOn(
  ProjectRef( sbt2901aUri, "sbt2901a" )
)
