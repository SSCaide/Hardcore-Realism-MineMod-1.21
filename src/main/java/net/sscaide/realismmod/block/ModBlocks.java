package net.sscaide.realismmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.custom.FlaxCropBlock;
import net.sscaide.realismmod.block.custom.ToggleableBulb;
import net.sscaide.realismmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RealismMod.MOD_ID);

    public static final DeferredBlock<SlabBlock> DIRT_SLAB = registerBlock("dirt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<SlabBlock> MUD_SLAB = registerBlock("mud_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.MUD)));
    public static final DeferredBlock<SlabBlock> CLAY_SLAB = registerBlock("clay_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<SlabBlock> GRAVEL_SLAB = registerBlock("gravel_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<SlabBlock> SAND_SLAB = registerBlock("sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));
    public static final DeferredBlock<SlabBlock> RED_SAND_SLAB = registerBlock("red_sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));

    public static final DeferredBlock<Block> WHITE_SAND = registerBlock("white_sand",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.5f).explosionResistance(.5f).sound(SoundType.SAND)));
    public static final DeferredBlock<SlabBlock> WHITE_SAND_SLAB = registerBlock("white_sand_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
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


    public static final DeferredBlock<SlabBlock> DEEPSLATE_SLAB = registerBlock("deepslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(3f).explosionResistance(6f).sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<SlabBlock> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(.75f).explosionResistance(.75f).sound(SoundType.CALCITE)));


    public static final DeferredBlock<RotatedPillarBlock> PALM_LOG = registerBlock("palm_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
            .strength(2f).ignitedByLava().explosionResistance(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(2f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));

    public static final DeferredBlock<StairBlock> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(ModBlocks.PALM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<SlabBlock> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<FenceBlock> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));

    public static final DeferredBlock<FenceGateBlock> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<DoorBlock> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD).noOcclusion()));
    public static final DeferredBlock<TrapDoorBlock> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD).noOcclusion()));

    public static final DeferredBlock<PressurePlateBlock> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));
    public static final DeferredBlock<ButtonBlock> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.of()
                    .strength(2f).ignitedByLava().explosionResistance(3f).sound(SoundType.WOOD)));


    public static final DeferredBlock<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new Block(BlockBehaviour.Properties.of()
            .strength(3f).requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));
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
