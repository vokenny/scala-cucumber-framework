package projectName.testdata.models

import projectName.utils.Configuration.environment
import projectName.testdata.models.Title.Title

case class TestCust(title: Title,
                    firstname: String,
                    lastname: String,
                    email: String,
                    password: String,
                    dob: String,
                    address: List[String],
                    mobile: String,
                    addrAlias: String,
                    cardDetails: CardDetails
                   )

object TestCust {

  val person: TestCust = environment match {
    case "local" => TestCust(Title.MR, "John", "Hopkins", Email.valid, "password123!", DateOfBirth.valid, Address.valid, "012345 67890", "My address", CardDetails.valid)
    case "dev"   => TestCust(Title.MR, "John", "Hopkins", Email.valid, "password123!", DateOfBirth.valid, Address.valid, "012345 67890", "My address", CardDetails.valid)
    case "qa"    => TestCust(Title.MR, "John", "Hopkins", Email.valid, "password123!", DateOfBirth.valid, Address.valid, "012345 67890", "My address", CardDetails.valid)
  }
}