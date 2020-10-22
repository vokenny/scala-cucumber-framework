package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.BaseUrls.automationBaseUrl

object HomePage extends BasePage {

  val url: String = s"$automationBaseUrl/index.php?"

  val expectedPageTitle: String = "My Store"
  val expectedPageHeader: String = "Automation Practice Website"
}
