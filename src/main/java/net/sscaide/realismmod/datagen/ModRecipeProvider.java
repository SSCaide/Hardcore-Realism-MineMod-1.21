package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TIN.get(), 9)
                        .requires(ModBlocks.RAW_TIN_BLOCK)
                        .unlockedBy("has_raw_tin_block",
                        has(ModBlocks.RAW_TIN_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block",
                        has(ModBlocks.TIN_BLOCK)).save(recipeOutput);
        List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE);
            oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 200, "tin");
            oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 100, "tin");

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get())
                        .pattern(" A ")
                        .pattern(" A ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_PICKAXE.get())
                        .pattern("AAA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                        .pattern("AA ")
                        .pattern("AB ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_AXE.get())
                        .pattern(" AA")
                        .pattern(" BA")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput, "sscaiderealism:copper_axe_2");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_SHOVEL.get())
                        .pattern(" A ")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                        .pattern("AA ")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_HOE.get())
                        .pattern(" AA")
                        .pattern(" B ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput, "sscaiderealism:copper_hoe_2");


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_TIN.get())
                .unlockedBy("has_tin", has(ModItems.RAW_TIN)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TIN_WALL.get(), ModItems.TIN_INGOT.get());

        planksFromLog(recipeOutput, ModBlocks.PALM_PLANKS, ModTags.Items.PALM_LOGS, 4);
        woodFromLogs(recipeOutput, ModBlocks.PALM_WOOD, ModBlocks.PALM_LOG);
        stairBuilder(ModBlocks.PALM_STAIRS.get(),
                Ingredient.of(ModBlocks.PALM_PLANKS)).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PALM_SLAB.get(), ModBlocks.PALM_PLANKS.get());
        fenceBuilder(ModBlocks.PALM_FENCE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(ModBlocks.PALM_FENCE_GATE.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        doorBuilder(ModBlocks.PALM_DOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(ModBlocks.PALM_TRAPDOOR.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.PALM_PRESSURE_PLATE.get(), ModBlocks.PALM_PLANKS.get());
        buttonBuilder(ModBlocks.PALM_BUTTON.get(), Ingredient.of(ModBlocks.PALM_PLANKS.get())).group("palm")
                .unlockedBy("has_palm", has(ModBlocks.PALM_PLANKS.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE)
                        .pattern("BB")
                        .pattern("BB")
                        .define('B', ModItems.ROCK.get())
                        .unlockedBy("has_rock", has(ModItems.ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLESTONE_SLAB)
                        .pattern("BB")
                        .define('B', ModItems.ROCK.get())
                        .unlockedBy("has_rock", has(ModItems.ROCK)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DIRT)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_DIRT.get())
                .unlockedBy("has_dirt_clump", has(ModItems.CLUMP_OF_DIRT)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_SLAB.get(), Blocks.DIRT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIRT_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_DIRT.get())
                .unlockedBy("has_dirt_clump", has(ModItems.CLUMP_OF_DIRT)).save(recipeOutput, "sscaiderealism:dirt_slab_from_clumps");

    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, RealismMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
