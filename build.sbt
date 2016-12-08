import Dependencies.Versions._

name := """spring-context-extension"""

version := "1.0-SNAPSHOT"

organization := "com.directual"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "org.springframework" % "spring-context" % springVersion,
  "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0"
)