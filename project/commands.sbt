/*
 * Run static and dynamic analisys...
 */
addCommandAlias("check", "; fmtCheck; testFull")
/*
 * Run the entirely build lifecycle...
 */
addCommandAlias("build", "; scalafmtCheckAll; compile; test; doc; assembly")
/*
 * As build, but bypassing sbt machine level cache...
 */
addCommandAlias(
  "buildFresh",
  "; cleanFull; scalafmtCheckAll; compile; test; doc; assembly"
)
/*
 * Format...
 */
addCommandAlias("fmt", "; scalafmtAll; scalafmtSbt")
/*
 * Check format...
 */
addCommandAlias("fmtCheck", "; scalafmtCheckAll; scalafmtSbtCheck")
