package projectName.testdata

import projectName.utils.Configuration.environment

case class CardDetails(cardNum: String, cvv: String)

object CardDetails {

  lazy val validCard: CardDetails = environment match {
    case "qa" => CardDetails("12345678901234567890", "123")
    case _    => CardDetails("12345678901234567890", "123")
  }
}