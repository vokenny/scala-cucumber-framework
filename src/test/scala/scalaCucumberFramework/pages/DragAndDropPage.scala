package scalaCucumberFramework.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import scalaCucumberFramework.testdata.ScenarioContext
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object DragAndDropPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/drag_and_drop"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Drag and Drop"

  def leftBox: WebElement = cssSelector("#columns > div:first-child > header").webElement
  def rightBox: WebElement = cssSelector("#columns > div:last-child > header").webElement

  def saveBoxContents(): Unit = {
    def saveContents(side: String): String = if (side == "left") leftBox.getText else rightBox.getText

    val leftBoxContent: String = saveContents("left")
    val rightBoxContent: String = saveContents("right")

    ScenarioContext.set("leftBox", leftBoxContent)
    ScenarioContext.set("rightBox", rightBoxContent)
  }

  def dragAndDropBox(side: String): Unit = {
    if (side == "left") dragAndDrop(leftBox, rightBox)
    else dragAndDrop(rightBox, leftBox)
  }

}
