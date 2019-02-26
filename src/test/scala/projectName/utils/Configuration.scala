package projectName.utils

case class TestConfig(googleUrl: String,
                      automationUrl: String,
                      catFactUrl: String,
                      pokéApiUrl: String
                     )

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon"
      )

    case "dev" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon"
      )

    case "qa" =>
      TestConfig(
        googleUrl     = "https://www.google.com",
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
