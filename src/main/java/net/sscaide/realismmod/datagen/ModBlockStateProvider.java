package net.sscaide.realismmod.datagen;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.FlaxCropBlock;
import net.sscaide.realismmod.block.custom.ToggleableBulb;

import java.util.function.Function;

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
        slabBlock(ModBlocks.CLAY_SLAB.get(), blockTexture(Blocks.CLAY), blockTexture(Blocks.CLAY));
            blockItem(ModBlocks.CLAY_SLAB);
        slabBlock(ModBlocks.GRAVEL_SLAB.get(), blockTexture(Blocks.GRAVEL), blockTexture(Blocks.GRAVEL));
            blockItem(ModBlocks.GRAVEL_SLAB);
        slabBlock(ModBlocks.SAND_SLAB.get(), blockTexture(Blocks.SAND), blockTexture(Blocks.SAND));
            blockItem(ModBlocks.SAND_SLAB);
        slabBlock(ModBlocks.RED_SAND_SLAB.get(), blockTexture(Blocks.RED_SAND), blockTexture(Blocks.RED_SAND));
            blockItem(ModBlocks.RED_SAND_SLAB);
        blockWithItem(ModBlocks.WHITE_SAND);
        slabBlock(ModBlocks.WHITE_SAND_SLAB.get(), blockTexture(ModBlocks.WHITE_SAND.get()), blockTexture(ModBlocks.WHITE_SAND.get()));
            blockItem(ModBlocks.WHITE_SAND_SLAB);
        topBottomBlockWithItem(ModBlocks.WHITE_SANDSTONE, "white_sandstone");
        stairsBlock(ModBlocks.WHITE_SANDSTONE_STAIRS.get(), blockTexture(ModBlocks.WHITE_SANDSTONE.get()));
            blockItem(ModBlocks.WHITE_SANDSTONE_STAIRS);
        slabBlock(ModBlocks.WHITE_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.WHITE_SANDSTONE.get()), blockTexture(ModBlocks.WHITE_SANDSTONE.get()));
            blockItem(ModBlocks.WHITE_SANDSTONE_SLAB);
        wallBlock(ModBlocks.WHITE_SANDSTONE_WALL.get(), blockTexture(ModBlocks.WHITE_SANDSTONE.get()));
        topBottomBlockWithItem(ModBlocks.CHISELED_WHITE_SANDSTONE, "chiseled_white_sandstone",
                modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_bottom"));
        blockWithItem(ModBlocks.SMOOTH_WHITE_SANDSTONE);
        stairsBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get(), blockTexture(ModBlocks.SMOOTH_WHITE_SANDSTONE.get()));
            blockItem(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
        slabBlock(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.SMOOTH_WHITE_SANDSTONE.get()), blockTexture(ModBlocks.SMOOTH_WHITE_SANDSTONE.get()));
            blockItem(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
        topBottomBlockWithItem(ModBlocks.CUT_WHITE_SANDSTONE, "cut_white_sandstone",
                modLoc("block/white_sandstone_top"), modLoc("block/white_sandstone_top"));
        slabBlock(ModBlocks.CUT_WHITE_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.CUT_WHITE_SANDSTONE.get()), blockTexture(ModBlocks.CUT_WHITE_SANDSTONE.get()));
            blockItem(ModBlocks.CUT_WHITE_SANDSTONE_SLAB);


        slabBlock(ModBlocks.DEEPSLATE_SLAB.get(), blockTexture(Blocks.DEEPSLATE), blockTexture(Blocks.DEEPSLATE));
            blockItem(ModBlocks.DEEPSLATE_SLAB);
        slabBlock(ModBlocks.CALCITE_SLAB.get(), blockTexture(Blocks.CALCITE), blockTexture(Blocks.CALCITE));
            blockItem(ModBlocks.CALCITE_SLAB);


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

        customToggleableBulb(ModBlocks.TIN_BULB, "tin_bulb");

        makeCrop(((CropBlock) ModBlocks.FLAX_CROP.get()), "flax_crop_stage", "flax_crop_stage");

    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((FlaxCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "block/" + textureName + state.getValue(((FlaxCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
    private void blockWithItem(DeferredBlock<?> block, String name, ResourceLocation texture) {
        ModelFile model = models().cubeAll(name, texture);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block.get());
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        getVariantBuilder(block.get()).addModels(partialState, partialState.modelForState().modelFile(model).build());
        simpleBlockItem(block.get(), model);
    }
    private void logBlockWithItem(DeferredBlock<RotatedPillarBlock> block) {
        logBlock(block.get());
        simpleBlockItem(block.get(), models().getBuilder(block.unwrapKey().orElseThrow().location().getPath()));
    }
    private void topBottomBlockWithItem(DeferredBlock<Block> block, String name) {
        ResourceLocation texture = blockTexture(block.get());
        ResourceLocation topTexture = texture.withSuffix("_top");
        ResourceLocation bottomTexture = texture.withSuffix("_bottom");
        ModelFile model = models().cubeBottomTop(name, texture, bottomTexture, topTexture);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block.get());
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        getVariantBuilder(block.get()).addModels(partialState, partialState.modelForState().modelFile(model).build());
        simpleBlockItem(block.get(), model);
    }
    private void topBottomBlockWithItem(DeferredBlock<Block> block, String name, ResourceLocation texture, ResourceLocation topTexture, ResourceLocation bottomTexture) {
        ModelFile model = models().cubeBottomTop(name, texture, bottomTexture, topTexture);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block.get());
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        getVariantBuilder(block.get()).addModels(partialState, partialState.modelForState().modelFile(model).build());
        simpleBlockItem(block.get(), model);
    }
    private void topBottomBlockWithItem(DeferredBlock<Block> block, String name, ResourceLocation topTexture, ResourceLocation bottomTexture) {
        ResourceLocation texture = blockTexture(block.get());
        ModelFile model = models().cubeBottomTop(name, texture, bottomTexture, topTexture);
        VariantBlockStateBuilder variantBuilder = getVariantBuilder(block.get());
        VariantBlockStateBuilder.PartialBlockstate partialState = variantBuilder.partialState();
        getVariantBuilder(block.get()).addModels(partialState, partialState.modelForState().modelFile(model).build());
        simpleBlockItem(block.get(), model);
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("sscaiderealism:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("sscaiderealism:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void customToggleableBulb(DeferredBlock<ToggleableBulb> lamp, String name) {
        getVariantBuilder(lamp.get()).forAllStates(state -> {
            if(state.getValue(ToggleableBulb.ACTIVE)) {
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
