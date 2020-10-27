package scalaCucumberFramework.pages

import org.openqa.selenium.WebElement
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object DynamicLoadingExample2Page extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/dynamic_loading/2"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Dynamically Loaded Page Elements"

  def startButton: WebElement = cssSelector("#start > button").webElement

}
