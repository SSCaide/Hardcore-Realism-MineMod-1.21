package net.sscaide.realismmod.recipe.builder;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.sscaide.realismmod.recipe.ModAnvilRecipe;

public class AnvilRecipeBuilder implements ModAnvilRecipeInterface{
    private final Item result;
    private final ItemStack resultStack;
    private Ingredient ingredient;
    private TagKey<Item> tool;
    private int materialTier;

    public AnvilRecipeBuilder(ItemLike result) {
        this(new ItemStack(result, 1));
    }

    public AnvilRecipeBuilder(ItemStack result) {
        this.resultStack = result;
        this.result = result.getItem();
    }

    public static AnvilRecipeBuilder anvil(ItemLike result) {
        return new AnvilRecipeBuilder(result);
    }

    public AnvilRecipeBuilder ingredient(ItemLike item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public AnvilRecipeBuilder ingredient(TagKey<Item> item) {
        this.ingredient = Ingredient.of(item);
        return this;
    }

    public AnvilRecipeBuilder tool(TagKey<Item> tag) {
        this.tool = tag;
        return this;
    }

    public AnvilRecipeBuilder tier(int materialTier) {
        this.materialTier = materialTier;
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceLocation id) {
        Ingredient ing = ingredient;
        Ingredient tool = Ingredient.of(this.tool);
        ModAnvilRecipe anvilRecipe = new ModAnvilRecipe(ing, tool, this.materialTier, this.resultStack);
        recipeOutput.accept(id.withSuffix("_anvil"), anvilRecipe, null);
    }
}
