package projectName.pages

import org.openqa.selenium.WebElement


trait RegBasePage extends BasePage {

  val firstname: WebElement = id("customer_firstname").webElement
  val surname: WebElement = id("customer_lastname").webElement
  val emailField: WebElement = id("email").webElement
  val password: WebElement = id("passwd").webElement
}
