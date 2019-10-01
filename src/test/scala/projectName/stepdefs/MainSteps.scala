package projectName.stepdefs

import projectName.pages._
import projectName.testdata.ScenarioVariables._
import projectName.testdata.models.AutomationPractice.TestCust
import projectName.utils.HelperFunctions

class MainSteps extends Steps {

  Given("""^the User is a (.*) customer$""") { userType: String =>
    user = userType match {
      case "New"      => TestCust.person
      case "Existing" => TestCust.person
      case "Etc"      => TestCust.person
    }
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  When("""^the User clicks (.*)$""") { elem: String =>
    HelperFunctions.clickOn(elem)
  }

  When("""^the User submits a valid email address$""") { () =>
    AuthPage.enterEmail(user.email)
    AuthPage.clickCreateAccount()
  }

  When("""^the User submits valid registration details$""") { () =>
    RegistrationPage.enterValidDetails(user)
    RegistrationPage.clickRegister()
  }

  Then("""^the User should be on the (.*) page$""") { page: String =>
    HelperFunctions.expectedPage(page)
  }
}
