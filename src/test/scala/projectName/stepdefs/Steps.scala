package projectName.stepdefs

import java.util.concurrent.TimeUnit

import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import projectName.utils.driver.Driver
import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import projectName.client.HttpClient
import projectName.mongo.Mongo
import projectName.testdata.ScenarioContext

trait Steps extends ScalaDsl with EN with Matchers with LazyLogging {

  import Steps._

  // Tries to get the value of [[_driver]] and [[_wait]] - will throw an exception if they don't exist
  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))
  implicit def getWaitUnsafe: WebDriverWait = _wait.getOrElse(sys.error("WebDriverWait object does not exist"))

  val httpClient = new HttpClient

  // Create a new driver for each scenario
  Before { _ =>
    if (_driver.isEmpty) {
      _driver = Some(Driver.initialiseDriver())
    }

    if (_wait.isEmpty) {
      val wdw = new WebDriverWait(_driver.get, 15, 100)
      _wait = Some(wdw)
    }

    logger.info("Test Set Up")
    ScenarioContext.reset()
    Mongo.dropDatabase()
  }


  After { _ =>
    // TODO: Add shutdown to config
    // Disable the following line to prevent automatic shutdown
    _driver.foreach(_.quit())
    _driver = None

    logger.info("Test Teardown")
    ScenarioContext.reset()
    Mongo.dropDatabase()
  }

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(_driver.get, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))

  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

  // Thread.sleep - if you're desperate
  def waitForMillisec(time: Int): Unit = TimeUnit.MILLISECONDS.sleep(time)
}

object Steps {
  private var _driver: Option[WebDriver] = None
  private var _wait: Option[WebDriverWait] = None
}
