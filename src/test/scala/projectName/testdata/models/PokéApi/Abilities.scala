package projectName.testdata.models.PokéApi

import play.api.libs.json.{Format, Json}

case class Abilities(ability: AbridgedAbility)

object Abilities {
  implicit val format: Format[Abilities] = Json.format[Abilities]
}
