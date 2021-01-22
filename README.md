# scala-cucumber-framework

This is a user acceptance test suite using Scala and Selenium, with Cucumber & Gherkin BDD.
It also involves API tests using Scala Play's Web Service client to manage network requests.

Example UI tests have been written for [The Internet by SauceLabs](https://github.com/saucelabs/the-internet)

Example API tests have been written for [Poké API by The PokéAPI project](https://github.com/PokeAPI/pokeapi)

## Dependencies

### Scala Build Tool `sbt`
Needed for compiling and running the tests

https://www.scala-sbt.org/

## Running The Tests

### Via the CLI
```
sbt -Dbrowser=chrome -Dheadless={true|false} clean 'test-only scalaCucumberFramework.runners.Runner'
```
