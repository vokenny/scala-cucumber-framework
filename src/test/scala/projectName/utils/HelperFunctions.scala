package projectName.utils

import projectName.pages._
import projectName.pages.traits.BasePage


object HelperFunctions extends BasePage {

  val url = ""

  val expectedPageTitle = ""
  val expectedPageHeader = ""

  override def shouldBeLoaded(): Unit = {}

  def navigateTo(page: String): Unit = {
    page match {
      case "Home"   => HomePage.goToPage()
      case "Google" => goTo("https://www.google.com")
    }
  }

  def expectedPage(page: String): Unit = {
    page match {
      case "Home"           => HomePage.shouldBeLoaded()
      case "Authentication" => AuthPage.shouldBeLoaded()
      case "Account"        => AccountPage.shouldBeLoaded()
      case "Registration"   =>
        waitForRedirect(RegistrationPage.url)
        RegistrationPage.shouldBeLoaded()
    }
  }

  def clickOn(elem: String): Unit = {
    elem match {
      case "Sign In" => HelperFunctions.clickSignIn()
    }
  }
}
