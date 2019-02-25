package projectName.pages

import projectName.testdata.models.{TestCust, Title}
import projectName.testdata.models.Title.Title
import projectName.utils.Configuration.testConfig


object RegistrationPage extends BasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?controller=authentication&back=my-account#account-creation"

  def expectedPageTitle: String = "Login - My Store"

  def expectedPageHeader: String = "CREATE AN ACCOUNT"

  def enterValidDetails(user: TestCust): Unit = {
    selectTitle(user.title)
    enterFirstName(user.firstName)
    enterSurname(user.surname)
    enterEmail(user.email)
    enterPassword(user.password)
    selectDoB(user.dob)
  }

  def selectTitle(title: Title): Unit = {
    if (title.equals(Title.MR)) click on id("id_gender1")
    else click on id("id_gender2")
  }

  def enterFirstName(fn: String): Unit = id("customer_firstname").webElement.sendKeys(fn)

  def enterSurname(sn: String): Unit = id("customer_lastname").webElement.sendKeys(sn)

  def enterEmail(email: String): Unit = {
    id("email").webElement.clear()
    id("email").webElement.sendKeys(email)
  }

  def enterPassword(pw: String): Unit = id("passwd").webElement.sendKeys(pw)

  def selectDoB(dob: String): Unit = {
    val date: List[String] = dob.split('-').toList
    val fields: List[String] = "years" :: "months" :: "days" :: Nil
    val dateFieldsMap: Map[String, String] = fields zip date toMap

//    .toInt.toString will strip out any leading zeroes
    dateFieldsMap.foreach { case (field, num) => singleSel(field).value = num.toInt.toString }
  }
}
