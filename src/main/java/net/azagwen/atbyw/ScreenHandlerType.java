package net.azagwen.atbyw;

import net.azagwen.atbyw.screen.TintingTableScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public class ScreenHandlerType {
    public static final net.minecraft.screen.ScreenHandlerType<TintingTableScreenHandler> TINTING_TABLE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(AtbywMain.id("tinting_table"), TintingTableScreenHandler::new);
}
