package net.sscaide.realismmod;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModCreativeModeTabs;
import net.sscaide.realismmod.item.ModItems;
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

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

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
            event.accept(ModItems.ROCK);
            event.accept(ModItems.VINE);

            event.accept(ModItems.OAK_BARK);
            event.accept(ModItems.SPRUCE_BARK);
            event.accept(ModItems.BIRCH_BARK);
            event.accept(ModItems.JUNGLE_BARK);
            event.accept(ModItems.ACACIA_BARK);
            event.accept(ModItems.DARK_OAK_BARK);
            event.accept(ModItems.MANGROVE_BARK);
            event.accept(ModItems.CHERRY_BARK);
            event.accept(ModItems.PALM_BARK);

            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.TIN_INGOT);
        }

        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.ORANGE);
        }

        if(event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.COPPER_SWORD);
        }

        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.COPPER_PICKAXE);
            event.accept(ModItems.COPPER_AXE);
            event.accept(ModItems.COPPER_SHOVEL);
            event.accept(ModItems.COPPER_HOE);

        }

        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.DIRT_SLAB);

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

        }
    }
}
