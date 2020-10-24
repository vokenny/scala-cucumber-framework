package scalaCucumberFramework.pages

import scalaCucumberFramework.utils.BaseUrls.automationBaseUrl

object HomePage extends BasePage {

  val url: String = s"$automationBaseUrl/index.php?"
  val expectedPageTitle: String = "My Store"
  val expectedPageHeader: String = "Automation Practice Website"

}
