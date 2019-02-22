package projectName.testdata


object ScenarioVariables {

  var storedResponse: StoredResponse = new StoredResponse("", "")
  var testVar = ""

  def reset(): Unit = {
    storedResponse = new StoredResponse("", "")
    testVar = ""
  }
}
