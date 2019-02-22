package projectName.pages

import projectName.utils.Configuration.testConfig

object GooglePage extends BasePage {

  val url: String = s"${testConfig.googleUrl}/"

  def expectedPageTitle: String = "Google"
  def expectedPageHeader: String = ""

//  Google homepage doesn't have a header
  override def assertCurrentPageHeader(): Unit = {}
}
