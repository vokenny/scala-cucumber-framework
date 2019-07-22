package projectName.api

import scalaj.http.{Http, HttpOptions, HttpResponse}


trait Api {

  val jsonHeader: Map[String, String] = Map("Content-Type" -> "application/json")

  def authHeader(token: String): Map[String, String] = Map("Authorization" -> token)

  def commonHeaders(token: String): Map[String, String] = Map("Content-Type" -> "application/json", "Authorization" -> token)

  def sessionIdHeader: Map[String, String] = Map("X-session-id" -> getSessionId)

  def getSessionId: String = "Placeholder"

  def GET(url: String, header: Map[String, String]*): HttpResponse[String] = {
    Http(url)
      .headers(header.flatten)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def POST(url: String, payload: String, header: Map[String, String]*): HttpResponse[String] = {
    Http(url)
      .postData(payload)
      .headers(header.flatten)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def PUT(url: String, payload: String, header: Map[String, String]*): HttpResponse[String] = {
    Http(url)
      .put(payload)
      .headers(header.flatten)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def DELETE(url: String, header: Map[String, String]*): HttpResponse[String] = {
    Http(url)
      .method("DELETE")
      .headers(header.flatten)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }
}
