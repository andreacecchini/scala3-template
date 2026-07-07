ThisBuild / scalaVersion := "3.8.1"

lazy val commonSettings = Seq(
  // Linting settings...
  scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all"),
  wartremoverErrors ++= {
    val excluded = Set(
      Wart.Var,
      Wart.Any
    )
    Warts.unsafe.filterNot(excluded.contains)
  },
  // Jacoco settings...
  jacocoExcludes := Seq("Main*"),
  // Assembly settings...
  assembly / assemblyJarName := s"${name.value}-${version.value}-fat.jar",
  // Common depeendencies...
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
addCommandAlias("check", "; fmtCheck; testFull")
/*
 * Command alias to build the project.
 */
addCommandAlias("build", "; scalafmtCheckAll; compile; test; doc; assembly")
/*
 * As build command alias, bypassing sbt 2.0 machine level cache
 */
addCommandAlias(
  "buildFresh",
  "; cleanFull; scalafmtCheckAll; compile; test; doc; assembly"
)
/*
 * Command alias to apply format.
 */
addCommandAlias("fmt", "; scalafmtAll; scalafmtSbt")
/*
 * Command alias to check format guidelines.
 */
addCommandAlias("fmtCheck", "; scalafmtCheckAll; scalafmtSbtCheck")
