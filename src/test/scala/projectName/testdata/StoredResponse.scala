package projectName.testdata

import play.api.libs.json.{JsValue, Json}

case class StoredResponse(code: Int, responseBody: String) {

  lazy val body: JsValue = Json.parse(responseBody)
}
