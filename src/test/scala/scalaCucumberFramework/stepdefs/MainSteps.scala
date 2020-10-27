package scalaCucumberFramework.stepdefs

import org.openqa.selenium.WebElement
import scalaCucumberFramework.pages.DynamicLoadingPage
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.testdata.models.theinternet.TestUser
import scalaCucumberFramework.testdata.models.theinternet.TestUser._
import scalaCucumberFramework.utils.HelperFunctions

class MainSteps extends BaseSteps with DriverActions {

  Given("""^the User is a (.*) customer$""") { userType: String =>
    val user: TestUser = userType match {
      case "New" => newCustomer
    }
    ScenarioContext.set("user", user)
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  When("""^the User clicks (.*)$""") { item: String =>
    val element: WebElement = item match {
      case "Start" => HelperFunctions.clickStart()
      case "Example 1 Hidden" => DynamicLoadingPage.example1hidden
      case "Example 2 Render" => DynamicLoadingPage.example2render
    }

    click on element
  }

  Then("""^the User should be on the (.*) page$""") { page: String =>
    HelperFunctions.expectedPage(page)
  }

  Then("""^the (.*) should be displayed$""") { item: String =>
    item match {
      case "Dynamic Content" => eventually {
        cssSelector("#finish > h4").webElement.getText should be ("Hello World!")
      }
    }
  }

}
