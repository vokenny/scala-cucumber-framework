package projectName.testdata

import projectName.testdata.models.TestCust


object ScenarioVariables {

  var setUp: Boolean = false
  var teardown: Boolean = false

  var user: TestCust = TestCust.person
  var storedResponse: StoredResponse = new StoredResponse("", "")
  var idCatFact: String = ""
  var pokémon: String = ""
  var englishText: String = ""
}
