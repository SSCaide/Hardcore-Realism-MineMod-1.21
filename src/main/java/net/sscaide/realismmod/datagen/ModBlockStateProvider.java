package net.sscaide.realismmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.ToggleableLamp;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RealismMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        slabBlock(ModBlocks.DIRT_SLAB.get(), blockTexture(Blocks.DIRT), blockTexture(Blocks.DIRT));
            blockItem(ModBlocks.DIRT_SLAB);
        slabBlock(ModBlocks.MUD_SLAB.get(), blockTexture(Blocks.MUD), blockTexture(Blocks.MUD));
            blockItem(ModBlocks.MUD_SLAB);

        logBlockWithItem(ModBlocks.PALM_LOG);
        blockWithItem(ModBlocks.PALM_WOOD);
        logBlockWithItem(ModBlocks.STRIPPED_PALM_LOG);
        blockWithItem(ModBlocks.STRIPPED_PALM_WOOD);
        blockWithItem(ModBlocks.PALM_PLANKS);
        stairsBlock(ModBlocks.PALM_STAIRS.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
            blockItem(ModBlocks.PALM_STAIRS);
        slabBlock(ModBlocks.PALM_SLAB.get(), blockTexture(ModBlocks.PALM_PLANKS.get()), blockTexture(ModBlocks.PALM_PLANKS.get()));
            blockItem(ModBlocks.PALM_SLAB);
        fenceBlock(ModBlocks.PALM_FENCE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));

        fenceGateBlock(ModBlocks.PALM_FENCE_GATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
            blockItem(ModBlocks.PALM_FENCE_GATE);
        doorBlockWithRenderType(ModBlocks.PALM_DOOR.get(), modLoc("block/palm_door_bottom"), modLoc("block/palm_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.PALM_TRAPDOOR.get(), modLoc("block/palm_trapdoor"), true, "cutout");
            blockItem(ModBlocks.PALM_TRAPDOOR, "_bottom");
        pressurePlateBlock(ModBlocks.PALM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));
            blockItem(ModBlocks.PALM_PRESSURE_PLATE);
        buttonBlock(ModBlocks.PALM_BUTTON.get(), blockTexture(ModBlocks.PALM_PLANKS.get()));

        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        wallBlock(ModBlocks.TIN_WALL.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));

        customToggleableLamp(ModBlocks.TIN_BULB, "tin_bulb");



    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void logBlockWithItem(DeferredBlock<RotatedPillarBlock> block) {
        logBlock(block.get());
        simpleBlockItem(block.get(), models().getBuilder(block.unwrapKey().orElseThrow().location().getPath()));
    }
    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("sscaiderealism:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("sscaiderealism:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void customToggleableLamp(DeferredBlock<ToggleableLamp> lamp, String name) {
        getVariantBuilder(lamp.get()).forAllStates(state -> {
            if(state.getValue(ToggleableLamp.ACTIVE)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name + "_on",
                        ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "block/" + name + "_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name + "_off",
                        ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "block/" + name + "_off")))};
            }
        });
        simpleBlockItem(lamp.get(), models().cubeAll(name + "_on",
                ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "block/" + name + "_on")));
    }
}
