package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.Configuration.testConfig

object AccountPage extends BasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?controller=my-account"

  def expectedPageTitle: String = "My account - My Store"
  def expectedPageHeader: String = "MY ACCOUNT"
}
