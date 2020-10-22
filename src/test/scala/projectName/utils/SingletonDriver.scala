package projectName.utils

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.support.ui.WebDriverWait
import projectName.utils.Configuration.headless

object SingletonDriver {
  private var instanceOpt: Option[WebDriver] = None
  private var wdWait: Option[WebDriverWait] = None

  def getDriver: WebDriver = instanceOpt.fold(SingletonDriver.initialiseDriver())(i => i)
  def getWebDriverWait: WebDriverWait = wdWait.fold(SingletonDriver.webDriverWait())(w => w)

  def initialiseDriver(): WebDriver = {
    val driver = new ChromeDriver(chromeOptions)
    instanceOpt = Some(driver)
    driver
  }

  def closeInstance(): Unit = instanceOpt foreach { instance =>
    instance.quit()
    instanceOpt = None
    wdWait = None
  }

  def chromeOptions: ChromeOptions = {
    val options = new ChromeOptions()

    options.setCapability("javascript.enabled", true)

    if (headless) options.addArguments("--headless")
    else options.addArguments("start-maximized")

    options
  }

  def webDriverWait(): WebDriverWait = {
    val wdw: WebDriverWait = instanceOpt
      .fold(throw new RuntimeException("No instance of WebDriver")
      )(i => new WebDriverWait(i, 15, 100))
    wdWait = Some(wdw)
    wdw
  }

}