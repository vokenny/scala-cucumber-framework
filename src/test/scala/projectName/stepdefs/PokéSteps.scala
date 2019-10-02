package projectName.stepdefs

import projectName.testdata.ScenarioVariables._
import projectName.testdata.models.PokéApi.AbridgedPokéProfile

class PokéSteps extends Steps {

  Given("""^we want Pokémon information for (.*)$""") { pocketMonster: String =>
    pokémon = pocketMonster
  }

  Then("""^the response body should be the (.*) profile with ID number (.*)$""") { (expectedPokéProfile: String, id: Int) =>
    val pokéProfile: AbridgedPokéProfile = storedResponse.body.as[AbridgedPokéProfile]

    pokéProfile.id should be (id)
    pokéProfile.name should be (expectedPokéProfile)
  }
}
