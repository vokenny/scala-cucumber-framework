package projectName.testdata.models.PirateTranslation

import play.api.libs.json.{JsResult, JsValue, Reads}

// AbridgedPirateTranslation returns some data that I don't care about
// so I only take what I want to assert
case class AbridgedPirateTranslation(translation: String, original: String)

object AbridgedPirateTranslation {

  implicit val reads: Reads[AbridgedPirateTranslation] = new Reads[AbridgedPirateTranslation] {
    def reads(json: JsValue): JsResult[AbridgedPirateTranslation] = {
      for {
        translation <- (json \ "contents" \ "translated").validate[String]
        original <- (json \ "contents" \ "text").validate[String]
      } yield AbridgedPirateTranslation(translation, original)
    }
  }
}
