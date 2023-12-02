plugins {
    kotlin("jvm") version "2.0.0-Beta1"
    application
}

group = "com.github.mvukic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("MainKt")
}

tasks {
    wrapper {
        version = "8.5"
    }
}