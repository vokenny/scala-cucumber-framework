package projectName.utils

case class TestConfig(automationUrl: String,
                      catFactUrl: String,
                      pokéApiUrl: String,
                      pirateUrl: String
                     )

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon",
        pirateUrl     = "https://api.funtranslations.com/translate"
      )

    case "dev" =>
      TestConfig(
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon",
        pirateUrl     = "https://api.funtranslations.com/translate"
      )

    case "qa" =>
      TestConfig(
        automationUrl = "http://automationpractice.com",
        catFactUrl    = "https://cat-fact.herokuapp.com",
        pokéApiUrl    = "https://pokeapi.co/api/v2/pokemon",
        pirateUrl     = "https://api.funtranslations.com/translate"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
