package net.sscaide.realismmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RealismMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CLUMP_OF_DIRT.get());
        basicItem(ModItems.ROCK.get());
        basicItem(ModItems.VINE.get());

        basicItem(ModItems.OAK_BARK.get());
        basicItem(ModItems.SPRUCE_BARK.get());
        basicItem(ModItems.BIRCH_BARK.get());
        basicItem(ModItems.JUNGLE_BARK.get());
        basicItem(ModItems.ACACIA_BARK.get());
        basicItem(ModItems.DARK_OAK_BARK.get());
        basicItem(ModItems.MANGROVE_BARK.get());
        basicItem(ModItems.CHERRY_BARK.get());
        basicItem(ModItems.PALM_BARK.get());

        basicItem(ModItems.RAW_TIN.get());
        basicItem(ModItems.TIN_INGOT.get());

        basicItem(ModItems.ORANGE.get());

        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_HOE);


        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        wallItem(ModBlocks.TIN_WALL, ModBlocks.TIN_BLOCK);
        basicItem(ModBlocks.PALM_DOOR.asItem());

    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
