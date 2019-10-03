package projectName.testdata.models.PokéApi

import play.api.libs.json._


case class AbridgedAbility(name: String, url: String)

object AbridgedAbility {
  implicit val format: Format[AbridgedAbility] = Json.format[AbridgedAbility]
}

case class Abilities(ability: AbridgedAbility)

object Abilities {
  implicit val format: Format[Abilities] = Json.format[Abilities]
}

// PokéApi returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedPokéProfile(id: Int, name: String, abilitiesSeq: Seq[Abilities])

object AbridgedPokéProfile {

  implicit val reads: Reads[AbridgedPokéProfile] = new Reads[AbridgedPokéProfile] {
    def reads(json: JsValue): JsResult[AbridgedPokéProfile] = {
      for {
        abilities <- (json \ "abilities").validate[Seq[Abilities]]
        id <- (json \ "id").validate[Int]
        name <- (json \ "name").validate[String]
      } yield {
        AbridgedPokéProfile(id, name, abilities)
      }
    }
  }
}
