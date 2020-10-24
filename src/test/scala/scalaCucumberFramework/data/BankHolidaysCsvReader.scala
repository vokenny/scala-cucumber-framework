package scalaCucumberFramework.data

import java.time.LocalDate

import scala.io.Source

object BankHolidaysCsvReader extends Csv {

  def readBankHolidays(fileName: String): List[LocalDate] = {
    val fileLines: List[String] = readLines(fileName)

    fileLines.map(line => LocalDate.parse(line.replaceAll(",", "")))
  }

  val bankHolidays: List[LocalDate] = BankHolidaysCsvReader.readBankHolidays(filePath("bank_holidays.csv"))
}
