package net.sscaide.realismmod.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.sscaide.realismmod.component.ModDataComponents;

import java.util.List;

import static net.sscaide.realismmod.component.ModDataComponents.SERVINGS;

public class MultiConsumableBowlItem extends Item {

    String tooltip;
    String tooltip2;
    public MultiConsumableBowlItem(Properties properties, String tooltipKey, String tooltipKey2) {
        super(properties);
        tooltip = tooltipKey;
        tooltip2 = tooltipKey2;
    }


    public String getTooltip()
    {
        return tooltip;
    }
    public String getTooltip2() { return tooltip2; }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        String theTooltip = this.getTooltip();
        String theTooltip2 = this.getTooltip2();
        String value = stack.get(ModDataComponents.SERVINGS).toString();
        tooltipComponents.add(Component.translatable(theTooltip, value));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
