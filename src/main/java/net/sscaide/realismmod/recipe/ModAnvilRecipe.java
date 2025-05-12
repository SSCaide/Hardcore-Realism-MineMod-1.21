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

public record ModAnvilRecipe(Ingredient inputItem, Ingredient inputTool, int materialTier, ItemStack output) implements Recipe<ModAnvilRecipeInput> {
    //materialTier: 1=weaker than stone, 2=stone, 3=copper, 4=iron/bronze, 5=steel, 6=stronger than steel, 7=netherite

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        list.add(inputTool);
        return list;
    }

    @Override
    public boolean matches(ModAnvilRecipeInput modAnvilRecipeInput, Level level) {
        if(level.isClientSide()) {
            return false;
        }

        return inputItem.test(modAnvilRecipeInput.getItem(0)) && inputTool.test(modAnvilRecipeInput.getItem(1));
    }

    @Override
    public ItemStack assemble(ModAnvilRecipeInput modAnvilRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.MOD_ANVIL_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MOD_ANVIL_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<ModAnvilRecipe> {
        public static final MapCodec<ModAnvilRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(ModAnvilRecipe::inputItem),
                Ingredient.CODEC_NONEMPTY.fieldOf("tool").forGetter(ModAnvilRecipe::inputTool),
                Codec.INT.fieldOf("material_tier").forGetter(ModAnvilRecipe::materialTier),
                ItemStack.CODEC.fieldOf("result").forGetter(ModAnvilRecipe::output))
                .apply(inst, ModAnvilRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ModAnvilRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ModAnvilRecipe::inputItem,
                        Ingredient.CONTENTS_STREAM_CODEC, ModAnvilRecipe::inputTool,
                        ByteBufCodecs.INT, ModAnvilRecipe::materialTier,
                        ItemStack.STREAM_CODEC, ModAnvilRecipe::output,
                        ModAnvilRecipe::new);


        @Override
        public MapCodec<ModAnvilRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ModAnvilRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
