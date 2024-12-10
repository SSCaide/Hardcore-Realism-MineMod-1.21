package net.sscaide.realismmod.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ORANGE = new FoodProperties.Builder()
            .nutrition(3).saturationModifier(.0667f).build();


    public static final FoodProperties BOWL_OF_FLAX_SEEDS = new FoodProperties.Builder()
            .nutrition(2).saturationModifier(.75f).fast().build();

}
