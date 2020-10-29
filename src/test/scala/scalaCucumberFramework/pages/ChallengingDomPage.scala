package scalaCucumberFramework.pages

import org.openqa.selenium.WebElement
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object ChallengingDomPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/challenging_dom"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Challenging DOM"

  def randomisedBtns: List[WebElement] =
    findAll(cssSelector("div.large-2.columns > a")).map(_.underlying).toList
}
