package projectName.pages.traits

import org.openqa.selenium.WebElement


trait RegBasePage extends BasePage {

  lazy val firstname: WebElement = id("customer_firstname").webElement
  lazy val lastname: WebElement = id("customer_lastname").webElement

  lazy val emailField: WebElement = id("email").webElement
  lazy val password: WebElement = id("passwd").webElement

  lazy val addrFirstname: WebElement = id("firstname").webElement
  lazy val addrLastname: WebElement = id("lastname").webElement

  lazy val addrLine1: WebElement = id("address1").webElement
  lazy val addrCity: WebElement = id("city").webElement
  lazy val addrState: SingleSel = singleSel("id_state")
  lazy val addrZip: WebElement = id("postcode").webElement

  lazy val mobile: WebElement = id("phone_mobile").webElement

  lazy val alias: WebElement = id("alias").webElement

}
