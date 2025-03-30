package net.sscaide.realismmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower PALM = new TreeGrower(RealismMod.MOD_ID + ":palm",
            Optional.empty(), Optional.of(ModConfiguredFeatures.PALM_KEY), Optional.empty());
}
