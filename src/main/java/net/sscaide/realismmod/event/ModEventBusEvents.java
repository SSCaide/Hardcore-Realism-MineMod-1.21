package net.sscaide.realismmod.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.entity.ModEntities;
import net.sscaide.realismmod.entity.client.GeckoModel;
import net.sscaide.realismmod.entity.custom.BoarEntity;
import net.sscaide.realismmod.entity.custom.GeckoEntity;

@EventBusSubscriber(modid = RealismMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
        event.put(ModEntities.BOAR.get(), BoarEntity.createAttributes().build());
    }
}
