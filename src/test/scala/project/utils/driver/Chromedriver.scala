package project.utils.driver

import java.net.URL

import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.remote.{CapabilityType, RemoteWebDriver}
import org.openqa.selenium.{Proxy, WebDriver}

object Chromedriver extends ProxySupport {

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

  private def chromeOptions(headless: Boolean = false): ChromeOptions = {
    val options = new ChromeOptions()

    if (sys.props.get("qa.proxy").isDefined) options.setCapability(CapabilityType.PROXY, proxyConfiguration)

    options.addArguments("test-type")
    options.addArguments("--no-sandbox")
    options.addArguments("disable-infobars")
    options.setCapability("takesScreenshot", true)
    options.setCapability("javascript.enabled", true)

    if (headless) options.addArguments("--headless")
    else options.addArguments("start-maximized")

    options
  }

  private def proxyConfiguration: Proxy = {
    new Proxy().setHttpProxy(sys.props.get("qa.proxy").get)
  }
}