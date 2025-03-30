package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {
    private final Supplier<Block> blockToSurviveOn;
    private final Supplier<Block> blockToSurviveOn2;
    private final Supplier<Block> blockToSurviveOn3;

    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Supplier<Block> block) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
        this.blockToSurviveOn2 = block;
        this.blockToSurviveOn3 = block;
    }
    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Supplier<Block> block, Supplier<Block> block2) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
        this.blockToSurviveOn2 = block2;
        this.blockToSurviveOn3 = block;
    }
    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Supplier<Block> block, Supplier<Block> block2, Supplier<Block> block3) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
        this.blockToSurviveOn2 = block2;
        this.blockToSurviveOn3 = block3;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        boolean same = false
                ;
        if(blockToSurviveOn.get() == state.getBlock()) { same = true; }
        else if(blockToSurviveOn.get() == state.getBlock()) { same = true; }
        else if(blockToSurviveOn.get() == state.getBlock()) { same = true; }

        return same;
    }
}
