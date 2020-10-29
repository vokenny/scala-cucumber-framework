package scalaCucumberFramework.stepdefs

import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.Matchers
import org.scalatest.concurrent.Eventually
import org.scalatest.time.{Millis, Seconds, Span}
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.utils.Configuration.teardown
import scalaCucumberFramework.utils.SingletonDriver

import scala.util.Try

trait BaseSteps extends ScalaDsl with EN with LazyLogging with Matchers with Eventually {

  override implicit val patienceConfig: PatienceConfig =
    PatienceConfig(timeout = scaled(Span(5, Seconds)), interval = scaled(Span(100, Millis)))

}

object BaseSteps extends BaseSteps {

  Before { _ =>
    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

  After { scenario =>
    if (scenario.isFailed) {
      import org.apache.commons.io.FileUtils
      import org.openqa.selenium.OutputType
      import org.openqa.selenium.TakesScreenshot
      val scrFile = driver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.FILE)
      FileUtils.copyFile(scrFile, new Nothing("c:\\tmp\\screenshot.png"))
    }

    if (teardown) Try(SingletonDriver.closeInstance())

    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

}