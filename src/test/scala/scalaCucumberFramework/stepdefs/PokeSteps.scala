package scalaCucumberFramework.stepdefs

import scalaCucumberFramework.client.StoredResponse
import scalaCucumberFramework.stepdefs.DriverActions._
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.testdata.models.PokeApi.AbridgedPokeProfile

class PokeSteps extends BaseSteps {

  Given("""^we want pokemon information for (.*)$""") { pocketMonster: String =>
    ScenarioContext.set("pokemon", pocketMonster)
  }

  Then("""^the response body should be the (.*) profile with ID number (.*)$""") { (expectedpokeProfile: String, id: Int) =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")
    val pokeProfile: AbridgedPokeProfile = response.body.as[AbridgedPokeProfile]

    pokeProfile.id should be (id)
    pokeProfile.name should be (expectedpokeProfile)
  }

  Then("""^(.*) should have the (.*) (?:ability|abilities)$""") { (expectedpokeProfile: String, abilities: String) =>
    val response = ScenarioContext.get[StoredResponse]("storedResponse")
    val pokeProfile: AbridgedPokeProfile = response.body.as[AbridgedPokeProfile]
    val pokeAbilities: Seq[String] = pokeProfile.abilitiesSeq.map(_.ability.name)

    pokeProfile.name should be (expectedpokeProfile)
    abilities.split(", ").foreach(pokeAbilities should contain (_))
  }
}
