package scalaCucumberFramework.utils

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.{PageLoadStrategy, WebDriver}
import scalaCucumberFramework.utils.Configuration.headless

object SingletonDriver {
  private var instanceOpt: Option[WebDriver] = None

  def getDriver: WebDriver = instanceOpt.fold(SingletonDriver.initialiseDriver())(i => i)

  def initialiseDriver(): WebDriver = {
    val driver = new ChromeDriver(chromeOptions)
    instanceOpt = Some(driver)
    driver
  }

  def closeInstance(): Unit = instanceOpt foreach { instance =>
    instance.quit()
    instanceOpt = None
  }

  def chromeOptions: ChromeOptions = {
    val options = new ChromeOptions()

    options.setCapability("javascript.enabled", true)
    options.setPageLoadStrategy(PageLoadStrategy.NORMAL)

    if (headless) options.addArguments("--headless")
    else options.addArguments("start-maximized")

    options
  }

}