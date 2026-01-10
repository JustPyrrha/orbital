package gay.pyrrha.orbital.fabric.di.service

import gay.pyrrha.orbital.di.service.PlatformService
import net.fabricmc.loader.api.FabricLoader

public class FabricPlatformService : PlatformService {
    override val platformKey: String
        get() = "Fabric"

    override fun isModLoaded(id: String): Boolean =
        FabricLoader.getInstance().isModLoaded(id)
}