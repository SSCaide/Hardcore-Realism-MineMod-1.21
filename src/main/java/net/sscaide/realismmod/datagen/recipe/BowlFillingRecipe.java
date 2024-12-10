package net.sscaide.realismmod.datagen.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.sscaide.realismmod.component.ModDataComponents;

import javax.annotation.Nonnull;
import java.util.Collections;

public class BowlFillingRecipe implements Recipe<ModRecipeTypes.BowlFillingInput> {
    public static final DataComponentType<Integer> bowlServingsComponent = ModDataComponents.SERVINGS.get();

    private final ItemLike bowl;
    private final ItemLike ingredient;
    private final int ingredientAmount;
    private final NonNullList<Ingredient> ingredients = NonNullList.create();
    private ItemContainerContents bowlContents;
    private final Item result;
    private ItemStack resultToReturn;

    public BowlFillingRecipe(ItemLike bowl, ItemLike ingredient,
                             int ingredientAmount, ItemStack result) {
        this.bowl = bowl;
        this.ingredient = ingredient;
        this.ingredientAmount = ingredientAmount;
        this.result = result.getItem();
        this.resultToReturn = result;
    }

    public static BowlFillingRecipe bowlFilling(ItemLike bowl, ItemLike ingredient, int ingredientAmount,
                                                ItemStack result) {
        return new BowlFillingRecipe(bowl, ingredient, ingredientAmount, result);
    }



    @Override
    public boolean matches(ModRecipeTypes.BowlFillingInput input, Level level) {
        return false;
    }

    @Override
    public @Nonnull ItemStack assemble(ModRecipeTypes.BowlFillingInput input, HolderLookup.Provider registries) {
        ItemStack bowlStack = new ItemStack(bowl);
        bowlContents = Integer.fromItems(Collections.singletonList(bowlStack));
//            BlockRendererBase.setPickaxeType(Block.byItem(result.getItem().getDefaultInstance().getItem()), pickStack);
        //ItemStack result = getResultItem(registries).copy(); // Copy the result item to avoid modifying the original (resultToReturn
        CompoundTag compound = new CompoundTag();
        NonNullList<ItemStack> bowlList = NonNullList.withSize(1, bowlStack);
        ContainerHelper.saveAllItems(compound, bowlList, registries);
        BlockBase.setPickType(bowlStack);
        // Example: Setting the pickaxe type
        resultToReturn.set(ModDataComponents.SERVINGS, bowlContents);
       // Main.LOGGER.debug("The pick type is...: {}", pickStack);

        resultToReturn.set(bowlServingsComponent, bowlContents);
        //resultToReturn.set(ModDataComponents.SERVINGS, this.bowlServings+1);
        return this.resultToReturn;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        resultToReturn.set(ModDataComponents.SERVINGS, this.bowlServings+1);
        return this.resultToReturn;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

}
