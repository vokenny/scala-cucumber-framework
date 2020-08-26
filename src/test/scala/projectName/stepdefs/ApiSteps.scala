package projectName.stepdefs

import projectName.api.PokéApi
import projectName.testdata.ScenarioVariables._
import projectName.testdata.StoredResponse
import scalaj.http.HttpResponse

class ApiSteps extends Steps {

  When("""^the GET request is made to the PokéApi endpoint$""") { () =>
    storedResponse = PokéApi.getPokémon(pokémon) match {
      case HttpResponse(body, code, _) => StoredResponse(code, body)
      case _ => fail("Did not receive a HttpResponse")
    }
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    storedResponse.code should be (expectedStatus.toInt)
  }
}
