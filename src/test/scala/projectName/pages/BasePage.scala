package projectName.pages

import org.scalatest.Matchers
import org.scalatest.selenium.WebBrowser
import projectName.pages.HomePage.className
import projectName.stepdefs.Steps


trait BasePage extends org.scalatest.selenium.Page with WebBrowser with Matchers with Steps {

  val url: String

  def expectedPageTitle: String
  def expectedPageHeader: String

  def currentPageTitle: String = pageTitle
  def currentPageService: String = cssSelector("#proposition-menu > span").webElement.getText
  def currentPageHeader: String = cssSelector("h1").webElement.getText

  def assertCurrentUrl(): Unit = currentUrl should be (url)
  def assertCurrentPageTitle(): Unit = currentPageTitle should be (expectedPageTitle)
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
