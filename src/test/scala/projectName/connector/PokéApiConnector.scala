package projectName.connector

import projectName.client.{HttpClient, RequestHeaders, StoredResponse}
import projectName.utils.Configuration.testConfig

import scala.concurrent.Future


class PokéApiConnector(client: HttpClient) extends RequestHeaders {

  // See https://pokeapi.co/ for API Documentation

  def getPokémon(name: String): Future[StoredResponse] = {
    val url: String = s"${testConfig.pokéApiUrl}/${name.toLowerCase}"
    client.GET(url)
  }

}
