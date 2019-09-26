package projectName.pages.traits

import org.scalatest.Matchers
import org.scalatestplus.selenium.{Page, WebBrowser}
import projectName.stepdefs.Steps


trait BasePage extends Page with WebBrowser with Matchers with Steps {

  val url: String

  val expectedPageTitle: String
  val expectedPageHeader: String

  def currentPageTitle: String   = pageTitle
  def currentPageHeader: String  = cssSelector("h1").webElement.getText

  def assertCurrentUrl(): Unit        = currentUrl should be (url)
  def assertCurrentPageTitle(): Unit  = currentPageTitle should be (expectedPageTitle)
  def assertCurrentPageHeader(): Unit = currentPageHeader should be (expectedPageHeader)

  def shouldBeLoaded(): Unit = {
    waitForPageToLoad()
    assertCurrentUrl()
    assertCurrentPageTitle()
    assertCurrentPageHeader()
  }

  def goToPage(): Unit = goTo(url)

  def clickSignIn(): Unit = click on className("login")
}
