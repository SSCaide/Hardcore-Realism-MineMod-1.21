package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.sscaide.realismmod.data.recipes.BowlFillingRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.item.custom.MultiConsumableBowlItem;
import net.sscaide.realismmod.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CLUMP_OF_DIRT.get(), 4)
                .requires(Blocks.DIRT)
                .unlockedBy("has_dirt",
                        has(Blocks.DIRT)).save(recipeOutput, "clumps_of_dirt_from_dirt");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CLUMP_OF_MUD.get(), 4)
                .requires(Blocks.MUD)
                .unlockedBy("has_mud",
                        has(Blocks.MUD)).save(recipeOutput, "clumps_of_mud_from_mud");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CLAY_BALL, 4)
                .requires(Blocks.CLAY)
                .unlockedBy("has_clay",
                        has(Blocks.CLAY)).save(recipeOutput, "clay_balls_from_clay");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 4)
                .requires(Blocks.GRAVEL)
                .unlockedBy("has_gravel",
                        has(Blocks.GRAVEL)).save(recipeOutput, "piles_of_gravel_from_gravel");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModTags.Items.ROCKS_NO_SANDSTONE)
                .unlockedBy("has_any_rock",
                        has(ModTags.Items.ROCKS)).save(recipeOutput, "pile_of_gravel_from_rocks");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_SAND.get(), 4)
                .requires(Blocks.SAND)
                .unlockedBy("has_sand",
                        has(Blocks.SAND)).save(recipeOutput, "piles_of_sand_from_sand");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_SAND.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.SANDSTONE_ROCK)
                .unlockedBy("has_sandstone_rock",
                        has(ModItems.SANDSTONE_ROCK)).save(recipeOutput, "pile_of_sand_from_sandstone_rock");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_RED_SAND.get(), 4)
                .requires(Blocks.RED_SAND)
                .unlockedBy("has_red_sand",
                        has(Blocks.RED_SAND)).save(recipeOutput, "piles_of_red_sand_from_red_sand");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_RED_SAND.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.RED_SANDSTONE_ROCK)
                .unlockedBy("has_red_sandstone_rock",
                        has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput, "pile_of_red_sand_from_red_sandstone_rock");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_WHITE_SAND.get(), 4)
                .requires(ModBlocks.WHITE_SAND)
                .unlockedBy("has_white_sand",
                        has(ModBlocks.WHITE_SAND)).save(recipeOutput, "piles_of_white_sand_from_white_sand");


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROCK.get(), 4)
                .requires(Blocks.COBBLESTONE)
                .unlockedBy("has_cobblestone",
                        has(Blocks.COBBLESTONE)).save(recipeOutput, "rocks_from_cobblestone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEEPSLATE_ROCK.get(), 4)
                .requires(Blocks.COBBLED_DEEPSLATE)
                .unlockedBy("has_cobbled_deepslate",
                        has(Blocks.COBBLED_DEEPSLATE)).save(recipeOutput, "deepslate_rocks_from_cobbled_deepslate");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANITE_ROCK.get(), 4)
                .requires(Blocks.GRANITE)
                .unlockedBy("has_granite",
                        has(Blocks.GRANITE)).save(recipeOutput, "granite_rocks_from_granite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIORITE_ROCK.get(), 4)
                .requires(Blocks.DIORITE)
                .unlockedBy("has_diorite",
                        has(Blocks.DIORITE)).save(recipeOutput, "diorite_rocks_from_diorite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANDESITE_ROCK.get(), 4)
                .requires(Blocks.ANDESITE)
                .unlockedBy("has_andesite",
                        has(Blocks.ANDESITE)).save(recipeOutput, "andesite_rocks_from_andesite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CALCITE_ROCK.get(), 4)
                .requires(Blocks.CALCITE)
                .unlockedBy("has_calcite",
                        has(Blocks.CALCITE)).save(recipeOutput, "calcite_rocks_from_calcite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUFF_ROCK.get(), 4)
                .requires(Blocks.TUFF)
                .unlockedBy("has_tuff",
                        has(Blocks.TUFF)).save(recipeOutput, "tuff_rocks_from_tuff");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(Items.FLINT, 2)
                .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.WIDE_SHAPED_FLINT)
                .unlockedBy("has_wide_shaped_flint", has(ModItems.WIDE_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.FANNED_SHAPED_FLINT)
                .unlockedBy("has_fanned_shaped_flint", has(ModItems.FANNED_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.LONG_SHAPED_FLINT)
                .unlockedBy("has_long_shaped_flint", has(ModItems.LONG_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.THIN_SHAPED_FLINT)
                .unlockedBy("has_thin_shaped_flint",
                        has(ModItems.THIN_SHAPED_FLINT)).save(recipeOutput, "pile_of_gravel_from_shaped_flint");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(Items.RAW_COPPER, 2)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.WIDE_SHAPED_COPPER)
                .unlockedBy("has_wide_shaped_copper", has(ModItems.WIDE_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.FANNED_SHAPED_COPPER)
                .unlockedBy("has_fanned_shaped_copper", has(ModItems.FANNED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JAGGED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.LONG_SHAPED_COPPER)
                .unlockedBy("has_long_shaped_copper", has(ModItems.LONG_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.JAGGED_SHAPED_COPPER)
                .unlockedBy("has_jagged_shaped_copper", has(ModItems.JAGGED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST.get(), 1)
                .requires(ModTags.Items.SHARPENED_ROCKS)
                .requires(ModItems.THIN_SHAPED_COPPER)
                .unlockedBy("has_thin_shaped_copper",
                        has(ModItems.THIN_SHAPED_COPPER)).save(recipeOutput, "copper_dust_from_shaped_flint");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TIN.get(), 9)
                .requires(ModBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_raw_tin_block", has(ModBlocks.RAW_TIN_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlocks.TIN_BLOCK)).save(recipeOutput);
        List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE);
        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 200, "tin");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 100, "tin");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9)
                .requires(Items.COPPER_INGOT, 1)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .requires(ModItems.COPPER_NUGGET, 9)
                .unlockedBy("has_copper_nugget", has(ModItems.COPPER_NUGGET)).save(recipeOutput);
        List<ItemLike> COPPER_INGOT_SMELTABLES = List.of(ModItems.WIDE_SHAPED_COPPER, ModItems.FANNED_SHAPED_COPPER);
        oreSmelting(recipeOutput, COPPER_INGOT_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 200, "copper");
        oreBlasting(recipeOutput, COPPER_INGOT_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 100, "copper");
        List<ItemLike> COPPER_NUGGET_SMELTABLES = List.of(ModItems.LONG_SHAPED_COPPER, ModItems.JAGGED_SHAPED_COPPER, ModItems.THIN_SHAPED_COPPER, ModItems.COPPER_DUST);
        oreSmelting(recipeOutput, COPPER_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.25f, 200, "copper_nugget");
        oreBlasting(recipeOutput, COPPER_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.25f, 100, "copper_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 9)
                    .requires(Items.OBSIDIAN, 1)
                            .unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OBSIDIAN, 1)
                .requires(ModItems.OBSIDIAN_SHARD, 9)
                .unlockedBy("has_obsidian_shard", has(ModItems.OBSIDIAN_SHARD)).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BOWL_OF_FLAX_SEEDS, 1)
                .requires(Items.BOWL, 1)
                .requires(ModItems.FLAX_SEEDS, 4)
                .unlockedBy("has_flax_seeds", has(ModItems.FLAX_SEEDS)).save(recipeOutput);
        BowlFillingRecipeBuilder.bowlFilling(RecipeCategory.FOOD, ModItems.BOWL_OF_FLAX_SEEDS)
                .requires(ModItems.BOWL_OF_FLAX_SEEDS)
                .requires(ModItems.FLAX_SEEDS, 4)
                .unlockedBy("has_bowl_of_flax_seeds", has(ModItems.BOWL_OF_FLAX_SEEDS)).save(recipeOutput);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPENED_STICK.get(), 1)
                        .requires(ModItems.SHARPENED_ROCK)
                        .requires(ModTags.Items.TIMBER)
                        .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SHARPENED_ROCK.get())
                        .pattern("A ")
                        .pattern(" A")
                        .define('A', ModTags.Items.ROCKS)
                        .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SHARPENED_ROCK.get())
                        .pattern(" A")
                        .pattern("A ")
                        .define('A', ModTags.Items.ROCKS)
                        .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS)).save(recipeOutput, "sharpened_rock_2");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_CRUDE_STONE_TOOL.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModTags.Items.ROCKS)
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_KNIFE.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_FLINT_TOOL.get())
                        .pattern("AB")
                        .pattern("AC")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_SPADE.get())
                        .pattern("AB")
                        .pattern("AC")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', ModItems.WIDE_SHAPED_FLINT)
                        .unlockedBy("has_wide_shaped_flint", has(ModItems.WIDE_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_HATCHET.get())
                        .pattern("AB")
                        .pattern("AC")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', ModItems.FANNED_SHAPED_FLINT)
                        .unlockedBy("has_fanned_shaped_flint", has(ModItems.FANNED_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_PICK.get())
                        .pattern("AB")
                        .pattern("AC")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', ModItems.LONG_SHAPED_FLINT)
                        .unlockedBy("has_long_shaped_flint", has(ModItems.LONG_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_TILL.get())
                        .pattern("AB")
                        .pattern("AC")
                        .define('A', Items.STICK)
                        .define('B', ModItems.VINE)
                        .define('C', ModItems.THIN_SHAPED_FLINT)
                        .unlockedBy("has_thin_shaped_flint", has(ModItems.THIN_SHAPED_FLINT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_CRUDE_COPPER_TOOL.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', Items.RAW_COPPER)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_SPADE.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModItems.WIDE_SHAPED_COPPER)
                .unlockedBy("has_wide_shaped_copper", has(ModItems.WIDE_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_HATCHET.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModItems.FANNED_SHAPED_COPPER)
                .unlockedBy("has_fanned_shaped_copper", has(ModItems.FANNED_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_PICK.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModItems.LONG_SHAPED_COPPER)
                .unlockedBy("has_long_shaped_copper", has(ModItems.LONG_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_KNIFE.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModItems.JAGGED_SHAPED_COPPER)
                .unlockedBy("has_jagged_shaped_copper", has(ModItems.JAGGED_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_TILL.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModItems.THIN_SHAPED_COPPER)
                .unlockedBy("has_thin_shaped_copper", has(ModItems.THIN_SHAPED_COPPER)).save(recipeOutput);

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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.STICK, 2)
                .requires(ModTags.Items.TIMBER)
                .unlockedBy("has_any_timber",
                        has(ModTags.Items.TIMBER)).save(recipeOutput);
        planksFromTimber(recipeOutput, Blocks.OAK_PLANKS, ModItems.OAK_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.SPRUCE_PLANKS, ModItems.SPRUCE_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.BIRCH_PLANKS, ModItems.BIRCH_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.JUNGLE_PLANKS, ModItems.JUNGLE_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.ACACIA_PLANKS, ModItems.ACACIA_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.DARK_OAK_PLANKS, ModItems.DARK_OAK_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.MANGROVE_PLANKS, ModItems.MANGROVE_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, Blocks.CHERRY_PLANKS, ModItems.CHERRY_TIMBER.get(), 1);
        planksFromTimber(recipeOutput, ModBlocks.PALM_PLANKS, ModItems.PALM_TIMBER.get(), 1);

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MUD)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_MUD.get())
                .unlockedBy("has_mud_clump", has(ModItems.CLUMP_OF_MUD)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_SLAB.get(), Blocks.MUD);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_MUD.get())
                .unlockedBy("has_mud_clump", has(ModItems.CLUMP_OF_MUD)).save(recipeOutput, "sscaiderealism:mud_slab_from_clumps");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PACKED_MUD, 1)
                .requires(Blocks.MUD)
                .requires(Items.STICK)
                .requires(ModItems.VINE)
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud_from_stick");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PACKED_MUD, 1)
                .requires(Blocks.MUD)
                .requires(ModItems.VINE)
                .requires(ModItems.VINE)
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud_from_vines");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PACKED_MUD, 1)
                .requires(Blocks.MUD)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING)
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud_from_seeds");

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLAY_SLAB.get(), Blocks.CLAY);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLAY_SLAB.get())
                .pattern("BB")
                .define('B', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL)).save(recipeOutput, "sscaiderealism:clay_slab_from_balls");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.GRAVEL)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModTags.Items.GRAVEL_MATERIALS)
                .unlockedBy("has_gravel_materials", has(ModTags.Items.GRAVEL_MATERIALS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAVEL_SLAB.get(), Blocks.GRAVEL);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAVEL_SLAB.get())
                .pattern("BB")
                .define('B', ModTags.Items.GRAVEL_MATERIALS)
                .unlockedBy("has_gravel_materials", has(ModTags.Items.GRAVEL_MATERIALS)).save(recipeOutput, "sscaiderealism:gravel_slab_from_gravel_materials");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SAND)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PILE_OF_SAND.get())
                .unlockedBy("has_sand_pile", has(ModItems.PILE_OF_SAND)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAND_SLAB.get(), Blocks.SAND);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SAND_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.PILE_OF_SAND.get())
                .unlockedBy("has_sand_pile", has(ModItems.PILE_OF_SAND)).save(recipeOutput, "sscaiderealism:sand_slab_from_piles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SAND)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PILE_OF_RED_SAND.get())
                .unlockedBy("has_red_sand_pile", has(ModItems.PILE_OF_RED_SAND)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SAND_SLAB.get(), Blocks.RED_SAND);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SAND_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.PILE_OF_RED_SAND.get())
                .unlockedBy("has_red_sand_pile", has(ModItems.PILE_OF_RED_SAND)).save(recipeOutput, "sscaiderealism:red_sand_slab_from_piles");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SAND)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PILE_OF_WHITE_SAND.get())
                .unlockedBy("has_white_sand_pile", has(ModItems.PILE_OF_WHITE_SAND)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SAND_SLAB.get(), ModBlocks.WHITE_SAND);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SAND_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.PILE_OF_WHITE_SAND.get())
                .unlockedBy("has_white_sand_pile", has(ModItems.PILE_OF_WHITE_SAND)).save(recipeOutput, "sscaiderealism:white_sand_slab_from_piles");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.DEEPSLATE_ROCK.get())
                .unlockedBy("has_deepslate_rock", has(ModItems.DEEPSLATE_ROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DEEPSLATE_SLAB.get(), Blocks.DEEPSLATE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.COBBLED_DEEPSLATE_SLAB)
                .pattern("BB")
                .define('B', ModItems.DEEPSLATE_ROCK.get())
                .unlockedBy("has_deepslate_rock", has(ModItems.DEEPSLATE_ROCK)).save(recipeOutput, "sscaiderealism:cobbled_deepslate_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.SANDSTONE_ROCK.get())
                .unlockedBy("has_sandstone_rock", has(ModItems.SANDSTONE_ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.SANDSTONE_ROCK.get())
                .unlockedBy("has_sandstone_rock", has(ModItems.SANDSTONE_ROCK)).save(recipeOutput, "sscaiderealism:sandstone_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.RED_SANDSTONE_ROCK.get())
                .unlockedBy("has_red_sandstone_rock", has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.RED_SANDSTONE_ROCK.get())
                .unlockedBy("has_red_sandstone_rock", has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput, "sscaiderealism:red_sandstone_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.GRANITE_ROCK.get())
                .unlockedBy("has_granite_rock", has(ModItems.GRANITE_ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE_SLAB)
                .pattern("BB")
                .define('B', ModItems.GRANITE_ROCK.get())
                .unlockedBy("has_granite_rock", has(ModItems.GRANITE_ROCK)).save(recipeOutput, "sscaiderealism:granite_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.DIORITE_ROCK.get())
                .unlockedBy("has_diorite_rock", has(ModItems.DIORITE_ROCK)).save(recipeOutput, "sscaiderealism:diorite_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE_SLAB)
                .pattern("BB")
                .define('B', ModItems.DIORITE_ROCK.get())
                .unlockedBy("has_diorite_rock", has(ModItems.DIORITE_ROCK)).save(recipeOutput, "sscaiderealism:diorite_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ANDESITE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.ANDESITE_ROCK.get())
                .unlockedBy("has_andesite_rock", has(ModItems.ANDESITE_ROCK)).save(recipeOutput, "sscaiderealism:andesite_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.ANDESITE_SLAB)
                .pattern("BB")
                .define('B', ModItems.ANDESITE_ROCK.get())
                .unlockedBy("has_andesite_rock", has(ModItems.ANDESITE_ROCK)).save(recipeOutput, "sscaiderealism:andesite_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CALCITE_ROCK.get())
                .unlockedBy("has_calcite_rock", has(ModItems.CALCITE_ROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(), Blocks.CALCITE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CALCITE_ROCK.get())
                .unlockedBy("has_calcite_rock", has(ModItems.CALCITE_ROCK)).save(recipeOutput, "sscaiderealism:calcite_slab_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.TUFF_ROCK.get())
                .unlockedBy("has_tuff_rock", has(ModItems.TUFF_ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF_SLAB)
                .pattern("BB")
                .define('B', ModItems.TUFF_ROCK.get())
                .unlockedBy("has_tuff_rock", has(ModItems.TUFF_ROCK)).save(recipeOutput, "sscaiderealism:tuff_slab_from_rocks");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE, 2)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .requires(ModTags.Items.ROCKS)
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS)).save(recipeOutput, "sscaiderealism:cobblestone_from_mixed_rocks");


        //trimSmithing(recipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "kaupen"));
    }

    protected static void planksFromTimber(RecipeOutput recipeOutput, ItemLike planks, Item timber, int resultCount) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, planks, resultCount)
                .pattern("BB")
                .pattern("BB")
                .define('B', timber)
                .group("planks")
                .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER))
                .save(recipeOutput, timber.getId(timber) + "_from_timber");
    }

    protected static void multiBowlFilling(RecipeOutput recipeOutput, MultiConsumableBowlItem bowl, Item ingredient, int ipb) {
        //ipb = Ingredients Per Bowl

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
