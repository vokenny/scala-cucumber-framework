package projectName.testdata

import projectName.testdata.models.AutomationPractice.TestCust
import projectName.testdata.models.PokéApi.{Abilities, AbridgedAbility, AbridgedPokéProfile}


object ScenarioVariables {

  var testSetUp: Boolean = true

  var user: TestCust = TestCust.person
  var storedResponse: StoredResponse = StoredResponse(0, "")
  var idCatFact: String = ""
  var pokémon: String = ""
  var pokéProfile: AbridgedPokéProfile = AbridgedPokéProfile(0, "", Seq(Abilities(AbridgedAbility("", ""))))
  var englishText: String = ""

  def reset(): Unit = {
    user = TestCust.person
    storedResponse = StoredResponse(0, "")
    idCatFact = ""
    pokémon = ""
    pokéProfile = AbridgedPokéProfile(0, "", Seq(Abilities(AbridgedAbility("", ""))))
    englishText = ""
  }
}
