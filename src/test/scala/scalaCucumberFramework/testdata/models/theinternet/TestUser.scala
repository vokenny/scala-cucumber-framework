package scalaCucumberFramework.testdata.models.theinternet

import java.time.LocalDate

case class TestUser(firstName: String, lastname: String, dob: LocalDate)

object TestUser {

  val newCustomer: TestUser = TestUser("Kenny", "Vo", LocalDate.parse("1994-08-20"))

}