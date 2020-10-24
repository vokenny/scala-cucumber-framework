package scalaCucumberFramework.utils

import scalaCucumberFramework.pages.{BasePage, _}
import scalaCucumberFramework.stepdefs.DriverActions._

object HelperFunctions {

  // TODO: Refactor to convert String to Objects (functional), then go to their page object URLs
  def navigateTo(page: String): Unit = {
    val url: String = page match {
      case "Home"   => HomePage.url
      case "Google" => "https://www.google.com"
    }

    goTo(url)
  }

  // TODO: Refactor to convert String to Objects (functional), then go to their page object URLs
  def expectedPage(pageStr: String): Unit = {
    val page: BasePage = pageStr match {
      case "Home" => HomePage
    }

    page.shouldBeLoaded()
  }

}
