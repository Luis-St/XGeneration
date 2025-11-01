XGeneration - NeoForge Terrain Playground
========================================

This project is a fork-friendly starting point for experimenting with custom terrain generation on NeoForge 21.x for Minecraft 1.21.8. The previous XBackpack inventory codebase has been replaced with a lightweight world generation playground that demonstrates how to:

- Register configured and placed features for mossy floor patches.
- Bootstrap a custom biome (`primeval_grove`) that reuses vanilla infrastructure but adds new vegetation.
- Wire a data generator pipeline so you can extend the worldgen registries (features, biomes, carvers, etc.) with Java code and emit the required JSON.

Getting Started
---------------

1. Run `JAVA_HOME=/home/luis/.jdks/temurin-21.0.8 ./gradlew runClientData` to (re)generate worldgen json into `src/generated/resources`.
2. Launch the dev client with `JAVA_HOME=/home/luis/.jdks/temurin-21.0.8 ./gradlew runClient` and pick the "Primeval Grove" world preset (under Experiments) to explore the biome in isolation.
3. Extend the registries in `net.luis.xgeneration.worldgen` with your own features, density functions, or carvers; regenerate data when you add new entries.

Helpful Files
-------------

- `net.luis.xgeneration.worldgen.feature.ModConfiguredFeatures` – define terrain elements (vegetation, boulders, etc.).
- `net.luis.xgeneration.worldgen.feature.ModPlacedFeatures` – control placement frequency and height ranges.
- `net.luis.xgeneration.worldgen.biome.PrimevalGroveBiome` – compose spawn rules and features for the sample biome.
- `docs/terrain-roadmap.md` – checklist of next steps for adding biomes, caves, and custom surface rules.

License
-------

GPL v3 (see `LICENSE`).
