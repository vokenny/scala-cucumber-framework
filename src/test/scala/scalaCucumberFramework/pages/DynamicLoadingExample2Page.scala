package scalaCucumberFramework.pages

import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object DynamicLoadingExample2Page extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/dynamic_loading/2"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Dynamically Loaded Page Elements"

  private var isLoaded: Boolean = false

  def clickStart(): Unit = {
    cssSelector("#start > button").webElement.click()
    isLoaded = true
  }

}
