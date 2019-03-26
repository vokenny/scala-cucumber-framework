package projectName.stepdefs

import java.util.concurrent.TimeUnit

import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.support.ui.ExpectedConditions.{urlToBe, visibilityOfElementLocated}
import projectName.utils.driver.Driver
import org.openqa.selenium._
import org.openqa.selenium.support.ui.{ExpectedCondition, WebDriverWait}
import org.scalatest.Matchers
import projectName.testdata.StoredResponse
import projectName.mongo.Mongo
import projectName.testdata.ScenarioVariables._
import projectName.testdata.models.TestCust


trait Steps extends ScalaDsl with EN with Matchers {

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
      testSetUpTeardown()
      testSetUp = false
    }
  }


  After { scenario =>
    if (scenario.isFailed) {
      _driver.foreach{
        case driver: TakesScreenshot =>
          try {
            val screenshot = driver.getScreenshotAs(OutputType.BYTES)
            scenario.embed(screenshot, "image/png")
          } catch {
            case e: WebDriverException => System.err.println(s"Error creating screenshot: ${e.getMessage}")
          }
        case _ => println("Screenshot will not be taken")
      }
    }

//    Disable the following line to prevent automatic shutdown
    _driver.foreach(_.quit())
    _driver = None

    if (!testSetUp) {
      testSetUpTeardown()
      testSetUp = true
    }
  }

  def testSetUpTeardown(): Unit = {
    user = TestCust.person
    storedResponse = new StoredResponse("", "")
    idCatFact = ""
    pokémon = ""
    englishText = ""

    Mongo.dropDatabase()
  }

  def waitFor[T](condition: ExpectedCondition[T]): T = {
    val wait = new WebDriverWait(_driver.get, 10)
    wait.until(condition)
  }

  def waitForRedirect(url: String): Boolean = waitFor(urlToBe(url))

  def waitForPageToLoad(): WebElement = waitFor(visibilityOfElementLocated(By.tagName("body")))

  def waitForMillisec(time: Int): Unit = TimeUnit.MILLISECONDS.sleep(time)
}

object Steps {
  private var _driver: Option[WebDriver] = None
  private var _wait: Option[WebDriverWait] = None
}
