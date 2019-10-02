package projectName.stepdefs

import projectName.testdata.ScenarioVariables.{idCatFact, storedResponse}
import projectName.testdata.models.CatFact.AbridgedCatFact

class CatFactSteps extends Steps {

  Given("""^the cat fact ID is (.*)$""") { id: String =>
    idCatFact = id
  }

  Then("""^the response body should contain the fact: (.*)$""") { expectedCatFact: String =>
    val catFactResponse: AbridgedCatFact = storedResponse.body.as[AbridgedCatFact]

    catFactResponse._id should be (idCatFact)
    catFactResponse.text should be (expectedCatFact)
  }
}
