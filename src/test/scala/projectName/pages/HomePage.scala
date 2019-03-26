package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.Configuration.testConfig

object HomePage extends BasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?"

  val expectedPageTitle: String = "My Store"
  val expectedPageHeader: String = "Automation Practice Website"
}
