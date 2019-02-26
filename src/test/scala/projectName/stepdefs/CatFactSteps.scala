package projectName.stepdefs

import projectName.testdata.ScenarioVariables._

class CatFactSteps extends Steps {

  Given("""^the cat fact ID is (.*)$""") { id: String =>
    idCatFact = id
  }

  Then("""^the response body should contain the fact: (.*)$""") { expectedCatFact: String =>
    val catFact: String = (storedResponse.body \ "text").get.toString()

    catFact should be (expectedCatFact)
  }
}
