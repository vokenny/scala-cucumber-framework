package scalaCucumberFramework.stepdefs

import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatestplus.selenium.WebBrowser
import scalaCucumberFramework.utils.SingletonDriver

trait DriverActions extends WebBrowser {

  implicit def driver: WebDriver = SingletonDriver.getDriver

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(driver, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))
  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

}

