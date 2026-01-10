/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

plugins {
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.neoGradle) apply false
    alias(libs.plugins.loom) apply false

    alias(libs.plugins.orbital.koin) apply false
    alias(libs.plugins.orbital.runtime) apply false
    alias(libs.plugins.orbital.shared) apply false
}

group = "gay.pyrrha"
version = "0.1.0"

repositories {
    mavenCentral()
}
