package projectName.stepdefs

import projectName.testdata.ScenarioVariables._
import projectName.testdata.models.PirateTranslation.AbridgedPirateTranslation

class PirateSteps extends Steps {

  Given("""^the English text is "(.*)"$""") { english: String =>
    englishText = english
  }

  Then("""^the Pirate translation should be (.*)$""") { expectedPirateTranslation: String =>
    val pirateResponse: AbridgedPirateTranslation = storedResponse.body.as[AbridgedPirateTranslation]

    pirateResponse.original should be (englishText)
    pirateResponse.translation should be (expectedPirateTranslation)
  }
}
