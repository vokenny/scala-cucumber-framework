package scalaCucumberFramework.pages

import org.scalatest.Matchers
import scalaCucumberFramework.stepdefs.DriverActions

trait BasePage extends DriverActions with Matchers {

  override def toString: String = this.getClass.getSimpleName.dropRight(1) // drop trailing "$" added by Scala compiler

  val url: String
  val expectedPageTitle: String
  val expectedPageHeader: String

  def shouldBeLoaded(): Unit = {
    waitForPageToLoad()
    assertCurrentUrl()
    assertCurrentPageTitle()
    assertCurrentPageHeader()
  }

  def pageHeader: String = cssSelector("h1").webElement.getText

  def assertCurrentUrl(): Unit = currentUrl should be (url)
  def assertCurrentPageTitle(): Unit = pageTitle should be (expectedPageTitle)
  def assertCurrentPageHeader(): Unit = pageHeader should be (expectedPageHeader)

}
