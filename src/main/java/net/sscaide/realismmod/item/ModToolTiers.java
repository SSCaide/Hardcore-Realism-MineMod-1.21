package net.sscaide.realismmod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.sscaide.realismmod.util.ModTags;

public class ModToolTiers {

    public static final Tier SHARPENED_STICK = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SHARPENED_STICK,
            22, .5f, .5f, 6,() -> Ingredient.of(ModTags.Items.TIMBER));
    public static final Tier SHARPENED_ROCK = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_SHARPENED_ROCK,
            18, 1f, 1f, 4,() -> Ingredient.of(ModTags.Items.ROCKS));


    public static final Tier CRUDE_STONE = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CRUDE_STONE_TOOL,
            66, 2f, .8f, 4,() -> Ingredient.of(ModTags.Items.ROCKS));
    public static final Tier FLINT = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL,
            64, 3f, 1.25f, 7,() -> Ingredient.of(Items.FLINT));

    public static final Tier CRUDE_COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_CRUDE_COPPER_TOOL,
            41, 2.5f, 1.3f, 13,() -> Ingredient.of(Items.RAW_COPPER));
    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            82, 5f, 1.5f, 18,() -> Ingredient.of(Items.COPPER_INGOT));

}
