package scalaCucumberFramework.utils

import org.scalatest.exceptions.TestFailedException
import scalaCucumberFramework.pages.{BasePage, DynamicLoadingExample1Page, DynamicLoadingExample2Page}
import scalaCucumberFramework.stepdefs.DriverActions

object HelperFunctions extends DriverActions {

  def navigateTo(pageStr: String): Unit = {
    val page: BasePage = PageObjs.fromString(pageStr)
    goTo(page.url)
  }

  def expectedPage(pageStr: String): BasePage = PageObjs.fromString(pageStr)

  def clickStart(): Unit = {
    currentUrl match {
      case DynamicLoadingExample1Page.url => DynamicLoadingExample1Page.clickStart()
      case DynamicLoadingExample2Page.url => DynamicLoadingExample2Page.clickStart()
      case _ => throw new TestFailedException(s"Could not click Start on: [$currentUrl]", 10)
    }
  }

}
