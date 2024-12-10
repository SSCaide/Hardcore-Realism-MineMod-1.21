package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, RealismMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.SEEDS_FOR_CRAFTING)
                .add(Items.WHEAT_SEEDS)
                .add(Items.BEETROOT_SEEDS)
                .add(Items.MELON_SEEDS)
                .add(Items.PUMPKIN_SEEDS)
                .add(Items.TORCHFLOWER_SEEDS);
        tag(ModTags.Items.TIMBER)
                .add(ModItems.OAK_TIMBER.get())
                .add(ModItems.SPRUCE_TIMBER.get())
                .add(ModItems.BIRCH_TIMBER.get())
                .add(ModItems.JUNGLE_TIMBER.get())
                .add(ModItems.ACACIA_TIMBER.get())
                .add(ModItems.DARK_OAK_TIMBER.get())
                .add(ModItems.MANGROVE_TIMBER.get())
                .add(ModItems.CHERRY_TIMBER.get())
                .add(ModItems.PALM_TIMBER.get());
        tag(ModTags.Items.GRAVEL_MATERIALS)
                .add(ModItems.PILE_OF_GRAVEL.get())
                .add(ModItems.WIDE_SHAPED_FLINT.get())
                .add(ModItems.FANNED_SHAPED_FLINT.get())
                .add(ModItems.LONG_SHAPED_FLINT.get())
                .add(ModItems.THIN_SHAPED_FLINT.get())
                .add(Items.FLINT);
        tag(ModTags.Items.COPPER_INGOT_SMELTABLES)
                .add(ModItems.WIDE_SHAPED_COPPER.get())
                .add(ModItems.FANNED_SHAPED_COPPER.get());
        tag(ModTags.Items.COPPER_NUGGET_SMELTABLES)
                .add(ModItems.LONG_SHAPED_COPPER.get())
                .add(ModItems.JAGGED_SHAPED_COPPER.get())
                .add(ModItems.THIN_SHAPED_COPPER.get())
                .add(ModItems.COPPER_DUST.get());
        tag(ModTags.Items.ROCKS)
                .add(ModItems.ROCK.get())
                .add(ModItems.DEEPSLATE_ROCK.get())
                .add(ModItems.SANDSTONE_ROCK.get())
                .add(ModItems.RED_SANDSTONE_ROCK.get())
                .add(ModItems.GRANITE_ROCK.get())
                .add(ModItems.DIORITE_ROCK.get())
                .add(ModItems.ANDESITE_ROCK.get())
                .add(ModItems.CALCITE_ROCK.get())
                .add(ModItems.TUFF_ROCK.get());
        tag(ModTags.Items.ROCKS_NO_SANDSTONE)
                .add(ModItems.ROCK.get())
                .add(ModItems.DEEPSLATE_ROCK.get())
                .add(ModItems.GRANITE_ROCK.get())
                .add(ModItems.DIORITE_ROCK.get())
                .add(ModItems.ANDESITE_ROCK.get())
                .add(ModItems.CALCITE_ROCK.get())
                .add(ModItems.TUFF_ROCK.get());


        tag(ItemTags.SWORDS)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.CRUDE_STONE_KNIFE.get())
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.CRUDE_COPPER_KNIFE.get())
                .add(ModItems.COPPER_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.CRUDE_STONE_PICK.get())
                .add(ModItems.FLINT_PICK.get())
                .add(ModItems.CRUDE_COPPER_PICK.get())
                .add(ModItems.COPPER_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.CRUDE_STONE_HATCHET.get())
                .add(ModItems.FLINT_HATCHET.get())
                .add(ModItems.CRUDE_COPPER_HATCHET.get())
                .add(ModItems.COPPER_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CRUDE_STONE_SPADE.get())
                .add(ModItems.FLINT_SPADE.get())
                .add(ModItems.CRUDE_COPPER_SPADE.get())
                .add(ModItems.COPPER_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.CRUDE_STONE_TILL.get())
                .add(ModItems.FLINT_TILL.get())
                .add(ModItems.CRUDE_COPPER_TILL.get())
                .add(ModItems.COPPER_HOE.get());
        tag(ModTags.Items.SHARPENED_ROCKS)
                .add(ModItems.SHARPENED_ROCK.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                        .add(ModItems.COPPER_HELMET.get())
                        .add(ModItems.COPPER_CHESTPLATE.get())
                        .add(ModItems.COPPER_LEGGINGS.get())
                        .add(ModItems.COPPER_BOOTS.get());
        this.tag(ItemTags.TRIM_MATERIALS)
                        .add(ModItems.TIN_INGOT.get());


        tag(ItemTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS.asItem());
        tag(ModTags.Items.PALM_LOGS)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem());

    }
}
