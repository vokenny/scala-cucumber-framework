package projectName.stepdefs

import projectName.client.StoredResponse
import projectName.connector.PokéApiConnector
import projectName.testdata.ScenarioContext

import scala.concurrent.Await
import scala.concurrent.duration._

class ApiSteps extends Steps {

  When("""^the GET request is made to the PokéApi endpoint$""") { () =>
    val connector: PokéApiConnector = new PokéApiConnector()
    val pokémon: String = ScenarioContext.get[String]("pokémon")

    ScenarioContext.set("storedResponse", Await.result(connector.getPokémon(pokémon), 10.seconds))
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")

    response.code should be (expectedStatus.toInt)
  }
}
