/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
initscript {
    val spotlessVersion = "8.1.0"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
    }
}

rootProject {
    if (rootProject.name == "buildLogic") {
        applySpotless(this)
    } else {
        subprojects {
            if (this.name != "mod") {
                applySpotless(this)
            }
        }
    }
}

fun applySpotless(project: org.gradle.api.Project) {
    project.apply<com.diffplug.gradle.spotless.SpotlessPlugin>()
    project.extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
        val spotlessTemplatesDir = rootProject.file(if (rootProject.name == "buildLogic") { "../spotless" } else { "spotless" })
        kotlin {
            ktlint()
            licenseHeaderFile("$spotlessTemplatesDir/license.kt", "(^(?![\\/ ]\\*).*$)")
        }
        kotlinGradle {
            ktlint()
            licenseHeaderFile("$spotlessTemplatesDir/license.kt", "(^(?![\\/ ]\\*).*$)")
        }

        format("json") {
            target("**/*.json")
            targetExclude(rootProject.file("runs"))
            biome()
        }
    }
}