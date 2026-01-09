/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePluginExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.repositories
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension

class SharedPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("org.jetbrains.kotlin.jvm")

            extensions.configure<BasePluginExtension> {
                archivesName = "${rootProject.name}-${project.name}"
            }

            extensions.configure<JavaPluginExtension> {
                toolchain.languageVersion.set(JavaLanguageVersion.of(25))
                withSourcesJar()
            }

            repositories {
                mavenCentral()
            }

            extensions.configure<KotlinJvmProjectExtension> {
                jvmToolchain(25)
                explicitApi()
            }

            listOf(
                "apiElements",
                "mainSourceElements",
                "runtimeElements",
            ).forEach { variant ->
                configurations.named(variant) {
                    outgoing {
                        capability("gay.pyrrha:orbital-${project.name}:$version")
                        capability("gay.pyrrha:orbital:$version")
                    }
                }
            }
        }
    }
}
