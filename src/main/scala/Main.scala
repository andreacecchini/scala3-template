/** Entrypoint of the program.
  */
object Main:
  /** The name of the project.
    */
  val projectName: String = "scala3-template"

  /** Greet who runs the program.
    */
  val greetingMessage: String = s"Welcome to $projectName"

  /** This method is the entry point of the program.
    * @param args
    *   unused
    */
  def main(args: Array[String]): Unit =
    println(f"Welcome to $projectName!")
