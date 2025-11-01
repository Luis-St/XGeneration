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

package net.luis.xgeneration.worldgen.carver;

import net.luis.xgeneration.XGeneration;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;

/**
 * Mirrors vanilla cave settings under a dedicated key so you can tweak parameters without starting from scratch.
 */
public final class ModCarvers {

    public static final ResourceKey<ConfiguredWorldCarver<?>> PRIMEVAL_CAVES = create("primeval_caves");

    private ModCarvers() {
    }

    private static ResourceKey<ConfiguredWorldCarver<?>> create(String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, ResourceLocation.fromNamespaceAndPath(XGeneration.MOD_ID, name));
    }

    public static void bootstrap(BootstrapContext<ConfiguredWorldCarver<?>> context) {
        HolderGetter<ConfiguredWorldCarver<?>> lookup = context.lookup(Registries.CONFIGURED_CARVER);
        Holder<ConfiguredWorldCarver<?>> vanillaCave = lookup.getOrThrow(Carvers.CAVE);
        context.register(PRIMEVAL_CAVES, vanillaCave.value());
    }
}
