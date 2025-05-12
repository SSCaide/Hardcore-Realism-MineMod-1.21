package net.sscaide.realismmod.recipe.builder;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

public interface ModAnvilRecipeInterface {
    Item getResult();

    void save(RecipeOutput var1, ResourceLocation var2);

    default void save(RecipeOutput recipeOutput) {
        this.save(recipeOutput, getDefaultRecipeId(this.getResult()));
    }

    default void save(RecipeOutput recipeOutput, String id) {
        ResourceLocation resourcelocation = getDefaultRecipeId(this.getResult());
        ResourceLocation resourcelocation1 = ResourceLocation.parse(id);
        if (resourcelocation1.equals(resourcelocation)) {
            throw new IllegalStateException("Recipe " + id + " should remove its 'save' argument as it is equal to default one");
        } else {
            this.save(recipeOutput, resourcelocation1);
        }
    }

    static ResourceLocation getDefaultRecipeId(ItemLike itemLike) {
        return BuiltInRegistries.ITEM.getKey(itemLike.asItem());
    }
}
