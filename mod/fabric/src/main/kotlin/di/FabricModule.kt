package gay.pyrrha.orbital.fabric.di

import gay.pyrrha.orbital.OrbitalShared
import gay.pyrrha.orbital.di.service.PlatformService
import gay.pyrrha.orbital.fabric.di.service.FabricPlatformService
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

internal val fabricModule = module {
    singleOf(::OrbitalShared)
    singleOf(::FabricPlatformService) { bind<PlatformService>() }
}
