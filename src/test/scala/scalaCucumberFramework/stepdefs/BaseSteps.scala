package scalaCucumberFramework.stepdefs

import com.typesafe.scalalogging.LazyLogging
import cucumber.api.scala.{EN, ScalaDsl}
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.utils.Configuration.teardown
import scalaCucumberFramework.utils.SingletonDriver

import scala.util.Try

trait BaseSteps extends ScalaDsl with EN with LazyLogging

object BaseSteps extends BaseSteps {

  Before { _ =>
    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

  After { _ =>
    if (teardown) Try(SingletonDriver.closeInstance())

    logger.info("Test data teardown")
    ScenarioContext.reset()
  }

}