package projectName.stepdefs

import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium._
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import projectName.client.HttpClient
import projectName.testdata.ScenarioContext
import projectName.utils.Configuration.teardown
import projectName.utils.SingletonDriver

import scala.util.Try

trait Steps extends ScalaDsl with EN with Matchers with LazyLogging {

  implicit def driver: WebDriver = SingletonDriver.getDriver
  implicit val httpClient: HttpClient = new HttpClient

  Before { _ =>
    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

  After { _ =>
    if (teardown) Try(SingletonDriver.closeInstance())

    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(driver, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))

  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

}