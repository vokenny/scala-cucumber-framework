package projectName.testdata

import projectName.testdata.models.TestCust


object ScenarioVariables {

  var user: TestCust = TestCust.person
  var storedResponse: StoredResponse = new StoredResponse("", "")

  def reset(): Unit = {
    user = TestCust.person
    storedResponse = new StoredResponse("", "")
  }
}
