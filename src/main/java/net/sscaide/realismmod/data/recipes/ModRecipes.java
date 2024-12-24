package net.sscaide.realismmod.data.recipes;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

import java.util.function.Supplier;

public class ModRecipes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, RealismMod.MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, "recipe_serializer");


    public static final Supplier<RecipeSerializer<BowlFillingRecipe>> BOWL_FILLING_SERIALIZER =
            RECIPE_SERIALIZERS.register("bowl_filling_serializer", BowlFillingRecipe.Serializer::new);
    RecipeType<CraftingRecipe> BOWL_FILLING = register("bowl_filling");


    static <T extends Recipe<?>> RecipeType<T> register(final String identifier) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.withDefaultNamespace(identifier), new RecipeType<T>() {
            @Override
            public String toString() {
                return identifier;
            }
        });
    }

    public static void registerTypes(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
    }
    public static void registerRecipes(IEventBus eventBus) {
        RECIPE_SERIALIZERS.register(eventBus);
    }


    public static <T extends Recipe<?>> RecipeType<T> simple(final ResourceLocation name) {
        final String toString = name.toString();
        return new RecipeType<T>() {
            @Override
            public String toString() {
                return toString;
            }
        };
    }
}
