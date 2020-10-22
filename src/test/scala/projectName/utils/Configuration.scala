package projectName.utils

import com.typesafe.config.{Config, ConfigFactory}
import projectName.utils.Environment._

object Configuration {

  val config: Config = ConfigFactory.load()

  val driverLocation: String = config.getString("webdriver.chrome.driver")
  sys.props += (("webdriver.chrome.driver", driverLocation))

  val envStr: String = config.getString("environment")
  val env: Environment = Environment.parse(envStr)
  val defaultConfig: Config = config.getConfig("local")
  val envConfig: Config = config.getConfig(envStr).withFallback(defaultConfig)

  def base(serviceName: String): String = envConfig.getString(s"services.$serviceName.productionRoute")

  def teardown: Boolean = config.getBoolean("teardown")

  def headless: Boolean = config.getBoolean("headless")

}
