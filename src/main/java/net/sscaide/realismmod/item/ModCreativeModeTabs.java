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
                        output.accept(ModItems.ROCK);
                        output.accept(ModItems.VINE);

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
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_FOOD_TAB = CREATIVE_MODE_TAB.register("sscr_food_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_blocks_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_food"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ORANGE);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_TOOLS_TAB = CREATIVE_MODE_TAB.register("sscr_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.COPPER_PICKAXE.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_food_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.FLINT_KNIFE);
                        output.accept(ModItems.RANDOM_FLINT_TOOL);
                        output.accept(ModItems.FLINT_PICK);
                        output.accept(ModItems.FLINT_HATCHET);
                        output.accept(ModItems.FLINT_SPADE);
                        output.accept(ModItems.FLINT_TILL);

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

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
