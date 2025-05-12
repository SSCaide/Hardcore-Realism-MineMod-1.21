package net.sscaide.realismmod.item.custom;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.ItemAbilities;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.sound.ModSounds;

import java.util.Random;
import java.util.function.Supplier;

public class FirePloughItem extends FlintAndSteelItem {
private final int maxChance;
private final int minChance;
    public FirePloughItem(Properties properties, int maxChance, int minChance) {
        super(properties);
        this.maxChance = maxChance;
        this.minChance = minChance;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos blockpos = context.getClickedPos();
        BlockState blockstate = level.getBlockState(blockpos);
        BlockState blockstate2 = blockstate.getToolModifiedState(context, ItemAbilities.FIRESTARTER_LIGHT, false);
        ItemStack itemstack = context.getItemInHand();
        int chance = itemstack.get(ModDataComponents.FIRE_CHANCE);
        Random rand = new Random();
        if (!level.isClientSide()) {

            if (blockstate2 == null) {
                BlockPos blockpos1 = blockpos.relative(context.getClickedFace());
                if (BaseFireBlock.canBePlacedAt(level, blockpos1, context.getHorizontalDirection())) {
                    level.playSound(null, blockpos1, ModSounds.FIRE_PLOUGH_USE.get(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.1F * chance);
                    chance++;
                    itemstack.set(ModDataComponents.IN_USE, true);
                    if (rand.nextInt(maxChance) < chance && chance > minChance) {
                        BlockState blockstate1 = BaseFireBlock.getState(level, blockpos1);
                        level.setBlock(blockpos1, blockstate1, 11);
                        level.gameEvent(player, GameEvent.BLOCK_PLACE, blockpos);
                        if (player instanceof ServerPlayer) {
                            CriteriaTriggers.PLACED_BLOCK.trigger((ServerPlayer) player, blockpos1, itemstack);
                        }

                        chance = 0;
                    }
                    if (player instanceof ServerPlayer) {
                        itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                        itemstack.set(ModDataComponents.FIRE_CHANCE, chance);
                    }
                    return InteractionResult.sidedSuccess(level.isClientSide());
                } else {
                    return InteractionResult.FAIL;
                }
            } else {
                level.playSound(null, blockpos, ModSounds.FIRE_PLOUGH_USE.get(), SoundSource.BLOCKS, 1.0F, level.getRandom().nextFloat() * 0.4F + 0.1F * chance);
                chance++;
                if (rand.nextInt(maxChance) < chance && chance > minChance) {
                    level.setBlock(blockpos, blockstate2, 11);
                    level.gameEvent(player, GameEvent.BLOCK_CHANGE, blockpos);
                    chance = 0;
                }
                if (player != null) {
                    itemstack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(context.getHand()));
                    itemstack.set(ModDataComponents.FIRE_CHANCE, chance);
                    itemstack.set(ModDataComponents.IN_USE, true);
                }
            }


        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if(!level.isClientSide()) {
            boolean inUse = stack.get(ModDataComponents.IN_USE);
            int ticker = stack.get(ModDataComponents.TICKER);
            if(stack.get(ModDataComponents.FIRE_CHANCE) > 0) {
                ticker--;
                if(ticker<=0 && inUse == false) {
                    stack.set(ModDataComponents.FIRE_CHANCE, stack.get(ModDataComponents.FIRE_CHANCE) - 1);
                    stack.set(ModDataComponents.TICKER, 10);
                } else if(ticker<=0 && inUse == true) {
                    stack.set(ModDataComponents.TICKER, 10);
                    stack.set(ModDataComponents.IN_USE, false);
                } else {
                    stack.set(ModDataComponents.TICKER, ticker);
                }
            }
        }
    }
}
