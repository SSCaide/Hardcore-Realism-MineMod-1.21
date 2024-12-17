package net.sscaide.realismmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.BOWL_OF_FLAX_SEEDS.get(), ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID
                        , "servings"), (stack, level, entity, seed) -> stack.get(ModDataComponents.SERVINGS));
    }
}
