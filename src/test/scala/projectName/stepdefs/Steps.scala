package projectName.stepdefs

import java.util.concurrent.TimeUnit

import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import projectName.utils.driver.Driver
import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import projectName.testdata.ScenarioVariables
import projectName.mongo.Mongo
import projectName.testdata.ScenarioVariables.testSetUp

trait Steps extends ScalaDsl with EN with Matchers with LazyLogging {

  import Steps._

//  Tries to get the value of [[_driver]] and [[_wait]] - will throw an exception if they don't exist
  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))
  implicit def getWaitUnsafe: WebDriverWait = _wait.getOrElse(sys.error("WebDriverWait object does not exist"))


//  create a new driver for each scenario
  Before { _ =>
    if (_driver.isEmpty) {
      _driver = Some(Driver.initialiseDriver())
    }

    if (_wait.isEmpty) {
      val wdw = new WebDriverWait(_driver.get, 15, 100)
      _wait = Some(wdw)
    }

    if (testSetUp) {
      logger.info("Test Set Up")
      ScenarioVariables.reset()
      Mongo.dropDatabase()
      testSetUp = false
    }
  }


  After { _ =>
    // TODO: Move shutdown to config
    // Disable the following line to prevent automatic shutdown
    _driver.foreach(_.quit())
    _driver = None

    if (!testSetUp) {
      logger.info("Test Teardown")
      ScenarioVariables.reset()
      Mongo.dropDatabase()
      testSetUp = true
    }
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
