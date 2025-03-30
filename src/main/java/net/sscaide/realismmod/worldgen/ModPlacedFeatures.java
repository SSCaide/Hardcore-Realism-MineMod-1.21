package net.sscaide.realismmod.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY_SMALL = registerKey("tin_ore_placed_small");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY_LARGE = registerKey("tin_ore_placed_large");

    public static final ResourceKey<PlacedFeature> PALM_PLACED_KEY = registerKey("palm_tree_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6, HeightRangePlacement
                        .triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(90))));
        register(context, TIN_ORE_PLACED_KEY_SMALL, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY_SMALL),
                ModOrePlacement.commonOrePlacement(2, HeightRangePlacement
                        .uniform(VerticalAnchor.absolute(60), VerticalAnchor.absolute(132))));
        register(context, TIN_ORE_PLACED_KEY_LARGE, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY_LARGE),
                ModOrePlacement.rareOrePlacement(20, HeightRangePlacement
                        .uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(112))));

        register(context, PALM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALM_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 0),
                        ModBlocks.PALM_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
