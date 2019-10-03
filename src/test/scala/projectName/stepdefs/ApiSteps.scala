package projectName.stepdefs

import play.api.libs.json.Json
import projectName.api.{CatFacts, PirateTranslator, PokéApi}
import projectName.testdata.ScenarioVariables._
import projectName.testdata.StoredResponse
import projectName.testdata.models.CatFact.AbridgedCatFact
import projectName.testdata.models.PokéApi.AbridgedPokéProfile
import scalaj.http.HttpResponse

class ApiSteps extends Steps {

  When("""^the GET request is made to the Cat Facts endpoint$""") { () =>
    storedResponse = CatFacts.getCatFactById(idCatFact) match {
      case HttpResponse(body, code, _) => StoredResponse(code, body)
      case _ => fail("Did not receive a HttpResponse")
    }
  }
  When("""^the GET request is made to the PokéApi endpoint$""") { () =>
    storedResponse = PokéApi.getPokémon(pokémon) match {
      case HttpResponse(body, code, _) => StoredResponse(code, body)
      case _ => fail("Did not receive a HttpResponse")
    }
  }

  When("""^the POST request is made to the Pirate endpoint$""") { () =>
    storedResponse = PirateTranslator.postTranslation(englishText) match {
      case HttpResponse(body, code, _) => StoredResponse(code, body)
      case _ => fail("Did not receive a HttpResponse")
    }
  }

  When("""^the POST request with missing payload is made to the Pirate endpoint$""") { () =>
    storedResponse = PirateTranslator.postTranslation("Missing") match {
      case HttpResponse(body, code, _) => StoredResponse(code, body)
      case _ => fail("Did not receive a HttpResponse")
    }
  }

  Then("""^the response code should be (.*)$""") { expectedStatus: String =>
    storedResponse.code should be (expectedStatus.toInt)
  }
}
