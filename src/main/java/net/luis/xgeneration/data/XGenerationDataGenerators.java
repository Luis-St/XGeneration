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

package net.luis.xgeneration.data;

import net.luis.xgeneration.XGeneration;
import net.luis.xgeneration.worldgen.ModWorldgen;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

/**
 * Registers data providers that bootstrap the world-generation registry entries.
 */
public final class XGenerationDataGenerators {

    private XGenerationDataGenerators() {
    }

    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        var registryBuilder = ModWorldgen.registryBuilder();
        generator.addProvider(true, new DatapackBuiltinEntriesProvider(packOutput, lookupProvider, registryBuilder, Set.of(XGeneration.MOD_ID)));
    }
}
