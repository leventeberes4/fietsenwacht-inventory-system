ThisBuild / organization := "com.fietsenwachtapp"
ThisBuild / version := "0.0.1-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.20" // or change based on your needs

//enablePlugins(SpringBootPlugin)

//javaToolchainLanguageVersion := Some(JavaLanguageVersion.of(17))

// Spring Boot and Dependency Management plugins
//enablePlugins(SpringBootPlugin)
//enablePlugins(DependencyManagementPlugin)

lazy val springVersion = "3.5.1"
libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter-data-mongodb" % springVersion,
  "org.springframework.boot" % "spring-boot-starter-security" % springVersion,
  "org.springframework.boot" % "spring-boot-starter-web" % springVersion,
  "org.springframework.boot" % "spring-boot-starter-test" % springVersion % Test,
//  "org.springframework.security" % "spring-security-test" % springVersion % Test,
  "org.junit.platform" % "junit-platform-launcher" % "1.10.2" % Test // version may need to match your setup
)

