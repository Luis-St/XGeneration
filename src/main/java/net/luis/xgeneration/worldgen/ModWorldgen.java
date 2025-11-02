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

package net.luis.xgeneration.worldgen;

import net.luis.xgeneration.worldgen.biome.ModBiomes;
import net.luis.xgeneration.worldgen.carver.ModCarvers;
import net.luis.xgeneration.worldgen.feature.ModConfiguredFeatures;
import net.luis.xgeneration.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import org.jetbrains.annotations.NotNull;

public class ModWorldgen {

    public static void init(@NotNull IEventBus modEventBus) {
        // Reserved for future deferred registers (biome modifiers, density functions, etc.).
    }

    public static RegistrySetBuilder registryBuilder() {
        return new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(Registries.CONFIGURED_CARVER, ModCarvers::bootstrap)
            .add(Registries.BIOME, ModBiomes::bootstrap);
    }
}
