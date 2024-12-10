package net.sscaide.realismmod;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.datagen.recipe.ModRecipeTypes;
import net.sscaide.realismmod.effect.ModEffects;
import net.sscaide.realismmod.item.ModCreativeModeTabs;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.sound.ModSounds;
import net.sscaide.realismmod.util.ModItemProperties;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RealismMod.MOD_ID)
public class RealismMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "sscaiderealism";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public RealismMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        //Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (RealismMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModCreativeModeTabs.register(modEventBus);

        ModRecipeTypes.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);

        ModEffects.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        //Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CLUMP_OF_DIRT);
            event.accept(ModItems.CLUMP_OF_MUD);
            event.accept(ModItems.PILE_OF_GRAVEL);
            event.accept(ModItems.PILE_OF_SAND);
            event.accept(ModItems.PILE_OF_RED_SAND);
            event.accept(ModItems.PILE_OF_WHITE_SAND);

            event.accept(ModItems.ROCK);
            event.accept(ModItems.DEEPSLATE_ROCK);
            event.accept(ModItems.SANDSTONE_ROCK);
            event.accept(ModItems.RED_SANDSTONE_ROCK);
            event.accept(ModItems.GRANITE_ROCK);
            event.accept(ModItems.DIORITE_ROCK);
            event.accept(ModItems.ANDESITE_ROCK);
            event.accept(ModItems.CALCITE_ROCK);
            event.accept(ModItems.TUFF_ROCK);

            event.accept(ModItems.VINE);

            event.accept(ModItems.OAK_TIMBER);
            event.accept(ModItems.OAK_BARK);
            event.accept(ModItems.SPRUCE_TIMBER);
            event.accept(ModItems.SPRUCE_BARK);
            event.accept(ModItems.BIRCH_TIMBER);
            event.accept(ModItems.BIRCH_BARK);
            event.accept(ModItems.JUNGLE_TIMBER);
            event.accept(ModItems.JUNGLE_BARK);
            event.accept(ModItems.ACACIA_TIMBER);
            event.accept(ModItems.ACACIA_BARK);
            event.accept(ModItems.DARK_OAK_TIMBER);
            event.accept(ModItems.DARK_OAK_BARK);
            event.accept(ModItems.MANGROVE_TIMBER);
            event.accept(ModItems.MANGROVE_BARK);
            event.accept(ModItems.CHERRY_TIMBER);
            event.accept(ModItems.CHERRY_BARK);
            event.accept(ModItems.PALM_TIMBER);
            event.accept(ModItems.PALM_BARK);

            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.TIN_INGOT);
            event.accept(ModItems.COPPER_DUST);
            event.accept(ModItems.COPPER_NUGGET);

            event.accept(ModItems.OBSIDIAN_SHARD);

            event.accept(ModItems.WIDE_SHAPED_FLINT);
            event.accept(ModItems.FANNED_SHAPED_FLINT);
            event.accept(ModItems.LONG_SHAPED_FLINT);
            event.accept(ModItems.THIN_SHAPED_FLINT);

            event.accept(ModItems.WIDE_SHAPED_COPPER);
            event.accept(ModItems.FANNED_SHAPED_COPPER);
            event.accept(ModItems.LONG_SHAPED_COPPER);
            event.accept(ModItems.JAGGED_SHAPED_COPPER);
            event.accept(ModItems.THIN_SHAPED_COPPER);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.ORANGE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.SHARPENED_STICK);
            event.accept(ModItems.SHARPENED_ROCK);

            event.accept(ModItems.CRUDE_STONE_KNIFE);
            event.accept(ModItems.FLINT_KNIFE);
            event.accept(ModItems.CRUDE_COPPER_KNIFE);

            event.accept(ModItems.COPPER_SWORD);
            event.accept(ModItems.COPPER_HELMET);
            event.accept(ModItems.COPPER_CHESTPLATE);
            event.accept(ModItems.COPPER_LEGGINGS);
            event.accept(ModItems.COPPER_BOOTS);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.SHARPENED_STICK);
            event.accept(ModItems.SHARPENED_ROCK);

            event.accept(ModItems.RANDOM_CRUDE_STONE_TOOL);
            event.accept(ModItems.CRUDE_STONE_PICK);
            event.accept(ModItems.CRUDE_STONE_HATCHET);
            event.accept(ModItems.CRUDE_STONE_SPADE);
            event.accept(ModItems.CRUDE_STONE_TILL);

            event.accept(ModItems.RANDOM_FLINT_TOOL);
            event.accept(ModItems.FLINT_PICK);
            event.accept(ModItems.FLINT_HATCHET);
            event.accept(ModItems.FLINT_SPADE);
            event.accept(ModItems.FLINT_TILL);

            event.accept(ModItems.RANDOM_CRUDE_COPPER_TOOL);
            event.accept(ModItems.CRUDE_COPPER_PICK);
            event.accept(ModItems.CRUDE_COPPER_HATCHET);
            event.accept(ModItems.CRUDE_COPPER_SPADE);
            event.accept(ModItems.CRUDE_COPPER_TILL);

            event.accept(ModItems.COPPER_PICKAXE);
            event.accept(ModItems.COPPER_AXE);
            event.accept(ModItems.COPPER_SHOVEL);
            event.accept(ModItems.COPPER_HOE);

        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.PALM_LOG);
            event.accept(ModBlocks.PALM_WOOD);
            event.accept(ModBlocks.STRIPPED_PALM_LOG);
            event.accept(ModBlocks.STRIPPED_PALM_WOOD);
            event.accept(ModBlocks.PALM_PLANKS);
            event.accept(ModBlocks.PALM_STAIRS);
            event.accept(ModBlocks.PALM_SLAB);
            event.accept(ModBlocks.PALM_FENCE);

            event.accept(ModBlocks.PALM_FENCE_GATE);
            event.accept(ModBlocks.PALM_DOOR);
            event.accept(ModBlocks.PALM_TRAPDOOR);
            event.accept(ModBlocks.PALM_PRESSURE_PLATE);
            event.accept(ModBlocks.PALM_BUTTON);

            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.RAW_TIN_BLOCK);
            event.accept(ModBlocks.TIN_BLOCK);
            event.accept(ModBlocks.TIN_WALL);

            event.accept(ModBlocks.DIRT_SLAB);
            event.accept(ModBlocks.MUD_SLAB);
            event.accept(ModBlocks.CLAY_SLAB);
            event.accept(ModBlocks.GRAVEL_SLAB);
            event.accept(ModBlocks.SAND_SLAB);
            event.accept(ModBlocks.RED_SAND_SLAB);
            event.accept(ModBlocks.WHITE_SAND);
            event.accept(ModBlocks.WHITE_SAND_SLAB);
            event.accept(ModBlocks.WHITE_SANDSTONE);
            event.accept(ModBlocks.WHITE_SANDSTONE_STAIRS);
            event.accept(ModBlocks.WHITE_SANDSTONE_SLAB);
            event.accept(ModBlocks.WHITE_SANDSTONE_WALL);
            event.accept(ModBlocks.CHISELED_WHITE_SANDSTONE);
            event.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE);
            event.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS);
            event.accept(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB);
            event.accept(ModBlocks.CUT_WHITE_SANDSTONE);
            event.accept(ModBlocks.CUT_WHITE_SANDSTONE_SLAB);

            event.accept(ModBlocks.DEEPSLATE_SLAB);
            event.accept(ModBlocks.CALCITE_SLAB);

        }
        if(event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.TIN_BULB);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
