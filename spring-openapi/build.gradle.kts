import com.gradle.kts.build.configuration.Dependencies
import com.gradle.kts.build.configuration.kotlinDeps

plugins {
    `maven-publish`
    `kotlin-dsl`
    kotlin("jvm") version System.getProperty("kotlinVersion")
    id("build-source-plugin")
    id("org.openapi.generator") version "5.3.0"
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    maven("https://jitpack.io")
}

java {
    withJavadocJar()
    withSourcesJar()
}

val sourceGroup = "com.gradle.kts.build.spring.openapi"
group = sourceGroup

version = "1.0.0"

gradlePlugin {
    plugins {
        register("build-spring-openapi-plugin") {
            id = "build-spring-openapi-plugin"
            implementationClass = "$sourceGroup.JavaOpenApiPlugin"
        }
        register("build-kotlin-spring-openapi-plugin") {
            id = "build-kotlin-spring-openapi-plugin"
            implementationClass = "$sourceGroup.KotlinOpenApiPlugin"
        }
    }
}

dependencies {
    kotlinDeps()
    implementation("com.gradle.kts.build.configuration:build-configuration:1.0.0")
    implementation("org.openapitools:openapi-generator-gradle-plugin:${Dependencies.Version.openapitools}") {
        exclude("com.fasterxml.jackson.core", "jackson-databind")
    }
}


