package projectName.stepdefs

import projectName.testdata.ScenarioVariables.{idCatFact, storedResponse}

class CatFactSteps extends Steps {

  Given("""^the cat fact ID is (.*)$""") { id: String =>
    idCatFact = id
  }

  Then("""^the response body should contain the fact: (.*)$""") { expectedCatFact: String =>
    val catFact: String = (storedResponse.body \ "text").get.toString()
      .replaceAll("\"", "")

    catFact should be (expectedCatFact)
  }
}
