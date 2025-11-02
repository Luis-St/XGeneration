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

package net.luis.xgeneration.worldgen.feature;

import net.luis.xgeneration.XGeneration;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import org.jetbrains.annotations.NotNull;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> PRIMEVAL_MOSS_PATCH = create("primeval_grove/moss_patch");

    private static @NotNull ResourceKey<ConfiguredFeature<?, ?>> create(@NotNull String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(XGeneration.MOD_ID, name));
    }

    public static void bootstrap(@NotNull BootstrapContext<ConfiguredFeature<?, ?>> context) {
        BlockState mossState = Blocks.MOSS_CARPET.defaultBlockState();
        var configuration = new SimpleBlockConfiguration(BlockStateProvider.simple(mossState));
        context.register(PRIMEVAL_MOSS_PATCH, new ConfiguredFeature<>(Feature.SIMPLE_BLOCK, configuration));
    }
}
