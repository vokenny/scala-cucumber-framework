package projectName.testdata.models

import projectName.utils.Configuration.environment

case class CardDetails(cardNum: String, cvv: String)

object CardDetails {

  val valid: CardDetails = environment match {
    case "local" => CardDetails("1234567890123456", "123")
    case "dev"   => CardDetails("1234567890123456", "123")
    case "qa"    => CardDetails("1234567890123456", "123")
  }
}