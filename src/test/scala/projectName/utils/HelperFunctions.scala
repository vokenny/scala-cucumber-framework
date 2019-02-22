package projectName.utils

import projectName.pages._


object HelperFunctions extends BasePage {

  val url = ""

  def expectedPageTitle = ""
  def expectedPageHeader = ""

  override def shouldBeLoaded(): Unit = {}

  def navigateTo(page: String): Unit = {
    page match {
      case "Google" => GooglePage.goToPage()
    }
  }

  def expectedPage(page: String): Unit = {
    page match {
      case "Google" => GooglePage.shouldBeLoaded()
    }
  }
}
