package scalaCucumberFramework.stepdefs

import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.testdata.models.theinternet.TestUser
import scalaCucumberFramework.testdata.models.theinternet.TestUser._
import scalaCucumberFramework.utils.HelperFunctions

class MainSteps extends BaseSteps {

  Given("""^the User is a (.*) customer$""") { userType: String =>
    val user: TestUser = userType match {
      case "New" => newCustomer
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
