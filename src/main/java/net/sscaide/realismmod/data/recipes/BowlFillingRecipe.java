package net.sscaide.realismmod.data.recipes;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.util.RecipeMatcher;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.item.ModItems;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Objects;

public class BowlFillingRecipe extends ShapelessRecipe {
    public static final DataComponentType<Integer> bowlServingsComponent = ModDataComponents.SERVINGS.get();

    final String group;
    final CraftingBookCategory category;
    final ItemLike bowl;
    private int servings;
    final NonNullList<Ingredient> ingredients = NonNullList.create();
    private final boolean isSimple;
    final ItemStack result;
    private ItemStack resultToReturn;


    public BowlFillingRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.group = group;
        this.category = category;
        this.bowl = ModItems.BOWL_OF_FLAX_SEEDS;
        ItemStack bowlStack = new ItemStack(bowl);
        this.servings = Objects.requireNonNull(bowlStack.get(ModDataComponents.SERVINGS));
        this.isSimple = ingredients.stream().allMatch(Ingredient::isSimple);
        this.result = result;
        this.resultToReturn = result;
    }

    public Item getResult() {
        return result.getItem();
    }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.resultToReturn;
    }

    public NonNullList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public boolean matches(CraftingInput input, Level level) {
        if (input.ingredientCount() != this.ingredients.size()) {
            return false;
        } else if (this.servings > 15){
            return false;
        } else if (!this.isSimple) {
            ArrayList<ItemStack> nonEmptyItems = new ArrayList(input.ingredientCount());

            for (ItemStack item : input.items()) {
                if (!item.isEmpty()) {
                    nonEmptyItems.add(item);
                }
            }

            return RecipeMatcher.findMatches(nonEmptyItems, this.ingredients) != null;
        } else {
            return input.size() == 1 && this.ingredients.size() == 1 ? this.ingredients.getFirst().test(input.getItem(0)) : input.stackedContents().canCraft(this, null);
        }
    }

    public @Nonnull ItemStack assemble(CraftingInput input, HolderLookup.Provider registries) {
        resultToReturn.set(ModDataComponents.SERVINGS, servings +=1);
        RealismMod.LOGGER.debug("The servings value is...: {}", servings += 1);
        return resultToReturn;
    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= this.ingredients.size();
    }

    @Override
    public RecipeType<?> getType() {
        return super.getType();
    }

    @Override
    public CraftingBookCategory category() {
        return category;
    }

    public ItemLike getBowl() {
        return bowl;
    }

    @Override
    public RecipeSerializer<BowlFillingRecipe> getSerializer() {
        return ModRecipes.BOWL_FILLING_SERIALIZER.get();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


    public static class Serializer implements RecipeSerializer<BowlFillingRecipe>{
        public static final StreamCodec<RegistryFriendlyByteBuf, BowlFillingRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        private static final MapCodec<BowlFillingRecipe> CODEC = RecordCodecBuilder.mapCodec((p_340779_) -> p_340779_.group(Codec.STRING.optionalFieldOf("group", "").forGetter((p_301127_) -> p_301127_.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter((p_301133_) -> p_301133_.category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter((p_301142_) -> p_301142_.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap((p_301021_) -> {
            Ingredient[] aingredient = p_301021_.toArray((x$0) -> new Ingredient[x$0]);
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter((p_300975_) -> p_300975_.getIngredients())).apply(p_340779_, BowlFillingRecipe::new));

        public Serializer() {}

        private static BowlFillingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            String s = buffer.readUtf();
            CraftingBookCategory craftingbookcategory = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            NonNullList<Ingredient> nonnulllist = NonNullList.withSize(i, Ingredient.EMPTY);
            nonnulllist.replaceAll((p_319735_) -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            ItemStack itemstack = ItemStack.STREAM_CODEC.decode(buffer);
            return new BowlFillingRecipe(s, craftingbookcategory, itemstack, nonnulllist);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, BowlFillingRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            buffer.writeVarInt(recipe.ingredients.size());

            for (Ingredient ingredient : recipe.ingredients) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }

        public MapCodec<BowlFillingRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, BowlFillingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }

}