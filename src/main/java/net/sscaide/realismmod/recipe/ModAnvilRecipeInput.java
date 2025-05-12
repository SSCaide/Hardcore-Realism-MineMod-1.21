package net.sscaide.realismmod.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ModAnvilRecipeInput(ItemStack ingredient, ItemStack tool) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        ItemStack stack;
        switch(i) {
            case 0 -> stack = ingredient;
            case 1 -> stack = tool;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + i);
        }

        return stack;
    }
    @Override
    public int size() {
        return 2;
    }

    public boolean isEmpty() {
        return this.ingredient.isEmpty() && this.tool.isEmpty();
    }

    public ItemStack ingredient() { return ingredient; }

    public ItemStack tool() { return tool; }
}
