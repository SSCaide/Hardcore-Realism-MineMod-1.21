package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.PALM_LOG)){
                popResource(context.getLevel(), context.getClickedPos(), ModItems.PALM_BARK.toStack(4));
                return ModBlocks.STRIPPED_PALM_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }else if(state.is(ModBlocks.PALM_WOOD)){
                popResource(context.getLevel(), context.getClickedPos(), ModItems.PALM_BARK.toStack(6));
                return ModBlocks.STRIPPED_PALM_WOOD.get().defaultBlockState();
            }
        }
        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
