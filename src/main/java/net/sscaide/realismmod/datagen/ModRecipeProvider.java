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

import static net.minecraft.data.recipes.SimpleCookingRecipeBuilder.smelting;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

//PETALS & DYE
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE, 2)
                .requires(Items.GREEN_DYE)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_green_dye", has(Items.GREEN_DYE)).save(recipeOutput, "cyan_dye_from_green_lblue");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GRAY_DYE, 3)
                .requires(Items.BLACK_DYE)
                .requires(Items.LIGHT_GRAY_DYE, 2)
                .unlockedBy("has_black_dye", has(Items.BLACK_DYE)).save(recipeOutput, "gray_dye_from_black_lgray");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GREEN_DYE, 2)
                .requires(Items.YELLOW_DYE)
                .requires(Items.BLUE_DYE)
                .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE)).save(recipeOutput, "green_dye_from_yellow_blue");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIME_DYE, 2)
                .requires(Items.YELLOW_DYE)
                .requires(Items.LIGHT_BLUE_DYE)
                .unlockedBy("has_yellow_dye", has(Items.YELLOW_DYE)).save(recipeOutput, "lime_dye_from_yellow_lblue");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE, 3)
                .requires(Items.WHITE_DYE)
                .requires(Items.MAGENTA_DYE, 2)
                .unlockedBy("has_magenta_dye", has(Items.MAGENTA_DYE)).save(recipeOutput, "pink_dye_from_magenta_white");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE, 2)
                .requires(Items.CYAN_DYE)
                .requires(Items.MAGENTA_DYE)
                .unlockedBy("has_cyan_dye", has(Items.CYAN_DYE)).save(recipeOutput, "purple_dye_from_cyan_purple");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_PETALS)
                .requires(Blocks.WITHER_ROSE)
                .unlockedBy("has_wither_rose", has(Blocks.WITHER_ROSE)).save(recipeOutput, "black_dye_from_wither_rose");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUE_PETALS)
                .requires(Blocks.CORNFLOWER)
                .unlockedBy("has_cornflower", has(Blocks.CORNFLOWER)).save(recipeOutput, "blue_dye_from_cornflower");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CYAN_PETALS, 3)
                .requires(Blocks.PITCHER_PLANT)
                .unlockedBy("has_pitcher_plant", has(Blocks.PITCHER_PLANT)).save(recipeOutput, "cyan_dye_from_pitcher_plant");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_BLUE_PETALS, 2)
                .requires(Blocks.BLUE_ORCHID)
                .unlockedBy("has_blue_orchid", has(Blocks.BLUE_ORCHID)).save(recipeOutput, "light_blue_dye_from_blue_orchid");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS, 2)
                .requires(Blocks.AZURE_BLUET)
                .unlockedBy("has_azure_bluet", has(Blocks.AZURE_BLUET)).save(recipeOutput, "light_gray_dye_from_azure_bluet");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS)
                .requires(Blocks.OXEYE_DAISY)
                .unlockedBy("has_oxeye_daisy", has(Blocks.OXEYE_DAISY)).save(recipeOutput, "light_gray_dye_from_oxeye_daisy");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS)
                .requires(Blocks.WHITE_TULIP)
                .unlockedBy("has_white_tulip", has(Blocks.WHITE_TULIP)).save(recipeOutput, "light_gray_dye_from_white_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGENTA_PETALS)
                .requires(Blocks.ALLIUM)
                .unlockedBy("has_allium", has(Blocks.ALLIUM)).save(recipeOutput, "magenta_dye_from_allium");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGENTA_PETALS, 8)
                .requires(Blocks.LILAC)
                .unlockedBy("has_lilac", has(Blocks.LILAC)).save(recipeOutput, "magenta_dye_from_lilac");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORANGE_PETALS)
                .requires(Blocks.ORANGE_TULIP)
                .unlockedBy("has_orange_tulip", has(Blocks.ORANGE_TULIP)).save(recipeOutput, "orange_dye_from_orange_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORANGE_PETALS)
                .requires(Blocks.TORCHFLOWER)
                .unlockedBy("has_torchflower", has(Blocks.TORCHFLOWER)).save(recipeOutput, "orange_dye_from_torchflower");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS)
                .requires(Blocks.PINK_TULIP)
                .unlockedBy("has_pink_tulip", has(Blocks.PINK_TULIP)).save(recipeOutput, "pink_dye_from_pink_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS, 6)
                .requires(Blocks.PEONY)
                .unlockedBy("has_peony", has(Blocks.PEONY)).save(recipeOutput, "pink_dye_from_peony");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS)
                .requires(Blocks.PINK_PETALS)
                .unlockedBy("has_vanilla_pink_petals", has(Blocks.PINK_PETALS)).save(recipeOutput, "pink_dye_from_pink_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS)
                .requires(Blocks.POPPY)
                .unlockedBy("has_poppy", has(Blocks.POPPY)).save(recipeOutput, "red_dye_from_poppy");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS)
                .requires(Blocks.RED_TULIP)
                .unlockedBy("has_red_tulip", has(Blocks.RED_TULIP)).save(recipeOutput, "red_dye_from_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS, 8)
                .requires(Blocks.ROSE_BUSH)
                .unlockedBy("has_rose_bush", has(Blocks.ROSE_BUSH)).save(recipeOutput, "red_dye_from_rose_bush");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WHITE_PETALS, 2)
                .requires(Blocks.LILY_OF_THE_VALLEY)
                .unlockedBy("has_lily_of_the_valley", has(Blocks.LILY_OF_THE_VALLEY)).save(recipeOutput, "white_dye_from_lily_of_the_valley");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YELLOW_PETALS)
                .requires(Blocks.DANDELION)
                .unlockedBy("has_dandelion", has(Blocks.DANDELION)).save(recipeOutput, "yellow_dye_from_dandelion");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YELLOW_PETALS, 2)
                .requires(Blocks.SUNFLOWER)
                .unlockedBy("has_sunflower", has(Blocks.SUNFLOWER)).save(recipeOutput, "yellow_dye_from_sunflower");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLACK_DYE)
                .requires(ModItems.BLACK_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_black_petals", has(ModItems.BLACK_PETALS)).save(recipeOutput, "dye_from_black_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE)
                .requires(ModItems.BLUE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_blue_petals", has(ModItems.BLUE_PETALS)).save(recipeOutput, "dye_from_blue_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModItems.CYAN_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_cyan_petals", has(ModItems.CYAN_PETALS)).save(recipeOutput, "dye_from_cyan_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GRAY_DYE)
                .requires(ModItems.GRAY_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_gray_petals", has(ModItems.GRAY_PETALS)).save(recipeOutput, "dye_from_gray_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE)
                .requires(ModItems.LIGHT_BLUE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_light_blue_petals", has(ModItems.LIGHT_BLUE_PETALS)).save(recipeOutput, "dye_from_light_blue_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_GRAY_DYE)
                .requires(ModItems.LIGHT_GRAY_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_light_gray_petals", has(ModItems.LIGHT_GRAY_PETALS)).save(recipeOutput, "dye_from_light_gray_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .requires(ModItems.MAGENTA_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_magenta_petals", has(ModItems.MAGENTA_PETALS)).save(recipeOutput, "dye_from_magenta_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE)
                .requires(ModItems.ORANGE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_orange_petals", has(ModItems.ORANGE_PETALS)).save(recipeOutput, "dye_from_orange_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE)
                .requires(ModItems.PINK_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_pink_petals", has(ModItems.PINK_PETALS)).save(recipeOutput, "dye_from_pink_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModItems.RED_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_red_petals", has(ModItems.RED_PETALS)).save(recipeOutput, "dye_from_red_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE)
                .requires(ModItems.WHITE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_white_petals", has(ModItems.WHITE_PETALS)).save(recipeOutput, "dye_from_white_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE)
                .requires(ModItems.YELLOW_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .unlockedBy("has_yellow_petals", has(ModItems.YELLOW_PETALS)).save(recipeOutput, "dye_from_yellow_petals");

//MATERIALS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CLUMP_OF_DIRT.get(), 4)
                .requires(Blocks.DIRT)
                .unlockedBy("has_dirt",
                        has(Blocks.DIRT)).save(recipeOutput, "clumps_of_dirt_from_dirt");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CLUMP_OF_MUD.get(), 4)
                .requires(Blocks.MUD)
                .unlockedBy("has_mud",
                        has(Blocks.MUD)).save(recipeOutput, "clumps_of_mud_from_mud");
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CLAY_BRICK.get())
                .pattern("AA")
                .define('A', Items.CLAY_BALL)
                .unlockedBy("has_clay_ball", has(Items.CLAY_BALL)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CLAY_BALL, 4)
                .requires(Blocks.CLAY)
                .unlockedBy("has_clay",
                        has(Blocks.CLAY)).save(recipeOutput, "clay_balls_from_clay");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 4)
                .requires(Blocks.GRAVEL)
                .unlockedBy("has_gravel",
                        has(Blocks.GRAVEL)).save(recipeOutput, "piles_of_gravel_from_gravel");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModTags.Items.ROCKS_NO_SANDSTONE)
                .unlockedBy("has_any_rock",
                        has(ModTags.Items.ROCKS)).save(recipeOutput, "pile_of_gravel_from_rocks");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_SAND.get(), 4)
                .requires(Blocks.SAND)
                .unlockedBy("has_sand",
                        has(Blocks.SAND)).save(recipeOutput, "piles_of_sand_from_sand");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_SAND.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.SANDSTONE_ROCK)
                .unlockedBy("has_sandstone_rock",
                        has(ModItems.SANDSTONE_ROCK)).save(recipeOutput, "pile_of_sand_from_sandstone_rock");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_RED_SAND.get(), 4)
                .requires(Blocks.RED_SAND)
                .unlockedBy("has_red_sand",
                        has(Blocks.RED_SAND)).save(recipeOutput, "piles_of_red_sand_from_red_sand");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_RED_SAND.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.RED_SANDSTONE_ROCK)
                .unlockedBy("has_red_sandstone_rock",
                        has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput, "pile_of_red_sand_from_red_sandstone_rock");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_WHITE_SAND.get(), 4)
                .requires(ModBlocks.WHITE_SAND)
                .unlockedBy("has_white_sand",
                        has(ModBlocks.WHITE_SAND)).save(recipeOutput, "piles_of_white_sand_from_white_sand");


        planksFromCarving(recipeOutput, ModItems.OAK_PLANK.get(), ModItems.OAK_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.SPRUCE_PLANK.get(), ModItems.SPRUCE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.BIRCH_PLANK.get(), ModItems.BIRCH_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.JUNGLE_PLANK.get(), ModItems.JUNGLE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.ACACIA_PLANK.get(), ModItems.ACACIA_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.DARK_OAK_PLANK.get(), ModItems.DARK_OAK_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.MANGROVE_PLANK.get(), ModItems.MANGROVE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.CHERRY_PLANK.get(), ModItems.CHERRY_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.PALM_PLANK.get(), ModItems.PALM_TIMBER.get());

        bricksFromChiseling(recipeOutput, ModItems.ROCK.get(), ModItems.STONE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.DEEPSLATE_ROCK.get(), ModItems.DEEPSLATE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.TUFF_ROCK.get(), ModItems.TUFF_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.BLACKROCK.get(), ModItems.BLACKSTONE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.END_ROCK.get(), ModItems.END_BRICK.get());


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
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(Items.FLINT, 2)
                .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.WIDE_SHAPED_FLINT)
                .unlockedBy("has_wide_shaped_flint", has(ModItems.WIDE_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.FANNED_SHAPED_FLINT)
                .unlockedBy("has_fanned_shaped_flint", has(ModItems.FANNED_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.LONG_SHAPED_FLINT)
                .unlockedBy("has_long_shaped_flint", has(ModItems.LONG_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.THIN_SHAPED_FLINT)
                .unlockedBy("has_thin_shaped_flint",
                        has(ModItems.THIN_SHAPED_FLINT)).save(recipeOutput, "pile_of_gravel_from_shaped_flint");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(Items.RAW_COPPER, 2)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.WIDE_SHAPED_COPPER)
                .unlockedBy("has_wide_shaped_copper", has(ModItems.WIDE_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.FANNED_SHAPED_COPPER)
                .unlockedBy("has_fanned_shaped_copper", has(ModItems.FANNED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JAGGED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.LONG_SHAPED_COPPER)
                .unlockedBy("has_long_shaped_copper", has(ModItems.LONG_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.JAGGED_SHAPED_COPPER)
                .unlockedBy("has_jagged_shaped_copper", has(ModItems.JAGGED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.THIN_SHAPED_COPPER)
                .unlockedBy("has_thin_shaped_copper",
                        has(ModItems.THIN_SHAPED_COPPER)).save(recipeOutput, "copper_dust_from_shaped_copper");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(Items.RAW_IRON, 2)
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.WIDE_SHAPED_IRON)
                .unlockedBy("has_wide_shaped_iron", has(ModItems.WIDE_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.FANNED_SHAPED_IRON)
                .unlockedBy("has_fanned_shaped_iron", has(ModItems.FANNED_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JAGGED_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.LONG_SHAPED_IRON)
                .unlockedBy("has_long_shaped_iron", has(ModItems.LONG_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.JAGGED_SHAPED_IRON)
                .unlockedBy("has_jagged_shaped_iron", has(ModItems.JAGGED_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRON_DUST.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.THIN_SHAPED_IRON)
                .unlockedBy("has_thin_shaped_iron",
                        has(ModItems.THIN_SHAPED_IRON)).save(recipeOutput, "iron_dust_from_shaped_iron");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_TIN.get(), 9)
                .requires(ModBlocks.RAW_TIN_BLOCK)
                .unlockedBy("has_raw_tin_block", has(ModBlocks.RAW_TIN_BLOCK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlocks.TIN_BLOCK)).save(recipeOutput);
        List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 200, "tin");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 100, "tin");

        List<ItemLike> BRICK_SMELTABLES = List.of(ModItems.CLAY_BRICK);
        oreSmelting(recipeOutput, BRICK_SMELTABLES, RecipeCategory.MISC, Items.BRICK, 0.3f, 200, "brick");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET, 9)
                .requires(Items.COPPER_INGOT, 1)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .requires(ModItems.COPPER_NUGGET, 9)
                .unlockedBy("has_copper_nugget", has(ModItems.COPPER_NUGGET)).save(recipeOutput);
        List<ItemLike> COPPER_INGOT_SMELTABLES = List.of(ModItems.WIDE_SHAPED_COPPER, ModItems.FANNED_SHAPED_COPPER);
        oreSmelting(recipeOutput, COPPER_INGOT_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 200, "copper");
        oreBlasting(recipeOutput, COPPER_INGOT_SMELTABLES, RecipeCategory.MISC, Items.COPPER_INGOT, 0.25f, 100, "copper");
        List<ItemLike> COPPER_NUGGET_SMELTABLES = List.of(ModItems.LONG_SHAPED_COPPER, ModItems.JAGGED_SHAPED_COPPER, ModItems.THIN_SHAPED_COPPER, ModItems.COPPER_DUST, ModItems.RAW_COPPER_NUGGET);
        oreSmelting(recipeOutput, COPPER_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.25f, 200, "copper_nugget");
        oreBlasting(recipeOutput, COPPER_NUGGET_SMELTABLES, RecipeCategory.MISC, ModItems.COPPER_NUGGET, 0.25f, 100, "copper_nugget");

        List<ItemLike> IRON_INGOT_SMELTABLES = List.of(ModItems.WIDE_SHAPED_IRON, ModItems.FANNED_SHAPED_IRON);
        oreSmelting(recipeOutput, IRON_INGOT_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 200, "iron");
        oreBlasting(recipeOutput, IRON_INGOT_SMELTABLES, RecipeCategory.MISC, Items.IRON_INGOT, 0.25f, 100, "iron");
        List<ItemLike> IRON_NUGGET_SMELTABLES = List.of(ModItems.LONG_SHAPED_IRON, ModItems.JAGGED_SHAPED_IRON, ModItems.THIN_SHAPED_IRON, ModItems.IRON_DUST, ModItems.RAW_IRON_NUGGET);
        oreSmelting(recipeOutput, IRON_NUGGET_SMELTABLES, RecipeCategory.MISC, Items.IRON_NUGGET, 0.25f, 200, "iron_nugget");
        oreBlasting(recipeOutput, IRON_NUGGET_SMELTABLES, RecipeCategory.MISC, Items.IRON_NUGGET, 0.25f, 100, "iron_nugget");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.OBSIDIAN_SHARD, 9)
                    .requires(Items.OBSIDIAN, 1)
                            .unlockedBy("has_obsidian", has(Items.OBSIDIAN)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OBSIDIAN, 1)
                .requires(ModItems.OBSIDIAN_SHARD, 9)
                .unlockedBy("has_obsidian_shard", has(ModItems.OBSIDIAN_SHARD)).save(recipeOutput);

//FOOD
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BOWL_OF_FLAX_SEEDS, 1)
                .requires(Items.BOWL, 1)
                .requires(ModItems.FLAX_SEEDS, 4)
                .unlockedBy("has_flax_seeds", has(ModItems.FLAX_SEEDS)).save(recipeOutput);
        BowlFillingRecipeBuilder.bowlFilling(RecipeCategory.FOOD, ModItems.BOWL_OF_FLAX_SEEDS)
                .requires(ModItems.BOWL_OF_FLAX_SEEDS)
                .requires(ModItems.FLAX_SEEDS, 4)
                .unlockedBy("has_bowl_of_flax_seeds", has(ModItems.BOWL_OF_FLAX_SEEDS)).save(recipeOutput, "bowl_of_flax_seeds_filling");

//TOOLS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPENED_STICK.get(), 1)
                        .requires(ModTags.Items.CRUDE_SHARPENING_CRAFTING)
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPENED_COPPER_CHUNK.get())
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(Items.RAW_COPPER)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPENED_IRON_CHUNK.get())
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(Items.RAW_IRON)
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_CRUDE_STONE_TOOL.get())
                .pattern("AB")
                .pattern("AC")
                .define('A', Items.STICK)
                .define('B', ModItems.VINE)
                .define('C', ModTags.Items.ROCKS)
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_KNIFE.get())
                        .pattern("CB")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_KNIFE.get())
                        .pattern("C ")
                        .pattern("AB")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput, "flint_knife_2");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_FLINT_TOOL.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_SPADE.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', ModItems.WIDE_SHAPED_FLINT)
                        .unlockedBy("has_wide_shaped_flint", has(ModItems.WIDE_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_HATCHET.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', ModItems.FANNED_SHAPED_FLINT)
                        .unlockedBy("has_fanned_shaped_flint", has(ModItems.FANNED_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_PICK.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', ModItems.LONG_SHAPED_FLINT)
                        .unlockedBy("has_long_shaped_flint", has(ModItems.LONG_SHAPED_FLINT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FLINT_TILL.get())
                        .pattern("BC")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', ModItems.THIN_SHAPED_FLINT)
                        .unlockedBy("has_thin_shaped_flint", has(ModItems.THIN_SHAPED_FLINT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_CRUDE_COPPER_TOOL.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', Items.RAW_COPPER)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_SPADE.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.WIDE_SHAPED_COPPER)
                .unlockedBy("has_wide_shaped_copper", has(ModItems.WIDE_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_HATCHET.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.FANNED_SHAPED_COPPER)
                .unlockedBy("has_fanned_shaped_copper", has(ModItems.FANNED_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_PICK.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.LONG_SHAPED_COPPER)
                .unlockedBy("has_long_shaped_copper", has(ModItems.LONG_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_KNIFE.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.JAGGED_SHAPED_COPPER)
                .unlockedBy("has_jagged_shaped_copper", has(ModItems.JAGGED_SHAPED_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_COPPER_TILL.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.THIN_SHAPED_COPPER)
                .unlockedBy("has_thin_shaped_copper", has(ModItems.THIN_SHAPED_COPPER)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RANDOM_CRUDE_IRON_TOOL.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', Items.RAW_IRON)
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_IRON_SPADE.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.WIDE_SHAPED_IRON)
                .unlockedBy("has_wide_shaped_iron", has(ModItems.WIDE_SHAPED_IRON)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_IRON_HATCHET.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.FANNED_SHAPED_IRON)
                .unlockedBy("has_fanned_shaped_iron", has(ModItems.FANNED_SHAPED_IRON)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_IRON_PICK.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.LONG_SHAPED_IRON)
                .unlockedBy("has_long_shaped_iron", has(ModItems.LONG_SHAPED_IRON)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_IRON_KNIFE.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.JAGGED_SHAPED_IRON)
                .unlockedBy("has_jagged_shaped_iron", has(ModItems.JAGGED_SHAPED_IRON)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CRUDE_IRON_TILL.get())
                .pattern("BC")
                .pattern("A ")
                .define('A', Items.STICK)
                .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .define('C', ModItems.THIN_SHAPED_IRON)
                .unlockedBy("has_thin_shaped_iron", has(ModItems.THIN_SHAPED_IRON)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_SWORD.get())
                        .pattern(" A ")
                        .pattern(" A ")
                        .pattern(" B ")
                        .define('A', Items.COPPER_INGOT)
                        .define('B', Items.STICK)
                        .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.COPPER_DAGGER.get())
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

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.IRON_DAGGER.get())
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.IRON_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_DAGGER.get())
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.DIAMOND)
                .define('B', Items.STICK)
                .unlockedBy("has_diamond", has(Items.DIAMOND)).save(recipeOutput);

        /*ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.NETH.get())
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.COPPER_INGOT)
                .define('B', Items.STICK)
                .unlockedBy("has_copper", has(Items.COPPER_INGOT)).save(recipeOutput);*/


//BLOCKS
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

        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_OAK_BLOCK, ModItems.OAK_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_SPRUCE_BLOCK, ModItems.SPRUCE_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_BIRCH_BLOCK, ModItems.BIRCH_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_JUNGLE_BLOCK, ModItems.JUNGLE_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_ACACIA_BLOCK, ModItems.ACACIA_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_DARK_OAK_BLOCK, ModItems.DARK_OAK_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_MANGROVE_BLOCK, ModItems.MANGROVE_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_CHERRY_BLOCK, ModItems.CHERRY_TIMBER.get(), 1);
        crudeBlocksFromTimber(recipeOutput, ModBlocks.CRUDE_PALM_BLOCK, ModItems.PALM_TIMBER.get(), 1);

        planksFromPlanks(recipeOutput, Blocks.OAK_PLANKS, ModItems.OAK_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.SPRUCE_PLANKS, ModItems.SPRUCE_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.BIRCH_PLANKS, ModItems.BIRCH_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.JUNGLE_PLANKS, ModItems.JUNGLE_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.ACACIA_PLANKS, ModItems.ACACIA_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.DARK_OAK_PLANKS, ModItems.DARK_OAK_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.MANGROVE_PLANKS, ModItems.MANGROVE_PLANK.get());
        planksFromPlanks(recipeOutput, Blocks.CHERRY_PLANKS, ModItems.CHERRY_PLANK.get());
        planksFromPlanks(recipeOutput, ModBlocks.PALM_PLANKS, ModItems.PALM_PLANK.get());

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
                .requires(ModTags.Items.PACKED_MUD_BINDING_AGENTS)
                .requires(ModTags.Items.PACKED_MUD_BINDING_AGENTS)
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud");
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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSS_BLOCK)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_MOSS.get())
                .unlockedBy("has_moss_clump", has(ModItems.CLUMP_OF_MOSS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_SLAB.get(), Blocks.MOSS_BLOCK);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSS_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_MOSS.get())
                .unlockedBy("has_moss_clump", has(ModItems.CLUMP_OF_MOSS)).save(recipeOutput, "sscaiderealism:moss_slab_from_clumps");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SOUL_SOIL)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_SOUL_SOIL.get())
                .unlockedBy("has_soul_soil_clump", has(ModItems.CLUMP_OF_SOUL_SOIL)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SOIL_SLAB.get(), Blocks.SOUL_SOIL);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SOIL_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CLUMP_OF_SOUL_SOIL.get())
                .unlockedBy("has_soul_soil_clump", has(ModItems.CLUMP_OF_SOUL_SOIL)).save(recipeOutput, "sscaiderealism:soul_soil_slab_from_clumps");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SOUL_SAND)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.PILE_OF_SOUL_SAND.get())
                .unlockedBy("has_soul_sand_pile", has(ModItems.PILE_OF_SOUL_SAND)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SAND_SLAB.get(), Blocks.SOUL_SAND);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SAND_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.PILE_OF_SOUL_SAND.get())
                .unlockedBy("has_soul_sand_pile", has(ModItems.PILE_OF_SOUL_SAND)).save(recipeOutput, "sscaiderealism:soul_sand_slab_from_piles");


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
                .unlockedBy("has_sandstone_rock", has(ModItems.SANDSTONE_ROCK)).save(recipeOutput, "sandstone_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.SANDSTONE_ROCK.get())
                .unlockedBy("has_sandstone_rock", has(ModItems.SANDSTONE_ROCK)).save(recipeOutput, "sscaiderealism:sandstone_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.RED_SANDSTONE_ROCK.get())
                .unlockedBy("has_red_sandstone_rock", has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput, "red_sandstone_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.RED_SANDSTONE_ROCK.get())
                .unlockedBy("has_red_sandstone_rock", has(ModItems.RED_SANDSTONE_ROCK)).save(recipeOutput, "sscaiderealism:red_sandstone_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SANDSTONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.WHITE_SANDSTONE_ROCK.get())
                .unlockedBy("has_white_sandstone_rock", has(ModItems.WHITE_SANDSTONE_ROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SANDSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.WHITE_SANDSTONE_ROCK.get())
                .unlockedBy("has_white_sandstone_rock", has(ModItems.WHITE_SANDSTONE_ROCK)).save(recipeOutput, "sscaiderealism:white_sandstone_slab_from_rocks");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_BLOCK)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.DRIPSTONE_ROCK.get())
                .unlockedBy("has_dripstone_rock", has(ModItems.DRIPSTONE_ROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_SLAB.get(), Blocks.DRIPSTONE_BLOCK);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.DRIPSTONE_ROCK.get())
                .unlockedBy("has_dripstone_rock", has(ModItems.DRIPSTONE_ROCK)).save(recipeOutput, "sscaiderealism:dripstone_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.NETHERROCK.get())
                .unlockedBy("has_netherrock", has(ModItems.NETHERROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_SLAB.get(), Blocks.NETHERRACK);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERRACK_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.NETHERROCK.get())
                .unlockedBy("has_netherrock", has(ModItems.NETHERROCK)).save(recipeOutput, "sscaiderealism:netherrack_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BLACKROCK.get())
                .unlockedBy("has_blackrock", has(ModItems.BLACKROCK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE_SLAB)
                .pattern("BB")
                .define('B', ModItems.BLACKROCK.get())
                .unlockedBy("has_blackrock", has(ModItems.BLACKROCK)).save(recipeOutput, "sscaiderealism:blackstone_slab_from_rocks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BASALT_ROCK.get())
                .unlockedBy("has_basalt_rock", has(ModItems.BASALT_ROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_SLAB.get(), Blocks.BASALT);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BASALT_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.BASALT_ROCK.get())
                .unlockedBy("has_basalt_rock", has(ModItems.BASALT_ROCK)).save(recipeOutput, "sscaiderealism:basalt_slab_from_rocks");
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_SLAB.get(), Blocks.SMOOTH_BASALT);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.END_ROCK.get())
                .unlockedBy("has_end_rock", has(ModItems.END_ROCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_SLAB.get(), Blocks.END_STONE);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.END_ROCK.get())
                .unlockedBy("has_end_rock", has(ModItems.END_ROCK)).save(recipeOutput, "sscaiderealism:end_stone_slab_from_rocks");

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


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICKS)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.STONE_BRICK.get())
                .unlockedBy("has_stone_brick", has(ModItems.STONE_BRICK)).save(recipeOutput, "stone_bricks_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.STONE_BRICK_SLAB)
                .pattern("BB")
                .define('B', ModItems.STONE_BRICK.get())
                .unlockedBy("has_stone_brick", has(ModItems.STONE_BRICK)).save(recipeOutput, "sscaiderealism:stone_brick_slab_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICKS)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.DEEPSLATE_BRICK.get())
                .unlockedBy("has_deepslate_brick", has(ModItems.DEEPSLATE_BRICK)).save(recipeOutput, "deepslate_bricks_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE_BRICK_SLAB)
                .pattern("BB")
                .define('B', ModItems.DEEPSLATE_BRICK.get())
                .unlockedBy("has_deepslate_brick", has(ModItems.DEEPSLATE_BRICK)).save(recipeOutput, "sscaiderealism:deepslate_brick_slab_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF_BRICKS)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.TUFF_BRICK.get())
                .unlockedBy("has_tuff_brick", has(ModItems.TUFF_BRICK)).save(recipeOutput, "tuff_bricks_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF_BRICK_SLAB)
                .pattern("BB")
                .define('B', ModItems.TUFF_BRICK.get())
                .unlockedBy("has_tuff_brick", has(ModItems.TUFF_BRICK)).save(recipeOutput, "sscaiderealism:tuff_brick_slab_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICKS)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.BLACKSTONE_BRICK.get())
                .unlockedBy("has_blackstone_brick", has(ModItems.BLACKSTONE_BRICK)).save(recipeOutput, "polished_blackstone_bricks_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BLACKSTONE_BRICK_SLAB)
                .pattern("BB")
                .define('B', ModItems.BLACKSTONE_BRICK.get())
                .unlockedBy("has_blackstone_brick", has(ModItems.BLACKSTONE_BRICK)).save(recipeOutput, "sscaiderealism:blackstone_brick_slab_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICKS)
                .pattern("BB")
                .pattern("BB")
                .define('B', ModItems.END_BRICK.get())
                .unlockedBy("has_end_brick", has(ModItems.END_BRICK)).save(recipeOutput, "end_stone_bricks_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE_BRICK_SLAB)
                .pattern("BB")
                .define('B', ModItems.END_BRICK.get())
                .unlockedBy("has_end_brick", has(ModItems.END_BRICK)).save(recipeOutput, "sscaiderealism:end_stone_brick_slab_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.FURNACE)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .define('A', ModTags.Items.STONE_BRICK_MATERIALS)
                .unlockedBy("has_any_brick", has(ModTags.Items.STONE_BRICK_MATERIALS)).save(recipeOutput, "furnace_from_bricks");

//MISC
        //trimSmithing(recipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "kaupen"));
    }

    protected static void crudeBlocksFromTimber(RecipeOutput recipeOutput, ItemLike planks, Item timber, int resultCount) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, planks, resultCount)
                .pattern("BB")
                .pattern("BB")
                .define('B', timber)
                .group("crude_wood_block")
                .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER))
                .save(recipeOutput,  "crude_wood_block_from_" + timber.getId(timber));
    }
    protected static void planksFromCarving(RecipeOutput recipeOutput, Item plank, Item timber) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, plank, 1)
                .requires(ModTags.Items.CARVING_CRAFTING)
                .requires(timber, 2)
                .group("plankCarving")
                .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER))
                .save(recipeOutput, plank.getId(plank) + "_from_carving_timber");
    }
    protected static void planksFromPlanks(RecipeOutput recipeOutput, ItemLike planks, Item plank) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, planks, 1)
                .pattern("BB")
                .pattern("BB")
                .define('B', plank)
                .group("planks")
                .unlockedBy("has_any_plank", has(ModTags.Items.PLANK_MATERIALS))
                .save(recipeOutput,  "planks_block_from_" + plank.getId(plank));
    }
    protected static void bricksFromChiseling(RecipeOutput recipeOutput, Item rock, Item brick) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, brick, 1)
                .requires(ModTags.Items.CHISEL_CRAFTING)
                .requires(rock, 2)
                .group("rockchiseling")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, brick.getId(brick) + "_from_chiseling_rocks");
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
