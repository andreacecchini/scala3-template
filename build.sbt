ThisBuild / scalaVersion := "3.8.1"

import Dependencies.*

lazy val root = (project in file("."))
  .settings(
    name := "scala3-template",
    libraryDependencies ++= Seq(
      scalaTest,
    )
  )
