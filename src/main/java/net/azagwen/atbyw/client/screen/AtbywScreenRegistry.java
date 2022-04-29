package net.azagwen.atbyw.client.screen;

import net.azagwen.atbyw.ScreenHandlerType;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

public class AtbywScreenRegistry {

    public static void init() {
        ScreenRegistry.register(ScreenHandlerType.TINTING_TABLE_SCREEN_HANDLER, TintingTableScreen::new);
    }
}
