package net.sscaide.realismmod.item.custom;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public class DaggerItem extends TieredItem {

    public DaggerItem(Tier tier, Item.Properties properties) {
        super(tier, properties.component(DataComponents.TOOL, createToolProperties()));
    }

    private static final ResourceLocation DAGGER_BLOCK_REACH = ResourceLocation.fromNamespaceAndPath("sscaiderealism", "dagger_block_reach");
    private static final ResourceLocation DAGGER_ENTITY_REACH = ResourceLocation.fromNamespaceAndPath("sscaiderealism", "dagger_entity_reach");

    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, float range) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ENTITY_INTERACTION_RANGE, new AttributeModifier(DAGGER_ENTITY_REACH, range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.BLOCK_INTERACTION_RANGE, new AttributeModifier(DAGGER_BLOCK_REACH, range, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        if (!hasCraftingRemainingItem(stack)) {
            return ItemStack.EMPTY;
        }
        ItemStack stack2 = new ItemStack(stack.getItem());
        stack2.getItem().setDamage(stack2, getDamage(stack)+2);
        int dam = stack2.getDamageValue();
        if(dam >= stack2.getMaxDamage())
        {
            return ItemStack.EMPTY;
        } else {
            return stack2;
        }
    }

}
