package com.gradle.kts.build.source

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyApplicationDependencies()
            applyPlugins()
        }
    }

    private fun Project.applyPlugins() {
        plugins.apply("org.jetbrains.kotlin.jvm")
    }

    private fun Project.applyApplicationDependencies() {
        dependencies {
            logBack()
            springSecurity()
            jsonLogger()
            kotlin()

            implementation("org.passay:passay:1.6.1")
            implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
            implementation("io.jsonwebtoken:jjwt:0.9.1")
        }
    }
}
