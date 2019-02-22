package project.utils

case class TestConfig(baseUrl1: String,
                      baseUrl2: String,
                      baseUrl3: String
                     )

object Configuration {
  lazy val environment: String = Option(System.getProperty("environment")).getOrElse("local").toLowerCase

  lazy val testConfig: TestConfig = environment match {
    case "local" =>
      TestConfig(
        baseUrl1 = "http://localhost:9043/stride-idp-stub",
        baseUrl2 = "http://localhost:9077/tops",
        baseUrl3 = "http://localhost:9076/pay-helpline"
      )

    case "dev" =>
      TestConfig(
        baseUrl1 = "https://admin.development.tax.service.gov.uk/stride-idp-stub",
        baseUrl2 = "https://admin.development.tax.service.gov.uk/tops",
        baseUrl3 = "https://admin.development.tax.service.gov.uk/pay-helpline"
      )

    case "qa" =>
      TestConfig(
        baseUrl1 = "https://admin.qa.tax.service.gov.uk/stride-idp-stub",
        baseUrl2 = "https://admin.qa.tax.service.gov.uk/tops",
        baseUrl3 = "https://admin.qa.tax.service.gov.uk/pay-helpline"
      )

    case _ => throw new IllegalArgumentException(s"Environment '$environment' not known")
  }
}
