name := "scala-cucumber-framework"

version := "1.0"

scalaVersion := "2.11.11"

val ScalatestVersion = "3.0.5"
val CucumberVersion = "1.2.5"

libraryDependencies ++= Seq(
  "org.scalatest"           %% "scalatest"              % ScalatestVersion excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "org.seleniumhq.selenium" %  "selenium-java"          % "3.7.1",
  "org.scalaj"              %% "scalaj-http"            % "2.4.1",
  "com.typesafe.play"       %% "play-test"              % "2.5.12",
  "info.cukes"              %  "cucumber-junit"         % CucumberVersion,
  "info.cukes"              %  "cucumber-picocontainer" % CucumberVersion,
  "info.cukes"              %% "cucumber-scala"         % CucumberVersion,
  "org.mongodb.scala"       %% "mongo-scala-driver"     % "2.6.0"
)
