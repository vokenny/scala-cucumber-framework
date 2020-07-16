package projectName.api

import scalaj.http.HttpResponse
import projectName.utils.Configuration.testConfig


object CatFacts extends RequestBuilder {

//  See https://alexwohlbruck.github.io/cat-facts/docs/ for API Documentation

  def getCatFactById(id: String): HttpResponse[String] = {
    val url: String = s"${testConfig.catFactUrl}/facts/$id"

    GET(url)
  }
}
