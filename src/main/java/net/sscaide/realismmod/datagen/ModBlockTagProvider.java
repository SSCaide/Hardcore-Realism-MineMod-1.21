package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RealismMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRON_BREAKABLE_STONE.get())

                .add(ModBlocks.DEEPSLATE_SLAB.get())
                .add(ModBlocks.CALCITE_SLAB.get())
                .add(ModBlocks.DRIPSTONE_SLAB.get())
                .add(ModBlocks.NETHERRACK_SLAB.get())
                .add(ModBlocks.BASALT_SLAB.get())
                .add(ModBlocks.SMOOTH_BASALT_SLAB.get())
                .add(ModBlocks.END_STONE_SLAB.get())

                .add(ModBlocks.WHITE_SANDSTONE.get())
                .add(ModBlocks.WHITE_SANDSTONE_STAIRS.get())
                .add(ModBlocks.WHITE_SANDSTONE_SLAB.get())
                .add(ModBlocks.WHITE_SANDSTONE_WALL.get())
                .add(ModBlocks.CHISELED_WHITE_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_WHITE_SANDSTONE.get())
                .add(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get())
                .add(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get())
                .add(ModBlocks.CUT_WHITE_SANDSTONE.get())
                .add(ModBlocks.CUT_WHITE_SANDSTONE_SLAB.get())

                .add(ModBlocks.CRACKED_STONE.get())
                .add(ModBlocks.MOD_COBBLESTONE.get())
                .add(ModBlocks.MOD_COBBLESTONE_STAIRS.get())
                .add(ModBlocks.MOD_COBBLESTONE_SLAB.get())
                .add(ModBlocks.CRACKED_DEEPSLATE.get())
                .add(ModBlocks.MOD_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.MOD_COBBLED_DEEPSLATE_STAIRS.get())
                .add(ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB.get())
                .add(ModBlocks.COBBLED_SANDSTONE.get())
                .add(ModBlocks.COBBLED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.COBBLED_SANDSTONE_SLAB.get())
                .add(ModBlocks.COBBLED_RED_SANDSTONE.get())
                .add(ModBlocks.COBBLED_RED_SANDSTONE_STAIRS.get())
                .add(ModBlocks.COBBLED_RED_SANDSTONE_SLAB.get())
                .add(ModBlocks.COBBLED_WHITE_SANDSTONE.get())
                .add(ModBlocks.COBBLED_WHITE_SANDSTONE_STAIRS.get())
                .add(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB.get())
                .add(ModBlocks.CRACKED_GRANITE.get())
                .add(ModBlocks.COBBLED_GRANITE.get())
                .add(ModBlocks.COBBLED_GRANITE_STAIRS.get())
                .add(ModBlocks.COBBLED_GRANITE_SLAB.get())
                .add(ModBlocks.CRACKED_DIORITE.get())
                .add(ModBlocks.COBBLED_DIORITE.get())
                .add(ModBlocks.COBBLED_DIORITE_STAIRS.get())
                .add(ModBlocks.COBBLED_DIORITE_SLAB.get())
                .add(ModBlocks.CRACKED_ANDESITE.get())
                .add(ModBlocks.COBBLED_ANDESITE.get())
                .add(ModBlocks.COBBLED_ANDESITE_STAIRS.get())
                .add(ModBlocks.COBBLED_ANDESITE_SLAB.get())
                .add(ModBlocks.CRACKED_CALCITE.get())
                .add(ModBlocks.COBBLED_CALCITE.get())
                .add(ModBlocks.COBBLED_CALCITE_STAIRS.get())
                .add(ModBlocks.COBBLED_CALCITE_SLAB.get())
                .add(ModBlocks.CRACKED_TUFF.get())
                .add(ModBlocks.COBBLED_TUFF.get())
                .add(ModBlocks.COBBLED_TUFF_STAIRS.get())
                .add(ModBlocks.COBBLED_TUFF_SLAB.get())
                .add(ModBlocks.CRACKED_DRIPSTONE.get())
                .add(ModBlocks.COBBLED_DRIPSTONE.get())
                .add(ModBlocks.COBBLED_DRIPSTONE_STAIRS.get())
                .add(ModBlocks.COBBLED_DRIPSTONE_SLAB.get())
                .add(ModBlocks.COBBLED_NETHERRACK.get())
                .add(ModBlocks.COBBLED_NETHERRACK_STAIRS.get())
                .add(ModBlocks.COBBLED_NETHERRACK_SLAB.get())
                .add(ModBlocks.COBBLED_BLACKSTONE.get())
                .add(ModBlocks.COBBLED_BLACKSTONE_STAIRS.get())
                .add(ModBlocks.COBBLED_BLACKSTONE_SLAB.get())
                .add(ModBlocks.CRACKED_BASALT.get())
                .add(ModBlocks.COBBLED_BASALT.get())
                .add(ModBlocks.COBBLED_BASALT_STAIRS.get())
                .add(ModBlocks.COBBLED_BASALT_SLAB.get())
                .add(ModBlocks.CRACKED_END_STONE.get())
                .add(ModBlocks.COBBLED_END_STONE.get())
                .add(ModBlocks.COBBLED_END_STONE_STAIRS.get())
                .add(ModBlocks.COBBLED_END_STONE_SLAB.get())

                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_WALL.get())

                .add(ModBlocks.TIN_BULB.get())
                .add(ModBlocks.BRICK_FURNACE.get())
                .add(ModBlocks.BLOOMERY.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.IRON_BREAKABLE_WOOD.get())

                .add(ModBlocks.CHIPPED_OAK_LOG.get())
                .add(ModBlocks.THIN_OAK_LOG.get())
                .add(ModBlocks.CHIPPED_SPRUCE_LOG.get())
                .add(ModBlocks.THIN_SPRUCE_LOG.get())
                .add(ModBlocks.CHIPPED_BIRCH_LOG.get())
                .add(ModBlocks.THIN_BIRCH_LOG.get())
                .add(ModBlocks.CHIPPED_JUNGLE_LOG.get())
                .add(ModBlocks.THIN_JUNGLE_LOG.get())
                .add(ModBlocks.CHIPPED_ACACIA_LOG.get())
                .add(ModBlocks.THIN_ACACIA_LOG.get())
                .add(ModBlocks.CHIPPED_DARK_OAK_LOG.get())
                .add(ModBlocks.THIN_DARK_OAK_LOG.get())
                .add(ModBlocks.CHIPPED_CHERRY_LOG.get())
                .add(ModBlocks.THIN_CHERRY_LOG.get())
                .add(ModBlocks.CHIPPED_MANGROVE_LOG.get())
                .add(ModBlocks.THIN_MANGROVE_LOG.get())
                .add(ModBlocks.CHIPPED_PALM_LOG.get())
                .add(ModBlocks.THIN_PALM_LOG.get())

                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.PALM_PLANKS.get())

                .add(ModBlocks.PALM_STAIRS.get())
                .add(ModBlocks.PALM_SLAB.get())
                .add(ModBlocks.PALM_FENCE.get())

                .add(ModBlocks.PALM_FENCE_GATE.get())
                .add(ModBlocks.PALM_DOOR.get())
                .add(ModBlocks.PALM_TRAPDOOR.get())
                .add(ModBlocks.PALM_PRESSURE_PLATE.get())
                .add(ModBlocks.PALM_BUTTON.get())

                .add(ModBlocks.CRUDE_OAK_BLOCK.get())
                .add(ModBlocks.CRUDE_SPRUCE_BLOCK.get())
                .add(ModBlocks.CRUDE_BIRCH_BLOCK.get())
                .add(ModBlocks.CRUDE_JUNGLE_BLOCK.get())
                .add(ModBlocks.CRUDE_ACACIA_BLOCK.get())
                .add(ModBlocks.CRUDE_DARK_OAK_BLOCK.get())
                .add(ModBlocks.CRUDE_MANGROVE_BLOCK.get())
                .add(ModBlocks.CRUDE_CHERRY_BLOCK.get())
                .add(ModBlocks.CRUDE_PALM_BLOCK.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.IRON_BREAKABLE_SOIL.get())

                .add(ModBlocks.DIRT_SLAB.get())
                .add(ModBlocks.MUD_SLAB.get())
                .add(ModBlocks.CLAY_SLAB.get())
                .add(ModBlocks.GRAVEL_SLAB.get())
                .add(ModBlocks.SAND_SLAB.get())
                .add(ModBlocks.RED_SAND_SLAB.get())
                .add(ModBlocks.WHITE_SAND.get())
                .add(ModBlocks.WHITE_SAND_SLAB.get());
        tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.MOSS_SLAB.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_WALL.get())

                .add(ModBlocks.TIN_BULB.get())


                .remove(Blocks.IRON_ORE)
                .remove(Blocks.DEEPSLATE_IRON_ORE);

        tag(ModTags.Blocks.NEEDS_SHARPENED_ROCK)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_SHARPENED_ROCK)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_SHARPENED_ROCK);

        tag(ModTags.Blocks.NEEDS_CRUDE_STONE_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_CRUDE_STONE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_CRUDE_STONE_TOOL);

        tag(ModTags.Blocks.NEEDS_FLINT_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_FLINT_TOOL);

        tag(ModTags.Blocks.NEEDS_CRUDE_COPPER_TOOL)
                .addTag(ModTags.Blocks.NEEDS_COPPER_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_CRUDE_COPPER_TOOL)
                .addTag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .remove(ModTags.Blocks.NEEDS_CRUDE_COPPER_TOOL);

        tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL)
                .add(Blocks.IRON_ORE)
                .add(Blocks.DEEPSLATE_IRON_ORE);
        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_COPPER_TOOL);

        tag(ModTags.Blocks.NEEDS_CRUDE_IRON_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_CRUDE_IRON_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_CRUDE_IRON_TOOL)
                .addTag(Tags.Blocks.ORES_DIAMOND);

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.IRON_BREAKABLE_STONE.get())
                .add(ModBlocks.IRON_BREAKABLE_SOIL.get())
                .add(ModBlocks.IRON_BREAKABLE_WOOD.get())
        ;


        tag(ModTags.Blocks.CRACKED_STONE)
                .add(ModBlocks.CRACKED_STONE.get())
                .add(ModBlocks.CRACKED_DEEPSLATE.get())
                .add(ModBlocks.CRACKED_GRANITE.get())
                .add(ModBlocks.CRACKED_DIORITE.get())
                .add(ModBlocks.CRACKED_ANDESITE.get())
                .add(ModBlocks.CRACKED_CALCITE.get())
                .add(ModBlocks.CRACKED_TUFF.get())
                .add(ModBlocks.CRACKED_DRIPSTONE.get())
                .add(ModBlocks.CRACKED_BASALT.get())
                .add(ModBlocks.CRACKED_END_STONE.get())
        ;
        tag(ModTags.Blocks.COBBLESTONE)
                .add(Blocks.COBBLESTONE)
                .add(Blocks.INFESTED_COBBLESTONE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(ModBlocks.MOD_COBBLESTONE.get())
                .add(ModBlocks.MOD_COBBLED_DEEPSLATE.get())
                .add(ModBlocks.COBBLED_SANDSTONE.get())
                .add(ModBlocks.COBBLED_RED_SANDSTONE.get())
                .add(ModBlocks.COBBLED_WHITE_SANDSTONE.get())
                .add(ModBlocks.COBBLED_GRANITE.get())
                .add(ModBlocks.COBBLED_DIORITE.get())
                .add(ModBlocks.COBBLED_ANDESITE.get())
                .add(ModBlocks.COBBLED_CALCITE.get())
                .add(ModBlocks.COBBLED_TUFF.get())
                .add(ModBlocks.COBBLED_DRIPSTONE.get())
                .add(ModBlocks.COBBLED_NETHERRACK.get())
                .add(ModBlocks.COBBLED_BLACKSTONE.get())
                .add(ModBlocks.COBBLED_BASALT.get())
                .add(ModBlocks.COBBLED_END_STONE.get())
                ;


        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.CHIPPED_OAK_LOG.get())
                .add(ModBlocks.THIN_OAK_LOG.get())
                .add(ModBlocks.CHIPPED_SPRUCE_LOG.get())
                .add(ModBlocks.THIN_SPRUCE_LOG.get())
                .add(ModBlocks.CHIPPED_BIRCH_LOG.get())
                .add(ModBlocks.THIN_BIRCH_LOG.get())
                .add(ModBlocks.CHIPPED_JUNGLE_LOG.get())
                .add(ModBlocks.THIN_JUNGLE_LOG.get())
                .add(ModBlocks.CHIPPED_ACACIA_LOG.get())
                .add(ModBlocks.THIN_ACACIA_LOG.get())
                .add(ModBlocks.CHIPPED_DARK_OAK_LOG.get())
                .add(ModBlocks.THIN_DARK_OAK_LOG.get())
                .add(ModBlocks.CHIPPED_CHERRY_LOG.get())
                .add(ModBlocks.THIN_CHERRY_LOG.get())
                .add(ModBlocks.CHIPPED_MANGROVE_LOG.get())
                .add(ModBlocks.THIN_MANGROVE_LOG.get())
                .add(ModBlocks.CHIPPED_PALM_LOG.get())
                .add(ModBlocks.THIN_PALM_LOG.get())

                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get());
        tag(BlockTags.LEAVES)
                .add(ModBlocks.PALM_LEAVES.get());
        tag(ModTags.Blocks.PALM_LOGS)
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get())
                .add(ModBlocks.CHIPPED_PALM_LOG.get())
                .add(ModBlocks.THIN_PALM_LOG.get());
        tag(BlockTags.FENCES)
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get())

                .add(ModBlocks.TIN_WALL.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.TIN_WALL.get());

        tag(BlockTags.SAND)
                .add(ModBlocks.SAND_SLAB.get())
                .add(ModBlocks.RED_SAND_SLAB.get())
                .add(ModBlocks.WHITE_SAND.get());
        tag(BlockTags.SOUL_SPEED_BLOCKS)
                .add(ModBlocks.SOUL_SOIL_SLAB.get())
                .add(ModBlocks.SOUL_SAND_SLAB.get());

        tag(BlockTags.ANVIL)
                .add(ModBlocks.STONE_ANVIL.get());

    }
}
