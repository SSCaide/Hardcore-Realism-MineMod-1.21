package net.sscaide.realismmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.level.BlockDropsEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.component.ModDataComponents;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.item.custom.MultiConsumableBowlItem;

import java.util.Objects;
import java.util.Random;

@EventBusSubscriber(modid = RealismMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    //player.sendSystemMessage(Component.literal("Test"));


    @SubscribeEvent
    public static void toolsBasedDrops(BlockDropsEvent event) {
        BlockState state = event.getState();
        ItemStack tool = event.getTool();
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Block ironOrBetterPick = ModBlocks.IRON_BREAKABLE_STONE.get();
        Block ironOrBetterShovel = ModBlocks.IRON_BREAKABLE_SOIL.get();
        boolean silk;
        int fortune;
        if (tool.isDamageableItem()) {
            var enchants = tool.get(DataComponents.ENCHANTMENTS);
            var server = level.getServer();
            var enchantmentHolder = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
            var enchantmentHolder2 = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.FORTUNE);
            silk = Objects.requireNonNull(enchants).getLevel(enchantmentHolder) != 0;
            fortune = Objects.requireNonNull(enchants).getLevel(enchantmentHolder2);
        } else {
            silk = false;
            fortune = 0;
        }
        Random rand = new Random();
        int rng;

        if ((!tool.isCorrectToolForDrops(ironOrBetterPick.defaultBlockState()) && !silk) || !(event.getBreaker() instanceof Player)) {
            if (state.is(Blocks.COBBLESTONE)) {
                Block.popResource(level, pos, ModItems.ROCK.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLED_DEEPSLATE)) {
                Block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(1));
                event.setCanceled(true);
            }

        }
        if ((!tool.isCorrectToolForDrops(ironOrBetterShovel.defaultBlockState()) && !silk) || !(event.getBreaker() instanceof Player)) {
            if (state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.ROOTED_DIRT) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT_PATH) || state.is(Blocks.MYCELIUM) || state.is(Blocks.PODZOL) || state.is(Blocks.FARMLAND)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.CLUMP_OF_DIRT.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.DIRT_SLAB)) {
                rng = rand.nextInt(2) + 1;
                Block.popResource(level, pos, ModItems.CLUMP_OF_DIRT.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(Blocks.MUD)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.CLUMP_OF_MUD.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.MUD_SLAB)) {
                rng = rand.nextInt(2) + 1;
                Block.popResource(level, pos, ModItems.CLUMP_OF_MUD.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.CLAY_SLAB)) {
                rng = rand.nextInt(2) + 1;
                ItemStack clay = new ItemStack(Items.CLAY_BALL, rng);
                Block.popResource(level, pos, clay);
                event.setCanceled(true);
            } else if (state.is(Blocks.GRAVEL)) {
                rng = rand.nextInt(5 - 2) + 2;
                var rng2 = switch (fortune) {
                    case 0 -> rand.nextInt(10);
                    case 1 -> rand.nextInt(7);
                    case 2 -> rand.nextInt(4);
                    default -> 0;
                };
                if (rng2 == 0) {
                    ItemStack flint = new ItemStack(Items.FLINT, 1);
                    Block.popResource(level, pos, flint);
                } else {
                    Block.popResource(level, pos, ModItems.PILE_OF_GRAVEL.toStack(rng));
                }
                event.setCanceled(true);
            } else if (state.is(ModBlocks.GRAVEL_SLAB)) {
                rng = rand.nextInt(5 - 2) + 2;
                var rng2 = switch (fortune) {
                    case 0 -> rand.nextInt(20);
                    case 1 -> rand.nextInt(14);
                    case 2 -> rand.nextInt(8);
                    default -> 0;
                };
                if (rng2 == 0) {
                    ItemStack flint = new ItemStack(Items.FLINT, 1);
                    Block.popResource(level, pos, flint);
                } else {
                    Block.popResource(level, pos, ModItems.PILE_OF_GRAVEL.toStack(rng));
                }
                event.setCanceled(true);
            } else if (state.is(Blocks.SAND)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.PILE_OF_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.SAND_SLAB)) {
                rng = rand.nextInt(2) + 1;
                Block.popResource(level, pos, ModItems.PILE_OF_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(Blocks.RED_SAND)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.PILE_OF_RED_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.RED_SAND_SLAB)) {
                rng = rand.nextInt(2) + 1;
                Block.popResource(level, pos, ModItems.PILE_OF_RED_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.WHITE_SAND)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.PILE_OF_WHITE_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(ModBlocks.MUD_SLAB)) {
                rng = rand.nextInt(2) + 1;
                Block.popResource(level, pos, ModItems.PILE_OF_WHITE_SAND.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(Blocks.MOSS_BLOCK)) {
                rng = rand.nextInt(5 - 2) + 2;
                Block.popResource(level, pos, ModItems.CLUMP_OF_MOSS.toStack(rng));
                event.setCanceled(true);
            } else if (state.is(Blocks.MOSS_CARPET)) {
                Block.popResource(level, pos, ModItems.CLUMP_OF_MOSS.toStack(1));
                event.setCanceled(true);
            }
        }

        if (tool.isCorrectToolForDrops(ironOrBetterPick.defaultBlockState()) && !silk) {
            if (state.is(Blocks.SANDSTONE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_SANDSTONE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.RED_SANDSTONE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_RED_SANDSTONE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.GRANITE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_GRANITE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.DIORITE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_DIORITE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.ANDESITE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_ANDESITE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.CALCITE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_CALCITE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.TUFF)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_TUFF.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.DRIPSTONE_BLOCK)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_DRIPSTONE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.NETHERRACK)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_NETHERRACK.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.BLACKSTONE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_BLACKSTONE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.BASALT)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_BASALT.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.END_STONE)) {
                Block.popResource(level, pos, ModBlocks.COBBLED_END_STONE.toStack(1));
                event.setCanceled(true);
            }
        }

        if (tool.isCorrectToolForDrops(ironOrBetterPick.defaultBlockState())) {
            if (state.is(Blocks.COBBLESTONE)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLESTONE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLESTONE_STAIRS)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLESTONE_STAIRS.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLESTONE_SLAB)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLESTONE_SLAB.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLED_DEEPSLATE)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLED_DEEPSLATE.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLED_DEEPSLATE_STAIRS)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLED_DEEPSLATE_STAIRS.toStack(1));
                event.setCanceled(true);
            } else if (state.is(Blocks.COBBLED_DEEPSLATE_SLAB)) {
                Block.popResource(level, pos, ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB.toStack(1));
                event.setCanceled(true);
            }
        }

        if (!silk && !tool.is(Items.SHEARS)) {
            if (state.is(Blocks.VINE) || state.is(Blocks.CAVE_VINES)) {
                Block.popResource(level, pos, ModItems.VINE.toStack(1));
            } else if (state.is(BlockTags.LEAVES)) {
                rng = rand.nextInt(16);
                if (rng == 0) {
                    Block.popResource(level, pos, ModItems.VINE.toStack(1));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        BlockState state = event.getState();
        ItemStack tool = player.getMainHandItem();
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        Block replacer;
        Block goodForStonePick = ModBlocks.MOD_COBBLESTONE.get();
        Block ironOrBetterPick = ModBlocks.IRON_BREAKABLE_STONE.get();
        Block ironOrBetterAxe = ModBlocks.IRON_BREAKABLE_WOOD.get();
        boolean silk;
        int fortune;
        if (tool.isDamageableItem()) {
            var enchants = tool.get(DataComponents.ENCHANTMENTS);
            var server = level.getServer();
            var enchantmentHolder = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
            var enchantmentHolder2 = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.FORTUNE);
            silk = Objects.requireNonNull(enchants).getLevel(enchantmentHolder) != 0;
            fortune = Objects.requireNonNull(enchants).getLevel(enchantmentHolder2);
        } else {
            silk = false;
            fortune = 0;
        }
        Random rand = new Random();
        int rng;

        if (player.isCreative()) {
            return;
        }

        if (!tool.isCorrectToolForDrops(ironOrBetterPick.defaultBlockState()) && !silk) {
            if (state.is(Blocks.STONE) || state.is(ModBlocks.CRACKED_STONE)) {
                Block.popResource(level, pos, ModItems.ROCK.toStack(1));
                if(state.is(Blocks.STONE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.MOD_COBBLESTONE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.DEEPSLATE) || state.is(ModBlocks.CRACKED_DEEPSLATE)) {
                Block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(1));
                if(state.is(Blocks.DEEPSLATE)) {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                } else {
                    replacer = ModBlocks.MOD_COBBLED_DEEPSLATE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.SANDSTONE)) {
                Block.popResource(level, pos, ModItems.SANDSTONE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_SANDSTONE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.RED_SANDSTONE)) {
                Block.popResource(level, pos, ModItems.RED_SANDSTONE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_RED_SANDSTONE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(ModBlocks.WHITE_SANDSTONE)) {
                Block.popResource(level, pos, ModItems.WHITE_SANDSTONE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_WHITE_SANDSTONE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.GRANITE) || state.is(ModBlocks.CRACKED_GRANITE)) {
                Block.popResource(level, pos, ModItems.GRANITE_ROCK.toStack(1));
                if(state.is(Blocks.GRANITE)) {
                    replacer = ModBlocks.CRACKED_GRANITE.get();
                } else {
                    replacer = ModBlocks.COBBLED_GRANITE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.DIORITE) || state.is(ModBlocks.CRACKED_DIORITE)) {
                Block.popResource(level, pos, ModItems.DIORITE_ROCK.toStack(1));
                if(state.is(Blocks.DIORITE)) {
                    replacer = ModBlocks.CRACKED_DIORITE.get();
                } else {
                    replacer = ModBlocks.COBBLED_DIORITE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.ANDESITE) || state.is(ModBlocks.CRACKED_ANDESITE)) {
                Block.popResource(level, pos, ModItems.ANDESITE_ROCK.toStack(1));
                if(state.is(Blocks.ANDESITE)) {
                    replacer = ModBlocks.CRACKED_ANDESITE.get();
                } else {
                    replacer = ModBlocks.COBBLED_ANDESITE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.CALCITE) || state.is(ModBlocks.CRACKED_CALCITE)) {
                Block.popResource(level, pos, ModItems.CALCITE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_CALCITE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.TUFF) || state.is(ModBlocks.CRACKED_TUFF)) {
                Block.popResource(level, pos, ModItems.TUFF_ROCK.toStack(1));
                if(state.is(Blocks.TUFF)) {
                    replacer = ModBlocks.CRACKED_TUFF.get();
                } else {
                    replacer = ModBlocks.COBBLED_TUFF.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.DRIPSTONE_BLOCK) || state.is(ModBlocks.CRACKED_DRIPSTONE)) {
                Block.popResource(level, pos, ModItems.DRIPSTONE_ROCK.toStack(1));
                if(state.is(Blocks.DRIPSTONE_BLOCK)) {
                    replacer = ModBlocks.CRACKED_DRIPSTONE.get();
                } else {
                    replacer = ModBlocks.COBBLED_DRIPSTONE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.NETHERRACK)) {
                Block.popResource(level, pos, ModItems.NETHERROCK.toStack(1));
                replacer = ModBlocks.COBBLED_NETHERRACK.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.BLACKSTONE)) {
                Block.popResource(level, pos, ModItems.BLACKROCK.toStack(1));
                replacer = ModBlocks.COBBLED_BLACKSTONE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.BASALT) || state.is(ModBlocks.CRACKED_BASALT)) {
                Block.popResource(level, pos, ModItems.BASALT_ROCK.toStack(1));
                if(state.is(Blocks.BASALT)) {
                    replacer = ModBlocks.CRACKED_BASALT.get();
                } else {
                    replacer = ModBlocks.COBBLED_BASALT.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.END_STONE) || state.is(ModBlocks.CRACKED_END_STONE)) {
                Block.popResource(level, pos, ModItems.END_ROCK.toStack(1));
                if(state.is(Blocks.END_STONE)) {
                    replacer = ModBlocks.CRACKED_END_STONE.get();
                } else {
                    replacer = ModBlocks.COBBLED_END_STONE.get();
                }

                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.COAL_ORE) || state.is(Blocks.DEEPSLATE_COAL_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    rng = rand.nextInt(3);
                    var drops = 1;
                    if (rng == 0) { //'Normal' drops
                        drops = getOreDropsAmt(fortune, 1);
                        ItemStack coal = new ItemStack(Items.COAL, drops);
                        Block.popResource(level, pos, coal);
                    } else { //Nugget drops
                        drops = getOreDropsAmt(fortune, 5, 2);
                        Block.popResource(level, pos, ModItems.COAL_NUGGET.toStack(drops));
                    }
                }
                if (state.is(Blocks.COAL_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.COPPER_ORE) || state.is(Blocks.DEEPSLATE_COPPER_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    rng = rand.nextInt(3);
                    var drops = 1;
                    if (rng == 0) { //'Normal' drops
                        drops = getOreDropsAmt(fortune, 6, 2);
                        ItemStack copper = new ItemStack(Items.RAW_COPPER, drops);
                        Block.popResource(level, pos, copper);
                    } else { //Nugget drops
                        drops = getOreDropsAmt(fortune, 7, 3);
                        Block.popResource(level, pos, ModItems.RAW_COPPER_NUGGET.toStack(drops));
                    }
                }
                if (state.is(Blocks.COPPER_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                    event.setCanceled(true);
            } else if (state.is(ModBlocks.TIN_ORE) || state.is(ModBlocks.DEEPSLATE_TIN_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    rng = rand.nextInt(3);
                    var drops = 1;
                    if (rng == 0) { //'Normal' drops
                        drops = getOreDropsAmt(fortune, 4, 1);
                        Block.popResource(level, pos, ModItems.RAW_TIN.toStack(drops));
                    } else { //Nugget drops
                        drops = getOreDropsAmt(fortune, 5, 3);
                        Block.popResource(level, pos, ModItems.RAW_TIN_NUGGET.toStack(drops));
                    }
                }
                if (state.is(ModBlocks.TIN_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.IRON_ORE) || state.is(Blocks.DEEPSLATE_IRON_ORE)) {
                if (tool.isCorrectToolForDrops(Blocks.IRON_ORE.defaultBlockState())) {
                    rng = rand.nextInt(3);
                    var drops = 1;
                    if (rng == 0) { //'Normal' drops
                        drops = getOreDropsAmt(fortune, 1);
                        ItemStack iron = new ItemStack(Items.RAW_IRON, drops);
                        Block.popResource(level, pos, iron);
                    } else { //Nugget drops
                        drops = getOreDropsAmt(fortune, 5, 2);
                        Block.popResource(level, pos, ModItems.RAW_IRON_NUGGET.toStack(drops));
                    }
                }

                if (state.is(Blocks.IRON_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.LAPIS_ORE) || state.is(Blocks.DEEPSLATE_LAPIS_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    var drops = getOreDropsAmt(fortune, 10, 4);
                        ItemStack lapis = new ItemStack(Items.LAPIS_LAZULI, drops);
                        Block.popResource(level, pos, lapis);
                }

                if (state.is(Blocks.LAPIS_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.GOLD_ORE) || state.is(Blocks.DEEPSLATE_GOLD_ORE)) {
                if (state.is(Blocks.GOLD_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.REDSTONE_ORE) || state.is(Blocks.DEEPSLATE_REDSTONE_ORE)) {
                if (state.is(Blocks.REDSTONE_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.EMERALD_ORE) || state.is(Blocks.DEEPSLATE_EMERALD_ORE)) {
                if (state.is(Blocks.EMERALD_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.DIAMOND_ORE) || state.is(Blocks.DEEPSLATE_DIAMOND_ORE)) {
                if (state.is(Blocks.DIAMOND_ORE)) {
                    replacer = ModBlocks.CRACKED_STONE.get();
                } else {
                    replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                }
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.NETHER_QUARTZ_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    var drops = getOreDropsAmt(fortune, 1);
                    ItemStack quartz = new ItemStack(Items.QUARTZ, drops);
                    Block.popResource(level, pos, quartz);
                }

                replacer = ModBlocks.COBBLED_NETHERRACK.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if(state.is(Blocks.NETHER_GOLD_ORE)) {
                if (tool.isCorrectToolForDrops(goodForStonePick.defaultBlockState())) {
                    var drops = getOreDropsAmt(fortune, 7, 2);
                        ItemStack gold = new ItemStack(Items.GOLD_NUGGET, drops);
                        Block.popResource(level, pos, gold);

                }

                replacer = ModBlocks.COBBLED_NETHERRACK.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            } else if(state.is(Blocks.GILDED_BLACKSTONE)) {
                var rng2 = switch (fortune) {
                    case 0 -> rand.nextInt(20);
                    case 1 -> rand.nextInt(14);
                    case 2 -> rand.nextInt(8);
                    default -> 0;
                };
                if (rng2 == 0) {
                    rng = rand.nextInt(6 - 2) +2;
                    ItemStack gold = new ItemStack(Items.GOLD_NUGGET, rng);
                    Block.popResource(level, pos, gold);
                } else {
                    Block.popResource(level, pos, ModItems.BLACKROCK.toStack(1));
                }

                replacer = ModBlocks.COBBLED_BLACKSTONE.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damagePickaxe(tool);
                event.setCanceled(true);
            }

            if(state.is(ModBlocks.MOD_COBBLESTONE)) {
                Block.popResource(level, pos, ModItems.ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.MOD_COBBLED_DEEPSLATE)) {
                Block.popResource(level, pos, ModItems.DEEPSLATE_BRICK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_SANDSTONE)) {
                Block.popResource(level, pos, ModItems.SANDSTONE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_RED_SANDSTONE)) {
                Block.popResource(level, pos, ModItems.RED_SANDSTONE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_WHITE_SANDSTONE)) {
                Block.popResource(level, pos, ModItems.WHITE_SANDSTONE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_GRANITE)) {
                Block.popResource(level, pos, ModItems.GRANITE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DIORITE)) {
                Block.popResource(level, pos, ModItems.DIORITE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_ANDESITE)) {
                Block.popResource(level, pos, ModItems.ANDESITE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_CALCITE)) {
                Block.popResource(level, pos, ModItems.CALCITE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_TUFF)) {
                Block.popResource(level, pos, ModItems.TUFF_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DRIPSTONE)) {
                Block.popResource(level, pos, ModItems.DRIPSTONE_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_NETHERRACK)) {
                Block.popResource(level, pos, ModItems.NETHERROCK.toStack(1));
                damagePickaxe(tool);
            }else if(state.is(ModBlocks.COBBLED_BLACKSTONE)) {
                Block.popResource(level, pos, ModItems.BLACKROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_BASALT)) {
                Block.popResource(level, pos, ModItems.BASALT_ROCK.toStack(1));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_END_STONE)) {
                Block.popResource(level, pos, ModItems.END_ROCK.toStack(1));
                damagePickaxe(tool);
            }
            rng = rand.nextInt(2) + 1;
            if(state.is(ModBlocks.MOD_COBBLESTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.MOD_COBBLED_DEEPSLATE_SLAB)) {
                Block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_SANDSTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_RED_SANDSTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.RED_SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_WHITE_SANDSTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.WHITE_SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_GRANITE_SLAB)) {
                Block.popResource(level, pos, ModItems.GRANITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DIORITE_SLAB)) {
                Block.popResource(level, pos, ModItems.DIORITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_ANDESITE_SLAB)) {
                Block.popResource(level, pos, ModItems.ANDESITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_CALCITE_SLAB)) {
                Block.popResource(level, pos, ModItems.CALCITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_TUFF_SLAB)) {
                Block.popResource(level, pos, ModItems.TUFF_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DRIPSTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.DRIPSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_NETHERRACK_SLAB)) {
                Block.popResource(level, pos, ModItems.NETHERROCK.toStack(rng));
                damagePickaxe(tool);
            }else if(state.is(ModBlocks.COBBLED_BLACKSTONE_SLAB)) {
                Block.popResource(level, pos, ModItems.BLACKROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_BASALT_SLAB)) {
                Block.popResource(level, pos, ModItems.BASALT_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_END_STONE_SLAB)) {
                Block.popResource(level, pos, ModItems.END_ROCK.toStack(rng));
                damagePickaxe(tool);
            }
            rng = rand.nextInt(3) + 1;
            if(state.is(ModBlocks.MOD_COBBLESTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.MOD_COBBLED_DEEPSLATE_STAIRS)) {
                Block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_SANDSTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_RED_SANDSTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.RED_SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_WHITE_SANDSTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.WHITE_SANDSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_GRANITE_STAIRS)) {
                Block.popResource(level, pos, ModItems.GRANITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DIORITE_STAIRS)) {
                Block.popResource(level, pos, ModItems.DIORITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_ANDESITE_STAIRS)) {
                Block.popResource(level, pos, ModItems.ANDESITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_CALCITE_STAIRS)) {
                Block.popResource(level, pos, ModItems.CALCITE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_TUFF_STAIRS)) {
                Block.popResource(level, pos, ModItems.TUFF_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_DRIPSTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.DRIPSTONE_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_NETHERRACK_STAIRS)) {
                Block.popResource(level, pos, ModItems.NETHERROCK.toStack(rng));
                damagePickaxe(tool);
            }else if(state.is(ModBlocks.COBBLED_BLACKSTONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.BLACKROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_BASALT_STAIRS)) {
                Block.popResource(level, pos, ModItems.BASALT_ROCK.toStack(rng));
                damagePickaxe(tool);
            } else if(state.is(ModBlocks.COBBLED_END_STONE_STAIRS)) {
                Block.popResource(level, pos, ModItems.END_ROCK.toStack(rng));
                damagePickaxe(tool);
            }
        }

        if (!tool.isCorrectToolForDrops(ironOrBetterAxe.defaultBlockState()) && !silk) {
            if (state.is(Blocks.OAK_LOG) || state.is(Blocks.STRIPPED_OAK_LOG)) {
                Block.popResource(level, pos, ModItems.OAK_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_OAK_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.SPRUCE_LOG) || state.is(Blocks.STRIPPED_SPRUCE_LOG)) {
                Block.popResource(level, pos, ModItems.SPRUCE_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_SPRUCE_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.BIRCH_LOG) || state.is(Blocks.STRIPPED_BIRCH_LOG)) {
                Block.popResource(level, pos, ModItems.BIRCH_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_BIRCH_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.JUNGLE_LOG) || state.is(Blocks.STRIPPED_JUNGLE_LOG)) {
                Block.popResource(level, pos, ModItems.JUNGLE_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_JUNGLE_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.ACACIA_LOG) || state.is(Blocks.STRIPPED_ACACIA_LOG)) {
                Block.popResource(level, pos, ModItems.ACACIA_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_ACACIA_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.DARK_OAK_LOG) || state.is(Blocks.STRIPPED_DARK_OAK_LOG)) {
                Block.popResource(level, pos, ModItems.DARK_OAK_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_DARK_OAK_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.MANGROVE_LOG) || state.is(Blocks.STRIPPED_MANGROVE_LOG)) {
                Block.popResource(level, pos, ModItems.MANGROVE_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_MANGROVE_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(Blocks.CHERRY_LOG) || state.is(Blocks.STRIPPED_CHERRY_LOG)) {
                Block.popResource(level, pos, ModItems.CHERRY_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_CHERRY_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            } else if (state.is(ModBlocks.PALM_LOG) || state.is(ModBlocks.STRIPPED_PALM_LOG)) {
                Block.popResource(level, pos, ModItems.PALM_TIMBER.toStack(1));
                replacer = ModBlocks.CHIPPED_PALM_LOG.get();
                if (!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                damageAxe(tool);
                event.setCanceled(true);
            }
        }

    }

    private static void damageAxe(ItemStack tool) {
        if(!tool.isEmpty() && tool.isDamageableItem()) {
            if(tool.getItem() instanceof DiggerItem) {
                if(tool.getItem() instanceof AxeItem) {
                    tool.setDamageValue(tool.getDamageValue()+1);
                } else {
                    tool.setDamageValue(tool.getDamageValue()+2);
                }
            }
        }
    }
    private static void damagePickaxe(ItemStack tool) {
        if(!tool.isEmpty() && tool.isDamageableItem()) {
            if(tool.getItem() instanceof DiggerItem) {
                if(tool.getItem() instanceof PickaxeItem) {
                    tool.setDamageValue(tool.getDamageValue()+1);
                } else {
                    tool.setDamageValue(tool.getDamageValue()+2);
                }
            }
        }
    }
    private static int getOreDropsAmt(int fortune, int max, int min) {
        Random rand = new Random();
        int rng;
        var drops = rand.nextInt(max - min) + min;
        if (fortune > 0) {
            if (fortune == 1) {
                rng = rand.nextInt(3);
                if (rng == 0) {
                    drops *= 2;
                }
            } else {
                for (int i = fortune; i > 0; i--) {
                    rng = rand.nextInt(4);
                    if (rng == 0) {
                        drops *= i + 1;
                        break;
                    }
                }
            }
        }
        return drops;
    }
    private static int getOreDropsAmt(int fortune, int amount) {
        Random rand = new Random();
        int rng;
        var drops = amount;
        if (fortune > 0) {
            if (fortune == 1) {
                rng = rand.nextInt(3);
                if (rng == 0) {
                    drops *= 2;
                }
            } else {
                for (int i = fortune; i > 0; i--) {
                    rng = rand.nextInt(4);
                    if (rng == 0) {
                        drops *= i + 1;
                        break;
                    }
                }
            }
        }
        return drops;
    }

}

