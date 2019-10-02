package projectName.testdata.models.PokéApi

import play.api.libs.json.{JsResult, JsValue, Reads}

// PokéApi returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedPokéProfile(id: Int, name: String)

object AbridgedPokéProfile {

  implicit val reads: Reads[AbridgedPokéProfile] = new Reads[AbridgedPokéProfile] {
    def reads(json: JsValue): JsResult[AbridgedPokéProfile] = {
      for {
        id <- (json \ "id").validate[Int]
        name <- (json \ "name").validate[String]
      } yield {
        AbridgedPokéProfile(id, name)
      }
    }
  }
}
