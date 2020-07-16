package projectName.testdata.models.CatFact

import play.api.libs.json.{JsResult, JsValue, Reads}

// Cat Fact returns a lot of data that I don't care about
// so I only take what I want to assert
case class AbridgedCatFact(_id: String, text: String)

object AbridgedCatFact {

  implicit val reads: Reads[AbridgedCatFact] = new Reads[AbridgedCatFact] {
    def reads(json: JsValue): JsResult[AbridgedCatFact] = {
      for {
        id <- (json \ "_id").validate[String]
        text <- (json \ "text").validate[String]
      } yield AbridgedCatFact(id, text)
    }
  }
}
