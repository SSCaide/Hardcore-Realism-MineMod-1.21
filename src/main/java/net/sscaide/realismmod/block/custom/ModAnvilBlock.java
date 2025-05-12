package net.sscaide.realismmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sscaide.realismmod.block.ModBlockProperties;
import net.sscaide.realismmod.block.blockentities.ModAnvilEntity;
import net.sscaide.realismmod.block.blockentities.ModBlockEntities;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.screen.custom.ModAnvilMenu;
import net.sscaide.realismmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

public class ModAnvilBlock extends BaseEntityBlock implements Fallable {
    public static final MapCodec<ModAnvilBlock> CODEC = simpleCodec(ModAnvilBlock::new);
    private int material; //1=weaker than stone, 2=stone, 3=copper, 4=iron/bronze, 5=steel, 6=stronger than steel, 7=netherite
    private int maxDamage;
    private static final VoxelShape BASE;
    private static final VoxelShape X_LEG1;
    private static final VoxelShape X_LEG2;
    private static final VoxelShape X_TOP;
    private static final VoxelShape Z_LEG1;
    private static final VoxelShape Z_LEG2;
    private static final VoxelShape Z_TOP;
    private static final VoxelShape X_AXIS_AABB;
    private static final VoxelShape Z_AXIS_AABB;
    public static DirectionProperty FACING;
    public static IntegerProperty DAMAGE;

    public ModAnvilBlock(Properties properties, int material, int maxDamage) {
        super(properties);
        this.material = material;
        this.maxDamage = maxDamage;
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }
    public ModAnvilBlock(Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(FACING, Direction.NORTH));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ModAnvilEntity entity) {

            ItemStack stored = entity.inventory.getStackInSlot(ModAnvilEntity.getIngredientSlot());
            if (!level.isClientSide) {
                if (stack.is(ModTags.Items.ANVIL_RECIPES) && stored.isEmpty()) {
                    entity.inventory.insertItem(0, stack.copy(), false);
                    stack.shrink(1);
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .15f, .75f);
                } else if(stack.isEmpty() && !stored.isEmpty() && player.isCrouching()) {
                    ItemStack item = entity.inventory.extractItem(0, 1, false);
                    player.setItemInHand(InteractionHand.MAIN_HAND, item);
                    entity.clearContents();
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, 1f);
                } else if(stack.is(stored.getItem()) && !stored.isEmpty() && player.isCrouching()) {
                    stack.grow(1);
                    entity.clearContents();
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, 1f);
                } else {
                    ((ServerPlayer) player).openMenu(new SimpleMenuProvider(entity, Component.literal("Anvil")), pos);
                    player.awardStat(Stats.INTERACT_WITH_ANVIL);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState)this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getClockWise());
    }

    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = (Direction)state.getValue(FACING);
        return direction.getAxis() == Direction.Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING});
    }

    protected void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        level.scheduleTick(pos, this, this.getDelayAfterPlace());
    }

    protected BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        level.scheduleTick(currentPos, this, this.getDelayAfterPlace());
        return super.updateShape(state, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ModAnvilEntity(blockPos, blockState, material, maxDamage);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof ModAnvilEntity entity) {
                entity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    protected boolean isPathfindable(BlockState state, PathComputationType pathComputationType) {
        return false;
    }

    public int getDustColor(BlockState state, BlockGetter reader, BlockPos pos) {
        return state.getMapColor(reader, pos).col;
    }

    protected void falling(FallingBlockEntity fallingEntity) {
        fallingEntity.setHurtsEntities(2.0F, 40);
    }

    public void onLand(Level level, BlockPos pos, BlockState state, BlockState replaceableState, FallingBlockEntity fallingBlock) {
        if (!fallingBlock.isSilent()) {
            level.levelEvent(1031, pos, 0);
        }

    }

    public DamageSource getFallDamageSource(Entity entity) {
        return entity.damageSources().anvil(entity);
    }

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight()) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, pos, state);
            this.falling(fallingblockentity);
        }

    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public static boolean isFree(BlockState state) {
        return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(16) == 0) {
            BlockPos blockpos = pos.below();
            if (isFree(level.getBlockState(blockpos))) {
                ParticleUtils.spawnParticleBelow(level, pos, random, new BlockParticleOption(ParticleTypes.FALLING_DUST, state));
            }
        }

    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        BASE = Block.box((double)2.0F, (double)0.0F, (double)2.0F, (double)14.0F, (double)4.0F, (double)14.0F);
        X_LEG1 = Block.box((double)3.0F, (double)4.0F, (double)4.0F, (double)13.0F, (double)5.0F, (double)12.0F);
        X_LEG2 = Block.box((double)4.0F, (double)5.0F, (double)6.0F, (double)12.0F, (double)10.0F, (double)10.0F);
        X_TOP = Block.box((double)0.0F, (double)10.0F, (double)3.0F, (double)16.0F, (double)16.0F, (double)13.0F);
        Z_LEG1 = Block.box((double)4.0F, (double)4.0F, (double)3.0F, (double)12.0F, (double)5.0F, (double)13.0F);
        Z_LEG2 = Block.box((double)6.0F, (double)5.0F, (double)4.0F, (double)10.0F, (double)10.0F, (double)12.0F);
        Z_TOP = Block.box((double)3.0F, (double)10.0F, (double)0.0F, (double)13.0F, (double)16.0F, (double)16.0F);
        X_AXIS_AABB = Shapes.or(BASE, new VoxelShape[]{X_LEG1, X_LEG2, X_TOP});
        Z_AXIS_AABB = Shapes.or(BASE, new VoxelShape[]{Z_LEG1, Z_LEG2, Z_TOP});

        DAMAGE = ModBlockProperties.DAMAGE;
    }
}
