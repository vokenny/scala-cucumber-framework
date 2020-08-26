package projectName.stepdefs

import projectName.connector.PokéApiConnector
import projectName.testdata.ScenarioVariables._

import scala.concurrent.Await
import scala.concurrent.duration._

class ApiSteps extends Steps {

  When("""^the GET request is made to the PokéApi endpoint$""") { () =>
    val connector = new PokéApiConnector(httpClient)
    storedResponse = Await.result(connector.getPokémon(pokémon), 10.seconds)
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    storedResponse.code should be (expectedStatus.toInt)
  }
}
