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

        tag(ModTags.Items.PACKED_MUD_BINDING_AGENTS)
                .add(ModItems.VINE.get())
                .add(ModItems.FLAX.get())
                .add(ModItems.CLUMP_OF_MOSS.get());

        tag(ModTags.Items.DYES)
                .add(Items.WHITE_DYE)
                .add(Items.LIGHT_GRAY_DYE)
                .add(Items.GRAY_DYE)
                .add(Items.BLACK_DYE)
                .add(Items.BROWN_DYE)
                .add(Items.RED_DYE)
                .add(Items.ORANGE_DYE)
                .add(Items.YELLOW_DYE)
                .add(Items.LIME_DYE)
                .add(Items.GREEN_DYE)
                .add(Items.CYAN_DYE)
                .add(Items.LIGHT_BLUE_DYE)
                .add(Items.BLUE_DYE)
                .add(Items.PURPLE_DYE)
                .add(Items.MAGENTA_DYE)
                .add(Items.PINK_DYE);

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
        tag(ModTags.Items.PLANK_MATERIALS)
                .add(ModItems.OAK_PLANK.get())
                .add(ModItems.SPRUCE_PLANK.get())
                .add(ModItems.BIRCH_PLANK.get())
                .add(ModItems.JUNGLE_PLANK.get())
                .add(ModItems.ACACIA_PLANK.get())
                .add(ModItems.DARK_OAK_PLANK.get())
                .add(ModItems.MANGROVE_PLANK.get())
                .add(ModItems.CHERRY_PLANK.get())
                .add(ModItems.PALM_PLANK.get());

        tag(ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .add(ModItems.VINE.get());

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
                .add(ModItems.COPPER_DUST.get())
                .add(ModItems.RAW_COPPER_NUGGET.get());

        tag(ModTags.Items.IRON_INGOT_SMELTABLES)
                .add(ModItems.WIDE_SHAPED_IRON.get())
                .add(ModItems.FANNED_SHAPED_IRON.get());
        tag(ModTags.Items.IRON_NUGGET_SMELTABLES)
                .add(ModItems.LONG_SHAPED_IRON.get())
                .add(ModItems.JAGGED_SHAPED_IRON.get())
                .add(ModItems.THIN_SHAPED_IRON.get())
                .add(ModItems.IRON_DUST.get())
                .add(ModItems.RAW_IRON_NUGGET.get());

        tag(ModTags.Items.ROCKS)
                .add(ModItems.ROCK.get())
                .add(ModItems.DEEPSLATE_ROCK.get())
                .add(ModItems.SANDSTONE_ROCK.get())
                .add(ModItems.RED_SANDSTONE_ROCK.get())
                .add(ModItems.WHITE_SANDSTONE_ROCK.get())
                .add(ModItems.GRANITE_ROCK.get())
                .add(ModItems.DIORITE_ROCK.get())
                .add(ModItems.ANDESITE_ROCK.get())
                .add(ModItems.CALCITE_ROCK.get())
                .add(ModItems.TUFF_ROCK.get())
                .add(ModItems.DRIPSTONE_ROCK.get())
                .add(ModItems.NETHERROCK.get())
                .add(ModItems.BLACKROCK.get())
                .add(ModItems.BASALT_ROCK.get())
                .add(ModItems.END_ROCK.get());
        tag(ModTags.Items.ROCKS_NO_SANDSTONE)
                .add(ModItems.ROCK.get())
                .add(ModItems.DEEPSLATE_ROCK.get())
                .add(ModItems.GRANITE_ROCK.get())
                .add(ModItems.DIORITE_ROCK.get())
                .add(ModItems.ANDESITE_ROCK.get())
                .add(ModItems.CALCITE_ROCK.get())
                .add(ModItems.TUFF_ROCK.get());

        tag(ModTags.Items.STONE_BRICK_MATERIALS)
                .add(ModItems.STONE_BRICK.get())
                .add(ModItems.DEEPSLATE_BRICK.get())
                .add(ModItems.TUFF_BRICK.get())
                .add(ModItems.BLACKSTONE_BRICK.get())
                .add(ModItems.END_BRICK.get());


        tag(ItemTags.SWORDS)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.COPPER_SWORD.get());
        tag(ModTags.Items.DAGGERS)
                .add(ModItems.CRUDE_STONE_KNIFE.get())
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.CRUDE_COPPER_KNIFE.get())
                .add(ModItems.CRUDE_IRON_KNIFE.get())
                .add(ModItems.STONE_DAGGER.get())
                .add(ModItems.GOLD_DAGGER.get())
                .add(ModItems.IRON_DAGGER.get())
                .add(ModItems.DIAMOND_DAGGER.get())
                .add(ModItems.NETHERITE_DAGGER.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.CRUDE_STONE_PICK.get())
                .add(ModItems.FLINT_PICK.get())
                .add(ModItems.CRUDE_COPPER_PICK.get())
                .add(ModItems.COPPER_PICKAXE.get())
                .add(ModItems.CRUDE_IRON_PICK.get());
        tag(ItemTags.AXES)
                .add(ModItems.SHARPENED_STICK.get())
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.CRUDE_STONE_HATCHET.get())
                .add(ModItems.FLINT_HATCHET.get())
                .add(ModItems.CRUDE_COPPER_HATCHET.get())
                .add(ModItems.COPPER_AXE.get())
                .add(ModItems.CRUDE_IRON_HATCHET.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.CRUDE_STONE_SPADE.get())
                .add(ModItems.FLINT_SPADE.get())
                .add(ModItems.CRUDE_COPPER_SPADE.get())
                .add(ModItems.COPPER_SHOVEL.get())
                .add(ModItems.CRUDE_IRON_SPADE.get());
        tag(ItemTags.HOES)
                .add(ModItems.CRUDE_STONE_TILL.get())
                .add(ModItems.FLINT_TILL.get())
                .add(ModItems.CRUDE_COPPER_TILL.get())
                .add(ModItems.COPPER_HOE.get())
                .add(ModItems.CRUDE_IRON_TILL.get());

        tag(ModTags.Items.CRUSHING_CRAFTING)
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.SHARPENED_COPPER_CHUNK.get())
                .add(ModItems.SHARPENED_IRON_CHUNK.get());
        tag(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .add(ModItems.SHARPENED_COPPER_CHUNK.get())
                .add(ModItems.SHARPENED_IRON_CHUNK.get());
        tag(ModTags.Items.CRUDE_SHARPENING_CRAFTING)
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.SHARPENED_COPPER_CHUNK.get())
                .add(ModItems.SHARPENED_IRON_CHUNK.get())
                .add(ModItems.CRUDE_STONE_KNIFE.get())
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.CRUDE_COPPER_KNIFE.get())
                .add(ModItems.CRUDE_IRON_KNIFE.get());
        tag(ModTags.Items.CRUDE_CARVING_CRAFTING)
                .add(ModItems.CRUDE_STONE_KNIFE.get())
                .add(ModItems.FLINT_KNIFE.get())
                .add(ModItems.CRUDE_COPPER_KNIFE.get())
                .add(ModItems.CRUDE_IRON_KNIFE.get());
        tag(ModTags.Items.CARVING_CRAFTING)
                .add(ModItems.COPPER_DAGGER.get())
                .add(ModItems.IRON_DAGGER.get())
                .add(ModItems.DIAMOND_DAGGER.get())
                .add(ModItems.NETHERITE_DAGGER.get())
                .add(ModItems.COPPER_CHISEL.get())
                .add(ModItems.IRON_CHISEL.get())
                .add(ModItems.DIAMOND_CHISEL.get())
                .add(ModItems.NETHERITE_CHISEL.get());
        tag(ModTags.Items.CHISEL_CRAFTING)
                .add(ModItems.COPPER_CHISEL.get())
                .add(ModItems.IRON_CHISEL.get())
                .add(ModItems.DIAMOND_CHISEL.get())
                .add(ModItems.NETHERITE_CHISEL.get());


        this.tag(ItemTags.TRIMMABLE_ARMOR)
                        .add(ModItems.COPPER_HELMET.get())
                        .add(ModItems.COPPER_CHESTPLATE.get())
                        .add(ModItems.COPPER_LEGGINGS.get())
                        .add(ModItems.COPPER_BOOTS.get());
        this.tag(ItemTags.TRIM_MATERIALS)
                        .add(ModItems.TIN_INGOT.get());


        tag(ItemTags.PLANKS)
                .add(ModBlocks.PALM_PLANKS.asItem());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem());

        tag(ModTags.Items.PALM_LOGS)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem());

    }
}
