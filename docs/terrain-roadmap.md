# Terrain Roadmap

Use this checklist to grow XGeneration into a fully fledged custom world:

## 1. Data Generation Workflow
- [ ] Run `JAVA_HOME=/home/luis/.jdks/temurin-21.0.8 ./gradlew runClientData` to emit JSON under `src/generated/resources`.
- [ ] Review generated files to understand how NeoForge expects worldgen data to look.
- [ ] Copy stabilized JSON into `src/main/resources` if you want to ship hand-edited variants.

## 2. Biomes
- [ ] Create additional biome factories alongside `PrimevalGroveBiome` and register them in `ModBiomes`.
- [ ] Tweak `MobSpawnSettings` / `BiomeSpecialEffects` to suit each biome theme.
- [ ] Use `BiomeDefaultFeatures` calls or custom placed features to differentiate vegetation and ambient generation.
- [ ] Add biome modifiers (data or code) to surface the biomes in the overworld noise router.

## 3. Caves & Carvers
- [ ] Add a class like `ModCarvers` with new `ConfiguredWorldCarver` entries and hook it into `ModWorldgen.registryBuilder()`.
- [ ] Reference your carvers from biomes or biome modifiers to activate them underground.
- [ ] Experiment with noise thresholds to sculpt cave breadth/height.

## 4. Surface Rules
- [ ] Create a utility similar to `ModSurfaceRules` (stub provided) and craft layered rules using `SurfaceRules.sequence`.
- [ ] Override the overworld noise settings via a custom `world_preset` JSON that references your noise + surface pipeline.
- [ ] Consider per-biome surface overrides using `SurfaceRules.ifTrue(SurfaceRules.isBiome(...), ...)`.

## 5. Testing
- [ ] Use `JAVA_HOME=/home/luis/.jdks/temurin-21.0.8 ./gradlew runClient` (and `runServer`) for quick iteration.
- [ ] Turn on the built-in chunk debug renderer (`F3 + G`) to visualise chunk borders and noise transitions.

## 6. Packaging
- [ ] Adjust `gradle.properties` (`ModVersion`) before releasing builds.
- [ ] Update `neoforge.mods.toml` credits/URLs once the mod has a public home.
