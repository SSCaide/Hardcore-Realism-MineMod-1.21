package net.sscaide.realismmod.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.sscaide.realismmod.util.ModTags;

public class ModToolTiers {

    public static final Tier COPPER = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            64, 5f, 1.5f, 18,() -> Ingredient.of(Items.COPPER_INGOT));


}
