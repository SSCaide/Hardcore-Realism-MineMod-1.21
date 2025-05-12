package net.sscaide.realismmod.block.blockentities;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, RealismMod.MOD_ID);

    public static final Supplier<BlockEntityType<BrickFurnaceEntity>> BRICK_FURNACE_ENTITY =
            BLOCK_ENTITY_TYPES.register("brick_furnace_entity", () -> BlockEntityType.Builder
                    .of(BrickFurnaceEntity::new, ModBlocks.BRICK_FURNACE.get()).build(null));
    public static final Supplier<BlockEntityType<BloomeryEntity>> BLOOMERY_ENTITY =
            BLOCK_ENTITY_TYPES.register("bloomery_entity", () -> BlockEntityType.Builder
                    .of(BloomeryEntity::new, ModBlocks.BLOOMERY.get()).build(null));
    public static final Supplier<BlockEntityType<ModAnvilEntity>> MOD_ANVIL_ENTITY =
            BLOCK_ENTITY_TYPES.register("mod_anvil_entity", () -> BlockEntityType.Builder
                    .of(ModAnvilEntity::new, ModBlocks.STONE_ANVIL.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }
}