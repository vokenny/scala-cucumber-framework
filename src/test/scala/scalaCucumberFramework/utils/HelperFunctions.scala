package scalaCucumberFramework.utils

import org.openqa.selenium.WebElement
import scalaCucumberFramework.pages.{BasePage, DynamicLoadingExample1Page, DynamicLoadingExample2Page}
import scalaCucumberFramework.stepdefs.DriverActions

object HelperFunctions extends DriverActions {

  def navigateTo(pageStr: String): Unit = {
    val page: BasePage = PageObjs.fromString(pageStr)
    goTo(page.url)
  }

  def expectedPage(pageStr: String): Unit = {
    val page: BasePage = PageObjs.fromString(pageStr)
    page.shouldBeLoaded()
  }

  def clickStart(): WebElement = {
    if (currentUrl == DynamicLoadingExample1Page.url) DynamicLoadingExample1Page.startButton
    else DynamicLoadingExample2Page.startButton
  }

}
