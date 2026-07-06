ThisBuild / scalaVersion := "3.8.1"

import Dependencies.*

lazy val root = (project in file("."))
  .settings(
    name := "scala3-template",
    libraryDependencies ++= Seq(
      scalaTest
    ),
    wartremoverErrors ++= Warts.unsafe.filterNot(_ == Wart.Var)
  )

/*
 * Add command alias to apply static and dynamic analysis.
 */
addCommandAlias("check", "; scalafmtCheckAll; testFull")
