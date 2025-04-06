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
                        output.accept(ModItems.OAK_TIMBER);
                        output.accept(ModItems.OAK_PLANK);
                        output.accept(ModItems.OAK_BARK);
                        output.accept(ModItems.SPRUCE_TIMBER);
                        output.accept(ModItems.SPRUCE_PLANK);
                        output.accept(ModItems.SPRUCE_BARK);
                        output.accept(ModItems.BIRCH_TIMBER);
                        output.accept(ModItems.BIRCH_PLANK);
                        output.accept(ModItems.BIRCH_BARK);
                        output.accept(ModItems.JUNGLE_TIMBER);
                        output.accept(ModItems.JUNGLE_PLANK);
                        output.accept(ModItems.JUNGLE_BARK);
                        output.accept(ModItems.ACACIA_TIMBER);
                        output.accept(ModItems.ACACIA_PLANK);
                        output.accept(ModItems.ACACIA_BARK);
                        output.accept(ModItems.DARK_OAK_TIMBER);
                        output.accept(ModItems.DARK_OAK_PLANK);
                        output.accept(ModItems.DARK_OAK_BARK);
                        output.accept(ModItems.MANGROVE_TIMBER);
                        output.accept(ModItems.MANGROVE_PLANK);
                        output.accept(ModItems.MANGROVE_BARK);
                        output.accept(ModItems.CHERRY_TIMBER);
                        output.accept(ModItems.CHERRY_PLANK);
                        output.accept(ModItems.CHERRY_BARK);
                        output.accept(ModItems.PALM_TIMBER);
                        output.accept(ModItems.PALM_PLANK);
                        output.accept(ModItems.PALM_BARK);

                        output.accept(ModItems.CLUMP_OF_DIRT);
                        output.accept(ModItems.CLUMP_OF_MUD);
                        output.accept(ModItems.CLAY_BRICK);
                        output.accept(ModItems.PILE_OF_GRAVEL);
                        output.accept(ModItems.PILE_OF_SAND);
                        output.accept(ModItems.PILE_OF_RED_SAND);
                        output.accept(ModItems.PILE_OF_WHITE_SAND);
                        output.accept(ModItems.CLUMP_OF_MOSS);
                        output.accept(ModItems.CLUMP_OF_SOUL_SOIL);
                        output.accept(ModItems.PILE_OF_SOUL_SAND);

                        output.accept(ModItems.ROCK);
                        output.accept(ModItems.STONE_BRICK);
                        output.accept(ModItems.DEEPSLATE_ROCK);
                        output.accept(ModItems.DEEPSLATE_BRICK);
                        output.accept(ModItems.SANDSTONE_ROCK);
                        output.accept(ModItems.RED_SANDSTONE_ROCK);
                        output.accept(ModItems.WHITE_SANDSTONE_ROCK);
                        output.accept(ModItems.GRANITE_ROCK);
                        output.accept(ModItems.DIORITE_ROCK);
                        output.accept(ModItems.ANDESITE_ROCK);
                        output.accept(ModItems.CALCITE_ROCK);
                        output.accept(ModItems.TUFF_ROCK);
                        output.accept(ModItems.TUFF_BRICK);
                        output.accept(ModItems.DRIPSTONE_ROCK);
                        output.accept(ModItems.NETHERROCK);
                        output.accept(ModItems.BLACKROCK);
                        output.accept(ModItems.BLACKSTONE_BRICK);
                        output.accept(ModItems.BASALT_ROCK);
                        output.accept(ModItems.END_ROCK);
                        output.accept(ModItems.END_BRICK);

                        output.accept(ModItems.VINE);
                        output.accept(ModItems.FLAX);

                        output.accept(ModItems.BLACK_PETALS);
                        output.accept(ModItems.BLUE_PETALS);
                        output.accept(ModItems.CYAN_PETALS);
                        output.accept(ModItems.GRAY_PETALS);
                        output.accept(ModItems.LIGHT_BLUE_PETALS);
                        output.accept(ModItems.LIGHT_GRAY_PETALS);
                        output.accept(ModItems.MAGENTA_PETALS);
                        output.accept(ModItems.ORANGE_PETALS);
                        output.accept(ModItems.PINK_PETALS);
                        output.accept(ModItems.RED_PETALS);
                        output.accept(ModItems.WHITE_PETALS);
                        output.accept(ModItems.YELLOW_PETALS);

                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);

                        output.accept(ModItems.RAW_COPPER_NUGGET);
                        output.accept(ModItems.COPPER_DUST);
                        output.accept(ModItems.COPPER_NUGGET);

                        output.accept(ModItems.RAW_GOLD_NUGGET);

                        output.accept(ModItems.RAW_IRON_NUGGET);
                        output.accept(ModItems.IRON_DUST);

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

                        output.accept(ModItems.WIDE_SHAPED_IRON);
                        output.accept(ModItems.FANNED_SHAPED_IRON);
                        output.accept(ModItems.LONG_SHAPED_IRON);
                        output.accept(ModItems.JAGGED_SHAPED_IRON);
                        output.accept(ModItems.THIN_SHAPED_IRON);
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
                        output.accept(ModBlocks.PALM_LEAVES);
                        output.accept(ModBlocks.PALM_SAPLING);
                        output.accept(ModBlocks.PALM_PLANKS);
                        output.accept(ModBlocks.PALM_STAIRS);
                        output.accept(ModBlocks.PALM_SLAB);
                        output.accept(ModBlocks.PALM_FENCE);

                        output.accept(ModBlocks.PALM_FENCE_GATE);
                        output.accept(ModBlocks.PALM_DOOR);
                        output.accept(ModBlocks.PALM_TRAPDOOR);
                        output.accept(ModBlocks.PALM_PRESSURE_PLATE);
                        output.accept(ModBlocks.PALM_BUTTON);

                        output.accept(ModBlocks.CRUDE_OAK_BLOCK);
                        output.accept(ModBlocks.CRUDE_SPRUCE_BLOCK);
                        output.accept(ModBlocks.CRUDE_BIRCH_BLOCK);
                        output.accept(ModBlocks.CRUDE_JUNGLE_BLOCK);
                        output.accept(ModBlocks.CRUDE_ACACIA_BLOCK);
                        output.accept(ModBlocks.CRUDE_DARK_OAK_BLOCK);
                        output.accept(ModBlocks.CRUDE_MANGROVE_BLOCK);
                        output.accept(ModBlocks.CRUDE_CHERRY_BLOCK);
                        output.accept(ModBlocks.CRUDE_PALM_BLOCK);


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
                        output.accept(ModBlocks.COBBLED_SANDSTONE);

                        output.accept(ModBlocks.RED_SAND_SLAB);
                        output.accept(ModBlocks.COBBLED_RED_SANDSTONE);

                        output.accept(ModBlocks.WHITE_SAND);
                        output.accept(ModBlocks.WHITE_SAND_SLAB);
                        output.accept(ModBlocks.WHITE_SANDSTONE);
                        output.accept(ModBlocks.WHITE_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.WHITE_SANDSTONE_SLAB);
                        output.accept(ModBlocks.WHITE_SANDSTONE_WALL);
                        output.accept(ModBlocks.COBBLED_WHITE_SANDSTONE);
                        output.accept(ModBlocks.CHISELED_WHITE_SANDSTONE);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
                        output.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
                        output.accept(ModBlocks.CUT_WHITE_SANDSTONE);
                        output.accept(ModBlocks.CUT_WHITE_SANDSTONE_SLAB);

                        output.accept(ModBlocks.MOSS_SLAB);

                        output.accept(ModBlocks.CRACKED_STONE);
                        output.accept(ModBlocks.DEEPSLATE_SLAB);
                        output.accept(ModBlocks.CRACKED_DEEPSLATE);
                        output.accept(ModBlocks.CRACKED_GRANITE);
                        output.accept(ModBlocks.COBBLED_GRANITE);
                        output.accept(ModBlocks.CRACKED_DIORITE);
                        output.accept(ModBlocks.COBBLED_DIORITE);
                        output.accept(ModBlocks.CRACKED_ANDESITE);
                        output.accept(ModBlocks.COBBLED_ANDESITE);
                        output.accept(ModBlocks.CALCITE_SLAB);
                        output.accept(ModBlocks.CRACKED_CALCITE);
                        output.accept(ModBlocks.COBBLED_CALCITE);
                        output.accept(ModBlocks.CRACKED_TUFF);
                        output.accept(ModBlocks.COBBLED_TUFF);
                        output.accept(ModBlocks.DRIPSTONE_SLAB);
                        output.accept(ModBlocks.CRACKED_DRIPSTONE);
                        output.accept(ModBlocks.COBBLED_DRIPSTONE);
                        output.accept(ModBlocks.NETHERRACK_SLAB);
                        output.accept(ModBlocks.COBBLED_NETHERRACK);
                        output.accept(ModBlocks.COBBLED_BLACKSTONE);
                        output.accept(ModBlocks.BASALT_SLAB);
                        output.accept(ModBlocks.CRACKED_BASALT);
                        output.accept(ModBlocks.COBBLED_BASALT);
                        output.accept(ModBlocks.SMOOTH_BASALT_SLAB);
                        output.accept(ModBlocks.END_STONE_SLAB);
                        output.accept(ModBlocks.CRACKED_END_STONE);
                        output.accept(ModBlocks.COBBLED_END_STONE);

                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_FOOD_TAB = CREATIVE_MODE_TAB.register("sscr_food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_blocks_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORANGE);

                        output.accept(ModItems.BLUEBERRIES);

                        output.accept(ModItems.FLAX_SEEDS);
                        output.accept(ModItems.BOWL_OF_FLAX_SEEDS);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_TOOLS_TAB = CREATIVE_MODE_TAB.register("sscr_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_PICKAXE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_food_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.SHARPENED_STICK);
                        output.accept(ModItems.SHARPENED_ROCK);
                        output.accept(ModItems.SHARPENED_COPPER_CHUNK);
                        output.accept(ModItems.SHARPENED_IRON_CHUNK);

                        output.accept(ModItems.CRUDE_STONE_KNIFE);
                        output.accept(ModItems.CRUDE_STONE_PICK);
                        output.accept(ModItems.CRUDE_STONE_HATCHET);
                        output.accept(ModItems.CRUDE_STONE_SPADE);
                        output.accept(ModItems.CRUDE_STONE_TILL);

                        output.accept(ModItems.FLINT_KNIFE);
                        output.accept(ModItems.FLINT_PICK);
                        output.accept(ModItems.FLINT_HATCHET);
                        output.accept(ModItems.FLINT_SPADE);
                        output.accept(ModItems.FLINT_TILL);

                        output.accept(ModItems.CRUDE_COPPER_KNIFE);
                        output.accept(ModItems.CRUDE_COPPER_PICK);
                        output.accept(ModItems.CRUDE_COPPER_HATCHET);
                        output.accept(ModItems.CRUDE_COPPER_SPADE);
                        output.accept(ModItems.CRUDE_COPPER_TILL);

                        output.accept(ModItems.CRUDE_IRON_KNIFE);
                        output.accept(ModItems.CRUDE_IRON_PICK);
                        output.accept(ModItems.CRUDE_IRON_HATCHET);
                        output.accept(ModItems.CRUDE_IRON_SPADE);
                        output.accept(ModItems.CRUDE_IRON_TILL);

                        output.accept(ModItems.COPPER_SWORD);
                        output.accept(ModItems.COPPER_DAGGER);
                        output.accept(ModItems.COPPER_PICKAXE);
                        output.accept(ModItems.COPPER_AXE);
                        output.accept(ModItems.COPPER_SHOVEL);
                        output.accept(ModItems.COPPER_HOE);
                        output.accept(ModItems.COPPER_CHISEL);

                        output.accept(ModItems.STONE_DAGGER);

                        output.accept(ModItems.GOLD_DAGGER);
                        output.accept(ModItems.GOLD_CHISEL);

                        output.accept(ModItems.IRON_DAGGER);
                        output.accept(ModItems.IRON_CHISEL);

                        output.accept(ModItems.DIAMOND_DAGGER);
                        output.accept(ModItems.DIAMOND_CHISEL);

                        output.accept(ModItems.NETHERITE_DAGGER);
                        output.accept(ModItems.NETHERITE_CHISEL);

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

                        output.accept(ModItems.RANDOM_CRUDE_STONE_TOOL);
                        output.accept(ModItems.RANDOM_FLINT_TOOL);
                        output.accept(ModItems.RANDOM_CRUDE_COPPER_TOOL);
                        output.accept(ModItems.RANDOM_CRUDE_IRON_TOOL);

                        output.accept(ModItems.GECKO_SPAWN_EGG);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
