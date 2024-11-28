package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RealismMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_ORE.get())
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
                .add(ModBlocks.PALM_BUTTON.get());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.DIRT_SLAB.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.RAW_TIN_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.TIN_WALL.get())

                .add(ModBlocks.TIN_BULB.get());


        tag(BlockTags.FENCES)
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get())

                .add(ModBlocks.TIN_WALL.get());
        tag(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE.get())
                .add(ModBlocks.PALM_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.TIN_WALL.get());
    }
}
