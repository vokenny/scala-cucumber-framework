package projectName.utils

case class TestConfig(googleUrl: String,
                      automationUrl: String
                     )

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://www.automationpractice.com"
      )

    case "dev" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://www.automationpractice.com"
      )

    case "qa" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://www.automationpractice.com"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
