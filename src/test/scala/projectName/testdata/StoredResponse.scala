package projectName.testdata

import play.api.libs.json.{JsValue, Json}

class StoredResponse(statusLine: String, responseBody: String) {

  lazy val status: String = statusLine
  lazy val body: JsValue = Json.parse(responseBody)
}
