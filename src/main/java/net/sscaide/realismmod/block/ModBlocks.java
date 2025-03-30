package net.sscaide.realismmod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.custom.*;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.worldgen.tree.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RealismMod.MOD_ID);

    public static final DeferredBlock<ModColoredFallingSlabBlock> DIRT_SLAB = registerBlock("dirt_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(13337634), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> MUD_SLAB = registerBlock("mud_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(2697019), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.MUD)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> CLAY_SLAB = registerBlock("clay_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(9812718), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> GRAVEL_SLAB = registerBlock("gravel_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(-8356741), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> SAND_SLAB = registerBlock("sand_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(14406560), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> RED_SAND_SLAB = registerBlock("red_sand_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(11098145), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));

    public static final DeferredBlock<ColoredFallingBlock> WHITE_SAND = registerBlock("white_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));
    public static final DeferredBlock<ModColoredFallingSlabBlock> WHITE_SAND_SLAB = registerBlock("white_sand_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));
    public static final DeferredBlock<Block> WHITE_SANDSTONE = registerBlock("white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<StairBlock> WHITE_SANDSTONE_STAIRS = registerBlock("white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> WHITE_SANDSTONE_SLAB = registerBlock("white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<WallBlock> WHITE_SANDSTONE_WALL = registerBlock("white_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CHISELED_WHITE_SANDSTONE = registerBlock("chiseled_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_SANDSTONE = registerBlock("smooth_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f).sound(SoundType.STONE)));
    public static final DeferredBlock<StairBlock> SMOOTH_WHITE_SANDSTONE_STAIRS = registerBlock("smooth_white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f).sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> SMOOTH_WHITE_SANDSTONE_SLAB = registerBlock("smooth_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CUT_WHITE_SANDSTONE = registerBlock("cut_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> CUT_WHITE_SANDSTONE_SLAB = registerBlock("cut_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f).sound(SoundType.STONE)));

    public static final DeferredBlock<ModColoredFallingSlabBlock> MOSS_SLAB = registerBlock("moss_slab",
            () -> new ModColoredFallingSlabBlock(new ColorRGBA(7709470), BlockBehaviour.Properties.of()
                    .strength(.1f).explosionResistance(.1f).sound(SoundType.MOSS)));
    public static final DeferredBlock<SlabBlock> SOUL_SOIL_SLAB = registerBlock("soul_soil_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SOUL_SOIL)));
    public static final DeferredBlock<SlabBlock> SOUL_SAND_SLAB = registerBlock("soul_sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SOUL_SAND)));

    public static final DeferredBlock<SlabBlock> DEEPSLATE_SLAB = registerBlock("deepslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(6f).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.75f).explosionResistance(.75f).sound(SoundType.CALCITE)));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f).explosionResistance(1f).sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<SlabBlock> NETHERRACK_SLAB = registerBlock("netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.4f).explosionResistance(.4f).sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<SlabBlock> BASALT_SLAB = registerBlock("basalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.25f).explosionResistance(4.2f).sound(SoundType.BASALT)));
    public static final DeferredBlock<SlabBlock> SMOOTH_BASALT_SLAB = registerBlock("smooth_basalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.25f).explosionResistance(4.2f).sound(SoundType.BASALT)));
    public static final DeferredBlock<SlabBlock> END_STONE_SLAB = registerBlock("end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(9f).sound(SoundType.STONE)));


    public static final DeferredBlock<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new ModLeavesBlock(MapColor.GRASS, SoundType.AZALEA_LEAVES));
    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.PALM, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING),
                    () -> Blocks.SAND, () -> Blocks.RED_SAND, () -> ModBlocks.WHITE_SAND.get()));


    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(ModBlocks.PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<TransparentBlock> CRUDE_OAK_BLOCK = registerBlock("crude_oak_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.of()
                    .strength(.7f).ignitedByLava().noOcclusion().sound(SoundType.WOOD)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_SPRUCE_BLOCK = registerBlock("crude_spruce_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_BIRCH_BLOCK = registerBlock("crude_birch_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_JUNGLE_BLOCK = registerBlock("crude_jungle_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_ACACIA_BLOCK = registerBlock("crude_acacia_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_DARK_OAK_BLOCK = registerBlock("crude_dark_oak_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_MANGROVE_BLOCK = registerBlock("crude_mangrove_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_CHERRY_BLOCK = registerBlock("crude_cherry_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });
    public static final DeferredBlock<TransparentBlock> CRUDE_PALM_BLOCK = registerBlock("crude_palm_block",
            () -> new TransparentBlock(BlockBehaviour.Properties.ofFullCopy(ModBlocks.CRUDE_OAK_BLOCK.get())) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 14;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 8;
                }
            });


    public static final DeferredBlock<ColoredFallingBlock> COBBLED_SANDSTONE = registerBlock("cobbled_sandstone",
            () -> new ColoredFallingBlock(new ColorRGBA(14406560), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_RED_SANDSTONE = registerBlock("cobbled_red_sandstone",
            () -> new ColoredFallingBlock(new ColorRGBA(11098145), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_WHITE_SANDSTONE = registerBlock("cobbled_white_sandstone",
            () -> new ColoredFallingBlock(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_GRANITE = registerBlock("cobbled_granite",
            () -> new ColoredFallingBlock(new ColorRGBA(13337413), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_DIORITE = registerBlock("cobbled_diorite",
            () -> new ColoredFallingBlock(new ColorRGBA(15067386), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_ANDESITE = registerBlock("cobbled_andesite",
            () -> new ColoredFallingBlock(new ColorRGBA(7898487), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_CALCITE = registerBlock("cobbled_calcite",
            () -> new ColoredFallingBlock(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(.75f)
                    .sound(SoundType.CALCITE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_TUFF = registerBlock("cobbled_tuff",
            () -> new ColoredFallingBlock(new ColorRGBA(6385257), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.TUFF)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_DRIPSTONE = registerBlock("cobbled_dripstone",
            () -> new ColoredFallingBlock(new ColorRGBA(10705701), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(1f)
                    .sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_BLACKSTONE = registerBlock("cobbled_blackstone",
            () -> new ColoredFallingBlock(new ColorRGBA(1246469), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_BASALT = registerBlock("cobbled_basalt",
            () -> new ColoredFallingBlock(new ColorRGBA(525593), BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(4.2f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ColoredFallingBlock> COBBLED_END_STONE = registerBlock("cobbled_end_stone",
            () -> new ColoredFallingBlock(new ColorRGBA(15857701), BlockBehaviour.Properties.of()
                    .strength(3.5f).requiresCorrectToolForDrops().explosionResistance(9f)
                    .sound(SoundType.STONE)));


    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(4.5f).requiresCorrectToolForDrops()
            .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(5f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<WallBlock> TIN_WALL = registerBlock("tin_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(6f).sound(SoundType.COPPER)));

    public static final DeferredBlock<ToggleableBulb> TIN_BULB = registerBlock("tin_bulb",
            () -> new ToggleableBulb(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(ToggleableBulb.ACTIVE) ? 15 : 0)));


    public static final DeferredBlock<Block> FLAX_CROP = BLOCKS.register("flax_crop",
            () -> new FlaxCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));


    public static final DeferredBlock<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
