package projectName.utils.driver

import java.net.URL

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.{FirefoxDriver, FirefoxOptions, FirefoxProfile}
import org.openqa.selenium.remote.RemoteWebDriver

object Firefoxdriver {

  def createFirefoxDriver(headless: Boolean = false, remote: Boolean = false, isJsEnabled: Boolean = true): WebDriver = {
    new FirefoxDriver(firefoxOptions)
  }

  def createRemoteFirefox(isJsEnabled: Boolean = true): WebDriver = {
    new RemoteWebDriver(new URL(s"http://localhost:4444/wd/hub"), firefoxOptions)
  }

  private def firefoxOptions: FirefoxOptions = {
    val profile = new FirefoxProfile()
    profile.setAcceptUntrustedCertificates(true)
    profile.setPreference("javascript.enabled", true)

    val options = new FirefoxOptions()

    options.setProfile(profile)
    options.setAcceptInsecureCerts(true)

    options
  }
}