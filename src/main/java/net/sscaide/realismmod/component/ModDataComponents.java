package net.sscaide.realismmod.component;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.util.ExtraCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
        DeferredRegister.createDataComponents(RealismMod.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES
            = register("coordinates",  builder -> builder.persistent(BlockPos.CODEC));

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> TICKER
            = register("ticker", builder -> builder.persistent(ExtraCodecs.intRange(-100, 100)).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SERVINGS
            = register("servings", builder -> builder.persistent(ExtraCodecs.intRange(0, 16)).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> FIRE_CHANCE
            = register("fire_chance", builder -> builder.persistent(ExtraCodecs.intRange(0, 40)).networkSynchronized(ByteBufCodecs.VAR_INT));
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> IN_USE
            = register("in_use", builder -> builder.networkSynchronized(ByteBufCodecs.BOOL));


    private static <T> DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
    UnaryOperator<DataComponentType.Builder<T>> builderOperator) {

        return DATA_COMPONENT_TYPES.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
