package project.utils

import project.pages.BasePage


object HelperFunctions extends BasePage {

  val url = ""

  def expectedPageTitle = ""
  def expectedPageHeader = ""

  override def shouldBeLoaded(): Unit = {}

  def expectedPage(page: String): Unit = {
    page match {
      case "Select Tax" =>
    }
  }
}
