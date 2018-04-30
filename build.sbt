name := "logbook"
organization := "com.needstyping"

version := "2.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % "test"
libraryDependencies ++= Seq("org.reactivemongo" %% "play2-reactivemongo" % "0.13.0-play26")

scalacOptions in Test ++= Seq("-Yrangepos")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"
