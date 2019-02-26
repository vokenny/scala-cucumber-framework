package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.Configuration.testConfig

object HomePage extends BasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?"

  def expectedPageTitle: String = "My Store"
  def expectedPageHeader: String = "Automation Practice Website"
}
