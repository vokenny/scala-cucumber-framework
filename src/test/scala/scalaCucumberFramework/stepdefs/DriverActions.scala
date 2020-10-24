package scalaCucumberFramework.stepdefs

import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import org.scalatestplus.selenium.WebBrowser
import scalaCucumberFramework.client.HttpClient
import scalaCucumberFramework.utils.SingletonDriver

object DriverActions extends WebBrowser with Matchers {

  implicit def driver: WebDriver = SingletonDriver.getDriver
  implicit val httpClient: HttpClient = new HttpClient

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(driver, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))
  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

  def pageHeader: String = cssSelector("h1").webElement.getText

  def assertCurrentUrl(url: String): Unit = currentUrl should be (url)
  def assertCurrentPageTitle(expectedPageTitle: String): Unit = pageTitle should be (expectedPageTitle)
  def assertCurrentPageHeader(expectedPageHeader: String): Unit = pageHeader should be (expectedPageHeader)

}

