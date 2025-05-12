package net.sscaide.realismmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class PlaceableSingleBrick extends HorizontalDirectionalBlock {
    public static final MapCodec<PlaceableSingleBrick> CODEC = simpleCodec(PlaceableSingleBrick::new);
    public static final VoxelShape SHAPE = Block.box(5, 0, 3, 11, 4, 13);
    public static final VoxelShape ROTATED_SHAPE = Block.box(3, 0, 5, 13, 4, 11);

    public PlaceableSingleBrick(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(state.getValue(FACING) == Direction.NORTH || state.getValue(FACING) == Direction.SOUTH)
        {
            return SHAPE;
        } else {
            return ROTATED_SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
