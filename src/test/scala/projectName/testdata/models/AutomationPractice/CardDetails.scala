package projectName.testdata.models.AutomationPractice

import projectName.utils.Configuration.env
import projectName.utils.{LOCAL, STAGING}

case class CardDetails(cardNum: String, cvv: String)

object CardDetails {

  val valid: CardDetails = env match {
    case LOCAL => CardDetails("1234567890123456", "123")
    case STAGING => CardDetails("1234567890123456", "123")
  }
}