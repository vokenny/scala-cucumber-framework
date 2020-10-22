# scala-cucumber-framework

This is a user acceptance test suite using Scala on the BDD Cucumber framework.

## Running The Tests

### Via sbt command
```
sbt -Dbrowser=chrome -Dheadless={true|false} clean 'test-only projectName.runner.Runner'
```

### Via IntelliJ
Set Cucumber Java configuration to:
```
Glue: projectName.stepdefs
Feature path: src/test/resources/features
VM options: -Dbrowser=chrome -Dheadless={true|false}
```

Set JUnit configuration to:
```
VM Options: -Denvironment={local|staging} -Dbrowser={chrome|headless}
Working directory: <blank>
```

Then from the src/test/scala/projectName/runner directory, right-click > run your choice of test runner
