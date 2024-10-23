name := """play-demo"""
organization := "com.github.jarnaud"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
  //.enablePlugins(PlayNettyServer).disablePlugins(PlayAkkaHttpServer) // uncomment to use the Netty backend

crossScalaVersions := Seq("2.13.14", "3.3.3")

scalaVersion := crossScalaVersions.value.head

libraryDependencies += guice

// Lombok.
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.34"
