package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {

    /**
     * Create a new provider.
     *
     * @param packOutput     the output location
     * @param lookupProvider a {@linkplain CompletableFuture} supplying the registries
     */
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {

        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
            .add(ModItems.VINE.getId(), new FurnaceFuel(50), false)
            .add(ModItems.FLAX.getId(), new FurnaceFuel(50), false)

            .add(ModItems.OAK_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.SPRUCE_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.BIRCH_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.JUNGLE_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.ACACIA_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.DARK_OAK_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.MANGROVE_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.CHERRY_TIMBER.getId(), new FurnaceFuel(100), false)
            .add(ModItems.PALM_TIMBER.getId(), new FurnaceFuel(100), false)

            .add(ModItems.OAK_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.SPRUCE_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.BIRCH_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.JUNGLE_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.ACACIA_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.DARK_OAK_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.MANGROVE_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.CHERRY_BARK.getId(), new FurnaceFuel(50), false)
            .add(ModItems.PALM_BARK.getId(), new FurnaceFuel(50), false)


            .add(ModBlocks.PALM_LOG.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_WOOD.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.STRIPPED_PALM_LOG.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.STRIPPED_PALM_WOOD.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_PLANKS.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_STAIRS.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_SLAB.getId(), new FurnaceFuel(150), false)
            .add(ModBlocks.PALM_FENCE.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_FENCE_GATE.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_DOOR.getId(), new FurnaceFuel(200), false)
            .add(ModBlocks.PALM_TRAPDOOR.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_PRESSURE_PLATE.getId(), new FurnaceFuel(300), false)
            .add(ModBlocks.PALM_BUTTON.getId(), new FurnaceFuel(100), false)
        ;

        this.builder(NeoForgeDataMaps.COMPOSTABLES)
            .add(ModItems.ORANGE.getId(), new Compostable(0.65f), false)

            .add(ModItems.VINE.getId(), new Compostable(0.30f), false)
            .add(ModItems.FLAX.getId(), new Compostable(0.30f), false)
            .add(ModItems.FLAX_SEEDS.getId(), new Compostable(0.30f), false)

            .add(ModItems.OAK_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.SPRUCE_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.BIRCH_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.JUNGLE_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.ACACIA_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.DARK_OAK_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.MANGROVE_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.CHERRY_BARK.getId(), new Compostable(0.25f), false)
            .add(ModItems.PALM_BARK.getId(), new Compostable(0.25f), false)
        ;

    }

}
