package net.sscaide.realismmod.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.entity.ModEntities;
import net.sscaide.realismmod.item.custom.*;
import net.sscaide.realismmod.sound.ModSounds;

import static net.sscaide.realismmod.component.ModDataComponents.SERVINGS;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RealismMod.MOD_ID);

    public static final DeferredItem<Item> OAK_TIMBER = ITEMS.register("oak_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_TIMBER = ITEMS.register("spruce_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_TIMBER = ITEMS.register("birch_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_TIMBER = ITEMS.register("jungle_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_TIMBER = ITEMS.register("acacia_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_TIMBER = ITEMS.register("dark_oak_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_TIMBER = ITEMS.register("mangrove_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_TIMBER = ITEMS.register("cherry_timber",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALM_TIMBER = ITEMS.register("palm_timber",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OAK_PLANK = ITEMS.register("oak_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SPRUCE_PLANK = ITEMS.register("spruce_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BIRCH_PLANK = ITEMS.register("birch_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> JUNGLE_PLANK = ITEMS.register("jungle_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ACACIA_PLANK = ITEMS.register("acacia_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DARK_OAK_PLANK = ITEMS.register("dark_oak_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MANGROVE_PLANK = ITEMS.register("mangrove_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CHERRY_PLANK = ITEMS.register("cherry_plank",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PALM_PLANK = ITEMS.register("palm_plank",
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

    public static final DeferredItem<Item> CLUMP_OF_DIRT = ITEMS.register("clump_of_dirt",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CLUMP_OF_MUD = ITEMS.register("clump_of_mud",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CLAY_BRICK = ITEMS.register("clay_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PILE_OF_GRAVEL = ITEMS.register("pile_of_gravel",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PILE_OF_SAND = ITEMS.register("pile_of_sand",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PILE_OF_RED_SAND = ITEMS.register("pile_of_red_sand",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PILE_OF_WHITE_SAND = ITEMS.register("pile_of_white_sand",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CLUMP_OF_MOSS = ITEMS.register("clump_of_moss",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CLUMP_OF_SOUL_SOIL = ITEMS.register("clump_of_soul_soil",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PILE_OF_SOUL_SAND = ITEMS.register("pile_of_soul_sand",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ROCK = ITEMS.register("rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DEEPSLATE_ROCK = ITEMS.register("deepslate_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> SANDSTONE_ROCK = ITEMS.register("sandstone_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_SANDSTONE_ROCK = ITEMS.register("red_sandstone_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WHITE_SANDSTONE_ROCK = ITEMS.register("white_sandstone_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRANITE_ROCK = ITEMS.register("granite_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DIORITE_ROCK = ITEMS.register("diorite_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ANDESITE_ROCK = ITEMS.register("andesite_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CALCITE_ROCK = ITEMS.register("calcite_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TUFF_ROCK = ITEMS.register("tuff_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DRIPSTONE_ROCK = ITEMS.register("dripstone_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NETHERROCK = ITEMS.register("netherrock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACKROCK = ITEMS.register("blackrock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BASALT_ROCK = ITEMS.register("basalt_rock",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> END_ROCK = ITEMS.register("end_rock",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STONE_BRICK = ITEMS.register("stone_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DEEPSLATE_BRICK = ITEMS.register("deepslate_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TUFF_BRICK = ITEMS.register("tuff_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLACKSTONE_BRICK = ITEMS.register("blackstone_brick",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> END_BRICK = ITEMS.register("end_brick",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> VINE = ITEMS.register("vine",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> FLAX = ITEMS.register("flax",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> BLACK_PETALS = ITEMS.register("black_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BLUE_PETALS = ITEMS.register("blue_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> CYAN_PETALS = ITEMS.register("cyan_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> GRAY_PETALS = ITEMS.register("gray_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_BLUE_PETALS = ITEMS.register("light_blue_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIGHT_GRAY_PETALS = ITEMS.register("light_gray_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> MAGENTA_PETALS = ITEMS.register("magenta_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ORANGE_PETALS = ITEMS.register("orange_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PINK_PETALS = ITEMS.register("pink_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RED_PETALS = ITEMS.register("red_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> WHITE_PETALS = ITEMS.register("white_petals",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> YELLOW_PETALS = ITEMS.register("yellow_petals",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_COPPER_NUGGET = ITEMS.register("raw_copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COPPER_DUST = ITEMS.register("copper_dust",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_GOLD_NUGGET = ITEMS.register("raw_gold_nugget",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_IRON_NUGGET = ITEMS.register("raw_iron_nugget",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> IRON_DUST = ITEMS.register("iron_dust",
            () -> new Item(new Item.Properties()));


    public static final DeferredItem<Item> OBSIDIAN_SHARD = ITEMS.register("obsidian_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SimpleItemWithTooltip> WIDE_SHAPED_FLINT = ITEMS.register("wide_shaped_flint",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.wide_shaped_flint.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> FANNED_SHAPED_FLINT = ITEMS.register("fanned_shaped_flint",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.fanned_shaped_flint.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> LONG_SHAPED_FLINT = ITEMS.register("long_shaped_flint",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.long_shaped_flint.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> THIN_SHAPED_FLINT = ITEMS.register("thin_shaped_flint",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.thin_shaped_flint.tooltip"));

    public static final DeferredItem<SimpleItemWithTooltip> WIDE_SHAPED_COPPER = ITEMS.register("wide_shaped_copper",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.wide_shaped_copper.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> FANNED_SHAPED_COPPER = ITEMS.register("fanned_shaped_copper",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.fanned_shaped_copper.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> LONG_SHAPED_COPPER = ITEMS.register("long_shaped_copper",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.long_shaped_copper.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> JAGGED_SHAPED_COPPER = ITEMS.register("jagged_shaped_copper",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.jagged_shaped_copper.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> THIN_SHAPED_COPPER = ITEMS.register("thin_shaped_copper",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.thin_shaped_copper.tooltip"));

    public static final DeferredItem<SimpleItemWithTooltip> WIDE_SHAPED_IRON = ITEMS.register("wide_shaped_iron",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.wide_shaped_iron.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> FANNED_SHAPED_IRON = ITEMS.register("fanned_shaped_iron",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.fanned_shaped_iron.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> LONG_SHAPED_IRON = ITEMS.register("long_shaped_iron",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.long_shaped_iron.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> JAGGED_SHAPED_IRON = ITEMS.register("jagged_shaped_iron",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.jagged_shaped_iron.tooltip"));
    public static final DeferredItem<SimpleItemWithTooltip> THIN_SHAPED_IRON = ITEMS.register("thin_shaped_iron",
            () -> new SimpleItemWithTooltip(new Item.Properties(), "tooltip.sscaiderealism.thin_shaped_iron.tooltip"));


    public static final DeferredItem<Item> ORANGE = ITEMS.register("orange",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ORANGE)));

    public static final DeferredItem<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.BLUEBERRIES)));

    public static final DeferredItem<Item> FLAX_SEEDS = ITEMS.register("flax_seeds",
            () -> new ItemNameBlockItem(ModBlocks.FLAX_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BOWL_OF_FLAX_SEEDS = ITEMS.register("bowl_of_flax_seeds",
            () -> new MultiConsumableBowlItem(new MultiConsumableBowlItem.Properties().food(ModFoodProperties.BOWL_OF_FLAX_SEEDS)
                    .stacksTo(1).component(SERVINGS.get(), new Integer(1)), "tooltip.sscaiderealism.multiBowl1.tooltip" , "tooltip.sscaiderealism.multiBowl2.tooltip"));


    public static final DeferredItem<SharpenedRockItem> SHARPENED_ROCK = ITEMS.register("sharpened_rock",
            () -> new SharpenedRockItem(ModToolTiers.SHARPENED_ROCK, new Item.Properties().stacksTo(1).setNoRepair()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SHARPENED_ROCK, .5f, -2.8f))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<SharpenedRockItem> SHARPENED_COPPER_CHUNK = ITEMS.register("sharpened_copper_chunk",
            () -> new SharpenedRockItem(ModToolTiers.SHARPENED_COPPER_CHUNK, new Item.Properties().stacksTo(1).setNoRepair()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SHARPENED_COPPER_CHUNK, .6f, -2.8f))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<SharpenedRockItem> SHARPENED_IRON_CHUNK = ITEMS.register("sharpened_iron_chunk",
            () -> new SharpenedRockItem(ModToolTiers.SHARPENED_IRON_CHUNK, new Item.Properties().stacksTo(1).setNoRepair()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SHARPENED_IRON_CHUNK, .7f, -2.8f))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<PickaxeItem> SHARPENED_STICK = ITEMS.register("sharpened_stick",
            () -> new PickaxeItem(ModToolTiers.SHARPENED_STICK, new Item.Properties().stacksTo(1).setNoRepair()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.SHARPENED_STICK, .5f, -2.8f))));


    public static final DeferredItem<RandomToolItem> RANDOM_CRUDE_STONE_TOOL = ITEMS.register("random_crude_stone_tool",
            () -> new RandomToolItem(new Item.Properties().stacksTo(1), "tooltip.sscaiderealism.random_crude_stone_tool.tooltip",
                    ModItems.CRUDE_STONE_KNIFE, ModItems.CRUDE_STONE_PICK, ModItems.CRUDE_STONE_HATCHET, ModItems.CRUDE_STONE_SPADE,
                    ModItems.CRUDE_STONE_TILL));
    public static final DeferredItem<DaggerItem> CRUDE_STONE_KNIFE = ITEMS.register("crude_stone_knife",
            () -> new DaggerItem(ModToolTiers.CRUDE_STONE, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(ModToolTiers.CRUDE_STONE, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<PickaxeItem> CRUDE_STONE_PICK = ITEMS.register("crude_stone_pick",
            () -> new PickaxeItem(ModToolTiers.CRUDE_STONE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CRUDE_STONE, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> CRUDE_STONE_SPADE = ITEMS.register("crude_stone_spade",
            () -> new ShovelItem(ModToolTiers.CRUDE_STONE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CRUDE_STONE, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> CRUDE_STONE_HATCHET = ITEMS.register("crude_stone_hatchet",
            () -> new AxeItem(ModToolTiers.CRUDE_STONE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CRUDE_STONE, 6.75f, -3.2f))));
    public static final DeferredItem<HoeItem> CRUDE_STONE_TILL = ITEMS.register("crude_stone_till",
            () -> new HoeItem(ModToolTiers.CRUDE_STONE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CRUDE_STONE, 0, -3.0f))));

    public static final DeferredItem<RandomFlintToolItem> RANDOM_FLINT_TOOL = ITEMS.register("random_flint_tool",
            () -> new RandomFlintToolItem(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<DaggerItem> FLINT_KNIFE = ITEMS.register("flint_knife",
            () -> new DaggerItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(ModToolTiers.FLINT, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<PickaxeItem> FLINT_PICK = ITEMS.register("flint_pick",
            () -> new PickaxeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.FLINT, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> FLINT_SPADE = ITEMS.register("flint_spade",
            () -> new ShovelItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.FLINT, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> FLINT_HATCHET = ITEMS.register("flint_hatchet",
            () -> new AxeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.FLINT, 6.75f, -3.2f))));
    public static final DeferredItem<HoeItem> FLINT_TILL = ITEMS.register("flint_till",
            () -> new HoeItem(ModToolTiers.FLINT, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.FLINT, 0, -3.0f))));

    public static final DeferredItem<RandomToolItem> RANDOM_CRUDE_COPPER_TOOL = ITEMS.register("random_crude_copper_tool",
            () -> new RandomToolItem(new Item.Properties().stacksTo(1), "tooltip.sscaiderealism.random_crude_copper_tool.tooltip",
                    ModItems.CRUDE_COPPER_KNIFE, ModItems.CRUDE_COPPER_PICK, ModItems.CRUDE_COPPER_HATCHET, ModItems.CRUDE_COPPER_SPADE,
                    ModItems.CRUDE_COPPER_TILL));
    public static final DeferredItem<DaggerItem> CRUDE_COPPER_KNIFE = ITEMS.register("crude_copper_knife",
            () -> new DaggerItem(ModToolTiers.CRUDE_COPPER, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(ModToolTiers.CRUDE_COPPER, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<PickaxeItem> CRUDE_COPPER_PICK = ITEMS.register("crude_copper_pick",
            () -> new PickaxeItem(ModToolTiers.CRUDE_COPPER, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CRUDE_COPPER, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> CRUDE_COPPER_SPADE = ITEMS.register("crude_copper_spade",
            () -> new ShovelItem(ModToolTiers.CRUDE_COPPER, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CRUDE_COPPER, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> CRUDE_COPPER_HATCHET = ITEMS.register("crude_copper_hatchet",
            () -> new AxeItem(ModToolTiers.CRUDE_COPPER, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CRUDE_COPPER, 6, -3.2f))));
    public static final DeferredItem<HoeItem> CRUDE_COPPER_TILL = ITEMS.register("crude_copper_till",
            () -> new HoeItem(ModToolTiers.CRUDE_COPPER, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CRUDE_COPPER, 0, -3.0f))));

    public static final DeferredItem<RandomToolItem> RANDOM_CRUDE_IRON_TOOL = ITEMS.register("random_crude_iron_tool",
            () -> new RandomToolItem(new Item.Properties().stacksTo(1), "tooltip.sscaiderealism.random_crude_iron_tool.tooltip",
                    ModItems.CRUDE_IRON_KNIFE, ModItems.CRUDE_IRON_PICK, ModItems.CRUDE_IRON_HATCHET, ModItems.CRUDE_IRON_SPADE,
                    ModItems.CRUDE_IRON_TILL));
    public static final DeferredItem<DaggerItem> CRUDE_IRON_KNIFE = ITEMS.register("crude_iron_knife",
            () -> new DaggerItem(ModToolTiers.CRUDE_IRON, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(ModToolTiers.CRUDE_IRON, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<PickaxeItem> CRUDE_IRON_PICK = ITEMS.register("crude_iron_pick",
            () -> new PickaxeItem(ModToolTiers.CRUDE_IRON, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.CRUDE_IRON, 1, -2.8f))));
    public static final DeferredItem<ShovelItem> CRUDE_IRON_SPADE = ITEMS.register("crude_iron_spade",
            () -> new ShovelItem(ModToolTiers.CRUDE_IRON, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.CRUDE_IRON, 1.5f, -3.0f))));
    public static final DeferredItem<AxeItem> CRUDE_IRON_HATCHET = ITEMS.register("crude_iron_hatchet",
            () -> new AxeItem(ModToolTiers.CRUDE_IRON, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.CRUDE_IRON, 6, -3.2f))));
    public static final DeferredItem<HoeItem> CRUDE_IRON_TILL = ITEMS.register("crude_iron_till",
            () -> new HoeItem(ModToolTiers.CRUDE_IRON, new Item.Properties()
                    .attributes(HoeItem.createAttributes(ModToolTiers.CRUDE_IRON, 0, -3.0f))));

    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.COPPER, 3, -2.4f))));
    public static final DeferredItem<DaggerItem> COPPER_DAGGER = ITEMS.register("copper_dagger",
            () -> new DaggerItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(ModToolTiers.COPPER, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
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
    public static final DeferredItem<ChiselItem> COPPER_CHISEL = ITEMS.register("copper_chisel",
            () -> new ChiselItem(ModToolTiers.COPPER, new Item.Properties()
                    .attributes(ChiselItem.createAttributes(ModToolTiers.COPPER, 1, -3.0f, -1))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<DaggerItem> STONE_DAGGER = ITEMS.register("stone_dagger",
            () -> new DaggerItem(Tiers.STONE, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(Tiers.STONE, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<DaggerItem> GOLD_DAGGER = ITEMS.register("gold_dagger",
            () -> new DaggerItem(Tiers.GOLD, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(Tiers.GOLD, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<ChiselItem> GOLD_CHISEL = ITEMS.register("gold_chisel",
            () -> new ChiselItem(Tiers.GOLD, new Item.Properties()
                    .attributes(ChiselItem.createAttributes(Tiers.GOLD, 1, -3.0f, -1))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<DaggerItem> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new DaggerItem(Tiers.IRON, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(Tiers.IRON, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<ChiselItem> IRON_CHISEL = ITEMS.register("iron_chisel",
            () -> new ChiselItem(Tiers.IRON, new Item.Properties()
                    .attributes(ChiselItem.createAttributes(Tiers.IRON, 1, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<DaggerItem> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new DaggerItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(Tiers.DIAMOND, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<ChiselItem> DIAMOND_CHISEL = ITEMS.register("diamond_chisel",
            () -> new ChiselItem(Tiers.DIAMOND, new Item.Properties()
                    .attributes(ChiselItem.createAttributes(Tiers.DIAMOND, 1, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));

    public static final DeferredItem<DaggerItem> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new DaggerItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(DaggerItem.createAttributes(Tiers.NETHERITE, 3, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));
    public static final DeferredItem<ChiselItem> NETHERITE_CHISEL = ITEMS.register("netherite_chisel",
            () -> new ChiselItem(Tiers.NETHERITE, new Item.Properties()
                    .attributes(ChiselItem.createAttributes(Tiers.NETHERITE, 1, -2.1f, -1))
                    .craftRemainder(ModItems.ROCK.get())));



    public static final DeferredItem<ArmorItem> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(12))));
    public static final DeferredItem<ArmorItem> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(12))));
    public static final DeferredItem<ArmorItem> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(12))));
    public static final DeferredItem<ArmorItem> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new ArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(12))));
    public static final DeferredItem<Item> COPPER_HORSE_ARMOR = ITEMS.register("copper_horse_armor",
                    () -> new AnimalArmorItem(ModArmorMaterials.COPPER_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                            false, new Item.Properties().stacksTo(1)));


    public static final DeferredItem<Item> WASTELAND_FUNK_MUSIC_DISC = ITEMS.register("wasteland_funk_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.WASTELAND_FUNK_KEY).stacksTo(1)));

    public static final DeferredItem<Item> GECKO_SPAWN_EGG = ITEMS.register("gecko_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.GECKO, 0x31afaf, 0xffac00,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
