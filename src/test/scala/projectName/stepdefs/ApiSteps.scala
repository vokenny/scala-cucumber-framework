package projectName.stepdefs

import projectName.api.{CatFacts, PirateTranslator, PokéApi}
import projectName.testdata.ScenarioVariables._
import projectName.testdata.StoredResponse
import scalaj.http.HttpResponse

class ApiSteps extends Steps {

  When("""^the (GET|POST|PUT|DELETE) request is made to the (.*) endpoint$""") { (request: String, endpoint: String) =>
    val response: HttpResponse[String] = (request, endpoint) match {
      case ("GET", "Cat Facts") => CatFacts.getCatFactById(idCatFact)
      case ("GET", "PokéApi")   => PokéApi.getPokémon(pokémon)
      case ("POST", "Pirate")   => PirateTranslator.postTranslation(englishText)
    }

    storedResponse = StoredResponse(response.code, response.body)
  }

  When("""^the (POST|PUT) request with missing payload is made to the (.*) endpoint$""") { (request: String, endpoint: String) =>
    val response = (request, endpoint) match {
      case ("POST", "Pirate")   => PirateTranslator.postTranslation("Missing")
    }

    storedResponse = StoredResponse(response.code, response.body)
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    storedResponse.code should be (expectedStatus.toInt)
  }
}
