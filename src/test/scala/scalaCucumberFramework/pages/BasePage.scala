package scalaCucumberFramework.pages

import org.scalatest.Matchers
import scalaCucumberFramework.stepdefs.DriverActions

trait BasePage extends DriverActions with Matchers {

  override def toString: String = this.getClass.getSimpleName.dropRight(1) // drop trailing "$" added by Scala compiler

  def url: String
  def expectedPageTitle: String
  def expectedPageHeader: String

  def pageHeader: String = cssSelector("h1").webElement.getText
  def content: String = id("content").webElement.getText

  def shouldBeLoaded(): Unit = {
    waitForPageToLoad()
    currentUrl should be (url)
    pageTitle should be (expectedPageTitle)
    pageHeader should be (expectedPageHeader)
  }

}
