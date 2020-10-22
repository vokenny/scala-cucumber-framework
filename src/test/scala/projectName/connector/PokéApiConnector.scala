package projectName.connector

import projectName.client.{HttpClient, RequestHeaders, StoredResponse}
import projectName.utils.BaseUrls.pokéApiBaseUrl

import scala.concurrent.Future


class PokéApiConnector(implicit client: HttpClient) extends RequestHeaders {

  // See https://pokeapi.co/ for API Documentation

  def getPokémon(name: String): Future[StoredResponse] = {
    val url: String = s"$pokéApiBaseUrl/${name.toLowerCase}"
    client.GET(url)
  }

}
