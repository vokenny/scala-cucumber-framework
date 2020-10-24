package scalaCucumberFramework.testdata.models.AutomationPractice

import scalaCucumberFramework.utils.Configuration.env
import scalaCucumberFramework.utils.{LOCAL, STAGING}

case class CardDetails(cardNum: String, cvv: String)

object CardDetails {

  val valid: CardDetails = env match {
    case LOCAL => CardDetails("1234567890123456", "123")
    case STAGING => CardDetails("1234567890123456", "123")
  }
}