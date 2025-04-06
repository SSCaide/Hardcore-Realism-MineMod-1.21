package net.sscaide.realismmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sscaide.realismmod.RealismMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SHARPENED_STICK = createTag("needs_sharpened_stick");
        public static final TagKey<Block> INCORRECT_FOR_SHARPENED_STICK = createTag("incorrect_for_sharpened_stick");
        public static final TagKey<Block> NEEDS_SHARPENED_ROCK = createTag("needs_sharpened_rock");
        public static final TagKey<Block> INCORRECT_FOR_SHARPENED_ROCK = createTag("incorrect_for_sharpened_rock");
        public static final TagKey<Block> NEEDS_CRUDE_STONE_TOOL = createTag("needs_crude_stone_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRUDE_STONE_TOOL = createTag("incorrect_for_crude_stone_tool");
        public static final TagKey<Block> NEEDS_FLINT_TOOL = createTag("needs_flint_tool");
        public static final TagKey<Block> INCORRECT_FOR_FLINT_TOOL = createTag("incorrect_for_flint_tool");
        public static final TagKey<Block> NEEDS_CRUDE_COPPER_TOOL = createTag("needs_crude_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRUDE_COPPER_TOOL = createTag("incorrect_for_crude_copper_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");
        public static final TagKey<Block> NEEDS_CRUDE_IRON_TOOL = createTag("needs_crude_iron_tool");
        public static final TagKey<Block> INCORRECT_FOR_CRUDE_IRON_TOOL = createTag("incorrect_for_crude_iron_tool");

        public static final TagKey<Block> CRACKED_STONE = createTag("cracked_stone");
        public static final TagKey<Block> PALM_LOGS = createTag("palm_logs");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DYES = createTag("dyes");
        public static final TagKey<Item> TIMBER = createTag("timber");
        public static final TagKey<Item> PLANK_MATERIALS = createTag("plank_materials");
        public static final TagKey<Item> GRAVEL_MATERIALS = createTag("gravel_materials");
        public static final TagKey<Item> ROCKS = createTag("rocks");
        public static final TagKey<Item> ROCKS_NO_SANDSTONE = createTag("rocks_no_sandstone");
        public static final TagKey<Item> STONE_BRICK_MATERIALS = createTag("stone_brick_materials");

        public static final TagKey<Item> DAGGERS = createTag("daggers");

        public static final TagKey<Item> SEEDS_FOR_CRAFTING = createTag("seeds_for_crafting");
        public static final TagKey<Item> PACKED_MUD_BINDING_AGENTS = createTag("packed_mud_binding_agents");
        public static final TagKey<Item> ROPES_FOR_CRAFTING_INCLUDE_VINE = createTag("ropes_for_crafting_include_vine");

        public static final TagKey<Item> COPPER_INGOT_SMELTABLES = createTag("copper_ingot_smeltables");
        public static final TagKey<Item> COPPER_NUGGET_SMELTABLES = createTag("copper_nugget_smeltables");
        public static final TagKey<Item> IRON_INGOT_SMELTABLES = createTag("iron_ingot_smeltables");
        public static final TagKey<Item> IRON_NUGGET_SMELTABLES = createTag("iron_nugget_smeltables");

        public static final TagKey<Item> CRUSHING_CRAFTING = createTag("crushing_crafting");
        public static final TagKey<Item> CRUSHING_CRAFTING_COPPER_PLUS = createTag("crushing_crafting_copper_plus");
        public static final TagKey<Item> CRUDE_SHARPENING_CRAFTING = createTag("crude_sharpening_crafting");
        public static final TagKey<Item> CRUDE_CARVING_CRAFTING = createTag("crude_carving_crafting");
        public static final TagKey<Item> CARVING_CRAFTING = createTag("carving_crafting");
        public static final TagKey<Item> CHISEL_CRAFTING = createTag("chisel_crafting");

        public static final TagKey<Item> PALM_LOGS = createTag("palm_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, name));
        }
    }
}
