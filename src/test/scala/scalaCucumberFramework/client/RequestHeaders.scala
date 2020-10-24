package scalaCucumberFramework.client

trait RequestHeaders {

  val jsonHeader: (String, String) = ("Content-Type", "application/json")

  def envHeader(env: String): (String, String) = ("Environment", env)

}
