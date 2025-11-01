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

package net.luis.xgeneration.worldgen.biome;

import net.luis.xgeneration.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

/**
 * Utility biome factory that produces a lush moss-heavy forest biome meant as a starting point.
 */
public final class PrimevalGroveBiome {

    private PrimevalGroveBiome() {
    }

    public static Biome create(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> carvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.plainsSpawns(spawnBuilder);
        BiomeDefaultFeatures.monsters(spawnBuilder, 95, 5, 100, false);

        BiomeGenerationSettings.Builder generationBuilder = new BiomeGenerationSettings.Builder(placedFeatures, carvers);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(generationBuilder);
        BiomeDefaultFeatures.addDefaultOres(generationBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(generationBuilder);
        BiomeDefaultFeatures.addLushCavesVegetationFeatures(generationBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(generationBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(generationBuilder);

        Holder<PlacedFeature> mossPatch = placedFeatures.getOrThrow(ModPlacedFeatures.PRIMEVAL_MOSS_PATCH);
        generationBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, mossPatch);

        BiomeSpecialEffects effects = new BiomeSpecialEffects.Builder()
            .waterColor(0x2a8a6f)
            .waterFogColor(0x184437)
            .fogColor(0x8ad6ff)
            .skyColor(0x66b7ff)
            .grassColorOverride(0x3fa75a)
            .foliageColorOverride(0x2f8245)
            .ambientLoopSound(SoundEvents.AMBIENT_CAVE)
            .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST))
            .build();

        return new Biome.BiomeBuilder()
            .hasPrecipitation(true)
            .temperature(0.8F)
            .downfall(0.9F)
            .specialEffects(effects)
            .mobSpawnSettings(spawnBuilder.build())
            .generationSettings(generationBuilder.build())
            .build();
    }
}
