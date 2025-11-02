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
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.carver.*;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import org.jetbrains.annotations.NotNull;

public class ModCarvers {

    public static final ResourceKey<ConfiguredWorldCarver<?>> PRIMEVAL_CAVES = create("primeval_caves");

    private static @NotNull ResourceKey<ConfiguredWorldCarver<?>> create(@NotNull String name) {
        return ResourceKey.create(Registries.CONFIGURED_CARVER, ResourceLocation.fromNamespaceAndPath(XGeneration.MOD_ID, name));
    }

    public static void bootstrap(@NotNull BootstrapContext<ConfiguredWorldCarver<?>> context) {
		HolderGetter<Block> blockLookup = context.lookup(Registries.BLOCK);
		
        context.register(PRIMEVAL_CAVES, WorldCarver.CAVE
			.configured(
				new CaveCarverConfiguration(
					0.15F,
					UniformHeight.of(VerticalAnchor.aboveBottom(8), VerticalAnchor.absolute(180)),
					UniformFloat.of(0.1F, 0.9F),
					VerticalAnchor.aboveBottom(8),
					CarverDebugSettings.of(false, Blocks.CRIMSON_BUTTON.defaultBlockState()),
					blockLookup.getOrThrow(BlockTags.OVERWORLD_CARVER_REPLACEABLES),
					UniformFloat.of(0.7F, 1.4F),
					UniformFloat.of(0.8F, 1.3F),
					UniformFloat.of(-1.0F, -0.4F)
				)
			));
    }
}
