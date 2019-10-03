package projectName.stepdefs

import projectName.testdata.ScenarioVariables._
import projectName.testdata.models.PokéApi.AbridgedPokéProfile

class PokéSteps extends Steps {

  Given("""^we want Pokémon information for (.*)$""") { pocketMonster: String =>
    pokémon = pocketMonster
  }

  Then("""^the response body should be the (.*) profile with ID number (.*)$""") { (expectedPokéProfile: String, id: Int) =>
    pokéProfile.id should be (id)
    pokéProfile.name should be (expectedPokéProfile)
  }

  Then("""^(.*) should have the (.*) (?:ability|abilities)$""") { (expectedPokéProfile: String, abilities: String) =>
    val pokéProfile: AbridgedPokéProfile = storedResponse.body.as[AbridgedPokéProfile]
    val pokéAbilities: Seq[String] = pokéProfile.abilitiesSeq.map(_.ability.name)

    pokéProfile.name should be (expectedPokéProfile)
    abilities.split(", ").foreach(pokéAbilities should contain (_))
  }
}
