package scalaCucumberFramework.stepdefs

import scalaCucumberFramework.client.StoredResponse
import scalaCucumberFramework.connector.PokeApiConnector
import scalaCucumberFramework.client.HttpClient._
import scalaCucumberFramework.testdata.ScenarioContext

import scala.concurrent.Await
import scala.concurrent.duration._

class ApiSteps extends BaseSteps {

  When("""^the GET request is made to the pokeApi endpoint$""") { () =>
    val connector: PokeApiConnector = new PokeApiConnector()
    val pokemon: String = ScenarioContext.get[String]("pokemon")

    ScenarioContext.set("storedResponse", Await.result(connector.getpokemon(pokemon), 10.seconds))
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")

    response.code should be (expectedStatus.toInt)
  }
}
