package net.sscaide.realismmod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
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
import java.util.function.ToIntFunction;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RealismMod.MOD_ID);



    public static final DeferredBlock<Block> IRON_BREAKABLE_STONE = BLOCKS.register("iron_breakable_stone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
    public static final DeferredBlock<Block> IRON_BREAKABLE_SOIL = BLOCKS.register("iron_breakable_soil",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> IRON_BREAKABLE_WOOD = BLOCKS.register("iron_breakable_wood",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));


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
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<StairBlock> WHITE_SANDSTONE_STAIRS = registerBlock("white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> WHITE_SANDSTONE_SLAB = registerBlock("white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<WallBlock> WHITE_SANDSTONE_WALL = registerBlock("white_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CHISELED_WHITE_SANDSTONE = registerBlock("chiseled_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SMOOTH_WHITE_SANDSTONE = registerBlock("smooth_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<StairBlock> SMOOTH_WHITE_SANDSTONE_STAIRS = registerBlock("smooth_white_sandstone_stairs",
            () -> new StairBlock(ModBlocks.WHITE_SANDSTONE.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> SMOOTH_WHITE_SANDSTONE_SLAB = registerBlock("smooth_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CUT_WHITE_SANDSTONE = registerBlock("cut_white_sandstone",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<SlabBlock> CUT_WHITE_SANDSTONE_SLAB = registerBlock("cut_white_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.8f).explosionResistance(.8f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

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
                    .strength(3f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.75f).explosionResistance(.75f)
                    .requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final DeferredBlock<SlabBlock> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.5f).explosionResistance(1f)
                    .requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<SlabBlock> NETHERRACK_SLAB = registerBlock("netherrack_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.4f).explosionResistance(.4f)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<SlabBlock> BASALT_SLAB = registerBlock("basalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.25f).explosionResistance(4.2f)
                    .requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<SlabBlock> SMOOTH_BASALT_SLAB = registerBlock("smooth_basalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(1.25f).explosionResistance(4.2f)
                    .requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<SlabBlock> END_STONE_SLAB = registerBlock("end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(9f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));


    public static final DeferredBlock<ChippedLogBlock> CHIPPED_OAK_LOG = registerBlock("chipped_oak_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_OAK_LOG = registerBlock("thin_oak_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_SPRUCE_LOG = registerBlock("chipped_spruce_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_SPRUCE_LOG = registerBlock("thin_spruce_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_BIRCH_LOG = registerBlock("chipped_birch_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_BIRCH_LOG = registerBlock("thin_birch_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_JUNGLE_LOG = registerBlock("chipped_jungle_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_JUNGLE_LOG = registerBlock("thin_jungle_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_ACACIA_LOG = registerBlock("chipped_acacia_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_ACACIA_LOG = registerBlock("thin_acacia_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_DARK_OAK_LOG = registerBlock("chipped_dark_oak_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_DARK_OAK_LOG = registerBlock("thin_dark_oak_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_MANGROVE_LOG = registerBlock("chipped_mangrove_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_MANGROVE_LOG = registerBlock("thin_mangrove_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_CHERRY_LOG = registerBlock("chipped_cherry_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_CHERRY_LOG = registerBlock("thin_cherry_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ChippedLogBlock> CHIPPED_PALM_LOG = registerBlock("chipped_palm_log",
            () -> new ChippedLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<ThinLogBlock> THIN_PALM_LOG = registerBlock("thin_palm_log",
            () -> new ThinLogBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> PALM_WOOD = registerBlock("palm_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
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


    public static final DeferredBlock<ModCobblestone> MOD_COBBLESTONE = registerBlock("mod_cobblestone",
            () -> new ModCobblestone(new ColorRGBA(7238528), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> MOD_COBBLESTONE_STAIRS = registerBlock("mod_cobblestone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(7238528), ModBlocks.MOD_COBBLESTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> MOD_COBBLESTONE_SLAB = registerBlock("mod_cobblestone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(7238528), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_STONE = registerBlock("cracked_stone",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> MOD_COBBLED_DEEPSLATE = registerBlock("mod_cobbled_deepslate",
            () -> new ModCobblestone(new ColorRGBA(1841444), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<ModCobblestoneStairs> MOD_COBBLED_DEEPSLATE_STAIRS = registerBlock("mod_cobbled_deepslate_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(1841444), ModBlocks.MOD_COBBLED_DEEPSLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<ModCobblestoneSlab> MOD_COBBLED_DEEPSLATE_SLAB = registerBlock("mod_cobbled_deepslate_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(1841444), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_DEEPSLATE = registerBlock("cracked_deepslate",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(3.25f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_SANDSTONE = registerBlock("cobbled_sandstone",
            () -> new ModCobblestone(new ColorRGBA(14406560), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_SANDSTONE_STAIRS = registerBlock("cobbled_sandstone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(14406560), ModBlocks.COBBLED_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_SANDSTONE_SLAB = registerBlock("cobbled_sandstone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(14406560), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_RED_SANDSTONE = registerBlock("cobbled_red_sandstone",
            () -> new ModCobblestone(new ColorRGBA(11098145), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_RED_SANDSTONE_STAIRS = registerBlock("cobbled_red_sandstone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(11098145), ModBlocks.COBBLED_RED_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_RED_SANDSTONE_SLAB = registerBlock("cobbled_red_sandstone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(11098145), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_WHITE_SANDSTONE = registerBlock("cobbled_white_sandstone",
            () -> new ModCobblestone(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_WHITE_SANDSTONE_STAIRS = registerBlock("cobbled_white_sandstone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(15659736), ModBlocks.COBBLED_WHITE_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_WHITE_SANDSTONE_SLAB = registerBlock("cobbled_white_sandstone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_GRANITE = registerBlock("cobbled_granite",
            () -> new ModCobblestone(new ColorRGBA(13337413), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_GRANITE_STAIRS = registerBlock("cobbled_granite_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(13337413), ModBlocks.COBBLED_GRANITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_GRANITE_SLAB = registerBlock("cobbled_granite_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(13337413), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_GRANITE = registerBlock("cracked_granite",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_DIORITE = registerBlock("cobbled_diorite",
            () -> new ModCobblestone(new ColorRGBA(15067386), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_DIORITE_STAIRS = registerBlock("cobbled_diorite_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(15067386), ModBlocks.COBBLED_DIORITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_DIORITE_SLAB = registerBlock("cobbled_diorite_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(15067386), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_DIORITE = registerBlock("cracked_diorite",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_ANDESITE = registerBlock("cobbled_andesite",
            () -> new ModCobblestone(new ColorRGBA(7898487), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_ANDESITE_STAIRS = registerBlock("cobbled_andesite_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(7898487), ModBlocks.COBBLED_ANDESITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_ANDESITE_SLAB = registerBlock("cobbled_andesite_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(7898487), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_ANDESITE = registerBlock("cracked_andesite",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_CALCITE = registerBlock("cobbled_calcite",
            () -> new ModCobblestone(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(.75f)
                    .sound(SoundType.CALCITE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_CALCITE_STAIRS = registerBlock("cobbled_calcite_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(15659736), ModBlocks.COBBLED_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1f).requiresCorrectToolForDrops().explosionResistance(.75f)
                            .sound(SoundType.CALCITE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_CALCITE_SLAB = registerBlock("cobbled_calcite_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(15659736), BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().explosionResistance(.75f)
                    .sound(SoundType.CALCITE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_CALCITE = registerBlock("cracked_calcite",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.25f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.CALCITE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_TUFF = registerBlock("cobbled_tuff",
            () -> new ModCobblestone(new ColorRGBA(6385257), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.TUFF)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_TUFF_STAIRS = registerBlock("cobbled_tuff_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(6385257), ModBlocks.COBBLED_TUFF.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.TUFF)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_TUFF_SLAB = registerBlock("cobbled_tuff_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(6385257), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.TUFF)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_TUFF = registerBlock("cracked_tuff",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.TUFF)));

    public static final DeferredBlock<ModCobblestone> COBBLED_DRIPSTONE = registerBlock("cobbled_dripstone",
            () -> new ModCobblestone(new ColorRGBA(10705701), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(1f)
                    .sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_DRIPSTONE_STAIRS = registerBlock("cobbled_dripstone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(10705701), ModBlocks.COBBLED_DRIPSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(1f)
                            .sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_DRIPSTONE_SLAB = registerBlock("cobbled_dripstone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(10705701), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(1f)
                    .sound(SoundType.DRIPSTONE_BLOCK)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_DRIPSTONE = registerBlock("cracked_dripstone",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(1f)
                    .sound(SoundType.DRIPSTONE_BLOCK)));

    public static final DeferredBlock<ModCobblestone> COBBLED_NETHERRACK = registerBlock("cobbled_netherrack",
            () -> new ModCobblestone(new ColorRGBA(5902629), BlockBehaviour.Properties.of()
                    .strength(.9f).requiresCorrectToolForDrops().explosionResistance(.4f)
                    .sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_NETHERRACK_STAIRS = registerBlock("cobbled_netherrack_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(5902629), ModBlocks.COBBLED_NETHERRACK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(.9f).requiresCorrectToolForDrops().explosionResistance(.4f)
                            .sound(SoundType.NETHERRACK)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_NETHERRACK_SLAB = registerBlock("cobbled_netherrack_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(5902629), BlockBehaviour.Properties.of()
                    .strength(.9f).requiresCorrectToolForDrops().explosionResistance(.4f)
                    .sound(SoundType.NETHERRACK)));

    public static final DeferredBlock<ModCobblestone> COBBLED_BLACKSTONE = registerBlock("cobbled_blackstone",
            () -> new ModCobblestone(new ColorRGBA(1246469), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_BLACKSTONE_STAIRS = registerBlock("cobbled_blackstone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(1246469), ModBlocks.COBBLED_BLACKSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_BLACKSTONE_SLAB = registerBlock("cobbled_blackstone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(1246469), BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().explosionResistance(6f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_BASALT = registerBlock("cobbled_basalt",
            () -> new ModCobblestone(new ColorRGBA(525593), BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(4.2f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_BASALT_STAIRS = registerBlock("cobbled_basalt_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(525593), ModBlocks.COBBLED_BASALT.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(1.75f).requiresCorrectToolForDrops().explosionResistance(4.2f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_BASALT_SLAB = registerBlock("cobbled_basalt_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(525593), BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(4.2f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_BASALT = registerBlock("cracked_basalt",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(1.75f).requiresCorrectToolForDrops().explosionResistance(4.2f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<ModCobblestone> COBBLED_END_STONE = registerBlock("cobbled_end_stone",
            () -> new ModCobblestone(new ColorRGBA(15857701), BlockBehaviour.Properties.of()
                    .strength(3.5f).requiresCorrectToolForDrops().explosionResistance(9f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneStairs> COBBLED_END_STONE_STAIRS = registerBlock("cobbled_end_stone_stairs",
            () -> new ModCobblestoneStairs(new ColorRGBA(15857701), ModBlocks.COBBLED_END_STONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(3.5f).requiresCorrectToolForDrops().explosionResistance(9f)
                            .sound(SoundType.STONE)));
    public static final DeferredBlock<ModCobblestoneSlab> COBBLED_END_STONE_SLAB = registerBlock("cobbled_end_stone_slab",
            () -> new ModCobblestoneSlab(new ColorRGBA(15857701), BlockBehaviour.Properties.of()
                    .strength(3.5f).requiresCorrectToolForDrops().explosionResistance(9f)
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<CrackedStoneBlock> CRACKED_END_STONE = registerBlock("cracked_end_stone",
            () -> new CrackedStoneBlock(BlockBehaviour.Properties.of()
                    .strength(3.25f).requiresCorrectToolForDrops().explosionResistance(9f)
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
            .strength(5f).requiresCorrectToolForDrops()
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));
    public static final DeferredBlock<WallBlock> TIN_WALL = registerBlock("tin_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(6f)
                    .requiresCorrectToolForDrops().sound(SoundType.COPPER)));

    public static final DeferredBlock<ToggleableBulb> TIN_BULB = registerBlock("tin_bulb",
            () -> new ToggleableBulb(BlockBehaviour.Properties.of()
                    .strength(3f).requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(ToggleableBulb.ACTIVE) ? 15 : 0)));


    public static final DeferredBlock<WetClayBrick> WET_CLAY_BRICK = registerBlock("wet_clay_brick",
            () -> new WetClayBrick(BlockBehaviour.Properties.of()
                    .instabreak().randomTicks().sound(SoundType.WET_GRASS)));
    public static final DeferredBlock<PlaceableSingleBrick> DRIED_BRICK = registerBlock("dried_brick",
            () -> new PlaceableSingleBrick(BlockBehaviour.Properties.of()
                    .instabreak().sound(SoundType.STONE)));


    public static final DeferredBlock<BrickFurnace> BRICK_FURNACE = registerBlock("brick_furnace",
            () -> new BrickFurnace(BlockBehaviour.Properties.of()
                    .strength(3.5f).explosionResistance(3.5f).requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(13))
                    .sound(SoundType.STONE)));
    public static final DeferredBlock<Bloomery> BLOOMERY = registerBlock("bloomery",
            () -> new Bloomery(BlockBehaviour.Properties.of()
                    .strength(3.5f).explosionResistance(3.5f).requiresCorrectToolForDrops()
                    .lightLevel(litBlockEmission(13))
                    .sound(SoundType.STONE).noOcclusion()));

    public static final DeferredBlock<ModAnvilBlock> STONE_ANVIL = registerBlock("stone_anvil",
            () -> new ModAnvilBlock(BlockBehaviour.Properties.of()
                    .strength(4.5f).explosionResistance(1000f).requiresCorrectToolForDrops().noOcclusion(), 2, 12));


    public static final DeferredBlock<Block> FLAX_CROP = BLOCKS.register("flax_crop",
            () -> new FlaxCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BEETROOTS)));


    public static final DeferredBlock<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)));



    private static ToIntFunction<BlockState> litBlockEmission(int lightValue) {
        return (p_50763_) -> (Boolean)p_50763_.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

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
