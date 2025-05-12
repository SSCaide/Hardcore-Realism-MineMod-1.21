package net.sscaide.realismmod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.FlaxCropBlock;
import net.sscaide.realismmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {


    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        add(ModBlocks.DIRT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DIRT_SLAB.get()));
        add(ModBlocks.MUD_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MUD_SLAB.get()));
        add(ModBlocks.CLAY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CLAY_SLAB.get()));
        add(ModBlocks.GRAVEL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.GRAVEL_SLAB.get()));
        add(ModBlocks.SAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SAND_SLAB.get()));
        add(ModBlocks.RED_SAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.RED_SAND_SLAB.get()));
        dropSelf(ModBlocks.WHITE_SAND.get());
        add(ModBlocks.WHITE_SAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_SAND_SLAB.get()));
        dropSelf(ModBlocks.WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.WHITE_SANDSTONE_STAIRS.get());
        add(ModBlocks.WHITE_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.WHITE_SANDSTONE_SLAB.get()));
        dropSelf(ModBlocks.WHITE_SANDSTONE_WALL.get());
        dropSelf(ModBlocks.CHISELED_WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_WHITE_SANDSTONE_STAIRS.get());
        add(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SMOOTH_WHITE_SANDSTONE_SLAB.get()));
        dropSelf(ModBlocks.CUT_WHITE_SANDSTONE.get());
        add(ModBlocks.CUT_WHITE_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CUT_WHITE_SANDSTONE_SLAB.get()));

        add(ModBlocks.MOSS_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MOSS_SLAB.get()));
        add(ModBlocks.SOUL_SOIL_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SOUL_SOIL_SLAB.get()));
        add(ModBlocks.SOUL_SAND_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SOUL_SAND_SLAB.get()));

        add(ModBlocks.DEEPSLATE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEEPSLATE_SLAB.get()));
        add(ModBlocks.CALCITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CALCITE_SLAB.get()));
        add(ModBlocks.DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DRIPSTONE_SLAB.get()));
        add(ModBlocks.NETHERRACK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NETHERRACK_SLAB.get()));
        add(ModBlocks.BASALT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BASALT_SLAB.get()));
        add(ModBlocks.SMOOTH_BASALT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SMOOTH_BASALT_SLAB.get()));
        add(ModBlocks.END_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.END_STONE_SLAB.get()));


        dropSelf(ModBlocks.CHIPPED_OAK_LOG.get());
        dropSelf(ModBlocks.THIN_OAK_LOG.get());
        dropSelf(ModBlocks.CHIPPED_SPRUCE_LOG.get());
        dropSelf(ModBlocks.THIN_SPRUCE_LOG.get());
        dropSelf(ModBlocks.CHIPPED_BIRCH_LOG.get());
        dropSelf(ModBlocks.THIN_BIRCH_LOG.get());
        dropSelf(ModBlocks.CHIPPED_JUNGLE_LOG.get());
        dropSelf(ModBlocks.THIN_JUNGLE_LOG.get());
        dropSelf(ModBlocks.CHIPPED_ACACIA_LOG.get());
        dropSelf(ModBlocks.THIN_ACACIA_LOG.get());
        dropSelf(ModBlocks.CHIPPED_DARK_OAK_LOG.get());
        dropSelf(ModBlocks.THIN_DARK_OAK_LOG.get());
        dropSelf(ModBlocks.CHIPPED_MANGROVE_LOG.get());
        dropSelf(ModBlocks.THIN_MANGROVE_LOG.get());
        dropSelf(ModBlocks.CHIPPED_CHERRY_LOG.get());
        dropSelf(ModBlocks.THIN_CHERRY_LOG.get());
        dropSelf(ModBlocks.CHIPPED_PALM_LOG.get());
        dropSelf(ModBlocks.THIN_PALM_LOG.get());

        dropSelf(ModBlocks.PALM_LOG.get());
        dropSelf(ModBlocks.PALM_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(ModBlocks.PALM_SAPLING.get());
        add(ModBlocks.PALM_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        dropSelf(ModBlocks.PALM_PLANKS.get());
        dropSelf(ModBlocks.PALM_STAIRS.get());
        add(ModBlocks.PALM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.PALM_SLAB.get()));
        dropSelf(ModBlocks.PALM_FENCE.get());
        dropSelf(ModBlocks.PALM_FENCE_GATE.get());
        add(ModBlocks.PALM_DOOR.get(),
                block -> createDoorTable(ModBlocks.PALM_DOOR.get()));
        dropSelf(ModBlocks.PALM_TRAPDOOR.get());
        dropSelf(ModBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.PALM_BUTTON.get());

        add(ModBlocks.CRUDE_OAK_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_OAK_BLOCK.get(), ModItems.OAK_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_SPRUCE_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_SPRUCE_BLOCK.get(), ModItems.SPRUCE_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_BIRCH_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_BIRCH_BLOCK.get(), ModItems.BIRCH_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_JUNGLE_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_JUNGLE_BLOCK.get(), ModItems.JUNGLE_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_ACACIA_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_ACACIA_BLOCK.get(), ModItems.ACACIA_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_DARK_OAK_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_DARK_OAK_BLOCK.get(), ModItems.DARK_OAK_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_MANGROVE_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_MANGROVE_BLOCK.get(), ModItems.MANGROVE_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_CHERRY_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_CHERRY_BLOCK.get(), ModItems.CHERRY_TIMBER.get(), 4, 4));
        add(ModBlocks.CRUDE_PALM_BLOCK.get(),
                block ->   createMultipleOreDrops(ModBlocks.CRUDE_PALM_BLOCK.get(), ModItems.PALM_TIMBER.get(), 4, 4));


        add(ModBlocks.CRACKED_STONE.get(),
                block -> createCobble(ModBlocks.CRACKED_STONE.get(), Blocks.COBBLESTONE.asItem()));
        dropSelf(ModBlocks.MOD_COBBLESTONE.get());
        dropSelf(ModBlocks.MOD_COBBLESTONE_STAIRS.get());
        add(ModBlocks.MOD_COBBLESTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MOD_COBBLESTONE_SLAB.get()));
        add(ModBlocks.CRACKED_DEEPSLATE.get(),
                block -> createCobble(ModBlocks.CRACKED_DEEPSLATE.get(), Blocks.COBBLED_DEEPSLATE.asItem()));
        dropSelf(ModBlocks.MOD_COBBLED_DEEPSLATE.get());
        dropSelf(ModBlocks.MOD_COBBLED_DEEPSLATE_STAIRS.get());
        add(ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB.get()));
        dropSelf(ModBlocks.COBBLED_SANDSTONE.get());
        dropSelf(ModBlocks.COBBLED_SANDSTONE_STAIRS.get());
        add(ModBlocks.COBBLED_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_SANDSTONE_SLAB.get()));
        dropSelf(ModBlocks.COBBLED_RED_SANDSTONE.get());
        dropSelf(ModBlocks.COBBLED_RED_SANDSTONE_STAIRS.get());
        add(ModBlocks.COBBLED_RED_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_RED_SANDSTONE_SLAB.get()));
        dropSelf(ModBlocks.COBBLED_WHITE_SANDSTONE.get());
        dropSelf(ModBlocks.COBBLED_WHITE_SANDSTONE_STAIRS.get());
        add(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB.get()));
        add(ModBlocks.CRACKED_GRANITE.get(),
                block -> createCobble(ModBlocks.CRACKED_GRANITE.get(), ModBlocks.COBBLED_GRANITE.asItem()));
        dropSelf(ModBlocks.COBBLED_GRANITE.get());
        dropSelf(ModBlocks.COBBLED_GRANITE_STAIRS.get());
        add(ModBlocks.COBBLED_GRANITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_GRANITE_SLAB.get()));
        add(ModBlocks.CRACKED_DIORITE.get(),
                block -> createCobble(ModBlocks.CRACKED_DIORITE.get(), ModBlocks.COBBLED_DIORITE.asItem()));
        dropSelf(ModBlocks.COBBLED_DIORITE.get());
        dropSelf(ModBlocks.COBBLED_DIORITE_STAIRS.get());
        add(ModBlocks.COBBLED_DIORITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_DIORITE_SLAB.get()));
        add(ModBlocks.CRACKED_ANDESITE.get(),
                block -> createCobble(ModBlocks.CRACKED_ANDESITE.get(), ModBlocks.COBBLED_ANDESITE.asItem()));
        dropSelf(ModBlocks.COBBLED_ANDESITE.get());
        dropSelf(ModBlocks.COBBLED_ANDESITE_STAIRS.get());
        add(ModBlocks.COBBLED_ANDESITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_ANDESITE_SLAB.get()));
        add(ModBlocks.CRACKED_CALCITE.get(),
                block -> createCobble(ModBlocks.CRACKED_CALCITE.get(), ModBlocks.COBBLED_CALCITE.asItem()));
        dropSelf(ModBlocks.COBBLED_CALCITE.get());
        dropSelf(ModBlocks.COBBLED_CALCITE_STAIRS.get());
        add(ModBlocks.COBBLED_CALCITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_CALCITE_SLAB.get()));
        add(ModBlocks.CRACKED_TUFF.get(),
                block -> createCobble(ModBlocks.CRACKED_TUFF.get(), ModBlocks.COBBLED_TUFF.asItem()));
        dropSelf(ModBlocks.COBBLED_TUFF.get());
        dropSelf(ModBlocks.COBBLED_TUFF_STAIRS.get());
        add(ModBlocks.COBBLED_TUFF_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_TUFF_SLAB.get()));
        add(ModBlocks.CRACKED_DRIPSTONE.get(),
                block -> createCobble(ModBlocks.CRACKED_DRIPSTONE.get(), ModBlocks.COBBLED_DRIPSTONE.asItem()));
        dropSelf(ModBlocks.COBBLED_DRIPSTONE.get());
        dropSelf(ModBlocks.COBBLED_DRIPSTONE_STAIRS.get());
        add(ModBlocks.COBBLED_DRIPSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_DRIPSTONE_SLAB.get()));
        dropSelf(ModBlocks.COBBLED_NETHERRACK.get());
        dropSelf(ModBlocks.COBBLED_NETHERRACK_STAIRS.get());
        add(ModBlocks.COBBLED_NETHERRACK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_NETHERRACK_SLAB.get()));
        dropSelf(ModBlocks.COBBLED_BLACKSTONE.get());
        dropSelf(ModBlocks.COBBLED_BLACKSTONE_STAIRS.get());
        add(ModBlocks.COBBLED_BLACKSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_BLACKSTONE_SLAB.get()));
        add(ModBlocks.CRACKED_BASALT.get(),
                block -> createCobble(ModBlocks.CRACKED_BASALT.get(), ModBlocks.COBBLED_BASALT.asItem()));
        dropSelf(ModBlocks.COBBLED_BASALT.get());
        dropSelf(ModBlocks.COBBLED_BASALT_STAIRS.get());
        add(ModBlocks.COBBLED_BASALT_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_BASALT_SLAB.get()));
        add(ModBlocks.CRACKED_END_STONE.get(),
                block -> createCobble(ModBlocks.CRACKED_END_STONE.get(), ModBlocks.COBBLED_END_STONE.asItem()));
        dropSelf(ModBlocks.COBBLED_END_STONE.get());
        dropSelf(ModBlocks.COBBLED_END_STONE_STAIRS.get());
        add(ModBlocks.COBBLED_END_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.COBBLED_END_STONE_SLAB.get()));


        add(ModBlocks.TIN_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get(), 1, 3));
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get(), 1, 3));
        dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.TIN_WALL.get());

        dropSelf(ModBlocks.TIN_BULB.get());


        dropOther(ModBlocks.WET_CLAY_BRICK.get(), ModItems.CLAY_BRICK);
        dropOther(ModBlocks.DRIED_BRICK.get(), Items.BRICK);

        dropSelf(ModBlocks.BRICK_FURNACE.get());
        dropSelf(ModBlocks.BLOOMERY.get());
        dropSelf(ModBlocks.STONE_ANVIL.get());


        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.FLAX_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(FlaxCropBlock.AGE, 3));
        this.add(ModBlocks.FLAX_CROP.get(), this.createCropDrops(ModBlocks.FLAX_CROP.get(),
                ModItems.FLAX.get(), ModItems.FLAX_SEEDS.get(), lootItemConditionBuilder));


        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.BLUEBERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BLUEBERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.BLUEBERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));


        dropSelf(ModBlocks.IRON_BREAKABLE_STONE.get());
        dropSelf(ModBlocks.IRON_BREAKABLE_SOIL.get());
        dropSelf(ModBlocks.IRON_BREAKABLE_WOOD.get());
    }

    protected LootTable.Builder createCobble(Block pBlock, Item item) {
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }

}
