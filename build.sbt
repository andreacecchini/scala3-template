/*
 * Project configuration...
 */
scalaVersion := "3.8.1"
version := "0.0.0-SNAPSHOT"
/*
 * Static analisys configuration...
 */
scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all")
wartremoverErrors ++= {
  val excluded = Set(Wart.Var, Wart.Any)
  Warts.unsafe.filterNot(excluded.contains)
}
/*
 * Jacoco configuration...
 */
jacocoExcludes := Seq("Main*")
/*
 * Common libraries between subprojects...
 */
libraryDependencies ++= Dependencies.testing
/*
 * Project definition...
 */
lazy val root = (project in file("."))
  .settings(
    name := "scala3-template",
    // Assembly configuration...
    assembly / assemblyJarName := s"${name.value}-${version.value}-fat.jar",
    assembly / assemblyMergeStrategy := {
      case PathList("META-INF", _*) => MergeStrategy.discard
      case _                        => MergeStrategy.first
    }
  )
/*
 * Run static and dynamic analisys...
 */
addCommandAlias("check", "; fmtCheck; test")
/*
 * Run the entirely build lifecycle...
 */
addCommandAlias("build", "; fmtCheck; assembly; doc")
/*
 * As build, but bypassing sbt machine level cache...
 */
addCommandAlias("buildFull", "; cleanFull; build")
/*
 * Format...
 */
addCommandAlias("fmt", "; scalafmtAll; scalafmtSbt")
/*
 * Check format...
 */
addCommandAlias("fmtCheck", "; scalafmtCheckAll; scalafmtSbtCheck")
