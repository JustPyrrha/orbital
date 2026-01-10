/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital.di.service

public interface PlatformService {
    public val platformKey: String

    public fun isModLoaded(id: String): Boolean
}
