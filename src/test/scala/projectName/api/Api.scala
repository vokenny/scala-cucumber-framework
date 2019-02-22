package projectName.api

import scalaj.http.{Http, HttpOptions, HttpResponse}


trait Api {

  val jsonHeader: Map[String, String] = Map("Content-Type" -> "application/json")

  def GET(url: String): HttpResponse[String] = {
    Http(url)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def POST(url: String, payload: String): HttpResponse[String] = {
    Http(url)
      .postData(payload)
      .headers(jsonHeader)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def PUT(url: String, payload: String): HttpResponse[String] = {
    Http(url)
      .put(payload)
      .headers(jsonHeader)
      .option(HttpOptions.readTimeout(20000))
      .asString
  }

  def DELETE(url: String): HttpResponse[String] = {
    Http(url)
      .method("DELETE")
      .option(HttpOptions.readTimeout(20000))
      .asString
  }
}
