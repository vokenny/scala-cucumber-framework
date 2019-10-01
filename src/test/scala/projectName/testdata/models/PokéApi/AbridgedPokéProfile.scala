package projectName.testdata.models.PokéApi

import play.api.libs.json.JsValue

// PokéApi returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedPokéProfile(id: Int, name: String)

object AbridgedPokéProfile {

  def reads(json: JsValue): AbridgedPokéProfile = {
    AbridgedPokéProfile(
      (json \ "id").as[Int],
      (json \ "name").as[String]
    )
  }
}
