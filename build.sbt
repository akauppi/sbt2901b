// build.sbt
//
import sbt.ProjectRef

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
//  'sbt2901a' has some tags:
//    "0.0.0"       where Scala 2.12 is the default
//    "0.0.0-2.11"  where Scala 2.11 is the default
//    "0.0.1"       with sbt 1.1.0; Scala 2.12.4 is the default
//    "0.0.1-2.11"  with sbt 1.1.0; Scala 2.11.8 is the default
//
val tag = "0.0.1"
val sbt2901aUri = uri(s"https://github.com/akauppi/sbt2901a.git#tags/$tag")

dependsOn(
  ProjectRef( sbt2901aUri, "sbt2901a" )
)
