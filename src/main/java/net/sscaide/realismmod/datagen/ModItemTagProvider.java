package net.sscaide.realismmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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
        tag(ModTags.Items.BARK)
                .add(ModItems.OAK_BARK.get())
                .add(ModItems.SPRUCE_BARK.get())
                .add(ModItems.BIRCH_BARK.get())
                .add(ModItems.JUNGLE_BARK.get())
                .add(ModItems.ACACIA_BARK.get())
                .add(ModItems.DARK_OAK_BARK.get())
                .add(ModItems.MANGROVE_BARK.get())
                .add(ModItems.CHERRY_BARK.get())
                .add(ModItems.PALM_BARK.get());
        tag(ModTags.Items.PLANK_MATERIALS)
                .add(ModItems.OAK_BOARD.get())
                .add(ModItems.SPRUCE_BOARD.get())
                .add(ModItems.BIRCH_BOARD.get())
                .add(ModItems.JUNGLE_BOARD.get())
                .add(ModItems.ACACIA_BOARD.get())
                .add(ModItems.DARK_OAK_BOARD.get())
                .add(ModItems.MANGROVE_BOARD.get())
                .add(ModItems.CHERRY_BOARD.get())
                .add(ModItems.PALM_BOARD.get());

        tag(ModTags.Items.ROPES_FOR_CRAFTING_INCLUDE_VINE)
                .add(ModItems.VINE.get())
                .add(Items.TWISTING_VINES)
                .add(Items.WEEPING_VINES);

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

        tag(ModTags.Items.BRICK_FURNACE_RECIPES)
                .addTag(ModTags.Items.COPPER_INGOT_SMELTABLES)
                .addTag(ModTags.Items.COPPER_NUGGET_SMELTABLES)
                .add(ModItems.RAW_TIN.get())
                .add(ModItems.RAW_TIN_NUGGET.get())
                .add(Items.RAW_GOLD)
                .add(ModItems.RAW_GOLD_NUGGET.get())
                .add(ModItems.CLAY_BRICK.get())
                .add(Items.BEEF)
                .add(Items.PORKCHOP)
                .add(Items.CHICKEN)
                .add(Items.RABBIT)
                .add(Items.MUTTON)
                .add(Items.POTATO)
                .add(Items.KELP)
                .add(Items.COD)
                .add(Items.SALMON);
        tag(ModTags.Items.BRICK_FURNACE_BURNABLES)
                .add(Items.BAKED_POTATO)
                .add(Items.COOKED_BEEF)
                .add(Items.COOKED_PORKCHOP)
                .add(Items.COOKED_MUTTON)
                .add(Items.COOKED_CHICKEN)
                .add(Items.COOKED_RABBIT)
                .add(Items.COOKED_COD)
                .add(Items.COOKED_SALMON)
                .add(Items.DRIED_KELP);

        tag(ModTags.Items.BLOOMERY_RECIPES)
                .addTag(ModTags.Items.COPPER_INGOT_SMELTABLES)
                .addTag(ModTags.Items.COPPER_NUGGET_SMELTABLES)
                .addTag(ModTags.Items.IRON_INGOT_SMELTABLES)
                .addTag(ModTags.Items.IRON_NUGGET_SMELTABLES)
                .add(ModItems.RAW_TIN.get())
                .add(ModItems.RAW_TIN_NUGGET.get())
                .add(Items.RAW_GOLD)
                .add(ModItems.RAW_GOLD_NUGGET.get());
        tag(ModTags.Items.COAL_FOR_BLOOMERY)
                .addTag(ItemTags.COALS)
                .add(Items.COAL_BLOCK)
                .add(ModItems.COAL_NUGGET.get());

        tag(ModTags.Items.ANVIL_RECIPES)
                .addTag(ModTags.Items.ROCKS)
                .add(Items.FLINT)
                .add(ModItems.WIDE_SHAPED_FLINT.get())
                .add(ModItems.FANNED_SHAPED_FLINT.get())
                .add(ModItems.LONG_SHAPED_FLINT.get())
                .add(ModItems.THIN_SHAPED_FLINT.get())
                .add(Items.RAW_COPPER)
                .add(ModItems.WIDE_SHAPED_COPPER.get())
                .add(ModItems.FANNED_SHAPED_COPPER.get())
                .add(ModItems.LONG_SHAPED_COPPER.get())
                .add(ModItems.JAGGED_SHAPED_COPPER.get())
                .add(ModItems.THIN_SHAPED_COPPER.get())
                .add(Items.RAW_IRON)
                .add(ModItems.WIDE_SHAPED_IRON.get())
                .add(ModItems.FANNED_SHAPED_IRON.get())
                .add(ModItems.LONG_SHAPED_IRON.get())
                .add(ModItems.JAGGED_SHAPED_IRON.get())
                .add(ModItems.THIN_SHAPED_IRON.get())
                ;

        tag(ModTags.Items.IRON_INGOT_SMELTABLES)
                .add(ModItems.WIDE_SHAPED_IRON.get())
                .add(ModItems.FANNED_SHAPED_IRON.get())
                .add(Items.RAW_IRON);
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
        tag(ModTags.Items.CARVED_STONE_BRICKS)
                .add(ModItems.STONE_BRICK.get())
                .add(ModItems.DEEPSLATE_BRICK.get())
                .add(ModItems.TUFF_BRICK.get())
                .add(ModItems.BLACKSTONE_BRICK.get())
                .add(ModItems.END_BRICK.get());

        tag(ModTags.Items.STRINGS)
                .add(Items.STRING);


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
        tag(ModTags.Items.FIRESTARTERS)
                .add(Items.FLINT_AND_STEEL)
                .add(Items.FIRE_CHARGE)
                .add(ModItems.FIRE_PLOUGH.get())
                .add(ModItems.BOW_DRILL.get());

        tag(ModTags.Items.CRUSHING_CRAFTING)
                .add(ModItems.SHARPENED_ROCK.get())
                .add(ModItems.SHARPENED_COPPER_CHUNK.get())
                .add(ModItems.SHARPENED_IRON_CHUNK.get());
        tag(ModTags.Items.CRUSHING_CRAFTING_COPPER_PLUS)
                .add(ModItems.SHARPENED_COPPER_CHUNK.get())
                .add(ModItems.SHARPENED_IRON_CHUNK.get());
        tag(ModTags.Items.CRUSHING_CRAFTING_IRON_PLUS)
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
        tag(ItemTags.WOODEN_STAIRS)
                .add(ModBlocks.PALM_STAIRS.asItem());
        tag(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.PALM_SLAB.asItem());
        tag(ItemTags.WOODEN_BUTTONS)
                .add(ModBlocks.PALM_BUTTON.asItem());
        tag(ItemTags.WOODEN_DOORS)
                .add(ModBlocks.PALM_DOOR.asItem());
        tag(ItemTags.WOODEN_FENCES)
                .add(ModBlocks.PALM_FENCE.asItem())
                .add(ModBlocks.PALM_FENCE_GATE.asItem())
        ;
        tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.PALM_PRESSURE_PLATE.asItem());
        tag(ItemTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.PALM_TRAPDOOR.asItem());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem())
                .addTag(ModTags.Items.CHIPPED_LOGS)
                .addTag(ModTags.Items.THIN_LOGS);
        tag(ModTags.Items.PALM_LOGS)
                .add(ModBlocks.PALM_LOG.asItem())
                .add(ModBlocks.PALM_WOOD.asItem())
                .add(ModBlocks.STRIPPED_PALM_LOG.asItem())
                .add(ModBlocks.STRIPPED_PALM_WOOD.asItem());
        tag(ModTags.Items.CHIPPED_LOGS)
                .add(ModBlocks.CHIPPED_OAK_LOG.asItem())
                .add(ModBlocks.CHIPPED_SPRUCE_LOG.asItem())
                .add(ModBlocks.CHIPPED_BIRCH_LOG.asItem())
                .add(ModBlocks.CHIPPED_JUNGLE_LOG.asItem())
                .add(ModBlocks.CHIPPED_ACACIA_LOG.asItem())
                .add(ModBlocks.CHIPPED_DARK_OAK_LOG.asItem())
                .add(ModBlocks.CHIPPED_MANGROVE_LOG.asItem())
                .add(ModBlocks.CHIPPED_CHERRY_LOG.asItem())
                .add(ModBlocks.CHIPPED_PALM_LOG.asItem());
        tag(ModTags.Items.THIN_LOGS)
                .add(ModBlocks.THIN_OAK_LOG.asItem())
                .add(ModBlocks.THIN_SPRUCE_LOG.asItem())
                .add(ModBlocks.THIN_BIRCH_LOG.asItem())
                .add(ModBlocks.THIN_JUNGLE_LOG.asItem())
                .add(ModBlocks.THIN_ACACIA_LOG.asItem())
                .add(ModBlocks.THIN_DARK_OAK_LOG.asItem())
                .add(ModBlocks.THIN_MANGROVE_LOG.asItem())
                .add(ModBlocks.THIN_CHERRY_LOG.asItem())
                .add(ModBlocks.THIN_PALM_LOG.asItem());


        tag(ModTags.Items.CRUDE_WOOD_BLOCKS)
                .add(ModBlocks.CRUDE_OAK_BLOCK.asItem())
                .add(ModBlocks.CRUDE_SPRUCE_BLOCK.asItem())
                .add(ModBlocks.CRUDE_BIRCH_BLOCK.asItem())
                .add(ModBlocks.CRUDE_JUNGLE_BLOCK.asItem())
                .add(ModBlocks.CRUDE_ACACIA_BLOCK.asItem())
                .add(ModBlocks.CRUDE_DARK_OAK_BLOCK.asItem())
                .add(ModBlocks.CRUDE_MANGROVE_BLOCK.asItem())
                .add(ModBlocks.CRUDE_CHERRY_BLOCK.asItem())
                .add(ModBlocks.CRUDE_PALM_BLOCK.asItem());


        tag(ModTags.Items.COBBLESTONE_REPLACE).add(Blocks.COBBLESTONE.asItem()).add(ModBlocks.MOD_COBBLESTONE.asItem());
        tag(ModTags.Items.COBBLESTONE_REPLACE_STAIRS).add(Blocks.COBBLESTONE_STAIRS.asItem()).add(ModBlocks.MOD_COBBLESTONE_STAIRS.asItem());
        tag(ModTags.Items.COBBLESTONE_REPLACE_SLAB).add(Blocks.COBBLESTONE_SLAB.asItem()).add(ModBlocks.MOD_COBBLESTONE_SLAB.asItem());
        tag(ModTags.Items.DEEPSLATE_REPLACE).add(Blocks.COBBLED_DEEPSLATE.asItem()).add(ModBlocks.MOD_COBBLED_DEEPSLATE.asItem());
        tag(ModTags.Items.DEEPSLATE_REPLACE_STAIRS).add(Blocks.COBBLED_DEEPSLATE_STAIRS.asItem()).add(ModBlocks.MOD_COBBLED_DEEPSLATE_STAIRS.asItem());
        tag(ModTags.Items.DEEPSLATE_REPLACE_SLAB).add(Blocks.COBBLED_DEEPSLATE_SLAB.asItem()).add(ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB.asItem());

        tag(ModTags.Items.CRACKED_STONE)
                .add(ModBlocks.CRACKED_STONE.asItem())
                .add(ModBlocks.CRACKED_DEEPSLATE.asItem())
                .add(ModBlocks.CRACKED_GRANITE.asItem())
                .add(ModBlocks.CRACKED_DIORITE.asItem())
                .add(ModBlocks.CRACKED_ANDESITE.asItem())
                .add(ModBlocks.CRACKED_CALCITE.asItem())
                .add(ModBlocks.CRACKED_TUFF.asItem())
                .add(ModBlocks.CRACKED_DRIPSTONE.asItem())
                .add(ModBlocks.CRACKED_BASALT.asItem())
                .add(ModBlocks.CRACKED_END_STONE.asItem())
        ;
        tag(ModTags.Items.COBBLESTONE)
                .add(Blocks.COBBLESTONE.asItem())
                .add(Blocks.INFESTED_COBBLESTONE.asItem())
                .add(Blocks.COBBLED_DEEPSLATE.asItem())
                .add(ModBlocks.MOD_COBBLESTONE.asItem())
                .add(ModBlocks.MOD_COBBLED_DEEPSLATE.asItem())
                .add(ModBlocks.COBBLED_SANDSTONE.asItem())
                .add(ModBlocks.COBBLED_RED_SANDSTONE.asItem())
                .add(ModBlocks.COBBLED_WHITE_SANDSTONE.asItem())
                .add(ModBlocks.COBBLED_GRANITE.asItem())
                .add(ModBlocks.COBBLED_DIORITE.asItem())
                .add(ModBlocks.COBBLED_ANDESITE.asItem())
                .add(ModBlocks.COBBLED_CALCITE.asItem())
                .add(ModBlocks.COBBLED_TUFF.asItem())
                .add(ModBlocks.COBBLED_DRIPSTONE.asItem())
                .add(ModBlocks.COBBLED_NETHERRACK.asItem())
                .add(ModBlocks.COBBLED_BLACKSTONE.asItem())
                .add(ModBlocks.COBBLED_BASALT.asItem())
                .add(ModBlocks.COBBLED_END_STONE.asItem())
        ;
    }
}
