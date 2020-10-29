package scalaCucumberFramework.pages

import scalaCucumberFramework.testdata.models.theinternet.Admin
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

import scala.util.matching.Regex

object BasicAuthPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = {
    val protocol: String = theInternetBaseUrl.reverse.dropWhile(_ != '/').reverse
    val domain: String = theInternetBaseUrl.reverse.takeWhile(_ != '/').reverse
    s"$protocol${Admin.username}:${Admin.password}@$domain/basic_auth"
  }

  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Basic Auth"

  def expectedContent: Regex =
    s"""Basic Auth
       |Congratulations! You must have the proper credentials.""".stripMargin.r

}
