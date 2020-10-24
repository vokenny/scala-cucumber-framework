package scalaCucumberFramework.testdata.models.pokeapi

import play.api.libs.json.{Format, Json}

case class AbridgedAbility(name: String, url: String)

object AbridgedAbility {
  implicit val format: Format[AbridgedAbility] = Json.format[AbridgedAbility]
}
