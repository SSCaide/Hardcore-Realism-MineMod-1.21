package net.sscaide.realismmod.recipe.builder;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipe;

public class BloomeryRecipeBuilder implements BloomeryRecipeInterface {
    private final Item result;
    private final ItemStack resultStack;
    private Ingredient ingredient;
    private int cookDuration;

    public BloomeryRecipeBuilder(ItemLike result) {
        this(new ItemStack(result, 1));
    }

    public BloomeryRecipeBuilder(ItemStack result) {
        this.resultStack = result;
        this.result = result.getItem();
    }

    public static BloomeryRecipeBuilder smelt(ItemLike result) {
        return new BloomeryRecipeBuilder(result);
    }

    public BloomeryRecipeBuilder ingredient(ItemLike item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public BloomeryRecipeBuilder ingredient(TagKey<Item> item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public BloomeryRecipeBuilder duration(int cookDuration) {
        this.cookDuration = cookDuration;
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        BrickFurnaceRecipe furnaceRecipe = new BrickFurnaceRecipe(this.ingredient, this.cookDuration, this.resultStack);
        recipeOutput.accept(id.withSuffix("_from_bloomery"), furnaceRecipe, null);
    }
}
