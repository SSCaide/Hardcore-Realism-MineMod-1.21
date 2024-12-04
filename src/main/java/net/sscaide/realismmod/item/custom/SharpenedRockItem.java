package net.sscaide.realismmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import net.sscaide.realismmod.item.ModItems;

import java.util.List;
import java.util.Random;

public class SharpenedRockItem extends PickaxeItem {

    public SharpenedRockItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (!hasCraftingRemainingItem(stack)) {
            return ItemStack.EMPTY;
        }
        ItemStack stack2 = new ItemStack(stack.getItem());
        stack2.getItem().setDamage(stack2, getDamage(stack)+2);
        int dam = stack2.getDamageValue();
        if(dam >= 18)
        {
            return ItemStack.EMPTY;
        } else {
            return stack2;
        }
    }


}
