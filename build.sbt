name := "scala-cucumber-framework"

version := "1.0"

scalaVersion := "2.11.11"

val ScalatestVersion = "3.0.7"
val CucumberVersion = "4.7.1"

libraryDependencies ++= Seq(
  "org.scalatest"           %% "scalatest"              % ScalatestVersion excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "org.seleniumhq.selenium" %  "selenium-java"          % "3.141.59",
  "org.scalaj"              %% "scalaj-http"            % "2.4.2",
  "com.typesafe.play"       %% "play-test"              % "2.5.12",
  "io.cucumber"             %  "cucumber-junit"         % CucumberVersion,
  "io.cucumber"             %% "cucumber-scala"         % CucumberVersion,
  "org.mongodb.scala"       %% "mongo-scala-driver"     % "2.7.0"
)
