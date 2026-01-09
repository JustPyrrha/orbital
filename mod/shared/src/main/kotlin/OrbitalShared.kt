/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging

internal val logger: KLogger = KotlinLogging.logger {}

public object OrbitalShared {
    public fun init() {
        logger.info { "$TAG Trans Rights are Human Rights!" }
    }
}
