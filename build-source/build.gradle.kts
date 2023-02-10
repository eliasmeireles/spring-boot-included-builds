import com.gradle.kts.build.configuration.*

plugins {
    `kotlin-dsl`
    `maven-publish`
    kotlin("jvm") version System.getProperty("kotlinVersion")
    id("build-configuration-plugin") version System.getProperty("kotlinVersion")
    id("org.jetbrains.kotlin.plugin.jpa") version System.getProperty("kotlinVersion")
    id("org.jetbrains.kotlin.plugin.spring") version System.getProperty("kotlinVersion")
    id("org.springframework.boot") version System.getProperty("springBootVersion")
    id("io.spring.dependency-management") version System.getProperty("springDependencyManagementVersion")
}

repositories {
    mavenCentral()
    mavenLocal()
    gradlePluginPortal()
    maven("https://jitpack.io")
    maven("https://repo.spring.io/milestone")
}

java {
    withJavadocJar()
    withSourcesJar()
}

val sourceGroup = "com.gradle.kts.build.source"
group = sourceGroup

version = "1.0.0"

gradlePlugin {
    plugins {
        register("build-source-plugin") {
            id = "build-source-plugin"
            implementationClass = "$sourceGroup.BuildSourcePlugin"
        }

        register("build-submodule-source-plugin") {
            id = "build-submodule-source-plugin"
            implementationClass = "$sourceGroup.BuildSubmoduleSourcePlugin"
        }
    }
}

dependencies {
    kotlinDeps()
    addSpringframeworkBoot("spring-boot-gradle-plugin")
    implementation("com.gradle.kts.build.configuration:build-configuration:1.0.0")
}

