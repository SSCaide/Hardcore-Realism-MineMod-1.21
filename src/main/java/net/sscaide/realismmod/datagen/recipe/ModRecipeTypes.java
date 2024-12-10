package net.sscaide.realismmod.datagen.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.item.custom.MultiConsumableBowlItem;

public class ModRecipeTypes {
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, RealismMod.MOD_ID);

    RecipeType<CraftingRecipe> BOWL_FILLING = register("bowl_filling");
    public record BowlFillingInput(ItemStack bowl, int bowlServings, ItemStack ingredient, int ingredientAmount)
    implements RecipeInput {


        public ItemStack getBowl() {
            return bowl;
        }

        @Override
        public ItemStack getItem(int index) {
            return null;
        }

        @Override
        public int size() {
            return 0;
        }
    }


    static <T extends Recipe<?>> RecipeType<T> register(final String identifier) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, ResourceLocation.withDefaultNamespace(identifier), new RecipeType<T>() {
            @Override
            public String toString() {
                return identifier;
            }
        });
    }
    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
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
