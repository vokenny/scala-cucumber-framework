package projectName.api

import projectName.testdata.payloads.PirateTranslatorPayloads
import projectName.utils.Configuration.testConfig
import scalaj.http.HttpResponse


object PirateTranslator extends Api with PirateTranslatorPayloads {

//  See https://funtranslations.com/api/pirate for API Documentation
//  Ratelimited to 60 requests/day, at 5 requests/hour

  def postTranslation(english: String): HttpResponse[String] = {
    val url: String = s"${testConfig.pirateUrl}/pirate"
    val payload: String = TranslationBody(english)

    POST(url, payload)
  }
}
