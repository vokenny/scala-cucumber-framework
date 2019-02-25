package projectName.testdata.models

import projectName.utils.Configuration.environment

case class CardDetails(cardNum: String, cvv: String)

object CardDetails {

  val valid: CardDetails = environment match {
    case "local" => CardDetails("12345678901234567890", "123")
    case "dev"   => CardDetails("12345678901234567890", "123")
    case "qa"    => CardDetails("12345678901234567890", "123")
  }
}