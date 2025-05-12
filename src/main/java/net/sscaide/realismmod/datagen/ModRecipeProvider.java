package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
import net.sscaide.realismmod.recipe.builder.AnvilRecipeBuilder;
import net.sscaide.realismmod.recipe.builder.BloomeryRecipeBuilder;
import net.sscaide.realismmod.recipe.builder.BrickFurnaceRecipeBuilder;
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
                .group("petals")
                .unlockedBy("has_wither_rose", has(Blocks.WITHER_ROSE)).save(recipeOutput, "black_dye_from_wither_rose");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUE_PETALS)
                .requires(Blocks.CORNFLOWER)
                .group("petals")
                .unlockedBy("has_cornflower", has(Blocks.CORNFLOWER)).save(recipeOutput, "blue_dye_from_cornflower");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CYAN_PETALS, 3)
                .requires(Blocks.PITCHER_PLANT)
                .group("petals")
                .unlockedBy("has_pitcher_plant", has(Blocks.PITCHER_PLANT)).save(recipeOutput, "cyan_dye_from_pitcher_plant");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_BLUE_PETALS, 2)
                .requires(Blocks.BLUE_ORCHID)
                .group("petals")
                .unlockedBy("has_blue_orchid", has(Blocks.BLUE_ORCHID)).save(recipeOutput, "light_blue_dye_from_blue_orchid");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS, 2)
                .requires(Blocks.AZURE_BLUET)
                .group("petals")
                .unlockedBy("has_azure_bluet", has(Blocks.AZURE_BLUET)).save(recipeOutput, "light_gray_dye_from_azure_bluet");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS)
                .requires(Blocks.OXEYE_DAISY)
                .group("petals")
                .unlockedBy("has_oxeye_daisy", has(Blocks.OXEYE_DAISY)).save(recipeOutput, "light_gray_dye_from_oxeye_daisy");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LIGHT_GRAY_PETALS)
                .requires(Blocks.WHITE_TULIP)
                .group("petals")
                .unlockedBy("has_white_tulip", has(Blocks.WHITE_TULIP)).save(recipeOutput, "light_gray_dye_from_white_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGENTA_PETALS)
                .requires(Blocks.ALLIUM)
                .group("petals")
                .unlockedBy("has_allium", has(Blocks.ALLIUM)).save(recipeOutput, "magenta_dye_from_allium");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MAGENTA_PETALS, 8)
                .requires(Blocks.LILAC)
                .group("petals")
                .unlockedBy("has_lilac", has(Blocks.LILAC)).save(recipeOutput, "magenta_dye_from_lilac");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORANGE_PETALS)
                .requires(Blocks.ORANGE_TULIP)
                .unlockedBy("has_orange_tulip", has(Blocks.ORANGE_TULIP)).save(recipeOutput, "orange_dye_from_orange_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORANGE_PETALS)
                .requires(Blocks.TORCHFLOWER)
                .group("petals")
                .unlockedBy("has_torchflower", has(Blocks.TORCHFLOWER)).save(recipeOutput, "orange_dye_from_torchflower");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS)
                .requires(Blocks.PINK_TULIP)
                .group("petals")
                .unlockedBy("has_pink_tulip", has(Blocks.PINK_TULIP)).save(recipeOutput, "pink_dye_from_pink_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS, 6)
                .requires(Blocks.PEONY)
                .group("petals")
                .unlockedBy("has_peony", has(Blocks.PEONY)).save(recipeOutput, "pink_dye_from_peony");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINK_PETALS)
                .requires(Blocks.PINK_PETALS)
                .group("petals")
                .unlockedBy("has_vanilla_pink_petals", has(Blocks.PINK_PETALS)).save(recipeOutput, "pink_dye_from_pink_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS)
                .requires(Blocks.POPPY)
                .group("petals")
                .unlockedBy("has_poppy", has(Blocks.POPPY)).save(recipeOutput, "red_dye_from_poppy");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS)
                .requires(Blocks.RED_TULIP)
                .group("petals")
                .unlockedBy("has_red_tulip", has(Blocks.RED_TULIP)).save(recipeOutput, "red_dye_from_tulip");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_PETALS, 8)
                .requires(Blocks.ROSE_BUSH)
                .group("petals")
                .unlockedBy("has_rose_bush", has(Blocks.ROSE_BUSH)).save(recipeOutput, "red_dye_from_rose_bush");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WHITE_PETALS, 2)
                .requires(Blocks.LILY_OF_THE_VALLEY)
                .group("petals")
                .unlockedBy("has_lily_of_the_valley", has(Blocks.LILY_OF_THE_VALLEY)).save(recipeOutput, "white_dye_from_lily_of_the_valley");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YELLOW_PETALS)
                .requires(Blocks.DANDELION)
                .group("petals")
                .unlockedBy("has_dandelion", has(Blocks.DANDELION)).save(recipeOutput, "yellow_dye_from_dandelion");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.YELLOW_PETALS, 2)
                .requires(Blocks.SUNFLOWER)
                .group("petals")
                .unlockedBy("has_sunflower", has(Blocks.SUNFLOWER)).save(recipeOutput, "yellow_dye_from_sunflower");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLACK_DYE)
                .requires(ModItems.BLACK_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_black_petals", has(ModItems.BLACK_PETALS)).save(recipeOutput, "dye_from_black_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.BLUE_DYE)
                .requires(ModItems.BLUE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_blue_petals", has(ModItems.BLUE_PETALS)).save(recipeOutput, "dye_from_blue_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModItems.CYAN_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_cyan_petals", has(ModItems.CYAN_PETALS)).save(recipeOutput, "dye_from_cyan_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.GRAY_DYE)
                .requires(ModItems.GRAY_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_gray_petals", has(ModItems.GRAY_PETALS)).save(recipeOutput, "dye_from_gray_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_BLUE_DYE)
                .requires(ModItems.LIGHT_BLUE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_light_blue_petals", has(ModItems.LIGHT_BLUE_PETALS)).save(recipeOutput, "dye_from_light_blue_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.LIGHT_GRAY_DYE)
                .requires(ModItems.LIGHT_GRAY_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_light_gray_petals", has(ModItems.LIGHT_GRAY_PETALS)).save(recipeOutput, "dye_from_light_gray_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .requires(ModItems.MAGENTA_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_magenta_petals", has(ModItems.MAGENTA_PETALS)).save(recipeOutput, "dye_from_magenta_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.ORANGE_DYE)
                .requires(ModItems.ORANGE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_orange_petals", has(ModItems.ORANGE_PETALS)).save(recipeOutput, "dye_from_orange_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PINK_DYE)
                .requires(ModItems.PINK_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_pink_petals", has(ModItems.PINK_PETALS)).save(recipeOutput, "dye_from_pink_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModItems.RED_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_red_petals", has(ModItems.RED_PETALS)).save(recipeOutput, "dye_from_red_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE)
                .requires(ModItems.WHITE_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
                .unlockedBy("has_white_petals", has(ModItems.WHITE_PETALS)).save(recipeOutput, "dye_from_white_petals");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE)
                .requires(ModItems.YELLOW_PETALS, 2)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .group("dyes_from_petals")
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


        planksFromCarving(recipeOutput, ModItems.OAK_BOARD.get(), ModItems.OAK_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.SPRUCE_BOARD.get(), ModItems.SPRUCE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.BIRCH_BOARD.get(), ModItems.BIRCH_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.JUNGLE_BOARD.get(), ModItems.JUNGLE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.ACACIA_BOARD.get(), ModItems.ACACIA_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.DARK_OAK_BOARD.get(), ModItems.DARK_OAK_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.MANGROVE_BOARD.get(), ModItems.MANGROVE_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.CHERRY_BOARD.get(), ModItems.CHERRY_TIMBER.get());
        planksFromCarving(recipeOutput, ModItems.PALM_BOARD.get(), ModItems.PALM_TIMBER.get());

        bricksFromChiseling(recipeOutput, ModItems.ROCK.get(), ModItems.STONE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.DEEPSLATE_ROCK.get(), ModItems.DEEPSLATE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.TUFF_ROCK.get(), ModItems.TUFF_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.BLACKROCK.get(), ModItems.BLACKSTONE_BRICK.get());
        bricksFromChiseling(recipeOutput, ModItems.END_ROCK.get(), ModItems.END_BRICK.get());


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROCK.get(), 4)
                .requires(ModTags.Items.COBBLESTONE_REPLACE)
                .group("rocks")
                .unlockedBy("has_cobblestone",
                        has(ModTags.Items.COBBLESTONE_REPLACE)).save(recipeOutput, "rocks_from_cobblestone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROCK.get(), 3)
                .requires(ModTags.Items.COBBLESTONE_REPLACE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobblestone_stairs",
                        has(ModTags.Items.COBBLESTONE_REPLACE_STAIRS)).save(recipeOutput, "rocks_from_cobblestone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ROCK.get(), 2)
                .requires(ModTags.Items.COBBLESTONE_REPLACE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobblestone_slab",
                        has(ModTags.Items.COBBLESTONE_REPLACE_SLAB)).save(recipeOutput, "rocks_from_cobblestone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEEPSLATE_ROCK.get(), 4)
                .requires(ModTags.Items.DEEPSLATE_REPLACE)
                .group("rocks")
                .unlockedBy("has_cobbled_deepslate",
                        has(ModTags.Items.DEEPSLATE_REPLACE)).save(recipeOutput, "deepslate_rocks_from_cobbled_deepslate");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEEPSLATE_ROCK.get(), 3)
                .requires(ModTags.Items.DEEPSLATE_REPLACE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_deepslate_stairs",
                        has(ModTags.Items.DEEPSLATE_REPLACE_STAIRS)).save(recipeOutput, "deepslate_rocks_from_cobbled_deepslate_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DEEPSLATE_ROCK.get(), 2)
                .requires(ModTags.Items.DEEPSLATE_REPLACE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_deepslate_slab",
                        has(ModTags.Items.DEEPSLATE_REPLACE_SLAB)).save(recipeOutput, "deepslate_rocks_from_cobbled_deepslate_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SANDSTONE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_SANDSTONE)
                .group("rocks")
                .unlockedBy("has_cobbled_sandstone",
                        has(ModBlocks.COBBLED_SANDSTONE)).save(recipeOutput, "sandstone_rocks_from_sandstone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SANDSTONE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_SANDSTONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_sandstone_stairs",
                        has(ModBlocks.COBBLED_SANDSTONE_STAIRS)).save(recipeOutput, "sandstone_rocks_from_sandstone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SANDSTONE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_SANDSTONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_sandstone_slab",
                        has(ModBlocks.COBBLED_SANDSTONE_SLAB)).save(recipeOutput, "sandstone_rocks_from_sandstone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_SANDSTONE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_SANDSTONE)
                .group("rocks")
                .unlockedBy("has_cobbled_red_sandstone",
                        has(ModBlocks.COBBLED_SANDSTONE)).save(recipeOutput, "red_sandstone_rocks_from_red_sandstone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_SANDSTONE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_RED_SANDSTONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_red_sandstone_stairs",
                        has(ModBlocks.COBBLED_RED_SANDSTONE_STAIRS)).save(recipeOutput, "red_sandstone_rocks_from_red_sandstone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RED_SANDSTONE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_RED_SANDSTONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_red_sandstone_slab",
                        has(ModBlocks.COBBLED_RED_SANDSTONE_SLAB)).save(recipeOutput, "red_sandstone_rocks_from_red_sandstone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WHITE_SANDSTONE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_WHITE_SANDSTONE)
                .group("rocks")
                .unlockedBy("has_cobbled_white_sandstone",
                        has(ModBlocks.COBBLED_WHITE_SANDSTONE)).save(recipeOutput, "white_sandstone_rocks_from_white_sandstone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WHITE_SANDSTONE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_WHITE_SANDSTONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_white_sandstone_stairs",
                        has(ModBlocks.COBBLED_WHITE_SANDSTONE_STAIRS)).save(recipeOutput, "white_sandstone_rocks_from_white_sandstone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WHITE_SANDSTONE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_white_sandstone_slab",
                        has(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB)).save(recipeOutput, "white_sandstone_rocks_from_white_sandstone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANITE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_GRANITE)
                .group("rocks")
                .unlockedBy("has_cobbled_granite",
                        has(ModBlocks.COBBLED_GRANITE)).save(recipeOutput, "granite_rocks_from_granite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANITE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_GRANITE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_granite_stairs",
                        has(ModBlocks.COBBLED_GRANITE_STAIRS)).save(recipeOutput, "granite_rocks_from_granite_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRANITE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_GRANITE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_granite_slab",
                        has(ModBlocks.COBBLED_GRANITE_SLAB)).save(recipeOutput, "granite_rocks_from_granite_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIORITE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_DIORITE)
                .group("rocks")
                .unlockedBy("has_cobbled_diorite",
                        has(ModBlocks.COBBLED_DIORITE)).save(recipeOutput, "diorite_rocks_from_diorite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIORITE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_DIORITE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_diorite_stairs",
                        has(ModBlocks.COBBLED_DIORITE_STAIRS)).save(recipeOutput, "diorite_rocks_from_diorite_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIORITE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_DIORITE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_diorite_slab",
                        has(ModBlocks.COBBLED_DIORITE_SLAB)).save(recipeOutput, "diorite_rocks_from_diorite_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANDESITE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_ANDESITE)
                .group("rocks")
                .unlockedBy("has_cobbled_andesite",
                        has(ModBlocks.COBBLED_ANDESITE)).save(recipeOutput, "andesite_rocks_from_andesite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANDESITE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_ANDESITE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_andesite_stairs",
                        has(ModBlocks.COBBLED_ANDESITE_STAIRS)).save(recipeOutput, "andesite_rocks_from_andesite_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ANDESITE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_ANDESITE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_andesite_slab",
                        has(ModBlocks.COBBLED_ANDESITE_SLAB)).save(recipeOutput, "andesite_rocks_from_andesite_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CALCITE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_CALCITE)
                .group("rocks")
                .unlockedBy("has_cobbled_calcite",
                        has(ModBlocks.COBBLED_CALCITE)).save(recipeOutput, "calcite_rocks_from_calcite");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CALCITE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_CALCITE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_calcite_stairs",
                        has(ModBlocks.COBBLED_CALCITE_STAIRS)).save(recipeOutput, "calcite_rocks_from_calcite_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CALCITE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_CALCITE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_calcite_slab",
                        has(ModBlocks.COBBLED_CALCITE_SLAB)).save(recipeOutput, "calcite_rocks_from_calcite_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUFF_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_TUFF)
                .group("rocks")
                .unlockedBy("has_cobbled_tuff",
                        has(ModBlocks.COBBLED_TUFF)).save(recipeOutput, "tuff_rocks_from_tuff");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUFF_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_TUFF_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_tuff_stairs",
                        has(ModBlocks.COBBLED_TUFF_STAIRS)).save(recipeOutput, "tuff_rocks_from_tuff_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TUFF_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_TUFF_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_tuff_slab",
                        has(ModBlocks.COBBLED_TUFF_SLAB)).save(recipeOutput, "tuff_rocks_from_tuff_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DRIPSTONE_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_DRIPSTONE)
                .group("rocks")
                .unlockedBy("has_cobbled_dripstone",
                        has(ModBlocks.COBBLED_DRIPSTONE)).save(recipeOutput, "dripstone_rocks_from_dripstone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DRIPSTONE_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_DRIPSTONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_dripstone_stairs",
                        has(ModBlocks.COBBLED_DRIPSTONE_STAIRS)).save(recipeOutput, "dripstone_rocks_from_dripstone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DRIPSTONE_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_DRIPSTONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_dripstone_slab",
                        has(ModBlocks.COBBLED_DRIPSTONE_SLAB)).save(recipeOutput, "dripstone_rocks_from_dripstone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERROCK.get(), 4)
                .requires(ModBlocks.COBBLED_NETHERRACK)
                .group("rocks")
                .unlockedBy("has_cobbled_netherrack",
                        has(ModBlocks.COBBLED_NETHERRACK)).save(recipeOutput, "netherrocks_from_netherrack");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERROCK.get(), 3)
                .requires(ModBlocks.COBBLED_NETHERRACK_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_NETHERRACK_stairs",
                        has(ModBlocks.COBBLED_NETHERRACK_STAIRS)).save(recipeOutput, "netherrocks_from_netherrack_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NETHERROCK.get(), 2)
                .requires(ModBlocks.COBBLED_NETHERRACK_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_NETHERRACK_slab",
                        has(ModBlocks.COBBLED_NETHERRACK_SLAB)).save(recipeOutput, "netherrocks_from_netherrack_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACKROCK.get(), 4)
                .requires(ModBlocks.COBBLED_BLACKSTONE)
                .group("rocks")
                .unlockedBy("has_cobbled_blackstone",
                        has(ModBlocks.COBBLED_BLACKSTONE)).save(recipeOutput, "blackrocks_from_blackstone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACKROCK.get(), 3)
                .requires(ModBlocks.COBBLED_BLACKSTONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_blackstone_stairs",
                        has(ModBlocks.COBBLED_BLACKSTONE_STAIRS)).save(recipeOutput, "blackrocks_from_blackstone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACKROCK.get(), 2)
                .requires(ModBlocks.COBBLED_BLACKSTONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_blackstone_slab",
                        has(ModBlocks.COBBLED_BLACKSTONE_SLAB)).save(recipeOutput, "blackrocks_from_blackstone_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BASALT_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_BASALT)
                .group("rocks")
                .unlockedBy("has_cobbled_basalt",
                        has(ModBlocks.COBBLED_BASALT)).save(recipeOutput, "basalt_rocks_from_basalt");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BASALT_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_BASALT_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_basalt_stairs",
                        has(ModBlocks.COBBLED_BASALT_STAIRS)).save(recipeOutput, "basalt_rocks_from_basalt_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BASALT_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_BASALT_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_basalt_slab",
                        has(ModBlocks.COBBLED_BASALT_SLAB)).save(recipeOutput, "basalt_rocks_from_basalt_slab");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.END_ROCK.get(), 4)
                .requires(ModBlocks.COBBLED_END_STONE)
                .group("rocks")
                .unlockedBy("has_cobbled_end_stone",
                        has(ModBlocks.COBBLED_END_STONE)).save(recipeOutput, "end_rocks_from_end_stone");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.END_ROCK.get(), 3)
                .requires(ModBlocks.COBBLED_END_STONE_STAIRS)
                .group("rocks")
                .unlockedBy("has_cobbled_end_stone",
                        has(ModBlocks.COBBLED_END_STONE_STAIRS)).save(recipeOutput, "end_rocks_from_end_stone_stairs");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.END_ROCK.get(), 2)
                .requires(ModBlocks.COBBLED_END_STONE_SLAB)
                .group("rocks")
                .unlockedBy("has_cobbled_end_stone",
                        has(ModBlocks.COBBLED_END_STONE_SLAB)).save(recipeOutput, "end_rocks_from_end_stone_slab");


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SHORT_HAFT.get(), 2)
                .requires(ModTags.Items.CRUDE_SHARPENING_CRAFTING)
                .requires(Items.STICK, 1)
                .group("short_haft")
                .unlockedBy("has_stick", has(Items.STICK)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SHORT_HAFT.get(), 2)
                .requires(ModTags.Items.CRUDE_CARVING_CRAFTING)
                .requires(Items.STICK, 1)
                .group("short_haft")
                .unlockedBy("has_stick", has(Items.STICK)).save(recipeOutput, "short_haft_2");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(Items.FLINT, 1)
                .group("flint_shaping")
                .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.WIDE_SHAPED_FLINT)
                .group("flint_shaping")
                .unlockedBy("has_wide_shaped_flint", has(ModItems.WIDE_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.FANNED_SHAPED_FLINT)
                .group("flint_shaping")
                .unlockedBy("has_fanned_shaped_flint", has(ModItems.FANNED_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_FLINT.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.LONG_SHAPED_FLINT)
                .group("flint_shaping")
                .unlockedBy("has_long_shaped_flint", has(ModItems.LONG_SHAPED_FLINT)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PILE_OF_GRAVEL.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.THIN_SHAPED_FLINT)
                .group("flint_shaping")
                .unlockedBy("has_thin_shaped_flint",
                        has(ModItems.THIN_SHAPED_FLINT)).save(recipeOutput, "pile_of_gravel_from_shaped_flint");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(Items.RAW_COPPER, 1)
                .group("copper_shaping")
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.WIDE_SHAPED_COPPER)
                .group("copper_shaping")
                .unlockedBy("has_wide_shaped_copper", has(ModItems.WIDE_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.FANNED_SHAPED_COPPER)
                .group("copper_shaping")
                .unlockedBy("has_fanned_shaped_copper", has(ModItems.FANNED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JAGGED_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.LONG_SHAPED_COPPER)
                .group("copper_shaping")
                .unlockedBy("has_long_shaped_copper", has(ModItems.LONG_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_COPPER.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.JAGGED_SHAPED_COPPER)
                .group("copper_shaping")
                .unlockedBy("has_jagged_shaped_copper", has(ModItems.JAGGED_SHAPED_COPPER)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_DUST.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(ModItems.THIN_SHAPED_COPPER)
                .group("copper_shaping")
                .unlockedBy("has_thin_shaped_copper",
                        has(ModItems.THIN_SHAPED_COPPER)).save(recipeOutput, "copper_dust_from_shaped_copper");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WIDE_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(Items.RAW_IRON, 1)
                .group("iron_shaping")
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.FANNED_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.WIDE_SHAPED_IRON)
                .group("iron_shaping")
                .unlockedBy("has_wide_shaped_iron", has(ModItems.WIDE_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LONG_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.FANNED_SHAPED_IRON)
                .group("iron_shaping")
                .unlockedBy("has_fanned_shaped_iron", has(ModItems.FANNED_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JAGGED_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.LONG_SHAPED_IRON)
                .group("iron_shaping")
                .unlockedBy("has_long_shaped_iron", has(ModItems.LONG_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.THIN_SHAPED_IRON.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.JAGGED_SHAPED_IRON)
                .group("iron_shaping")
                .unlockedBy("has_jagged_shaped_iron", has(ModItems.JAGGED_SHAPED_IRON)).save(recipeOutput);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.IRON_DUST.get(), 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .requires(ModItems.THIN_SHAPED_IRON)
                .group("iron_shaping")
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

//TOOLS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.TOOLS, ModItems.SHARPENED_STICK.get(), 1)
                        .requires(ModTags.Items.CRUDE_SHARPENING_CRAFTING)
                        .requires(ModTags.Items.TIMBER)
                        .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FIRE_PLOUGH.get())
                        .pattern("A ")
                        .pattern(" A")
                        .define('A', Items.STICK).group("fire_plough")
                        .unlockedBy("has_stick", has(Items.STICK)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.FIRE_PLOUGH.get())
                        .pattern(" A")
                        .pattern("A ")
                        .define('A', Items.STICK).group("fire_plough")
                        .unlockedBy("has_stick", has(Items.STICK)).save(recipeOutput, "fire_plough_2");
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BOW_DRILL.get())
                        .pattern("AB")
                        .pattern(" A")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.STRINGS).group("bow_drill")
                        .unlockedBy("has_any_string", has(ModTags.Items.STRINGS)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BOW_DRILL.get())
                        .pattern("BA")
                        .pattern("A ")
                        .define('A', Items.STICK)
                        .define('B', ModTags.Items.STRINGS).group("bow_drill")
                        .unlockedBy("has_any_string", has(Items.STRING)).save(recipeOutput, "bow_drill_2");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SHARPENED_COPPER_CHUNK.get())
                .pattern("A ")
                .pattern(" B")
                .define('A', ModTags.Items.CRUSHING_CRAFTING)
                .define('B', Items.RAW_COPPER)
                .unlockedBy("has_raw_copper", has(Items.RAW_COPPER)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.SHARPENED_IRON_CHUNK.get())
                .pattern("A ")
                .pattern(" B")
                .define('A', ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .define('B', Items.RAW_IRON)
                .unlockedBy("has_raw_iron", has(Items.RAW_IRON)).save(recipeOutput);

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
                        .define('A', ModItems.SHORT_HAFT)
                        .define('B', ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                        .define('C', Items.FLINT)
                        .unlockedBy("has_flint", has(Items.FLINT)).save(recipeOutput);
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
                .define('A', ModItems.SHORT_HAFT)
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
                .define('A', ModItems.SHORT_HAFT)
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

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.COPPER_CHISEL)
                        .pattern(" A")
                        .pattern("B ")
                        .define('A', ModItems.COPPER_NUGGET).define('B', ModItems.SHORT_HAFT)
                        .unlockedBy("has_copper_nugget", has(ModItems.COPPER_NUGGET)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.GOLD_CHISEL)
                        .pattern(" A")
                        .pattern("B ")
                        .define('A', Items.GOLD_NUGGET).define('B', ModItems.SHORT_HAFT)
                        .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.IRON_CHISEL)
                        .pattern(" A")
                        .pattern("B ")
                        .define('A', Items.IRON_NUGGET).define('B', ModItems.SHORT_HAFT)
                        .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DIAMOND_CHISEL)
                        .pattern(" A")
                        .pattern("B ")
                        .define('A', Items.DIAMOND).define('B', ModItems.SHORT_HAFT)
                        .unlockedBy("has_diamond_shard", has(Items.DIAMOND)).save(recipeOutput);

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
                        .define('B', ModItems.SHORT_HAFT)
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
                .define('B', ModItems.SHORT_HAFT)
                .unlockedBy("has_iron", has(Items.IRON_INGOT)).save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DIAMOND_DAGGER.get())
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.DIAMOND)
                .define('B', ModItems.SHORT_HAFT)
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

        planksFromPlanks(recipeOutput, Blocks.OAK_PLANKS, ModItems.OAK_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.SPRUCE_PLANKS, ModItems.SPRUCE_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.BIRCH_PLANKS, ModItems.BIRCH_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.JUNGLE_PLANKS, ModItems.JUNGLE_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.ACACIA_PLANKS, ModItems.ACACIA_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.DARK_OAK_PLANKS, ModItems.DARK_OAK_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.MANGROVE_PLANKS, ModItems.MANGROVE_BOARD.get());
        planksFromPlanks(recipeOutput, Blocks.CHERRY_PLANKS, ModItems.CHERRY_BOARD.get());
        planksFromPlanks(recipeOutput, ModBlocks.PALM_PLANKS, ModItems.PALM_BOARD.get());

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
                .requires(ModTags.Items.PACKED_MUD_BINDING_AGENTS).group("packed_mud")
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PACKED_MUD, 1)
                .requires(Blocks.MUD)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING)
                .requires(ModTags.Items.SEEDS_FOR_CRAFTING).group("packed_mud")
                .unlockedBy("has_mud", has(Blocks.MUD)).save(recipeOutput, "sscaiderealism:packed_mud_from_seeds");

        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLAY_SLAB.get(), Blocks.CLAY);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CLAY_SLAB.get())
                .pattern("BB")
                .define('B', ModItems.CLAY_BRICK)
                .unlockedBy("has_clay_brick", has(ModItems.CLAY_BRICK)).save(recipeOutput, "sscaiderealism:clay_slab_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_SLAB)
                .pattern("BB")
                .define('B', Items.BRICK)
                .unlockedBy("has_brick", has(Items.BRICK)).save(recipeOutput, "sscaiderealism:brick_slab_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_STAIRS)
                .pattern("B ")
                .pattern("BB")
                .define('B', Items.BRICK)
                .unlockedBy("has_brick", has(Items.BRICK)).save(recipeOutput, "sscaiderealism:brick_stairs_from_bricks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_STAIRS)
                .pattern(" B")
                .pattern("BB")
                .define('B', Items.BRICK)
                .unlockedBy("has_brick", has(Items.BRICK)).save(recipeOutput, "sscaiderealism:brick_stairs_from_bricks_2");

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


        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.MOD_COBBLESTONE.get(), ModItems.ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.MOD_COBBLED_DEEPSLATE.get(), ModItems.DEEPSLATE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_SANDSTONE.get(), ModItems.SANDSTONE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_RED_SANDSTONE.get(), ModItems.RED_SANDSTONE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_WHITE_SANDSTONE.get(), ModItems.WHITE_SANDSTONE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_GRANITE.get(), ModItems.GRANITE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_DIORITE.get(), ModItems.DIORITE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_ANDESITE.get(), ModItems.ANDESITE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_CALCITE.get(), ModItems.CALCITE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_TUFF.get(), ModItems.TUFF_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_DRIPSTONE.get(), ModItems.DRIPSTONE_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_NETHERRACK.get(), ModItems.NETHERROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_BLACKSTONE.get(), ModItems.BLACKROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_BASALT.get(), ModItems.BASALT_ROCK.get());
        cobblestoneBlocksFromRocks(recipeOutput, ModBlocks.COBBLED_END_STONE.get(), ModItems.END_ROCK.get());

        List<ItemLike> COBBLESTONE_SMELTING = List.of(ModBlocks.MOD_COBBLESTONE, ModBlocks.CRACKED_STONE);
        oreSmelting(recipeOutput, COBBLESTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.STONE, 0.0f, 200, "stone");
        List<ItemLike> DEEPSLATE_SMELTING = List.of(ModBlocks.MOD_COBBLED_DEEPSLATE, ModBlocks.CRACKED_DEEPSLATE);
        oreSmelting(recipeOutput, DEEPSLATE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.DEEPSLATE, 0.0f, 200, "deepslate");
        List<ItemLike> SANDSTONE_SMELTING = List.of(ModBlocks.COBBLED_SANDSTONE);
        oreSmelting(recipeOutput, SANDSTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.SANDSTONE, 0.0f, 200, "sandstone");
        List<ItemLike> RED_SANDSTONE_SMELTING = List.of(ModBlocks.COBBLED_RED_SANDSTONE);
        oreSmelting(recipeOutput, RED_SANDSTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.RED_SANDSTONE, 0.0f, 200, "red_sandstone");
        List<ItemLike> WHITE_SANDSTONE_SMELTING = List.of(ModBlocks.COBBLED_WHITE_SANDSTONE);
        oreSmelting(recipeOutput, WHITE_SANDSTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SANDSTONE, 0.0f, 200, "white_sandstone");
        List<ItemLike> GRANITE_SMELTING = List.of(ModBlocks.COBBLED_GRANITE, ModBlocks.CRACKED_GRANITE);
        oreSmelting(recipeOutput, GRANITE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE, 0.0f, 200, "granite");
        List<ItemLike> DIORITE_SMELTING = List.of(ModBlocks.COBBLED_DIORITE, ModBlocks.CRACKED_DIORITE);
        oreSmelting(recipeOutput, DIORITE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE, 0.0f, 200, "diorite");
        List<ItemLike> ANDESITE_SMELTING = List.of(ModBlocks.COBBLED_ANDESITE, ModBlocks.CRACKED_ANDESITE);
        oreSmelting(recipeOutput, ANDESITE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.ANDESITE, 0.0f, 200, "andesite");
        List<ItemLike> CALCITE_SMELTING = List.of(ModBlocks.COBBLED_CALCITE, ModBlocks.CRACKED_CALCITE);
        oreSmelting(recipeOutput, CALCITE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE, 0.0f, 200, "calcite");
        List<ItemLike> TUFF_SMELTING = List.of(ModBlocks.COBBLED_TUFF, ModBlocks.CRACKED_TUFF);
        oreSmelting(recipeOutput, TUFF_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF, 0.0f, 200, "tuff");
        List<ItemLike> DRIPSTONE_SMELTING = List.of(ModBlocks.COBBLED_DRIPSTONE, ModBlocks.CRACKED_DRIPSTONE);
        oreSmelting(recipeOutput, DRIPSTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_BLOCK, 0.0f, 200, "dripstone");
        List<ItemLike> NETHERRACK_SMELTING = List.of(ModBlocks.COBBLED_NETHERRACK);
        oreSmelting(recipeOutput, NETHERRACK_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHERRACK, 0.0f, 200, "netherrack");
        List<ItemLike> BLACKSTONE_SMELTING = List.of(ModBlocks.COBBLED_BLACKSTONE);
        oreSmelting(recipeOutput, BLACKSTONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE, 0.0f, 200, "blackstone");
        List<ItemLike> BASALT_SMELTING = List.of(ModBlocks.COBBLED_BASALT, ModBlocks.CRACKED_BASALT);
        oreSmelting(recipeOutput, BASALT_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.BASALT, 0.0f, 200, "basalt");
        List<ItemLike> END_STONE_SMELTING = List.of(ModBlocks.COBBLED_END_STONE);
        oreSmelting(recipeOutput, END_STONE_SMELTING, RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE, 0.0f, 200, "end_stone");

        crackedStoneFromCrushing(recipeOutput, Blocks.STONE, ModBlocks.CRACKED_STONE);
        crackedStoneFromCrushing(recipeOutput, Blocks.DEEPSLATE, ModBlocks.CRACKED_DEEPSLATE);
        crackedStoneFromCrushing(recipeOutput, Blocks.GRANITE, ModBlocks.CRACKED_GRANITE);
        crackedStoneFromCrushing(recipeOutput, Blocks.DIORITE, ModBlocks.CRACKED_DIORITE);
        crackedStoneFromCrushing(recipeOutput, Blocks.ANDESITE, ModBlocks.CRACKED_ANDESITE);
        crackedStoneFromCrushing(recipeOutput, Blocks.CALCITE, ModBlocks.CRACKED_CALCITE);
        crackedStoneFromCrushing(recipeOutput, Blocks.TUFF, ModBlocks.CRACKED_TUFF);
        crackedStoneFromCrushing(recipeOutput, Blocks.DRIPSTONE_BLOCK, ModBlocks.CRACKED_DRIPSTONE);
        crackedStoneFromCrushing(recipeOutput, Blocks.BASALT, ModBlocks.CRACKED_BASALT);
        crackedStoneFromCrushing(recipeOutput, Blocks.END_STONE, ModBlocks.CRACKED_END_STONE);

        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_STONE, ModBlocks.MOD_COBBLESTONE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_DEEPSLATE, ModBlocks.MOD_COBBLED_DEEPSLATE);
        cobblestoneFromCrushing(recipeOutput, Blocks.SANDSTONE, ModBlocks.COBBLED_SANDSTONE);
        cobblestoneFromCrushing(recipeOutput, Blocks.RED_SANDSTONE, ModBlocks.COBBLED_RED_SANDSTONE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.WHITE_SANDSTONE, ModBlocks.COBBLED_WHITE_SANDSTONE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_GRANITE, ModBlocks.COBBLED_GRANITE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_DIORITE, ModBlocks.COBBLED_DIORITE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_ANDESITE, ModBlocks.COBBLED_ANDESITE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_CALCITE, ModBlocks.COBBLED_CALCITE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_TUFF, ModBlocks.COBBLED_TUFF);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_DRIPSTONE, ModBlocks.COBBLED_DRIPSTONE);
        cobblestoneFromCrushing(recipeOutput, Blocks.NETHERRACK, ModBlocks.COBBLED_NETHERRACK);
        cobblestoneFromCrushing(recipeOutput, Blocks.BLACKSTONE, ModBlocks.COBBLED_BLACKSTONE);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_BASALT, ModBlocks.COBBLED_BASALT);
        cobblestoneFromCrushing(recipeOutput, ModBlocks.CRACKED_END_STONE, ModBlocks.COBBLED_END_STONE);

        blockFromSlabs(recipeOutput, Blocks.DIRT);
        blockFromSlabs(recipeOutput, Blocks.MUD);
        blockFromSlabs(recipeOutput, Blocks.CLAY);
        blockFromSlabs(recipeOutput, Blocks.GRAVEL);
        blockFromSlabs(recipeOutput, Blocks.SAND);
        blockFromSlabs(recipeOutput, Blocks.RED_SAND);
        blockFromSlabs(recipeOutput, ModBlocks.WHITE_SAND.get());
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.MOSS_BLOCK, 1)
                .pattern("A")
                .pattern("A")
                .define('A', ModBlocks.MOSS_SLAB)
                .unlockedBy("has_moss_slab", has(ModBlocks.MOSS_SLAB))
                .save(recipeOutput, "moss_from_slabs");
        blockFromSlabs(recipeOutput, Blocks.SOUL_SOIL);
        blockFromSlabs(recipeOutput, Blocks.SOUL_SAND);
        blockFromSlabs(recipeOutput, ModBlocks.MOD_COBBLESTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.MOD_COBBLED_DEEPSLATE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_SANDSTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_RED_SANDSTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_WHITE_SANDSTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_GRANITE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_DIORITE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_ANDESITE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_CALCITE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_TUFF.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_DRIPSTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_NETHERRACK.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_BLACKSTONE.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_BASALT.get());
        blockFromSlabs(recipeOutput, ModBlocks.COBBLED_END_STONE.get());

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

        blockChiseling(recipeOutput, Blocks.COPPER_BLOCK, Blocks.CHISELED_COPPER);
        blockChiseling(recipeOutput, Blocks.DEEPSLATE_BRICKS, Blocks.CHISELED_DEEPSLATE);
        blockChiseling(recipeOutput, Blocks.NETHER_BRICKS, Blocks.CHISELED_NETHER_BRICKS);
        blockChiseling(recipeOutput, Blocks.POLISHED_BLACKSTONE, Blocks.CHISELED_POLISHED_BLACKSTONE);
        blockChiseling(recipeOutput, Blocks.QUARTZ_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK);
        blockChiseling(recipeOutput, Blocks.RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE);
        blockChiseling(recipeOutput, Blocks.SANDSTONE, Blocks.CHISELED_SANDSTONE);
        blockChiseling(recipeOutput, ModBlocks.WHITE_SANDSTONE, ModBlocks.CHISELED_WHITE_SANDSTONE);
        blockChiseling(recipeOutput, Blocks.STONE_BRICKS, Blocks.CHISELED_STONE_BRICKS);
        blockChiseling(recipeOutput, Blocks.TUFF, Blocks.CHISELED_TUFF);
        blockChiseling(recipeOutput, Blocks.TUFF_BRICKS, Blocks.CHISELED_TUFF_BRICKS);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.CRAFTING_TABLE)
                .requires(ItemTags.PLANKS)
                .requires(ModTags.Items.CARVING_CRAFTING)
                .unlockedBy("has_any_plank", has(ItemTags.PLANKS)).save(recipeOutput, "crafting_table_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_FURNACE)
                .pattern("AB")
                .pattern("BA")
                .define('A', Items.BRICK).define('B', Blocks.BRICK_SLAB)
                .group("brick_furnace")
                .unlockedBy("has_brick", has(Items.BRICK)).save(recipeOutput, "brick_furnace1");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BRICK_FURNACE)
                .pattern("AB")
                .pattern("BA")
                .define('A', Blocks.BRICK_SLAB).define('B', Items.BRICK)
                .group("brick_furnace")
                .unlockedBy("has_brick", has(Items.BRICK)).save(recipeOutput, "brick_furnace2");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOOMERY)
                .pattern("AAA")
                .pattern("A A")
                .pattern("AAA")
                .define('A', ModTags.Items.CARVED_STONE_BRICKS)
                .unlockedBy("has_any_brick", has(ModTags.Items.CARVED_STONE_BRICKS)).save(recipeOutput, "bloomery_from_bricks");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_ANVIL)
                .pattern("AAA")
                .pattern(" A ")
                .pattern("AAA")
                .define('A', ModTags.Items.CARVED_STONE_BRICKS)
                .unlockedBy("has_any_brick", has(ModTags.Items.CARVED_STONE_BRICKS)).save(recipeOutput);


