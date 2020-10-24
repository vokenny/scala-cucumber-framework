package scalaCucumberFramework.client

import play.api.libs.json.{JsValue, Json}

case class StoredResponse(code: Int, responseBody: Option[String], headers: Option[Map[String, Seq[String]]]) {

  lazy val body: JsValue = responseBody match {
    case Some(b) => Json.parse(b)
    case None => throw new Exception("No response body to parse to JSON")
  }

  lazy val strBody: String = responseBody match {
    case Some(b) => b.toString
    case None => throw new Exception("No response body to transform to String type")
  }

}
