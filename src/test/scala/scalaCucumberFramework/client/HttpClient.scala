package scalaCucumberFramework.client

import akka.actor.ActorSystem
import com.typesafe.scalalogging.LazyLogging
import play.api.libs.ws.DefaultBodyWritables._
import play.api.libs.ws.ahc.StandaloneAhcWSClient

import scala.concurrent.{ExecutionContext, Future}

class HttpClient extends LazyLogging {

  implicit val actorSystem: ActorSystem = ActorSystem()
  val wsClient: StandaloneAhcWSClient = StandaloneAhcWSClient()
  implicit val ec: ExecutionContext = ExecutionContext.global

  private def logUrl(reqType: String, url: String): Unit = logger.info(s"${reqType.toUpperCase} to $url")

  def GET(url: String, headers: (String, String)*): Future[StoredResponse] = {
    logUrl("GET", url)
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .get
      .map(response => StoredResponse(
        response.status,
        Option(response.body),
        Option(response.headers)
      ))
  }

  def POST(url: String, bodyAsJson: String, headers: (String, String)*): Future[StoredResponse] = {
    logUrl("POST", url)
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .post(bodyAsJson)
      .map(response => StoredResponse(
        response.status,
        Option(response.body),
        Option(response.headers)
      ))
  }

  def DELETE(url: String, headers: (String, String)*): Future[StoredResponse] = {
    logUrl("DELETE", url)
    wsClient
      .url(url)
      .withHttpHeaders(headers: _*)
      .delete
      .map(response => StoredResponse(
        response.status,
        Option(response.body),
        Option(response.headers)
      ))
  }

}
