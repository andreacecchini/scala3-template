/*
 * "Bare" global settings, applied to all subprojects...
 */
scalaVersion := "3.8.1"
scalacOptions ++= Seq("-Werror", "-Wall", "-Wunused:all")
wartremoverErrors ++= {
  val excluded = Set(Wart.Var, Wart.Any)
  Warts.unsafe.filterNot(excluded.contains)
}
jacocoExcludes := Seq("Main*")
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
