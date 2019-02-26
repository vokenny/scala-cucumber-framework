package projectName.stepdefs

import projectName.pages._
import projectName.testdata.models.TestCust._
import projectName.utils.HelperFunctions

class MainSteps extends Steps {

  Given("""^the User does not have an existing account$""") { () =>
//    No action
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  When("""^the User clicks (.*)$""") { elem: String =>
    HelperFunctions.clickOn(elem)
  }

  When("""^the User submits a valid email address$""") { () =>
    AuthPage.enterEmail(person.email)
    AuthPage.clickCreateAccount()
  }

  When("""^the User submits valid registration details$""") { () =>
    RegistrationPage.enterValidDetails(person)
    RegistrationPage.clickRegister()
  }

  Then("""^the User should be on the (.*) page$""") { page: String =>
    HelperFunctions.expectedPage(page)
  }
}
