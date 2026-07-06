import sbt.*

/** Contains the project dependencies.
  */
object Dependencies:
  object Modules:
    /*
     * Scalatest
     */
    val scalaTest = "org.scalatest" %% "scalatest" % "3.2.20"
    /*
     * Mockito
     */
    val mockito = "org.scalatestplus" %% "mockito-5-23" % "3.2.20.0"

  import Modules.*

  /** A sequence of testing dependencies.
    */
  val testing: Seq[ModuleID] = Seq(scalaTest, mockito) map (_ % Test)
