package projectName.api

import projectName.utils.Configuration.testConfig
import scalaj.http.HttpResponse


object PokéApi extends Api {

//  See https://pokeapi.co/ for API Documentation

  def getPokémon(name: String): HttpResponse[String] = {
    val url = s"${testConfig.pokéApiUrl}/${name.toLowerCase}"

    GET(url)
  }
}
