package net.sscaide.realismmod.item;

import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RealismMod.MOD_ID);


    public static final DeferredItem<Item> CLUMP_OF_DIRT = ITEMS.register("clump_of_dirt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VINE = ITEMS.register("vine",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OAK_BARK = ITEMS.register("oak_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_BARK = ITEMS.register("spruce_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_BARK = ITEMS.register("birch_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_BARK = ITEMS.register("jungle_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_BARK = ITEMS.register("acacia_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_BARK = ITEMS.register("dark_oak_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_BARK = ITEMS.register("mangrove_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_BARK = ITEMS.register("cherry_bark",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALM_BARK = ITEMS.register("palm_bark",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ORANGE)));


    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -2.4f))));
    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe",
            () -> new PickaxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel",
            () -> new ShovelItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.COPPER, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe",
            () -> new AxeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.COPPER, 6, -3.2f))));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe",
            () -> new HoeItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.COPPER, 0, -3.0f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