//MISC
        //trimSmithing(recipeOutput, ModItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "kaupen"));

//BRICK FURNACE RECIPES
        BrickFurnaceRecipeBuilder.smelt(Items.BRICK)
                        .ingredient(ModItems.CLAY_BRICK)
                        .duration(800)
                        .save(recipeOutput);

        BrickFurnaceRecipeBuilder.smelt(ModItems.COPPER_NUGGET)
                .ingredient(ModTags.Items.COPPER_NUGGET_SMELTABLES)
                .duration(1000)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COPPER_INGOT)
                .ingredient(ModTags.Items.COPPER_INGOT_SMELTABLES)
                .duration(1200)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.TIN_NUGGET)
                .ingredient(ModItems.RAW_TIN_NUGGET)
                .duration(1000)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.TIN_INGOT)
                .ingredient(ModItems.RAW_TIN)
                .duration(1200)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.GOLD_NUGGET)
                .ingredient(ModItems.RAW_GOLD_NUGGET)
                .duration(1000)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.GOLD_INGOT)
                .ingredient(Items.RAW_GOLD)
                .duration(1200)
                .save(recipeOutput);

        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_BEEF)
                .ingredient(Items.BEEF)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_BEEF)
                .ingredient(Items.COOKED_BEEF)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_CHICKEN)
                .ingredient(Items.CHICKEN)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_CHICKEN)
                .ingredient(Items.COOKED_CHICKEN)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_PORKCHOP)
                .ingredient(Items.PORKCHOP)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_PORKCHOP)
                .ingredient(Items.COOKED_PORKCHOP)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_MUTTON)
                .ingredient(Items.MUTTON)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_MUTTON)
                .ingredient(Items.COOKED_MUTTON)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_RABBIT)
                .ingredient(Items.RABBIT)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_RABBIT)
                .ingredient(Items.COOKED_RABBIT)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_COD)
                .ingredient(Items.COD)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_COD)
                .ingredient(Items.COOKED_COD)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.COOKED_SALMON)
                .ingredient(Items.SALMON)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_SALMON)
                .ingredient(Items.COOKED_SALMON)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.BAKED_POTATO)
                .ingredient(Items.POTATO)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.BURNT_POTATO)
                .ingredient(Items.BAKED_POTATO)
                .duration(300)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(Items.DRIED_KELP)
                .ingredient(Items.KELP)
                .duration(600)
                .save(recipeOutput);
        BrickFurnaceRecipeBuilder.smelt(ModItems.PILE_OF_ASH)
                .ingredient(Items.DRIED_KELP)
                .duration(300)
                .save(recipeOutput);

