/*
 * XGeneration
 * Copyright (C) 2025 Luis Staudt
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <https://www.gnu.org/licenses/>.
 */

package net.luis.xgeneration;

import net.luis.xgeneration.worldgen.ModWorldgen;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@Mod(XGeneration.MOD_ID)
public final class XGeneration {

    public static final String MOD_ID = "xgeneration";
    public static final String MOD_NAME = "XGeneration";
    public static final Logger LOGGER = LogManager.getLogger(XGeneration.class);

    public XGeneration(@NotNull ModContainer container) {
        IEventBus modEventBus = Objects.requireNonNull(container.getEventBus());
        ModWorldgen.init(modEventBus);
    }
}
