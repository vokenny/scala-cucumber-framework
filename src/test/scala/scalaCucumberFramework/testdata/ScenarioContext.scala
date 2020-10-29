package scalaCucumberFramework.testdata

object ScenarioContext {

  private var variables: Map[String, Any] = Map.empty

  def set(key: String, value: Any): Unit = {
    variables = variables + (key -> value)
  }

  def get[T](key: String): T = {
    variables
      .get(key)
      .fold(throw new Exception(s"Scenario variable [$key] is not found"))(_.asInstanceOf[T])
  }

  def getOrElse[T](key: String, elseResult: T): T = {
    variables
      .get(key)
      .fold(elseResult)(_.asInstanceOf[T])
  }

  def remove(key: String): Unit = variables = variables - key

  def reset(): Unit = variables.foreach { case (key, _) => remove(key) }

}
