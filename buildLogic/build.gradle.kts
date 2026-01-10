/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
plugins {
    `kotlin-dsl`
}

repositories {
    maven("https://maven.fabricmc.net/") { name = "Fabric" }
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.neoForge.modDevGradlePlugin)
    compileOnly(libs.fabric.loomGradlePlugin)
}

gradlePlugin {
    plugins {
        val koinPlugin by creating {
            id = "gay.pyrrha.orbital.koin"
            implementationClass = "KoinPlugin"
        }
        val runtimePlugin by creating {
            id = "gay.pyrrha.orbital.runtime"
            implementationClass = "RuntimePlugin"
        }
        val sharedPlugin by creating {
            id = "gay.pyrrha.orbital.shared"
            implementationClass = "SharedPlugin"
        }
    }
}