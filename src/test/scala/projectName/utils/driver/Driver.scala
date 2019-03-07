package projectName.utils.driver

import projectName.utils.driver.Chromedriver._
import projectName.utils.driver.Firefoxdriver._
import org.openqa.selenium.WebDriver

object Driver {

  private val systemProperties = System.getProperties

  def initialiseDriver(): WebDriver = {
    systemProperties.getProperty("browser", "chrome") match {
      case "chrome"         => createChromeDriver()
      case "remote-chrome"  => createChromeDriver(remote = true)
      case "headless"       => createChromeDriver(headless = true)
      case "zap-chrome"     => createRemoteZapChrome()
      case "firefox"        => createFirefoxDriver()
      case "remote-firefox" => createRemoteFirefox()
    }
  }
}