package net.azagwen.atbyw.mixin.accessor;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(HandledScreen.class)
public interface HandledScreenAccessor extends ScreenAccessor{

    @Accessor("x")
    int getX();

    @Accessor("y")
    int getY();
}
