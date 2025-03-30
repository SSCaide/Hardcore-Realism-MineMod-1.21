package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

public class ModLeavesBlock extends LeavesBlock {

    public ModLeavesBlock(MapColor color, SoundType sound) {
        super(Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(color).sound(sound));
    }

    @Override public int getFlammability(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 60;
    }
    @Override public int getFireSpreadSpeed(BlockState state, BlockGetter getter, BlockPos pos, Direction face) {
        return 30;
    }

}
