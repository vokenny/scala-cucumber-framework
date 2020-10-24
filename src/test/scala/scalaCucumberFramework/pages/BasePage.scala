package scalaCucumberFramework.pages

import scalaCucumberFramework.stepdefs.DriverActions.{assertCurrentPageHeader, assertCurrentPageTitle, assertCurrentUrl, waitForPageToLoad}

trait BasePage {

  val url: String
  val expectedPageTitle: String
  val expectedPageHeader: String

  def shouldBeLoaded(): Unit = {
    waitForPageToLoad()
    assertCurrentUrl(url)
    assertCurrentPageTitle(expectedPageTitle)
    assertCurrentPageHeader(expectedPageHeader)
  }

}
