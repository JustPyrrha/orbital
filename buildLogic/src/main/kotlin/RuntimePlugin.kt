/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.attributes.Attribute
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project
import org.gradle.kotlin.dsl.withType
import org.gradle.language.jvm.tasks.ProcessResources
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

class RuntimePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("gay.pyrrha.orbital.shared")

            val commonKotlin =
                configurations.create("commonKotlin") {
                    isCanBeResolved = true
                }

            val commonJava =
                configurations.create("commonJava") {
                    isCanBeResolved = true
                }

            val commonResources =
                configurations.create("commonResources") {
                    isCanBeResolved = true
                }

            dependencies {
                "compileOnly"(project(path = ":mod:shared")) {
                    capabilities {
                        requireCapability("gay.pyrrha:orbital")
                    }
                    val loaderAttr: Attribute<String> = Attribute.of("io.github.mcgradleconventions.loader", String::class.java)
                    attributes {
                        attribute(loaderAttr, "common")
                    }
                }

                commonKotlin(project(path = ":mod:shared", configuration = "commonKotlin"))
                commonJava(project(path = ":mod:shared", configuration = "commonJava"))
                commonResources(project(path = ":mod:shared", configuration = "commonResources"))
            }

            tasks.withType<KotlinJvmCompile> {
                dependsOn(commonKotlin)
                source(commonKotlin)
            }

            tasks.withType<JavaCompile> {
                dependsOn(commonJava)
                source(commonJava)
            }

            tasks.withType<ProcessResources> {
                dependsOn(commonResources)
                from(commonResources)
            }

            tasks.named("sourcesJar", Jar::class.java) {
                dependsOn(commonKotlin)
                from(commonKotlin)
                dependsOn(commonJava)
                from(commonJava)
                dependsOn(commonResources)
                from(commonResources)
            }
        }
    }
}
