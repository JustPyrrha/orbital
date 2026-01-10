/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital.fabric.di

import gay.pyrrha.orbital.OrbitalShared
import gay.pyrrha.orbital.di.service.PlatformService
import gay.pyrrha.orbital.fabric.di.service.FabricPlatformService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val fabricModule =
    module {
        singleOf(::OrbitalShared)
        singleOf(::FabricPlatformService) { bind<PlatformService>() }
    }
