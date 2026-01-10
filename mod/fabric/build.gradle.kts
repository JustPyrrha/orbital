/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.loom)
    alias(libs.plugins.orbital.koin)
    alias(libs.plugins.orbital.runtime)
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabric.kotlin)
    implementation(libs.fabric.loader)

    implementation(libs.kotlin.logging)
    include(libs.kotlin.logging)

    include(libs.koin.annotations)
    include(libs.koin.core)
}

loom {
    runtimeOnlyLog4j = true
    runs {
        configureEach {
            ideConfigGenerated(true)
            name = "fabric $name"
            runDir = "../../runs/fabric/$name"
        }
    }
    mods {
        create("orbital") {
            sourceSet(sourceSets.main.get())
        }
    }
}

sourceSets {
    main {
        kotlin {
            srcDir("build/generated/ksp/main")
        }
    }
}

val loaderAttr: Attribute<String> = Attribute.of("io.github.mcgradleconventions.loader", String::class.java)
listOf(
    "apiElements",
    "mainSourceElements",
    "runtimeElements",
).forEach { variant ->
    configurations.named(variant) {
        attributes {
            attribute(loaderAttr, "fabric")
        }
    }
}

sourceSets.configureEach {
    listOf(
        compileClasspathConfigurationName,
        runtimeClasspathConfigurationName,
    ).forEach { variant ->
        configurations.named(variant) {
            attributes {
                attribute(loaderAttr, "fabric")
            }
        }
    }
}
