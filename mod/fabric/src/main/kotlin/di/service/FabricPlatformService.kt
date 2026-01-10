/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital.fabric.di.service

import gay.pyrrha.orbital.di.service.PlatformService
import net.fabricmc.loader.api.FabricLoader
import org.koin.core.annotation.Single

@Single
public class FabricPlatformService : PlatformService {
    override val platformKey: String
        get() = "Fabric"

    override fun isModLoaded(id: String): Boolean = FabricLoader.getInstance().isModLoaded(id)
}
