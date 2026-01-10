/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital

import gay.pyrrha.orbital.di.service.PlatformService
import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import org.koin.core.annotation.Single

internal val logger: KLogger = KotlinLogging.logger {}

@Single
public class OrbitalShared(
    private val platform: PlatformService,
) {
    public fun init() {
        logger.info { "$TAG Trans Rights are Human Rights!" }
        logger.info { "$TAG Detected ${platform.platformKey}." }
    }
}
