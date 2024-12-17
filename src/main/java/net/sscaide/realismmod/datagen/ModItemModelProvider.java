package net.sscaide.realismmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

import java.util.LinkedHashMap;

public class ModItemModelProvider extends ItemModelProvider {
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RealismMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.CLUMP_OF_DIRT.get());
        basicItem(ModItems.CLUMP_OF_MUD.get());
        basicItem(ModItems.PILE_OF_GRAVEL.get());
        basicItem(ModItems.PILE_OF_SAND.get());
        basicItem(ModItems.PILE_OF_RED_SAND.get());
        basicItem(ModItems.PILE_OF_WHITE_SAND.get());

        basicItem(ModItems.ROCK.get());
        basicItem(ModItems.DEEPSLATE_ROCK.get());
        basicItem(ModItems.SANDSTONE_ROCK.get());
        basicItem(ModItems.RED_SANDSTONE_ROCK.get());
        basicItem(ModItems.GRANITE_ROCK.get());
        basicItem(ModItems.DIORITE_ROCK.get());
        basicItem(ModItems.ANDESITE_ROCK.get());
        basicItem(ModItems.CALCITE_ROCK.get());
        basicItem(ModItems.TUFF_ROCK.get());

        basicItem(ModItems.VINE.get());
        basicItem(ModItems.FLAX.get());

        basicItem(ModItems.OAK_TIMBER.get());
        basicItem(ModItems.SPRUCE_TIMBER.get());
        basicItem(ModItems.BIRCH_TIMBER.get());
        basicItem(ModItems.JUNGLE_TIMBER.get());
        basicItem(ModItems.ACACIA_TIMBER.get());
        basicItem(ModItems.DARK_OAK_TIMBER.get());
        basicItem(ModItems.MANGROVE_TIMBER.get());
        basicItem(ModItems.CHERRY_TIMBER.get());
        basicItem(ModItems.PALM_TIMBER.get());

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
        basicItem(ModItems.COPPER_DUST.get());
        basicItem(ModItems.COPPER_NUGGET.get());

        basicItem(ModItems.OBSIDIAN_SHARD.get());

        basicItem(ModItems.WIDE_SHAPED_FLINT.get());
        basicItem(ModItems.FANNED_SHAPED_FLINT.get());
        basicItem(ModItems.LONG_SHAPED_FLINT.get());
        basicItem(ModItems.THIN_SHAPED_FLINT.get());

        basicItem(ModItems.WIDE_SHAPED_COPPER.get());
        basicItem(ModItems.FANNED_SHAPED_COPPER.get());
        basicItem(ModItems.LONG_SHAPED_COPPER.get());
        basicItem(ModItems.JAGGED_SHAPED_COPPER.get());
        basicItem(ModItems.THIN_SHAPED_COPPER.get());


        basicItem(ModItems.ORANGE.get());

        basicItem(ModItems.FLAX_SEEDS.get());
        basicItem(ModItems.BOWL_OF_FLAX_SEEDS.get());


        handheldItem(ModItems.SHARPENED_STICK);
        handheldItem(ModItems.SHARPENED_ROCK);

        basicItem(ModItems.RANDOM_CRUDE_STONE_TOOL.get());
        handheldItem(ModItems.CRUDE_STONE_KNIFE);
        handheldItem(ModItems.CRUDE_STONE_PICK);
        handheldItem(ModItems.CRUDE_STONE_HATCHET);
        handheldItem(ModItems.CRUDE_STONE_SPADE);
        handheldItem(ModItems.CRUDE_STONE_TILL);

        basicItem(ModItems.RANDOM_FLINT_TOOL.get());
        handheldItem(ModItems.FLINT_KNIFE);
        handheldItem(ModItems.FLINT_PICK);
        handheldItem(ModItems.FLINT_HATCHET);
        handheldItem(ModItems.FLINT_SPADE);
        handheldItem(ModItems.FLINT_TILL);

        basicItem(ModItems.RANDOM_CRUDE_COPPER_TOOL.get());
        handheldItem(ModItems.CRUDE_COPPER_KNIFE);
        handheldItem(ModItems.CRUDE_COPPER_PICK);
        handheldItem(ModItems.CRUDE_COPPER_HATCHET);
        handheldItem(ModItems.CRUDE_COPPER_SPADE);
        handheldItem(ModItems.CRUDE_COPPER_TILL);

        handheldItem(ModItems.COPPER_SWORD);
        handheldItem(ModItems.COPPER_PICKAXE);
        handheldItem(ModItems.COPPER_AXE);
        handheldItem(ModItems.COPPER_SHOVEL);
        handheldItem(ModItems.COPPER_HOE);


        trimmedArmorItem(ModItems.COPPER_HELMET);
        trimmedArmorItem(ModItems.COPPER_CHESTPLATE);
        trimmedArmorItem(ModItems.COPPER_LEGGINGS);
        trimmedArmorItem(ModItems.COPPER_BOOTS);
        basicItem(ModItems.COPPER_HORSE_ARMOR.get());


        basicItem(ModItems.WASTELAND_FUNK_MUSIC_DISC.get());


        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);

        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);

        wallItem(ModBlocks.TIN_WALL, ModBlocks.TIN_BLOCK);
        wallItem(ModBlocks.WHITE_SANDSTONE_WALL, ModBlocks.WHITE_SANDSTONE);

        basicItem(ModBlocks.PALM_DOOR.asItem());

    }

    // Shoutout to El_Redstoniano for making this
    private void trimmedArmorItem(DeferredItem<ArmorItem> itemDeferredItem) {
        final String MOD_ID = RealismMod.MOD_ID; // Change this to your mod id

        if(itemDeferredItem.get() instanceof ArmorItem armorItem) {
            trimMaterials.forEach((trimMaterial, value) -> {
                float trimValue = value;

                String armorType = switch (armorItem.getEquipmentSlot()) {
                    case HEAD -> "helmet";
                    case CHEST -> "chestplate";
                    case LEGS -> "leggings";
                    case FEET -> "boots";
                    default -> "";
                };

                String armorItemPath = armorItem.toString();
                String trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().getPath();
                String currentTrimName = armorItemPath + "_" + trimMaterial.location().getPath() + "_trim";
                ResourceLocation armorItemResLoc = ResourceLocation.parse(armorItemPath);
                ResourceLocation trimResLoc = ResourceLocation.parse(trimPath); // minecraft namespace
                ResourceLocation trimNameResLoc = ResourceLocation.parse(currentTrimName);

                // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
                // avoid an IllegalArgumentException
                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures");

                // Trimmed armorItem files
                getBuilder(currentTrimName)
                        .parent(new ModelFile.UncheckedModelFile("item/generated"))
                        .texture("layer0", armorItemResLoc.getNamespace() + ":item/" + armorItemResLoc.getPath())
                        .texture("layer1", trimResLoc);

                // Non-trimmed armorItem file (normal variant)
                this.withExistingParent(itemDeferredItem.getId().getPath(),
                                mcLoc("item/generated"))
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimNameResLoc.getNamespace()  + ":item/" + trimNameResLoc.getPath()))
                        .predicate(mcLoc("trim_type"), trimValue).end()
                        .texture("layer0",
                                ResourceLocation.fromNamespaceAndPath(MOD_ID,
                                        "item/" + itemDeferredItem.getId().getPath()));
            });
        }
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
