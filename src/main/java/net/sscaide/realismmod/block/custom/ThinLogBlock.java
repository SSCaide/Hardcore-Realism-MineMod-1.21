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

public class ThinLogBlock extends ModFlammableRotatedPillarBlock {
    private static final VoxelShape SHAPE = Block.box(4, 0, 4, 12, 16, 12);
    private static final VoxelShape Z_SHAPE = Block.box(4, 4, 0, 12, 12, 16);
    private static final VoxelShape X_SHAPE = Block.box(0, 4, 4, 16, 12, 12);

    public ThinLogBlock(Properties properties) {
        super(properties);
    }
    private static ItemStack timber;
    private static Block ironOrBetter = ModBlocks.IRON_BREAKABLE_WOOD.get();

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
        if (player.getMainHandItem() != ItemStack.EMPTY) {
            var enchants = player.getMainHandItem().get(DataComponents.ENCHANTMENTS);
            var server = level.getServer();
            var enchantmentHolder = Objects.requireNonNull(server).registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
            silk = Objects.requireNonNull(enchants).getLevel(enchantmentHolder) != 0;
        } else {
            silk = false;
        }

        if (player.isCreative()) {
            return;
        }

        if (player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState())) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        } else if (!player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);

            if(state.is(ModBlocks.THIN_OAK_LOG)) {
                timber = ModItems.OAK_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_SPRUCE_LOG)) {
                timber = ModItems.SPRUCE_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_BIRCH_LOG)) {
                timber = ModItems.BIRCH_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_JUNGLE_LOG)) {
                timber = ModItems.JUNGLE_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_ACACIA_LOG)) {
                timber = ModItems.ACACIA_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_DARK_OAK_LOG)) {
                timber = ModItems.DARK_OAK_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_MANGROVE_LOG)) {
                timber = ModItems.MANGROVE_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_CHERRY_LOG)) {
                timber = ModItems.CHERRY_TIMBER.toStack();
            } else if(state.is(ModBlocks.THIN_PALM_LOG)) {
                timber = ModItems.PALM_TIMBER.toStack();
            } else {
                timber = ModItems.OAK_TIMBER.toStack();
            }
            popResource(level, pos, timber);

        } else {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        }
    }
}
