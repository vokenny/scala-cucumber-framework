package scalaCucumberFramework.connector

import scalaCucumberFramework.client.{HttpClient, RequestHeaders, StoredResponse}
import scalaCucumberFramework.utils.BaseUrls.pokeApiBaseUrl

import scala.concurrent.Future


class PokeApiConnector(implicit client: HttpClient) extends RequestHeaders {

  // See https://pokeapi.co/ for API Documentation

  def getpokemon(name: String): Future[StoredResponse] = {
    val url: String = s"$pokeApiBaseUrl/pokemon/${name.toLowerCase}"
    client.GET(url)
  }

}
