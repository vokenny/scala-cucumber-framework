package scalaCucumberFramework.runners

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("src/test/resources/features"),
  glue = Array("scalaCucumberFramework.stepdefs"),
  plugin = Array("pretty", "html:target/cucumber", "json:target/cucumber.json"),
  tags = Array("not @api", "not @wip", "not @ignore")
)
class Runner {}
