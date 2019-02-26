package projectName.stepdefs

import projectName.testdata.ScenarioVariables._

class PokéSteps extends Steps {

  Given("""^we want Pokémon information for (.*)$""") { poketMonster: String =>
    pokémon = poketMonster
  }

  Then("""^the response body should be the (.*) profile$""") { expectedPokéProfile: String =>
    val pokéProfile: String = (storedResponse.body \ "species" \ "name").get.toString()

    pokéProfile should be ('\"' + expectedPokéProfile.toLowerCase + '\"')
  }
}
