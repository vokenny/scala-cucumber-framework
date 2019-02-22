# scala-cucumber-framework

This is an acceptance test suite using Scala, and Cucumber. Mongo Scala Driver and Scalaj Http have also been included for querying Mongo, and API testing respectively.

## Getting Started
You will need up-to-date versions of Chrome and Firefox installed on your device along with their compatible drivers inside:
```
/usr/local/bin/
```

Now, make sure you have Mongo and all the services running locally.

## Running The Tests

### Via sbt command

#### Local or Development Environment
```
sbt -Denvironment={local|dev} -Dbrowser={chrome|firefox|headless} clean 'test-only project.runner.Runner'
```
#### QA Environment
```
sbt -Denvironment=qa -Dbrowser={chrome|firefox|headless} clean 'test-only project.runner.QaRunner'
```

### Via IntelliJ
Set Cucumber Java configuration to:
```
Glue: project.stepdefs
Feature path: src/test/resources/features
VM options: -Denvironment={local|dev|qa} -Dbrowser={chrome|firefox|headless}
```

Set JUnit configuration to:
```
VM Options: -Denvironment={local|dev|qa} -Dbrowser={chrome|firefox|headless}
Working directory: <blank>
```

Then from the src/test/scala/project/runner directory, right-click > run your choice of test runner
