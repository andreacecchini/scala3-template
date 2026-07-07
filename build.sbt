ThisBuild / scalaVersion := "3.8.1"

lazy val commonSettings = Seq(
  scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all"),
  wartremoverErrors ++= {
    val excluded = Seq(
      Wart.Var,
      Wart.Any
    )
    Warts.unsafe.filterNot(excluded.contains)
  },
  libraryDependencies ++= Dependencies.testing
)

lazy val root = (project in file("."))
  .settings(
    name := "scala3-template",
    commonSettings
  )

/*
 * Command alias to apply static and dynamic analysis.
 */
addCommandAlias("check", "; clean; fmtCheck; testFull")
/*
 * Command alias to build the project.
 */
addCommandAlias("build", "clean; scalafmtCheckAll; compile; test; doc")
/*
 * Command alias to apply format.
 */
addCommandAlias("fmt", "; scalafmtAll; scalafmtSbt")
/*
 * Command alias to check format guidelines.
 */
addCommandAlias("fmtCheck", "; scalafmtCheckAll; scalafmtSbtCheck")
