package projectName.testdata

import projectName.client.StoredResponse
import projectName.testdata.models.AutomationPractice.TestCust

// TODO: Refactor to ScenarioContext
object ScenarioVariables {

  var testSetUp: Boolean = true

  var user: TestCust = TestCust.person
  var storedResponse: StoredResponse = StoredResponse(0, None, None)
  var pokémon: String = ""

  def reset(): Unit = {
    user = TestCust.person
    storedResponse = StoredResponse(0, None, None)
    pokémon = ""
  }
}
