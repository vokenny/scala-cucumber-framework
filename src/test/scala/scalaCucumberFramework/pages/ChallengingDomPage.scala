package scalaCucumberFramework.pages

import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object ChallengingDomPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/challenging_dom"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Challenging DOM"

}
