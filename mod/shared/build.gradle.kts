/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
plugins {
    alias(libs.plugins.kotlin)
    alias(libs.plugins.loom)
    alias(libs.plugins.orbital.shared)
}

configurations {
    val commonKotlin by creating {
        isCanBeResolved = false
        isCanBeConsumed = true
    }
    val commonJava by creating {
        isCanBeResolved = false
        isCanBeConsumed = true
    }
    val commonResources by creating {
        isCanBeResolved = false
        isCanBeConsumed = true
    }
}

artifacts {
    sourceSets.main.get().kotlin.sourceDirectories.forEach {
        add("commonKotlin", it)
    }
    add(
        "commonJava",
        sourceSets.main
            .get()
            .java.sourceDirectories.singleFile,
    )
    add(
        "commonResources",
        sourceSets.main
            .get()
            .resources.sourceDirectories.singleFile,
    )
}

val loaderAttr: Attribute<String> = Attribute.of("io.github.mcgradleconventions.loader", String::class.java)
listOf(
    "apiElements",
    "mainSourceElements",
    "runtimeElements",
).forEach { variant ->
    configurations.named(variant) {
        attributes {
            attribute(loaderAttr, "common")
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
                attribute(loaderAttr, "common")
            }
        }
    }
}

dependencies {
    minecraft(libs.minecraft)

    implementation(libs.kotlin.logging)
}

loom {
    runtimeOnlyLog4j = true
    runs {
        configureEach {
            ideConfigGenerated(false)
        }
    }
}
