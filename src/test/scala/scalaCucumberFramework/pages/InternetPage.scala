package scalaCucumberFramework.pages

import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object InternetPage extends BasePage {

  val url: String = theInternetBaseUrl
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Welcome to the-internet"

}
