package net.azagwen.atbyw.mixin.accessor;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.StairShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(StairsBlock.class)
public interface StairsBlockAccessor {

    @Invoker
    static StairShape invokeGetStairShape(BlockState state, BlockView world, BlockPos pos) {
        throw new IllegalArgumentException("oh no");
    };
}
