grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolution = {
  // inherit Grails' default dependencies
  inherits("global") {
    // uncomment to disable ehcache
    // excludes 'ehcache'
  }
  log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
  repositories {
    grailsPlugins()
    grailsHome()
    grailsCentral()

    // uncomment the below to enable remote dependency resolution
    // from public Maven repositories
    mavenLocal()
    mavenCentral()
  }
  dependencies {
    def scalaVersion = '2.10.2'
    build "org.scala-lang:scala-compiler:$scalaVersion",
      "org.scala-lang:scala-library:$scalaVersion"
    compile "org.scala-lang:scala-compiler:$scalaVersion",
      "org.scala-lang:scala-library:$scalaVersion"
    compile('org.codehaus.groovy.modules:groovytransforms:0.2') { transitive = false }
  }
  plugins {
    /*
    This validation is for prevent load the following plugins in previous Grails versions.
    I some Grails versions from 1.3.* the 'export = false' does not work. For Grails 2.* works properly
    */
    if (grailsVersion.startsWith('2')) {
      build(":release:2.0.3") { export = false }
      build(":rest-client-builder:1.0.2") { export = false }
      build ":tomcat:$grailsVersion"
    }
  }
}


grails.release.scm.enabled = false
grails.project.repos.default = "grailsCentral"