package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
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
                .add(ModBlocks.DEEPSLATE_SLAB.get())
                .add(ModBlocks.CALCITE_SLAB.get())
                .add(ModBlocks.DRIPSTONE_SLAB.get())
                .add(ModBlocks.NETHERRACK_SLAB.get())
                .add(ModBlocks.BASALT_SLAB.get())
                .add(ModBlocks.SMOOTH_BASALT_SLAB.get())
                .add(ModBlocks.END_STONE_SLAB.get())

                .add(ModBlocks.COBBLED_SANDSTONE.get())

                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_WALL.get())

                .add(ModBlocks.TIN_BULB.get());
        tag(BlockTags.MINEABLE_WITH_AXE)
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


        tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get());
        tag(ModTags.Blocks.PALM_LOGS)
                .add(ModBlocks.PALM_LOG.get())
                .add(ModBlocks.PALM_WOOD.get())
                .add(ModBlocks.STRIPPED_PALM_LOG.get())
                .add(ModBlocks.STRIPPED_PALM_WOOD.get());
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
    }
}
