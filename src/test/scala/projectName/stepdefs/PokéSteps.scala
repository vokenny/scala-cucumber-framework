package projectName.stepdefs

import projectName.client.StoredResponse
import projectName.testdata.ScenarioContext
import projectName.testdata.models.PokéApi.AbridgedPokéProfile

class PokéSteps extends Steps {

  Given("""^we want Pokémon information for (.*)$""") { pocketMonster: String =>
    ScenarioContext.set("pokémon", pocketMonster)
  }

  Then("""^the response body should be the (.*) profile with ID number (.*)$""") { (expectedPokéProfile: String, id: Int) =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")
    val pokéProfile: AbridgedPokéProfile = response.body.as[AbridgedPokéProfile]

    pokéProfile.id should be (id)
    pokéProfile.name should be (expectedPokéProfile)
  }

  Then("""^(.*) should have the (.*) (?:ability|abilities)$""") { (expectedPokéProfile: String, abilities: String) =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")
    val pokéProfile: AbridgedPokéProfile = response.body.as[AbridgedPokéProfile]
    val pokéAbilities: Seq[String] = pokéProfile.abilitiesSeq.map(_.ability.name)

    pokéProfile.name should be (expectedPokéProfile)
    abilities.split(", ").foreach(pokéAbilities should contain (_))
  }
}
