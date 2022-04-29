package net.azagwen.atbyw.block.entity;

import net.azagwen.atbyw.block.slab.FallingSlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FallingSlabEntity extends FallingBlockEntity {
    private BlockState block;
    private BlockPos originalPos;

    public FallingSlabEntity(EntityType<? extends FallingBlockEntity> entityType, World world) {
        super(entityType, world);
    }

    public FallingSlabEntity(World world, double x, double y, double z, BlockState block, BlockPos originalPos) {
        this(EntityType.FALLING_BLOCK, world);
        this.block = block;
        this.inanimate = true;
        this.setPosition(x, y, z);
        this.setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
        this.setFallingBlockPos(this.getBlockPos());
        this.originalPos = originalPos;
    }

    @Override
    public void tick() {
        var world = this.world;
        var pos = this.getBlockPos();
        if (pos.getY() <= (this.originalPos.getY() - 1) && world.getBlockState(pos).getBlock() instanceof FallingSlabBlock) {
            if (world.getBlockState(pos).isOf(this.block.getBlock())) {
                if (world.getBlockState(pos).get(FallingSlabBlock.TYPE) == SlabType.BOTTOM) {
                    world.setBlockState(pos, this.block.with(FallingSlabBlock.TYPE, SlabType.DOUBLE));
                    this.dropItem = false;
                }
            }
        } else {
            this.dropItem = true;
        }
        super.tick();
    }
}
