package scalaCucumberFramework.stepdefs

import scalaCucumberFramework.stepdefs.DriverActions._
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.testdata.models.AutomationPractice.TestCust
import scalaCucumberFramework.utils.HelperFunctions

class MainSteps extends BaseSteps {

  Given("""^the User is a (.*) customer$""") { userType: String =>
    val user = userType match {
      case "New"      => TestCust.person
      case "Existing" => TestCust.person
      case "Etc"      => TestCust.person
    }

    ScenarioContext.set("user", user)
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  Then("""^the User should be on the (.*) page$""") { page: String =>
    HelperFunctions.expectedPage(page)
  }
}
