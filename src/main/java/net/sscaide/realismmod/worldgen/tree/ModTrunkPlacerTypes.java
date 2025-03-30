package net.sscaide.realismmod.worldgen.tree;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

import java.util.function.Supplier;

public class ModTrunkPlacerTypes extends TrunkPlacerType {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER_TYPES = DeferredRegister.create(BuiltInRegistries.TRUNK_PLACER_TYPE, RealismMod.MOD_ID);

    public ModTrunkPlacerTypes(MapCodec codec) {
        super(codec);
    }

    public static final DeferredHolder<TrunkPlacerType<?>, TrunkPlacerType<SpiralTrunkPlacer>> SPIRAL_TRUNK_PLACER = TRUNK_PLACER_TYPES.register("spiral_trunk_placer",
            () -> new TrunkPlacerType<>(SpiralTrunkPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        TRUNK_PLACER_TYPES.register(eventBus);
    }

}
