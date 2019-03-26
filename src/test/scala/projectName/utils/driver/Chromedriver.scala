package projectName.utils.driver

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.remote.RemoteWebDriver

object Chromedriver {

  def createChromeDriver(headless: Boolean = false, remote: Boolean = false): WebDriver = {
    if (remote) new RemoteWebDriver(new URL(s"http://localhost:4444/wd/hub"), chromeOptions(headless))
    else new ChromeDriver(chromeOptions(headless))
  }

  def createRemoteZapChrome(): WebDriver = {
    var options = chromeOptions()

    options.addArguments("--allow-insecure-localhost")
    options.addArguments("--ignore-certificate-error")
    options.addArguments("ignore-certificate-error")
    options.addArguments("--ignore-ssl-errors")
    options.addArguments("--proxy-server=http://localhost:11000")

    new RemoteWebDriver(new URL(s"http://localhost:4444/wd/hub"), options)
  }

  private def chromeOptions(headless: Boolean): ChromeOptions = {
    val options = new ChromeOptions()

    options.addArguments("test-type")
    options.addArguments("--no-sandbox")
    options.addArguments("disable-infobars")
    options.setCapability("takesScreenshot", true)
    options.setCapability("javascript.enabled", true)

    if (headless) options.addArguments("--headless")
    else options.addArguments("start-maximized")

    options
  }
}