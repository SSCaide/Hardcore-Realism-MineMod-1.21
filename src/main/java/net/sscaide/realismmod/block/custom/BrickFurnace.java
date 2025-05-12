package net.sscaide.realismmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.BlockHitResult;
import net.sscaide.realismmod.block.blockentities.ModBlockEntities;
import net.sscaide.realismmod.block.ModBlockProperties;
import net.sscaide.realismmod.block.blockentities.BrickFurnaceEntity;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipe;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipeInput;
import net.sscaide.realismmod.recipe.ModRecipes;
import net.sscaide.realismmod.sound.ModSounds;
import net.sscaide.realismmod.util.ModTags;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.Random;

public class BrickFurnace extends BaseEntityBlock {
    public static final MapCodec<BrickFurnace> CODEC = simpleCodec(BrickFurnace::new);
    public static final DirectionProperty FACING;
    public static BooleanProperty LIT;
    public static BooleanProperty FUELED;
    private int fuel;

    public BrickFurnace(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    protected BlockState rotate(BlockState state, Rotation rot) {
        return (BlockState)state.setValue(FACING, rot.rotate((Direction)state.getValue(FACING)));
    }

    protected BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.getValue(FACING)));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BrickFurnaceEntity(pos, state);
    }

    @SuppressWarnings("unchecked") // Due to generics, an unchecked cast is necessary here.
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if(level.isClientSide()) {
            return null;
        }
        if(state.getValue(LIT)) {
            return createTickerHelper(type, ModBlockEntities.BRICK_FURNACE_ENTITY.get(),
                    (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
        }
        else return null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(level.getBlockEntity(pos) instanceof BrickFurnaceEntity entity) {

            ItemStack stored = entity.inventory.getStackInSlot(0);
            ItemStack charcoal = entity.remnantInv.getStackInSlot(0);
            ItemStack ash = entity.remnantInv.getStackInSlot(1);
            fuel = entity.getFuel();
            Random rand = new Random();
            if (!level.isClientSide) {
                int burnTime = stack.getBurnTime(RecipeType.SMELTING) * 2;
                if (hasRecipe(stack, level) && stored.isEmpty()) {
                    entity.inventory.insertItem(0, stack.copy(), false);
                    stack.shrink(1);
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, .75f);
                } else if(stack.isEmpty() && !stored.isEmpty()) {
                    ItemStack item = entity.inventory.extractItem(0, 1, false);
                    player.setItemInHand(InteractionHand.MAIN_HAND, item);
                    entity.clearContents();
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, 1f);
                } else if(stack.is(stored.getItem()) && !stored.isEmpty()) {
                    stack.grow(1);
                    entity.clearContents();
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, 1f);
                } else if (burnTime > 0 && fuel < 2400) {
                    entity.setFuel(fuel + burnTime);
                    level.setBlockAndUpdate(pos, state.setValue(FUELED, true));
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, .6f);
                    if (fuel > 2400) {
                        entity.setFuel(2400);
                    }

                    //Fuel remnant code
                    if(stack.is(ItemTags.LOGS)) {
                        var i = rand.nextInt(4);
                        if(i < 3) {
                            i = rand.nextInt(10) +1;
                            if(i<= 8) {
                                entity.addCharcoal(3);
                            } else { entity.addAsh(3); }
                        }
                    } else if(stack.is(ModTags.Items.TIMBER) || stack.is(ModTags.Items.BARK)) {
                        var i = rand.nextInt(4);
                        if(i < 3) {
                            i = rand.nextInt(2);
                            if(i==0) {
                                entity.addCharcoal(1);
                            } else { entity.addAsh(2); }
                        }
                    } else if(!stack.is(ModTags.Items.COAL_FOR_BLOOMERY)) {
                        var i = rand.nextInt(3);
                        if(i==0) {
                            entity.addAsh(rand.nextInt(2)+1);
                        }
                    }
                    if(!player.isCreative()) {
                        stack.shrink(1);
                    }
                } else if(stack.getItem() instanceof ShovelItem && (!charcoal.isEmpty() || !ash.isEmpty())) {
                    if(!charcoal.isEmpty()) {
                        player.addItem(charcoal);
                        entity.clearCharcoal();
                    }
                    if(!ash.isEmpty()) {
                        player.addItem(ash);
                        entity.clearAsh();
                    }
                    level.playSound(null, pos, SoundEvents.ITEM_PICKUP, SoundSource.BLOCKS, .25f, 1f);
                } else if(stack.is(ModTags.Items.FIRESTARTERS) && !state.getValue(LIT) && fuel > 0) {
                    if(!player.isCreative()) {
                        if(stack.is(Items.FLINT_AND_STEEL)) {
                            var i = rand.nextInt(10);
                            if(i<=5) {
                                level.setBlockAndUpdate(pos, state.setValue(LIT, true));
                                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, .4f, 1f);
                            } else {
                                level.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, .5f, .75f);
                            }
                        } else if(stack.is(Items.FIRE_CHARGE)) {
                            level.setBlockAndUpdate(pos, state.setValue(LIT, true));
                            level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, .4f, 1f);
                        } else if(stack.is(ModItems.FIRE_PLOUGH)) {
                            var i = rand.nextInt(5);
                            if(i==0) {
                                level.setBlockAndUpdate(pos, state.setValue(LIT, true));
                                level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, .4f, 1f);
                            } else {
                                level.playSound(null, pos, ModSounds.FIRE_PLOUGH_USE.get(), SoundSource.BLOCKS, .5f, .75f);
                            }
                        }
                        if(!stack.is(Items.FIRE_CHARGE)) {
                            stack.getItem().setDamage(stack, stack.getItem().getDamage(stack)+1);
                            if(stack.getItem().getDamage(stack) > stack.getMaxDamage()) {
                                stack.shrink(1);
                            }
                        } else {
                            stack.shrink(1);
                        }
                    } else {
                        level.setBlockAndUpdate(pos, state.setValue(LIT, true));
                        level.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, .4f, 1f);
                    }
                } else if(stack.is(Items.WATER_BUCKET) && state.getValue(LIT)) {
                    if(!player.isCreative()) {
                        ItemStack bucket = new ItemStack(Items.BUCKET);
                        player.setItemInHand(InteractionHand.MAIN_HAND, bucket);
                    }
                    level.setBlockAndUpdate(pos, state.setValue(LIT, false));
                    level.playSound(null, pos, SoundEvents.GENERIC_SPLASH, SoundSource.BLOCKS, .5f, 1f);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.FAIL;
    }

    private boolean hasRecipe(ItemStack stack, Level level) {
        Optional<RecipeHolder<BrickFurnaceRecipe>> recipe = getCurrentRecipe(stack, level);
        if(recipe.isEmpty()) {
            return false;
        }

        return true;
    }

    private Optional<RecipeHolder<BrickFurnaceRecipe>> getCurrentRecipe(ItemStack stack, Level level) {
        return level.getRecipeManager().getRecipeFor(ModRecipes.BRICK_FURNACE_TYPE.get(),
                new BrickFurnaceRecipeInput(stack), level);
    }

    @Override
    protected void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        if(state.getBlock() != newState.getBlock()) {
            if(level.getBlockEntity(pos) instanceof BrickFurnaceEntity entity) {
                entity.drops();
                level.updateNeighbourForOutputSignal(pos, this);
            }
        }
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if ((Boolean)state.getValue(LIT)) {
            double d0 = (double)pos.getX() + (double)0.5F;
            double d1 = (double)pos.getY();
            double d2 = (double)pos.getZ() + (double)0.5F;
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d0, d1, d2, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = (Direction)state.getValue(FACING);
            Direction.Axis direction$axis = direction.getAxis();
            double d3 = 0.52;
            double d4 = random.nextDouble() * 0.6 - 0.3;
            double d5 = direction$axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : d4;
            double d6 = random.nextDouble() * (double)6.0F / (double)16.0F;
            double d7 = direction$axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : d4;
            level.addParticle(ParticleTypes.SMOKE, d0 + d5, d1 + d6, d2 + d7, (double)0.0F, (double)0.0F, (double)0.0F);
            level.addParticle(ParticleTypes.FLAME, d0 + d5, d1 + d6, d2 + d7, (double)0.0F, (double)0.0F, (double)0.0F);
        }

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite())
                .setValue(FUELED, false).setValue(LIT, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, LIT, FUELED});
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        LIT = BlockStateProperties.LIT;
        FUELED = ModBlockProperties.FUELED;
    }

}
