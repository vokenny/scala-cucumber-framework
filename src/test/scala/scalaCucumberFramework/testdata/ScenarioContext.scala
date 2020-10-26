package scalaCucumberFramework.testdata

object ScenarioContext {

  private var variables: Map[String, Any] = Map.empty

  def set(key: String, value: Any): Unit = {
    variables = variables + (key -> value)
  }

  def get[T](key: String): T = {
    variables.get(key).map(_.asInstanceOf[T]) match {
      case Some(v) => v
      case None => throw new Exception(s"Scenario variable [$key] is not found")
    }
  }

  def reset(): Unit = variables.foreach { case (key, _) => variables - key }

}