//BLOOMERY RECIPES
        BloomeryRecipeBuilder.smelt(ModItems.COPPER_NUGGET)
                .ingredient(ModTags.Items.COPPER_NUGGET_SMELTABLES)
                .duration(900)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(Items.COPPER_INGOT)
                .ingredient(ModTags.Items.COPPER_INGOT_SMELTABLES)
                .duration(1100)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(ModItems.TIN_NUGGET)
                .ingredient(ModItems.RAW_TIN_NUGGET)
                .duration(900)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(ModItems.TIN_INGOT)
                .ingredient(ModItems.RAW_TIN)
                .duration(1100)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(Items.GOLD_NUGGET)
                .ingredient(ModItems.RAW_GOLD_NUGGET)
                .duration(900)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(Items.GOLD_INGOT)
                .ingredient(Items.RAW_GOLD)
                .duration(1100)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(Items.IRON_NUGGET)
                .ingredient(ModTags.Items.IRON_NUGGET_SMELTABLES)
                .duration(1000)
                .save(recipeOutput);
        BloomeryRecipeBuilder.smelt(Items.IRON_INGOT)
                .ingredient(ModTags.Items.IRON_INGOT_SMELTABLES)
                .duration(1200)
                .save(recipeOutput);

//ANVIL RECIPES
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(ModTags.Items.ROCKS_NO_SANDSTONE).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_rocks");

        AnvilRecipeBuilder.anvil(ModItems.WIDE_SHAPED_FLINT)
                .ingredient(Items.FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "wide_shaped_flint_from_flint");
        AnvilRecipeBuilder.anvil(ModItems.FANNED_SHAPED_FLINT)
                .ingredient(Items.FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "fanned_shaped_flint_from_flint");
        AnvilRecipeBuilder.anvil(ModItems.LONG_SHAPED_FLINT)
                .ingredient(Items.FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "long_shaped_flint_from_flint");
        AnvilRecipeBuilder.anvil(ModItems.THIN_SHAPED_FLINT)
                .ingredient(Items.FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "thin_shaped_flint_from_flint");
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(Items.FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_flint");
        AnvilRecipeBuilder.anvil(ModItems.FANNED_SHAPED_FLINT)
                .ingredient(ModItems.WIDE_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "fanned_shaped_flint_from_wide_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.LONG_SHAPED_FLINT)
                .ingredient(ModItems.WIDE_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "long_shaped_flint_from_wide_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.THIN_SHAPED_FLINT)
                .ingredient(ModItems.WIDE_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "thin_shaped_flint_from_wide_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(ModItems.WIDE_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_wide_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.LONG_SHAPED_FLINT)
                .ingredient(ModItems.FANNED_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "long_shaped_flint_from_fanned_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.THIN_SHAPED_FLINT)
                .ingredient(ModItems.FANNED_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "thin_shaped_flint_from_fanned_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(ModItems.FANNED_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_fanned_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.THIN_SHAPED_FLINT)
                .ingredient(ModItems.LONG_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "thin_shaped_flint_from_long_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(ModItems.LONG_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_long_shaped_flint");
        AnvilRecipeBuilder.anvil(ModItems.PILE_OF_GRAVEL)
                .ingredient(ModItems.THIN_SHAPED_FLINT).tool(ModTags.Items.CRUSHING_CRAFTING)
                .tier(2).save(recipeOutput, "pile_of_gravel_from_thin_shaped_flint");

        AnvilRecipeBuilder.anvil(ModItems.WIDE_SHAPED_COPPER)
                .ingredient(Items.RAW_COPPER).tool(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .tier(3).save(recipeOutput, "wide_shaped_copper_from_raw_copper");
        AnvilRecipeBuilder.anvil(ModItems.FANNED_SHAPED_COPPER)
                .ingredient(Items.RAW_COPPER).tool(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .tier(3).save(recipeOutput, "fanned_shaped_copper_from_raw_copper");
        AnvilRecipeBuilder.anvil(ModItems.LONG_SHAPED_COPPER)
                .ingredient(Items.RAW_COPPER).tool(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .tier(3).save(recipeOutput, "long_shaped_copper_from_raw_copper");
        AnvilRecipeBuilder.anvil(ModItems.JAGGED_SHAPED_COPPER)
                .ingredient(Items.RAW_COPPER).tool(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .tier(3).save(recipeOutput, "jagged_shaped_copper_from_raw_copper");
        AnvilRecipeBuilder.anvil(ModItems.THIN_SHAPED_COPPER)
                .ingredient(Items.RAW_COPPER).tool(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .tier(3).save(recipeOutput, "thin_shaped_copper_from_raw_copper");

    }

//METHODS
    protected static void crudeBlocksFromTimber(RecipeOutput recipeOutput, ItemLike planks, Item timber, int resultCount) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, planks, resultCount)
                .pattern("BB")
                .pattern("BB")
                .define('B', timber)
                .group("crude_wood_block")
                .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER))
                .save(recipeOutput,  "crude_wood_block_from_" + getItemName(timber));
    }
    protected static void blockFromSlabs(RecipeOutput recipeOutput, ItemLike block) {
        ResourceLocation theSlab = ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, getItemName(block) + "_slab");
        ItemLike slab = BuiltInRegistries.ITEM.get(theSlab);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, block, 1)
                .pattern("A")
                .pattern("A")
                .define('A', slab)
                .unlockedBy("has_" + getItemName(slab), has(slab))
                .save(recipeOutput, getItemName(block) + "_from_slabs");
    }
    protected static void cobblestoneBlocksFromRocks(RecipeOutput recipeOutput, ItemLike cobble, Item rock) {
        ResourceLocation theStairs = ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, getItemName(cobble) + "_stairs");
        ResourceLocation theSlab = ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, getItemName(cobble) + "_slab");
        ItemLike stairs = BuiltInRegistries.ITEM.get(theStairs);
        ItemLike slab = BuiltInRegistries.ITEM.get(theSlab);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, cobble, 1)
                .pattern("AA")
                .pattern("AA")
                .define('A', rock)
                .group("cobble_from_rocks")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, getItemName(cobble) + "_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 1)
                .pattern("A ")
                .pattern("AA")
                .define('A', rock)
                .group("cobbled_stairs_from_rocks")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, getItemName(cobble) + "_stairs_from_rocks");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairs, 1)
                .pattern(" A")
                .pattern("AA")
                .define('A', rock)
                .group("cobbled_stairs_from_rocks")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, getItemName(cobble) + "_stairs_from_rocks_2");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 1)
                .pattern("AA")
                .define('A', rock)
                .group("cobbled_slabs_from_rocks")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, getItemName(cobble) + "_slab_from_rocks");
    }
    protected static void crackedStoneFromCrushing(RecipeOutput recipeOutput, ItemLike stone, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(stone)
                .group("crackedStoneCrushing")
                .unlockedBy("has_any_cracked_stone", has(ModTags.Items.CRACKED_STONE))
                .save(recipeOutput, getItemName(result) + "_from_crushing_stone");
    }
    protected static void cobblestoneFromCrushing(RecipeOutput recipeOutput, ItemLike stone, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .requires(ModTags.Items.CRUSHING_CRAFTING)
                .requires(stone)
                .group("cobblestoneCrushing")
                .unlockedBy("has_any_cobblestone", has(ModTags.Items.COBBLESTONE))
                .save(recipeOutput, getItemName(result) + "_from_crushing_stone");
    }
    protected static void planksFromCarving(RecipeOutput recipeOutput, Item plank, Item timber) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, plank, 1)
                .requires(ModTags.Items.CARVING_CRAFTING)
                .requires(timber, 2)
                .group("plankCarving")
                .unlockedBy("has_any_timber", has(ModTags.Items.TIMBER))
                .save(recipeOutput, getItemName(plank) + "_from_carving_timber");
    }
    protected static void planksFromPlanks(RecipeOutput recipeOutput, ItemLike planks, Item plank) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, planks, 1)
                .pattern("BB")
                .pattern("BB")
                .define('B', plank)
                .group("planks")
                .unlockedBy("has_any_plank", has(ModTags.Items.PLANK_MATERIALS))
                .save(recipeOutput,  "planks_block_from_" + getItemName(plank));
    }
    protected static void bricksFromChiseling(RecipeOutput recipeOutput, Item rock, Item brick) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, brick, 1)
                .requires(ModTags.Items.CHISEL_CRAFTING)
                .requires(rock, 2)
                .group("rock_chiseling")
                .unlockedBy("has_any_rock", has(ModTags.Items.ROCKS))
                .save(recipeOutput, getItemName(brick) + "_from_chiseling_rocks");
    }
    protected static void blockChiseling(RecipeOutput recipeOutput, ItemLike block, ItemLike result) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, result, 1)
                .requires(block)
                .requires(ModTags.Items.CHISEL_CRAFTING)
                .group("block_chiseling")
                .unlockedBy("has_chisel", has(ModTags.Items.CHISEL_CRAFTING))
                .save(recipeOutput, getItemName(result) + "_from_chiseling");
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
