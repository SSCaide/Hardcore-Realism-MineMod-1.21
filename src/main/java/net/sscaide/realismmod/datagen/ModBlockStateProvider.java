package net.sscaide.realismmod.datagen;

import com.google.gson.JsonElement;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.TexturedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.BlueberryBushBlock;
import net.sscaide.realismmod.block.custom.FlaxCropBlock;
import net.sscaide.realismmod.block.custom.ModColoredFallingSlabBlock;
import net.sscaide.realismmod.block.custom.ToggleableBulb;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, RealismMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        fallingSlabBlock(ModBlocks.DIRT_SLAB.get(), blockTexture(Blocks.DIRT), blockTexture(Blocks.DIRT));
            blockItem(ModBlocks.DIRT_SLAB);
        fallingSlabBlock(ModBlocks.MUD_SLAB.get(), blockTexture(Blocks.MUD), blockTexture(Blocks.MUD));
            blockItem(ModBlocks.MUD_SLAB);
        fallingSlabBlock(ModBlocks.CLAY_SLAB.get(), blockTexture(Blocks.CLAY), blockTexture(Blocks.CLAY));
            blockItem(ModBlocks.CLAY_SLAB);
        fallingSlabBlock(ModBlocks.GRAVEL_SLAB.get(), blockTexture(Blocks.GRAVEL), blockTexture(Blocks.GRAVEL));
            blockItem(ModBlocks.GRAVEL_SLAB);
        fallingSlabBlock(ModBlocks.SAND_SLAB.get(), blockTexture(Blocks.SAND), blockTexture(Blocks.SAND));
            blockItem(ModBlocks.SAND_SLAB);
        fallingSlabBlock(ModBlocks.RED_SAND_SLAB.get(), blockTexture(Blocks.RED_SAND), blockTexture(Blocks.RED_SAND));
            blockItem(ModBlocks.RED_SAND_SLAB);
        blockWithItem(ModBlocks.WHITE_SAND);
        fallingSlabBlock(ModBlocks.WHITE_SAND_SLAB.get(),  blockTexture(ModBlocks.WHITE_SAND.get()), blockTexture(ModBlocks.WHITE_SAND.get()));
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

        fallingSlabBlock(ModBlocks.MOSS_SLAB.get(), blockTexture(Blocks.MOSS_BLOCK), blockTexture(Blocks.MOSS_BLOCK));
            blockItem(ModBlocks.MOSS_SLAB);
        slabBlock(ModBlocks.SOUL_SOIL_SLAB.get(), blockTexture(Blocks.SOUL_SOIL), blockTexture(Blocks.SOUL_SOIL));
            blockItem(ModBlocks.SOUL_SOIL_SLAB);
        slabBlock(ModBlocks.SOUL_SAND_SLAB.get(), blockTexture(Blocks.SOUL_SAND), blockTexture(Blocks.SOUL_SAND));
            blockItem(ModBlocks.SOUL_SAND_SLAB);


        slabBlock(ModBlocks.DEEPSLATE_SLAB.get(), blockTexture(Blocks.DEEPSLATE), blockTexture(Blocks.DEEPSLATE));
            blockItem(ModBlocks.DEEPSLATE_SLAB);
        slabBlock(ModBlocks.CALCITE_SLAB.get(), blockTexture(Blocks.CALCITE), blockTexture(Blocks.CALCITE));
            blockItem(ModBlocks.CALCITE_SLAB);
        slabBlock(ModBlocks.DRIPSTONE_SLAB.get(), blockTexture(Blocks.DRIPSTONE_BLOCK), blockTexture(Blocks.DRIPSTONE_BLOCK));
            blockItem(ModBlocks.DRIPSTONE_SLAB);
        slabBlock(ModBlocks.NETHERRACK_SLAB.get(), blockTexture(Blocks.NETHERRACK), blockTexture(Blocks.NETHERRACK));
            blockItem(ModBlocks.NETHERRACK_SLAB);
        slabBlock(ModBlocks.BASALT_SLAB.get(), blockTexture(Blocks.SMOOTH_BASALT), blockTexture(Blocks.SMOOTH_BASALT));
            blockItem(ModBlocks.BASALT_SLAB);
        slabBlock(ModBlocks.SMOOTH_BASALT_SLAB.get(), blockTexture(Blocks.SMOOTH_BASALT), blockTexture(Blocks.SMOOTH_BASALT));
            blockItem(ModBlocks.SMOOTH_BASALT_SLAB);
        slabBlock(ModBlocks.END_STONE_SLAB.get(), blockTexture(Blocks.END_STONE), blockTexture(Blocks.END_STONE));
            blockItem(ModBlocks.END_STONE_SLAB);


        logBlockWithItem(ModBlocks.PALM_LOG);
        logBlockWithItem(ModBlocks.STRIPPED_PALM_LOG);
        //blockWithItem(ModBlocks.PALM_LOG);
        blockWithItem(ModBlocks.PALM_WOOD);
        //blockWithItem(ModBlocks.STRIPPED_PALM_LOG);
        blockWithItem(ModBlocks.STRIPPED_PALM_WOOD);

        leavesBlock(ModBlocks.PALM_LEAVES);
        saplingBlock(ModBlocks.PALM_SAPLING);

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

        blockWithItem(ModBlocks.CRUDE_OAK_BLOCK);
        blockWithItem(ModBlocks.CRUDE_SPRUCE_BLOCK);
        blockWithItem(ModBlocks.CRUDE_BIRCH_BLOCK);
        blockWithItem(ModBlocks.CRUDE_JUNGLE_BLOCK);
        blockWithItem(ModBlocks.CRUDE_ACACIA_BLOCK);
        blockWithItem(ModBlocks.CRUDE_DARK_OAK_BLOCK);
        blockWithItem(ModBlocks.CRUDE_MANGROVE_BLOCK);
        blockWithItem(ModBlocks.CRUDE_CHERRY_BLOCK);
        blockWithItem(ModBlocks.CRUDE_PALM_BLOCK);


        blockWithItem(ModBlocks.COBBLED_SANDSTONE);
        blockWithItem(ModBlocks.COBBLED_RED_SANDSTONE);
        blockWithItem(ModBlocks.COBBLED_WHITE_SANDSTONE);
        blockWithItem(ModBlocks.COBBLED_GRANITE);
        blockWithItem(ModBlocks.COBBLED_DIORITE);
        blockWithItem(ModBlocks.COBBLED_ANDESITE);
        blockWithItem(ModBlocks.COBBLED_CALCITE);
        blockWithItem(ModBlocks.COBBLED_TUFF);
        blockWithItem(ModBlocks.COBBLED_DRIPSTONE);
        blockWithItem(ModBlocks.COBBLED_BLACKSTONE);
        blockWithItem(ModBlocks.COBBLED_BASALT);
        blockWithItem(ModBlocks.COBBLED_END_STONE);


        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        wallBlock(ModBlocks.TIN_WALL.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));

        customToggleableBulb(ModBlocks.TIN_BULB, "tin_bulb");

        makeCrop(((CropBlock) ModBlocks.FLAX_CROP.get()), "flax_crop_stage", "flax_crop_stage");

        makeBush(((SweetBerryBushBlock) ModBlocks.BLUEBERRY_BUSH.get()), "blueberry_bush_stage","blueberry_bush_stage");



    }

    private void fallingSlabBlock(ModColoredFallingSlabBlock block, ResourceLocation texture, ResourceLocation thedoubleslab) {
        ModelFile bottom = models().slab(BuiltInRegistries.BLOCK.getKey(block).getPath(), texture, texture, texture);
        ModelFile top = models().slabTop(BuiltInRegistries.BLOCK.getKey(block).getPath() + "_top", texture, texture, texture);
        ModelFile doubleslab = models().getExistingFile(thedoubleslab);

        getVariantBuilder(block).partialState().with(ModColoredFallingSlabBlock.TYPE, SlabType.BOTTOM).addModels(new ConfiguredModel[]{new ConfiguredModel(bottom)}).partialState().with(ModColoredFallingSlabBlock.TYPE, SlabType.TOP).addModels(new ConfiguredModel[]{new ConfiguredModel(top)}).partialState().with(ModColoredFallingSlabBlock.TYPE, SlabType.DOUBLE).addModels(new ConfiguredModel[]{new ConfiguredModel(doubleslab)});
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(BlueberryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "block/" + textureName + state.getValue(BlueberryBushBlock.AGE))).renderType("cutout"));

        return models;
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
