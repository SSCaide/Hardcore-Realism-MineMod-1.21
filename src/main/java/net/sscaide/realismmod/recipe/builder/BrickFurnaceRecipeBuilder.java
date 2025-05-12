package net.sscaide.realismmod.recipe.builder;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipe;
import net.sscaide.realismmod.recipe.ModAnvilRecipe;

public class BrickFurnaceRecipeBuilder implements BrickFurnaceRecipeInterface {
    private final Item result;
    private final ItemStack resultStack;
    private Ingredient ingredient;
    private int cookDuration;

    public BrickFurnaceRecipeBuilder(ItemLike result) {
        this(new ItemStack(result, 1));
    }

    public BrickFurnaceRecipeBuilder(ItemStack result) {
        this.resultStack = result;
        this.result = result.getItem();
    }

    public static BrickFurnaceRecipeBuilder smelt(ItemLike result) {
        return new BrickFurnaceRecipeBuilder(result);
    }

    public BrickFurnaceRecipeBuilder ingredient(ItemLike item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public BrickFurnaceRecipeBuilder ingredient(TagKey<Item> item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public BrickFurnaceRecipeBuilder duration(int cookDuration) {
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
        recipeOutput.accept(id.withSuffix("_from_brick_furnace"), furnaceRecipe, null);
    }
}
