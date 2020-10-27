package scalaCucumberFramework.pages

import org.openqa.selenium.WebElement
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object DynamicLoadingPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/dynamic_loading"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Dynamically Loaded Page Elements"

  def example1hidden: WebElement = cssSelector("#content > div > a[href=\"/dynamic_loading/1\"]").webElement
  def example2render: WebElement = cssSelector("#content > div > a[href=\"/dynamic_loading/2\"]").webElement

}
