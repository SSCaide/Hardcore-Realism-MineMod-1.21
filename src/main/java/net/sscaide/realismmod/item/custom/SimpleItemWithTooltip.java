package net.sscaide.realismmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.sscaide.realismmod.item.ModItems;

import java.util.List;
import java.util.Random;

public class SimpleItemWithTooltip extends Item {

    String tooltip;
    public SimpleItemWithTooltip(Properties properties, String tooltipKey) {
        super(properties);
        tooltip = tooltipKey;
    }


    public String getTooltip()
    {
        return tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String theTooltip = this.getTooltip();
        tooltipComponents.add(Component.translatable(theTooltip));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }


}
