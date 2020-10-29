package scalaCucumberFramework.pages

import java.io.File

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated
import scalaCucumberFramework.utils.BaseUrls.theInternetBaseUrl

object FileUploaderPage extends BasePage {

  override def pageHeader: String = cssSelector("h3").webElement.getText

  private var hasUploaded: Boolean = false

  val url: String = theInternetBaseUrl + "/upload"
  val expectedPageTitle: String = "The Internet"
  def expectedPageHeader: String = if (hasUploaded) "File Uploaded!" else "File Uploader"

  override def shouldBeLoaded(): Unit = {
    if (hasUploaded) waitFor(visibilityOfElementLocated(By.id("uploaded-files")))
    else waitForPageToLoad()

    currentUrl should be (url)
    pageTitle should be (expectedPageTitle)
    pageHeader should be (expectedPageHeader)
  }

  def chooseFileBtn: WebElement = id("file-upload").webElement

  def uploadBtn: WebElement = id("file-submit").webElement

  def uploadFile(file: File): Unit = {
    chooseFileBtn.sendKeys(file.getAbsolutePath)
    uploadBtn.click()
    hasUploaded = true
  }

  def uploadedFileName: String = cssSelector("#uploaded-files").webElement.getText

}
