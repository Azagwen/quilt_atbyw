package net.azagwen.atbyw.mixin.block_behavior;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class BlockMixin {
    private @Unique ClassLoader classLoader;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void injectInConstructor(AbstractBlock.Settings settings, CallbackInfo ci) {
        this.classLoader = this.getClass().getClassLoader();
    }

    @Inject(method = "toString", at = @At("RETURN"), cancellable = true)
    private void addClassToString(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(cir.getReturnValue().replace("}", ", " + this.classLoader.getName() + "}"));
    }
}
