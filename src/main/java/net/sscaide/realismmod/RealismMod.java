package net.sscaide.realismmod;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.sscaide.realismmod.block.blockentities.ModBlockEntities;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.screen.ModMenuTypes;
import net.sscaide.realismmod.block.blockentities.renderer.BrickFurnaceEntityRenderer;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.recipe.ModRecipes;
import net.sscaide.realismmod.effect.ModEffects;
import net.sscaide.realismmod.entity.ModEntities;
import net.sscaide.realismmod.entity.client.GeckoRenderer;
import net.sscaide.realismmod.item.ModCreativeModeTabs;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.screen.custom.ModAnvilScreen;
import net.sscaide.realismmod.sound.ModSounds;
import net.sscaide.realismmod.util.ModItemProperties;
import net.sscaide.realismmod.worldgen.tree.ModFoliagePlacerTypes;
import net.sscaide.realismmod.worldgen.tree.ModTrunkPlacerTypes;
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
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(RealismMod.MOD_ID)
public class RealismMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "sscaiderealism";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

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

        ModRecipes.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModEntities.register(modEventBus);

        ModDataComponents.register(modEventBus);
        ModSounds.register(modEventBus);
        ModEffects.register(modEventBus);

        ModTrunkPlacerTypes.register(modEventBus);
        ModFoliagePlacerTypes.register(modEventBus);

        //Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

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

            EntityRenderers.register(ModEntities.GECKO.get(), GeckoRenderer::new);
            //EntityRenderers.register(ModEntities.BOAR.get(), BoarRenderer::new);

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_OAK_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_SPRUCE_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_BIRCH_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_JUNGLE_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_ACACIA_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_DARK_OAK_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_MANGROVE_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_CHERRY_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.CRUDE_PALM_BLOCK.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOMERY.get(), RenderType.translucent());
        }

        @SubscribeEvent
        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.BRICK_FURNACE_ENTITY.get(), BrickFurnaceEntityRenderer::new);
        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.MOD_ANVIL_MENU.get(), ModAnvilScreen::new);
        }
    }

}
