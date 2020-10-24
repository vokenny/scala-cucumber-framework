package scalaCucumberFramework.testdata.models.AutomationPractice

import scala.util.Random

object Email {

  private val randomChars: Stream[Char] = Random.alphanumeric

  private val prefix: String = randomChars.take(10).mkString

  val valid: String = prefix + "@email.com"
}
