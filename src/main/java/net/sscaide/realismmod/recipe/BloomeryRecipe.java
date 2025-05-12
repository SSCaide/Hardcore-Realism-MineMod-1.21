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

public record BloomeryRecipe(Ingredient input, int cookDuration, ItemStack output) implements Recipe<BloomeryRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(input);
        return list;
    }

    @Override
    public boolean matches(BloomeryRecipeInput bloomeryRecipeInput, Level level) {
        if(level.isClientSide()) {
            return false;
        }

        return input.test(bloomeryRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(BloomeryRecipeInput bloomeryRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.BLOOMERY_SERAILIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.BLOOMERY_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<BloomeryRecipe> {
        public static final MapCodec<BloomeryRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("input").forGetter(BloomeryRecipe::input),
                Codec.INT.fieldOf("duration").forGetter(BloomeryRecipe::cookDuration),
                ItemStack.CODEC.fieldOf("result").forGetter(BloomeryRecipe::output))
                .apply(inst, BloomeryRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, BloomeryRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, BloomeryRecipe::input,
                        ByteBufCodecs.INT, BloomeryRecipe::cookDuration,
                        ItemStack.STREAM_CODEC, BloomeryRecipe::output,
                        BloomeryRecipe::new);

        @Override
        public MapCodec<BloomeryRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, BloomeryRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}


