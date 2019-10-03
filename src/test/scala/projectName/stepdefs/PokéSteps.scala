package projectName.stepdefs

import projectName.testdata.ScenarioVariables._

class PokéSteps extends Steps {

  Given("""^we want Pokémon information for (.*)$""") { pocketMonster: String =>
    pokémon = pocketMonster
  }

  Then("""^the response body should be the (.*) profile with ID number (.*)$""") { (expectedPokéProfile: String, id: Int) =>
    pokéProfile.id should be (id)
    pokéProfile.name should be (expectedPokéProfile)
  }

  Then("""^(.*) should have the (.*) (?:ability|abilities)$""") { (expectedPokéProfile: String, abilities: String) =>
    val pokéAbilities: Seq[String] = pokéProfile.abilitiesSeq.map(_.ability.name)
    val abilitiesSeq: Seq[String] = abilities.split(", ").toSeq

    pokéProfile.name should be (expectedPokéProfile)
    abilitiesSeq.foreach(pokéAbilities should contain (_))
  }
}
