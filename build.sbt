name := "scala-cucumber-framework"

version := "1.0"

scalaVersion := "2.12.12"

val ScalatestVersion = "3.0.7"
val CucumberVersion = "4.7.1"

libraryDependencies ++= Seq(
  "org.scalatest"              %% "scalatest"               % ScalatestVersion excludeAll ExclusionRule(organization = "org.seleniumhq.selenium"),
  "org.seleniumhq.selenium"    %  "selenium-java"           % "3.141.59",
  "com.typesafe.play"          %% "play-ahc-ws-standalone"  % "2.1.2",
  "com.typesafe.play"          %% "play-ws-standalone-json" % "2.1.2",
  "com.typesafe.play"          %% "play-test"               % "2.8.2",
  "com.typesafe.scala-logging" %% "scala-logging"           % "3.9.2",
  "ch.qos.logback"             %  "logback-classic"         % "1.2.3",
  "io.cucumber"                %  "cucumber-junit"          % CucumberVersion,
  "io.cucumber"                %% "cucumber-scala"          % CucumberVersion,
  "org.mongodb.scala"          %% "mongo-scala-driver"      % "2.7.0"
)
