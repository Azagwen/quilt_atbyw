package net.azagwen.atbyw;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Tags {

    public static class BlockTags {
        public static final TagKey<Block> BOOKSHELVES_COMMON = registerBlockTag(new Identifier("c", "bookshelves"));
        public static final TagKey<Block> SHROOMSTICK_REPLACEABLE_GROUND = registerBlockTag("shroomstick_replaceable_ground");
        public static final TagKey<Block> SHROOMSTICK_REPLACEABLE_WATER = registerBlockTag("shroomstick_replaceable_water");
        public static final TagKey<Block> LARGE_CHAIN_TRANSITION_BOTTOM = registerBlockTag("large_chain_transition_bottom");
        public static final TagKey<Block> LARGE_CHAIN_TRANSITION_TOP = registerBlockTag("large_chain_transition_top");
        public static final TagKey<Block> CONNECTS_TO_PIPES = registerBlockTag("connects_to_pipes");
        public static final TagKey<Block> CONNECTS_TO_PIPES_AND_UPDATES = registerBlockTag("connects_to_pipes_and_updates");
        public static final TagKey<Block> KILLS_GRASS = registerBlockTag("kills_grass");
        public static final TagKey<Block> SPARES_GRASS = registerBlockTag("spares_grass");
    }

    public static class ItemTags {
        public static final TagKey<Item> BOOKSHELVES_COMMON = blockItemTag(BlockTags.BOOKSHELVES_COMMON);
        public static final TagKey<Item> SHROOMSTICK_REPLACEABLE_GROUND = blockItemTag(BlockTags.SHROOMSTICK_REPLACEABLE_GROUND);
        public static final TagKey<Item> SHROOMSTICK_REPLACEABLE_WATER = blockItemTag(BlockTags.SHROOMSTICK_REPLACEABLE_WATER);
        public static final TagKey<Item> LARGE_CHAIN_TRANSITION_BOTTOM = blockItemTag(BlockTags.LARGE_CHAIN_TRANSITION_BOTTOM);
        public static final TagKey<Item> LARGE_CHAIN_TRANSITION_TOP = blockItemTag(BlockTags.LARGE_CHAIN_TRANSITION_TOP);
        public static final TagKey<Item> CONNECTS_TO_PIPES = blockItemTag(BlockTags.CONNECTS_TO_PIPES);
        public static final TagKey<Item> CONNECTS_TO_PIPES_AND_UPDATES = blockItemTag(BlockTags.CONNECTS_TO_PIPES_AND_UPDATES);
        public static final TagKey<Item> KILLS_GRASS = blockItemTag(BlockTags.KILLS_GRASS);
        public static final TagKey<Item> SPARES_GRASS = blockItemTag(BlockTags.SPARES_GRASS);
    }

    private Tags() {
    }

    public static TagKey<Item> blockItemTag(TagKey<Block> blockTag) {
        return TagKey.of(Registry.ITEM_KEY, blockTag.id());
    }

    public static TagKey<Block> registerBlockTag(String path) {
        return TagKey.of(Registry.BLOCK_KEY, AtbywMain.id(path));
    }

    public static TagKey<Block> registerBlockTag(Identifier id) {
        return TagKey.of(Registry.BLOCK_KEY, id);
    }

    public static TagKey<Item> registerItemTag(String path) {
        return TagKey.of(Registry.ITEM_KEY, AtbywMain.id(path));
    }
}
