package net.azagwen.atbyw.testing;

import net.azagwen.atbyw.block.registry.BlockRegistry;
import net.azagwen.atbyw.AtbywMain;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;

import static net.azagwen.atbyw.block.registry.Utils.registerBlock;
import static net.azagwen.atbyw.AtbywMain.DECO_TAB;

public class TestingBlockRegistry extends BlockRegistry {
    public static final Block ACACIA_RAILING = new RailingBlock(AtbywMain.id("acacia_railing"), FabricBlockSettings.copyOf(Blocks.ACACIA_FENCE));
    public static final Block MINI_BLOCK = new MiniBlock(FabricBlockSettings.of(Material.STONE));

    public static void register() {
        registerBlock(DECO_TAB, "mini_block", MINI_BLOCK);
        registerBlock(DECO_TAB, AXE_MINEABLE, "acacia_railing", ACACIA_RAILING);
    }

}
