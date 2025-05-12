package net.sscaide.realismmod.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class ModBlockProperties {
    public static final BooleanProperty FUELED = BooleanProperty.create("fueled");

    public static final IntegerProperty DAMAGE = IntegerProperty.create("damage", 0, 3);

}
