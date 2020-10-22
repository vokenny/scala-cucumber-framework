package projectName.testdata.models.AutomationPractice

import projectName.testdata.models.AutomationPractice.Title.Title
import projectName.utils.Configuration.env
import projectName.utils.{LOCAL, STAGING}

case class TestCust(title: Title, firstname: String,
                    lastname: String, email: String,
                    password: String, dob: String,
                    address: List[String], mobile: String,
                    addrAlias: String, cardDetails: CardDetails
                   )

object TestCust {

  val person: TestCust = env match {
    case LOCAL => TestCust(Title.MR, "John", "Hopkins", Email.valid, "password123!", DateOfBirth.valid, Address.valid, "012345 67890", "My address", CardDetails.valid)
    case STAGING => TestCust(Title.MR, "John", "Hopkins", Email.valid, "password123!", DateOfBirth.valid, Address.valid, "012345 67890", "My address", CardDetails.valid)
  }
}