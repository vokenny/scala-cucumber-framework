package projectName.pages

import projectName.pages.traits.BasePage
import projectName.utils.Configuration.testConfig

object AuthPage extends BasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?controller=authentication&back=my-account"

  val expectedPageTitle: String = "Login - My Store"
  val expectedPageHeader: String = "AUTHENTICATION"

  def enterEmail(email: String): Unit = id("email_create").webElement.sendKeys(email)

  def clickCreateAccount(): Unit = click on id("SubmitCreate")
}
