/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital.fabric

import gay.pyrrha.orbital.OrbitalShared
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import net.fabricmc.api.ModInitializer

internal val logger: KLogger = KotlinLogging.logger { }

public object OrbitalFabric : ModInitializer {
    override fun onInitialize() {
        logger.info { "$TAG Starting..." }
        OrbitalShared.init()
    }
}
