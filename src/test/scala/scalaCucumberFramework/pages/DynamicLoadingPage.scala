package scalaCucumberFramework.pages

import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object DynamicLoadingPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  val url: String = theInternetBaseUrl + "/dynamic_loading"
  val expectedPageTitle: String = "The Internet"
  val expectedPageHeader: String = "Dynamically Loaded Page Elements"

  def clickExample1Hidden(): Unit =
    cssSelector("#content > div > a[href=\"/dynamic_loading/1\"]").webElement.click()

  def clickExample2Render(): Unit =
    cssSelector("#content > div > a[href=\"/dynamic_loading/2\"]").webElement.click()

}
