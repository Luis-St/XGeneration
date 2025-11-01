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

package net.luis.xgeneration.worldgen.surface;

import net.luis.xgeneration.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

/**
 * Pre-built surface rule snippets that can be plugged into a custom noise generator.
 */
public final class ModSurfaceRules {

    private ModSurfaceRules() {
    }

    public static SurfaceRules.RuleSource primevalGroveSurface() {
        SurfaceRules.RuleSource mossFloor = SurfaceRules.ifTrue(
            SurfaceRules.ON_FLOOR,
            SurfaceRules.state(Blocks.MOSS_BLOCK.defaultBlockState())
        );

        SurfaceRules.RuleSource mossUnder = SurfaceRules.ifTrue(
            SurfaceRules.UNDER_FLOOR,
            SurfaceRules.state(Blocks.MOSSY_COBBLESTONE.defaultBlockState())
        );

        SurfaceRules.RuleSource defaultTop = SurfaceRules.ifTrue(
            SurfaceRules.ON_FLOOR,
            SurfaceRules.state(Blocks.GRASS_BLOCK.defaultBlockState())
        );

        SurfaceRules.RuleSource defaultUnder = SurfaceRules.ifTrue(
            SurfaceRules.UNDER_FLOOR,
            SurfaceRules.state(Blocks.DIRT.defaultBlockState())
        );

        return SurfaceRules.sequence(
            SurfaceRules.ifTrue(
                SurfaceRules.isBiome(ModBiomes.PRIMEVAL_GROVE),
                SurfaceRules.sequence(mossFloor, mossUnder)
            ),
            SurfaceRules.sequence(defaultTop, defaultUnder)
        );
    }
}
