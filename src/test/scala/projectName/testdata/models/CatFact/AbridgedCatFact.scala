package projectName.testdata.models.CatFact

import play.api.libs.json.JsValue

// Cat Fact returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedCatFact(_id: String, text: String)

object AbridgedCatFact {

  def reads(json: JsValue): AbridgedCatFact = {
    AbridgedCatFact(
      (json \ "_id").as[String],
      (json \ "text").as[String]
    )
  }
}
