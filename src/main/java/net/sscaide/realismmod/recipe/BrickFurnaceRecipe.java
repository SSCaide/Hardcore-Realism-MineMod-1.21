package net.sscaide.realismmod.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record BrickFurnaceRecipe(Ingredient input, int cookDuration, ItemStack output) implements Recipe<BrickFurnaceRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input);
        return list;
    }

    @Override
    public boolean matches(BrickFurnaceRecipeInput brickFurnaceRecipeInput, Level level) {
        if(level.isClientSide()) {
            return false;
        }

        return input.test(brickFurnaceRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(BrickFurnaceRecipeInput brickFurnaceRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.BRICK_FURNACE_SERAILIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BRICK_FURNACE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<BrickFurnaceRecipe> {
        public static final MapCodec<BrickFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("input").forGetter(BrickFurnaceRecipe::input),
                Codec.INT.fieldOf("duration").forGetter(BrickFurnaceRecipe::cookDuration),
                ItemStack.CODEC.fieldOf("result").forGetter(BrickFurnaceRecipe::output))
                .apply(inst, BrickFurnaceRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BrickFurnaceRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, BrickFurnaceRecipe::input,
                        ByteBufCodecs.INT, BrickFurnaceRecipe::cookDuration,
                        ItemStack.STREAM_CODEC, BrickFurnaceRecipe::output,
                        BrickFurnaceRecipe::new);

        @Override
        public MapCodec<BrickFurnaceRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BrickFurnaceRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}


