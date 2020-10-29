package scalaCucumberFramework.stepdefs

import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.scalatestplus.selenium.WebBrowser
import scalaCucumberFramework.utils.SingletonDriver

trait DriverActions extends WebBrowser {

  implicit def driver: WebDriver = SingletonDriver.getDriver

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(driver, 5)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))
  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

  def dragAndDrop(from: WebElement, to: WebElement): Unit = {
    val actions = new Actions(driver)

    // Actions dragAndDrop doesn't work with Chromedriver
    //actions.dragAndDrop(from, to)

    // Separating out the actions ourselves doesn't work in ChromeDriver either
    actions
      .clickAndHold(from)
      .moveByOffset(0, -1)
      .moveToElement(to)
      .release(to)
      .build()
      .perform()
  }

}