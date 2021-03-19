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

### Getting started
Replace the existing `chromedrive.exe` in `driverbinaries` directory with the corresponding chromedriver version for your version of Chrome.

[Chromedriver version downloads](https://chromedriver.chromium.org/downloads)

#### Via the CLI
```
sbt -Dbrowser=chrome -Dheadless={true|false} -Denvironment={local|staging} clean 'test-only scalaCucumberFramework.runners.Runner'
```

#### Via test runners
1. Set configuration for JUnit:
   ```
   VM options: -Dbrowser=chrome -Dheadless={true|false} -Denvironment={local|staging}
   Working directory: <blank>
   ```
2. Set configuration for Cucumber java:
   ```
   Glue: scalaCucumberFramework.stepdefs
   Feature or folder path: src/test/resources/features
   VM options: -Dbrowser=chrome -Denvironment=local
   ```
4. Select Runner to run inside `/scala/scalaCucumberFramework/runners` by right-clicking and selecting `Run`
