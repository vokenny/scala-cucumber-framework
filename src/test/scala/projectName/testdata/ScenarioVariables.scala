package projectName.testdata

import projectName.testdata.models.AutomationPractice.TestCust


object ScenarioVariables {

  var testSetUp: Boolean = true

  var user: TestCust = TestCust.person
  var storedResponse: StoredResponse = StoredResponse(0, "")
  var idCatFact: String = ""
  var pokémon: String = ""
  var englishText: String = ""

  def reset(): Unit = {
    user = TestCust.person
    storedResponse = StoredResponse(0, "")
    idCatFact = ""
    pokémon = ""
    englishText = ""
  }
}
