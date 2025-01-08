package net.sscaide.realismmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    //Actual saturation applied = double nutrition*satMod

    public static final FoodProperties ORANGE = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(.0667f).build();

    public static final FoodProperties BLUEBERRIES = new FoodProperties.Builder()
            .nutrition(1).saturationModifier(.4f).fast().build();


    public static final FoodProperties BOWL_OF_FLAX_SEEDS = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(.75f).fast().build();

}
