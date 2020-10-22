package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.BaseUrls.automationBaseUrl

// TODO: Use the-internet Heroku for test automation practice
object AccountPage extends BasePage {

  val url: String = s"$automationBaseUrl/index.php?controller=my-account"

  val expectedPageTitle: String = "My account - My Store"
  val expectedPageHeader: String = "MY ACCOUNT"
}
