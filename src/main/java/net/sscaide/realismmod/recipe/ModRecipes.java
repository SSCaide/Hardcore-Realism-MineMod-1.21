package net.sscaide.realismmod.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, RealismMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, RealismMod.MOD_ID);


    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ModAnvilRecipe>> MOD_ANVIL_SERIALIZER =
            RECIPE_SERIALIZERS.register("mod_anvil", ModAnvilRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ModAnvilRecipe>> MOD_ANVIL_TYPE =
            RECIPE_TYPES.register("mod_anvil", () -> new RecipeType<ModAnvilRecipe>() {
                @Override
                public String toString() {
                    return "mod_anvil";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BrickFurnaceRecipe>> BRICK_FURNACE_SERAILIZER =
            RECIPE_SERIALIZERS.register("brick_furnace", BrickFurnaceRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<BrickFurnaceRecipe>> BRICK_FURNACE_TYPE =
            RECIPE_TYPES.register("brick_furnace", () -> new RecipeType<BrickFurnaceRecipe>() {
                @Override
                public String toString() {
                    return "brick_furnace";
                }
            });

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BloomeryRecipe>> BLOOMERY_SERAILIZER =
            RECIPE_SERIALIZERS.register("bloomery", BloomeryRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<BloomeryRecipe>> BLOOMERY_TYPE =
            RECIPE_TYPES.register("bloomery", () -> new RecipeType<BloomeryRecipe>() {
                @Override
                public String toString() {
                    return "bloomery";
                }
            });


    public static void register(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
        RECIPE_TYPES.register(eventBus);
    }
}
