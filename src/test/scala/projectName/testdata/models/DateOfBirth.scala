package projectName.testdata.models

import org.joda.time.DateTime


object DateOfBirth {

  private val dateFormat: String = "yyyy-MM-dd"

  private val now: DateTime = DateTime.now()

  private val dob18: DateTime = now.plusYears(-18)

  private val dob16: DateTime = now.plusYears(-16)

  val valid: String = dob18.toString(dateFormat)

  val invalid: String = dob16.toString(dateFormat)
}