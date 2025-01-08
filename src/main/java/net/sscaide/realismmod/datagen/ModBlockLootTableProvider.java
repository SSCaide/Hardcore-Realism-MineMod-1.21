package net.sscaide.realismmod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
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


        add(ModBlocks.DEEPSLATE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.DEEPSLATE_SLAB.get()));
        add(ModBlocks.CALCITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CALCITE_SLAB.get()));


        dropSelf(ModBlocks.PALM_LOG.get());
        dropSelf(ModBlocks.PALM_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(ModBlocks.STRIPPED_PALM_WOOD.get());
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


        add(ModBlocks.TIN_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get(), 1, 3));
        dropSelf(ModBlocks.RAW_TIN_BLOCK.get());
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.TIN_WALL.get());

        dropSelf(ModBlocks.TIN_BULB.get());


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
