ThisBuild / scalaVersion := "3.8.1"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all"),
  wartremoverErrors ++= Warts.unsafe.filterNot(_ == Wart.Var),
  libraryDependencies ++= Dependencies.testing
)

lazy val root = (project in file("."))
  .settings(
    name := "scala3-template",
    commonSettings
  )

/*
 * Add command alias to apply static and dynamic analysis.
 */
addCommandAlias("check", "; scalafmtCheckAll; testFull")
