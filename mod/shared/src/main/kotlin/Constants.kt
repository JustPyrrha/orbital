/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */
package gay.pyrrha.orbital

import net.minecraft.resources.Identifier

public const val MOD_ID: String = "orbital"
internal const val TAG: String = "(Orbital)"
internal const val TAG_CLIENT: String = "(Orbital|Client)"
internal const val TAG_SERVER: String = "(Orbital|Server)"

public fun id(path: String): Identifier = Identifier.fromNamespaceAndPath(MOD_ID, path)
