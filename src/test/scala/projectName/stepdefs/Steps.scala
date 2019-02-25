package projectName.stepdefs

import java.lang

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import projectName.utils.driver.Driver
import org.openqa.selenium.{By, WebDriver, WebElement}
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import projectName.testdata.ScenarioVariables
import projectName.mongo.Mongo

trait Steps extends ScalaDsl with EN with Matchers {

  import Steps._

//  Tries to get the value of [[_driver]] and [[_wait]] - will throw an exception if they don't exist
  implicit def getDriverUnsafe: WebDriver = _driver.getOrElse(sys.error("Driver does not exist"))

  implicit def getWaitUnsafe: WebDriverWait = _wait.getOrElse(sys.error("WebDriverWait object does not exist"))

//  create a new driver for each scenario
  Before { _ ⇒
    if (_driver.isEmpty) {
      _driver = Some(Driver.initialiseDriver())
    }

    if (_wait.isEmpty) {
      val wdw = new WebDriverWait(_driver.get, 15, 100)
      _wait = Some(wdw)
    }

    ScenarioVariables.reset()
    Mongo.dropDatabase()
  }

  After { _ ⇒
    ScenarioVariables.reset()
    Mongo.dropDatabase()

//    Disable the following line to prevent automatic shutdown
    _driver.foreach(_.quit())
    _driver = None
  }

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(_driver.get, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))

  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))
}

object Steps {
  private var _driver: Option[WebDriver] = None
  private var _wait: Option[WebDriverWait] = None
}
