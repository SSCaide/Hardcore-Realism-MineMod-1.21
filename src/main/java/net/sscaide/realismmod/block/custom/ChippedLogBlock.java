package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

import javax.annotation.Nullable;
import java.util.Objects;

public class ChippedLogBlock extends ModFlammableRotatedPillarBlock {
    public static Block replacer;
    private static ItemStack timber;
    private static Block ironOrBetter = ModBlocks.IRON_BREAKABLE_WOOD.get();
    private static final VoxelShape SHAPE = Block.box(2, 0, 2, 14, 16, 14);
    private static final VoxelShape Z_SHAPE = Block.box(2, 2, 0, 14, 14, 16);
    private static final VoxelShape X_SHAPE = Block.box(0, 2, 2, 16, 14, 14);

    public ChippedLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(state.getValue(AXIS) == Direction.Axis.Y) {
            return SHAPE;
        } else if(state.getValue(AXIS) == Direction.Axis.Z) {
            return Z_SHAPE;
        } else {
            return X_SHAPE;
        }
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        boolean silk;
        if(player.getMainHandItem() != ItemStack.EMPTY) {
            var enchants = player.getMainHandItem().get(DataComponents.ENCHANTMENTS);
            var server = level.getServer();
            var enchantmentHolder = Objects.requireNonNull(server).registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
            silk = Objects.requireNonNull(enchants).getLevel(enchantmentHolder) != 0;
        } else { silk = false; }

        if(player.isCreative()) { return; }

        if(player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState())) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        } else if(!player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);

            if(state.is(ModBlocks.CHIPPED_OAK_LOG)) {
                timber = ModItems.OAK_TIMBER.toStack();
                replacer = ModBlocks.THIN_OAK_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_SPRUCE_LOG)) {
                timber = ModItems.SPRUCE_TIMBER.toStack();
                replacer = ModBlocks.THIN_SPRUCE_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_BIRCH_LOG)) {
                timber = ModItems.BIRCH_TIMBER.toStack();
                replacer = ModBlocks.THIN_BIRCH_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_JUNGLE_LOG)) {
                timber = ModItems.JUNGLE_TIMBER.toStack();
                replacer = ModBlocks.THIN_JUNGLE_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_ACACIA_LOG)) {
                timber = ModItems.ACACIA_TIMBER.toStack();
                replacer = ModBlocks.THIN_ACACIA_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_DARK_OAK_LOG)) {
                timber = ModItems.DARK_OAK_TIMBER.toStack();
                replacer = ModBlocks.THIN_DARK_OAK_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_MANGROVE_LOG)) {
                timber = ModItems.MANGROVE_TIMBER.toStack();
                replacer = ModBlocks.THIN_MANGROVE_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_CHERRY_LOG)) {
                timber = ModItems.CHERRY_TIMBER.toStack();
                replacer = ModBlocks.THIN_CHERRY_LOG.get();
            } else if(state.is(ModBlocks.CHIPPED_PALM_LOG)) {
                timber = ModItems.PALM_TIMBER.toStack();
                replacer = ModBlocks.THIN_PALM_LOG.get();
            } else {
                timber = ModItems.OAK_TIMBER.toStack();
                replacer = ModBlocks.THIN_OAK_LOG.get();
            }
            popResource(level, pos, timber);

            if(!level.isClientSide) {
                level.setBlockAndUpdate(pos, replacer.defaultBlockState());
            }
        } else {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        }
    }
}
