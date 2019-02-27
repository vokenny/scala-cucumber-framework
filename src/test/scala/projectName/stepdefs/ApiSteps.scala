package projectName.stepdefs

import projectName.api.{CatFacts, PirateTranslator, PokéApi}
import projectName.testdata.ScenarioVariables._
import projectName.testdata.StoredResponse

class ApiSteps extends Steps {

  When("""^the (GET|POST|PUT|DELETE) request to the (.*) endpoint is made$""") { (request: String, endpoint: String) =>
    val response = (request, endpoint) match {
      case ("GET", "Cat Facts") => CatFacts.getCatFactById(idCatFact)
      case ("GET", "PokéApi")   => PokéApi.getPokémon(pokémon)
      case ("POST", "Pirate")   => PirateTranslator.postTranslation(englishText)
    }

    storedResponse = new StoredResponse(response.statusLine, response.body)
  }

  Then("""^the response status should be (.*)$""") { expectedStatus: String =>
    storedResponse.status should be ("HTTP/1.1 " + expectedStatus)
  }
}
