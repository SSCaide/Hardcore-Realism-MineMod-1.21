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
import net.neoforged.neoforge.registries.DeferredItem;
import net.sscaide.realismmod.item.ModItems;

import java.util.List;
import java.util.Random;

public class RandomToolItem extends Item {

    String tooltip;
    DeferredItem sword;
    DeferredItem pickaxe;
    DeferredItem axe;
    DeferredItem shovel;
    DeferredItem hoe;

    public RandomToolItem(Properties properties, String itemTooltip, DeferredItem randSword,
                          DeferredItem randPick, DeferredItem randAxe, DeferredItem randShovel, DeferredItem randHoe) {
        super(properties);
        tooltip = itemTooltip;
        sword = randSword;
        pickaxe = randPick;
        axe = randAxe;
        shovel = randShovel;
        hoe = randHoe;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable(tooltip));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);

        level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ITEM_BREAK,
                SoundSource.NEUTRAL,
                0.5F,
                1.2F * (level.getRandom().nextFloat() * 0.75F + 1F)
        );

        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.setCount(0);

        Random rand = new Random();
        int n = rand.nextInt(11)+1;
        itemstack = switch (n) { //shovel
            case 1, 2 -> shovel.toStack(); //Shovel
            case 3, 4, 5 -> axe.toStack(); //Axe
            case 6, 7, 8 -> pickaxe.toStack(); //Pickaxe
            case 9, 10 -> sword.toStack(); //Sword
            case 11 -> hoe.toStack(); //Hoe
            default -> itemstack;
        };


        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}
