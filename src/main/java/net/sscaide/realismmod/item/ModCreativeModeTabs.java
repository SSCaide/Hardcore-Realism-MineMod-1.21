package net.sscaide.realismmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RealismMod.MOD_ID);

    public static final Supplier<CreativeModeTab> SSCR_ITEMS_TAB = CREATIVE_MODE_TAB.register("sscr_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CLUMP_OF_DIRT.get()))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CLUMP_OF_DIRT);
                        output.accept(ModItems.CLUMP_OF_MUD);
                        output.accept(ModItems.PILE_OF_GRAVEL);
                        output.accept(ModItems.PILE_OF_SAND);
                        output.accept(ModItems.PILE_OF_RED_SAND);
                        output.accept(ModItems.PILE_OF_WHITE_SAND);

                        output.accept(ModItems.ROCK);
                        output.accept(ModItems.DEEPSLATE_ROCK);
                        output.accept(ModItems.SANDSTONE_ROCK);
                        output.accept(ModItems.RED_SANDSTONE_ROCK);
                        output.accept(ModItems.GRANITE_ROCK);
                        output.accept(ModItems.DIORITE_ROCK);
                        output.accept(ModItems.ANDESITE_ROCK);
                        output.accept(ModItems.CALCITE_ROCK);
                        output.accept(ModItems.TUFF_ROCK);

                        output.accept(ModItems.VINE);
                        output.accept(ModItems.FLAX);

                        output.accept(ModItems.OAK_TIMBER);
                        output.accept(ModItems.OAK_BARK);
                        output.accept(ModItems.SPRUCE_TIMBER);
                        output.accept(ModItems.SPRUCE_BARK);
                        output.accept(ModItems.BIRCH_TIMBER);
                        output.accept(ModItems.BIRCH_BARK);
                        output.accept(ModItems.JUNGLE_TIMBER);
                        output.accept(ModItems.JUNGLE_BARK);
                        output.accept(ModItems.ACACIA_TIMBER);
                        output.accept(ModItems.ACACIA_BARK);
                        output.accept(ModItems.DARK_OAK_TIMBER);
                        output.accept(ModItems.DARK_OAK_BARK);
                        output.accept(ModItems.MANGROVE_TIMBER);
                        output.accept(ModItems.MANGROVE_BARK);
                        output.accept(ModItems.CHERRY_TIMBER);
                        output.accept(ModItems.CHERRY_BARK);
                        output.accept(ModItems.PALM_TIMBER);
                        output.accept(ModItems.PALM_BARK);

                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.COPPER_DUST);
                        output.accept(ModItems.COPPER_NUGGET);

                        output.accept(ModItems.OBSIDIAN_SHARD);

                        output.accept(ModItems.WIDE_SHAPED_FLINT);
                        output.accept(ModItems.FANNED_SHAPED_FLINT);
                        output.accept(ModItems.LONG_SHAPED_FLINT);
                        output.accept(ModItems.THIN_SHAPED_FLINT);

                        output.accept(ModItems.WIDE_SHAPED_COPPER);
                        output.accept(ModItems.FANNED_SHAPED_COPPER);
                        output.accept(ModItems.LONG_SHAPED_COPPER);
                        output.accept(ModItems.JAGGED_SHAPED_COPPER);
                        output.accept(ModItems.THIN_SHAPED_COPPER);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sscr_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_items_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.PALM_LOG);
                        output.accept(ModBlocks.PALM_WOOD);
                        output.accept(ModBlocks.STRIPPED_PALM_LOG);
                        output.accept(ModBlocks.STRIPPED_PALM_WOOD);
                        output.accept(ModBlocks.PALM_PLANKS);
                        output.accept(ModBlocks.PALM_STAIRS);
                        output.accept(ModBlocks.PALM_SLAB);
                        output.accept(ModBlocks.PALM_FENCE);

                        output.accept(ModBlocks.PALM_FENCE_GATE);
                        output.accept(ModBlocks.PALM_DOOR);
                        output.accept(ModBlocks.PALM_TRAPDOOR);
                        output.accept(ModBlocks.PALM_PRESSURE_PLATE);
                        output.accept(ModBlocks.PALM_BUTTON);


                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.RAW_TIN_BLOCK);
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.TIN_WALL);

                        output.accept(ModBlocks.TIN_BULB);


                        output.accept(ModBlocks.DIRT_SLAB);
                        output.accept(ModBlocks.MUD_SLAB);
                        output.accept(ModBlocks.CLAY_SLAB);
                        output.accept(ModBlocks.GRAVEL_SLAB);
                        output.accept(ModBlocks.SAND_SLAB);
                        output.accept(ModBlocks.RED_SAND_SLAB);
                        output.accept(ModBlocks.WHITE_SAND);
                        output.accept(ModBlocks.WHITE_SAND_SLAB);
                        output.accept(ModBlocks.WHITE_SANDSTONE);
                        output.accept(ModBlocks.WHITE_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.WHITE_SANDSTONE_SLAB);
                        output.accept(ModBlocks.WHITE_SANDSTONE_WALL);
                        output.accept(ModBlocks.CHISELED_WHITE_SANDSTONE);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
                        output.accept(ModBlocks.CUT_WHITE_SANDSTONE);
                        output.accept(ModBlocks.CUT_WHITE_SANDSTONE_SLAB);


                        output.accept(ModBlocks.DEEPSLATE_SLAB);
                        output.accept(ModBlocks.CALCITE_SLAB);

                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_FOOD_TAB = CREATIVE_MODE_TAB.register("sscr_food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_blocks_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORANGE);

                        output.accept(ModItems.FLAX_SEEDS);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_TOOLS_TAB = CREATIVE_MODE_TAB.register("sscr_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_PICKAXE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_food_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SHARPENED_STICK);
                        output.accept(ModItems.SHARPENED_ROCK);

                        output.accept(ModItems.RANDOM_CRUDE_STONE_TOOL);
                        output.accept(ModItems.CRUDE_STONE_KNIFE);
                        output.accept(ModItems.CRUDE_STONE_PICK);
                        output.accept(ModItems.CRUDE_STONE_HATCHET);
                        output.accept(ModItems.CRUDE_STONE_SPADE);
                        output.accept(ModItems.CRUDE_STONE_TILL);

                        output.accept(ModItems.RANDOM_FLINT_TOOL);
                        output.accept(ModItems.FLINT_KNIFE);
                        output.accept(ModItems.FLINT_PICK);
                        output.accept(ModItems.FLINT_HATCHET);
                        output.accept(ModItems.FLINT_SPADE);
                        output.accept(ModItems.FLINT_TILL);

                        output.accept(ModItems.RANDOM_CRUDE_COPPER_TOOL);
                        output.accept(ModItems.CRUDE_COPPER_KNIFE);
                        output.accept(ModItems.CRUDE_COPPER_PICK);
                        output.accept(ModItems.CRUDE_COPPER_HATCHET);
                        output.accept(ModItems.CRUDE_COPPER_SPADE);
                        output.accept(ModItems.CRUDE_COPPER_TILL);

                        output.accept(ModItems.COPPER_SWORD);
                        output.accept(ModItems.COPPER_PICKAXE);
                        output.accept(ModItems.COPPER_AXE);
                        output.accept(ModItems.COPPER_SHOVEL);
                        output.accept(ModItems.COPPER_HOE);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_ARMOR_TAB = CREATIVE_MODE_TAB.register("sscr_armor_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_HELMET.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_tools_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_armor"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.COPPER_HELMET);
                        output.accept(ModItems.COPPER_CHESTPLATE);
                        output.accept(ModItems.COPPER_LEGGINGS);
                        output.accept(ModItems.COPPER_BOOTS);
                        output.accept(ModItems.COPPER_HORSE_ARMOR);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_MISC_TAB = CREATIVE_MODE_TAB.register("sscr_misc_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WASTELAND_FUNK_MUSIC_DISC.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_armor_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_misc"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.WASTELAND_FUNK_MUSIC_DISC);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
