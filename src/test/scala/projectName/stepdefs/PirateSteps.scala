package projectName.stepdefs

import projectName.testdata.ScenarioVariables._

class PirateSteps extends Steps {

  Given("""^the English text is "(.*)"$""") { english: String =>
    englishText = english
  }

  Then("""^the Pirate translation should be "(.*)"$""") { expectedPirateTranslation: String =>
    val pirateTranslation: String = (storedResponse.body \ "contents" \ "translated").get.toString()

    pirateTranslation should be ('\"' + expectedPirateTranslation + '\"')
  }
}
