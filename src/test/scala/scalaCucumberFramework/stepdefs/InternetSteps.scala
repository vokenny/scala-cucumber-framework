package scalaCucumberFramework.stepdefs

import scalaCucumberFramework.pages._
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.testdata.models.theinternet.Admin
import scalaCucumberFramework.utils.{FileSys, HelperFunctions}

class InternetSteps extends BaseSteps with DriverActions {

  Given("""^the User is the Admin$""") { () =>
    ScenarioContext.set("admin", Admin)
  }

  When("""^the User navigates to the (.*) page$""") { page: String =>
    HelperFunctions.navigateTo(page)
  }

  When("""^the User clicks (.*)$""") { item: String =>
    item match {
      case "Start" => HelperFunctions.clickStart()
      case "Example 1 Hidden" => DynamicLoadingPage.clickExample1Hidden()
      case "Example 2 Render" => DynamicLoadingPage.clickExample2Render()
    }
  }

  When("""^the User drag and drops the (left|right) Box on to the (?:left|right) Box$""") { side: String =>
    DragAndDropPage.saveBoxContents()
    DragAndDropPage.dragAndDropBox(side)
  }

  When("""^the User uploads a file$""") { () =>
    val testFile = FileSys.getTestFile("quadparrot.gif")
    FileUploaderPage.uploadFile(testFile)
  }

  Then("""^the User should be on the (.*) page$""") { pageStr: String =>
    val page: BasePage = HelperFunctions.expectedPage(pageStr)
    page.shouldBeLoaded()
  }

  Then("""^the box placements should have switched$""") { () =>
    DragAndDropPage.leftBox.getText should be (ScenarioContext.get[String]("rightBox"))
    DragAndDropPage.rightBox.getText should be (ScenarioContext.get[String]("leftBox"))
  }

  Then("""^the (.*) should be displayed$""") { item: String =>
    item match {
      case "Randomised Buttons" =>
        ChallengingDomPage.randomisedBtns foreach { b =>
          b.isDisplayed should be (true)
          b.getText should fullyMatch regex "(foo|bar|baz|qux)".r
        }
    }
  }

}
