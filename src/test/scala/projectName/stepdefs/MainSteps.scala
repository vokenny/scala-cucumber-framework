package projectName.stepdefs

import projectName.utils.HelperFunctions

class MainSteps extends Steps {

  Given("""^the User does not have an existing account$""") { () =>
//    No action
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  Then("""^the User should be on the (.*) page$""") { page: String =>
    HelperFunctions.expectedPage(page)
  }
}
