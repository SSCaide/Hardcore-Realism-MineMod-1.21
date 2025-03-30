package net.sscaide.realismmod.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ModColoredFallingSlabBlock extends ColoredFallingBlock implements SimpleWaterloggedBlock {



//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

    private final ColorRGBA dustColor;
    public static final MapCodec<net.minecraft.world.level.block.SlabBlock> SLAB_CODEC = simpleCodec(net.minecraft.world.level.block.SlabBlock::new);
    public static final EnumProperty<SlabType> TYPE;
    public static final BooleanProperty WATERLOGGED;
    protected static final VoxelShape BOTTOM_AABB;
    protected static final VoxelShape TOP_AABB;


    public MapCodec<? extends net.minecraft.world.level.block.SlabBlock> slabCodec() {
        return SLAB_CODEC;
    }

    public ModColoredFallingSlabBlock(ColorRGBA dustColor, BlockBehaviour.Properties properties) {
        super(dustColor, properties);
        this.registerDefaultState((BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, false));
        this.dustColor = dustColor;
    }

    protected boolean useShapeForLightOcclusion(BlockState state) {
        return state.getValue(TYPE) != SlabType.DOUBLE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{TYPE, WATERLOGGED});
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        SlabType slabtype = (SlabType)state.getValue(TYPE);
        switch (slabtype) {
            case DOUBLE -> {
                return Shapes.block();
            }
            case TOP -> {
                return TOP_AABB;
            }
            default -> {
                return BOTTOM_AABB;
            }
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = context.getLevel().getBlockState(blockpos);
        if (blockstate.is(this)) {
            return (BlockState)((BlockState)blockstate.setValue(TYPE, SlabType.DOUBLE)).setValue(WATERLOGGED, false);
        } else {
            FluidState fluidstate = context.getLevel().getFluidState(blockpos);
            BlockState blockstate1 = (BlockState)((BlockState)this.defaultBlockState().setValue(TYPE, SlabType.BOTTOM)).setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
            Direction direction = context.getClickedFace();
            return direction == Direction.DOWN || direction != Direction.UP && context.getClickLocation().y - (double)blockpos.getY() > (double)0.5F ? (BlockState)blockstate1.setValue(TYPE, SlabType.TOP) : blockstate1;
        }
    }

    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        ItemStack itemstack = useContext.getItemInHand();
        SlabType slabtype = (SlabType)state.getValue(TYPE);
        if (slabtype != SlabType.DOUBLE && itemstack.is(this.asItem())) {
            if (useContext.replacingClickedOnBlock()) {
                boolean flag = useContext.getClickLocation().y - (double)useContext.getClickedPos().getY() > (double)0.5F;
                Direction direction = useContext.getClickedFace();
                return slabtype == SlabType.BOTTOM ? direction == Direction.UP || flag && direction.getAxis().isHorizontal() : direction == Direction.DOWN || !flag && direction.getAxis().isHorizontal();
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    protected FluidState getFluidState(BlockState state) {
        return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override


    public boolean placeLiquid(LevelAccessor level, BlockPos pos, BlockState state, FluidState fluidState) {
        return state.getValue(TYPE) != SlabType.DOUBLE ? placeLiquid(level, pos, state, fluidState) : false;
    }

    public boolean canPlaceLiquid(@Nullable Player player, BlockGetter level, BlockPos pos, BlockState state, Fluid fluid) {
        return state.getValue(TYPE) != SlabType.DOUBLE ? canPlaceLiquid(player, level, pos, state, fluid) : false;
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if ((Boolean)state.getValue(WATERLOGGED)) {
            level.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        switch (pathComputationType) {
            case LAND -> {
                return false;
            }
            case WATER -> {
                return state.getFluidState().is(FluidTags.WATER);
            }
            case AIR -> {
                return false;
            }
            default -> {
                return false;
            }
        }
    }

    static {
        TYPE = BlockStateProperties.SLAB_TYPE;
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        BOTTOM_AABB = Block.box((double)0.0F, (double)0.0F, (double)0.0F, (double)16.0F, (double)8.0F, (double)16.0F);
        TOP_AABB = Block.box((double)0.0F, (double)8.0F, (double)0.0F, (double)16.0F, (double)16.0F, (double)16.0F);
    }
}

