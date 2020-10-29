# scala-cucumber-framework

This is a user acceptance test suite using Scala on the BDD Cucumber framework.

Example UI tests have been written for [The Internet by SauceLabs](https://github.com/saucelabs/the-internet)

Example API tests have been written for [Poké API by The PokéAPI project](https://github.com/PokeAPI/pokeapi)

## Running The Tests

### Via sbt command
```
sbt -Dbrowser=chrome -Dheadless={true|false} clean 'test-only scalaCucumberFramework.runners.Runner'
```

### Via IntelliJ
Set Cucumber Java configuration to:
```
Glue: scalaCucumberFramework.stepdefs
Feature path: src/test/resources/features
VM options: -Dbrowser=chrome -Dheadless={true|false}
```

And set JUnit configuration to:
```
VM Options: -Dbrowser=chrome -Dheadless={true|false}
Working directory: <blank>
```

Then from the src/test/scala/scalaCucumberFramework/runners directory, right-click > run your choice of test runner
