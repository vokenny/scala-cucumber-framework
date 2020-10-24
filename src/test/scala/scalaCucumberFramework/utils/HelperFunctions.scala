package scalaCucumberFramework.utils

import scalaCucumberFramework.pages.BasePage
import scalaCucumberFramework.pages.pageUtils.PageObjs
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

}
