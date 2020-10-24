package scalaCucumberFramework.utils

import java.io.File

import scalaCucumberFramework.pages.{BasePage, ChallengingDomPage, InternetPage}

object PageObjs {

  private val pagesDir: File = new File("src/test/scala/scalaCucumberFramework/pages")
  private val endExt: List[String] = List("Page.scala")
  private val pages: List[BasePage] = FileSys.getListOfFiles(pagesDir, endExt).map(convertFileToBasePage)

  private def convertFileToBasePage(file: File): BasePage = {
    file.getName match {
      case "ChallengingDomPage.scala" => ChallengingDomPage
      case "InternetPage.scala"       => InternetPage
    }
  }

  def fromString(pageStr: String): BasePage = {
    val pageName: String = pageStr.replaceAll(" ", "") + "Page"
    pages.find(_.toString.equalsIgnoreCase(pageName))
      .fold(throw new Exception(s"Page Object not found for [$pageStr]"))(p => p)
  }

}
