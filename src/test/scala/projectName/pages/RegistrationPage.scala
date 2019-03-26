package projectName.pages

import projectName.pages.traits.RegBasePage
import projectName.testdata.models.{TestCust, Title}
import projectName.testdata.models.Title.Title
import projectName.utils.Configuration.testConfig


object RegistrationPage extends RegBasePage {

  val url: String = s"${testConfig.automationUrl}/index.php?controller=authentication&back=my-account#account-creation"

  val expectedPageTitle: String = "Login - My Store"
  val expectedPageHeader: String = "CREATE AN ACCOUNT"

  def enterValidDetails(user: TestCust): Unit = {
    selectTitle(user.title)
    enterFirstname(user.firstname)
    enterLastname(user.lastname)
    enterEmail(user.email)
    enterPassword(user.password)
    selectDoB(user.dob)
    enterAddrFirstname(user.firstname)
    enterAddrLastname(user.lastname)
    enterAddress(user.address)
    enterMobile(user.mobile)
    enterAlias(user.addrAlias)
  }

  def selectTitle(title: Title): Unit = {
    if (title.equals(Title.MR)) click on id("id_gender1")
    else click on id("id_gender2")
  }

  def enterFirstname(fn: String): Unit = firstname.sendKeys(fn)

  def enterLastname(ln: String): Unit = lastname.sendKeys(ln)

  def enterEmail(email: String): Unit = {
    emailField.clear()
    emailField.sendKeys(email)
  }

  def enterPassword(pw: String): Unit = password.sendKeys(pw)

  def selectDoB(dob: String): Unit = {
    val date: Array[String] = dob.split('-')
    val fields: List[String] = "years" :: "months" :: "days" :: Nil
    val dateFieldsMap: Map[String, String] = fields zip date toMap

//    .toInt.toString will strip out any leading zeroes
    dateFieldsMap.foreach { case (field, num) => singleSel(field).value = num.toInt.toString }
  }

  def enterAddrFirstname(fn: String): Unit = {
    addrFirstname.clear()
    addrFirstname.sendKeys(fn)
  }

  def enterAddrLastname(ln: String): Unit = {
    addrLastname.clear()
    addrLastname.sendKeys(ln)
  }

  def enterAddress(addr: List[String]): Unit = {
    addrLine1.sendKeys(addr.head)
    addrCity.sendKeys(addr(1))
    addrState.value = addr(2)
    addrZip.sendKeys(addr(3))
  }

  def enterMobile(phone: String): Unit = mobile.sendKeys(phone)

  def enterAlias(name: String): Unit = {
    alias.clear()
    alias.sendKeys(name)
  }

  def clickRegister(): Unit = click on id("submitAccount")
}
