package net.azagwen.atbyw.world.feature;

import com.mojang.serialization.Codec;
import net.azagwen.atbyw.world.structure.BigIglooGenerator;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructureStart;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.world.HeightLimitView;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class BigIglooFeature extends StructureFeature<DefaultFeatureConfig> {

    public BigIglooFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public StructureFeature.StructureStartFactory<DefaultFeatureConfig> getStructureStartFactory() {
        return Start::new;
    }

    public static class Start extends StructureStart<DefaultFeatureConfig> {
        public Start(StructureFeature<DefaultFeatureConfig> feature, ChunkPos chunkPos, int references, long seed) {
            super(feature, chunkPos, references, seed);
        }

        // Called when the world attempts to spawn in a new structure, and is the gap between your feature and generator.
        public void init(DynamicRegistryManager registryManager, ChunkGenerator chunkGenerator, StructureManager manager, ChunkPos chunkPos, Biome biome, DefaultFeatureConfig config, HeightLimitView world) {
            int x = chunkPos.x * 16;
            int z = chunkPos.z * 16;
            int y = chunkGenerator.getHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG, world);
            BlockPos blockPos = new BlockPos(x, (Math.min(y, 70)), z);
            BlockRotation rotation = BlockRotation.random(this.random);
            BigIglooGenerator.addPieces(manager, blockPos, rotation, this.children);
            this.setBoundingBoxFromChildren();
        }
    }
}
