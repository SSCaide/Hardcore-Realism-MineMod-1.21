package net.sscaide.realismmod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.extensions.ILevelReaderExtension;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.CrackedStoneBlock;
import net.sscaide.realismmod.item.ModItems;

import java.util.Random;

@EventBusSubscriber(modid = RealismMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    /*@SubscribeEvent
    public static void livingDamage(LivingDamageEvent.Pre event) {
        if (event.getEntity() instanceof Sheep sheep && event.getSource().getDirectEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() == Items.END_ROD) {
                player.sendSystemMessage((Component.literal(player.getName().getString() + " just hit a sheep with an End Rod you SICK FREAK!!")));
                sheep.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 6));
                player.getMainHandItem().shrink(1);
            }
        }
    }*/

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        Block block = event.getState().getBlock();
        Player player = event.getPlayer();
        BlockState state = event.getState();
        Level level = (Level) event.getLevel();
        BlockPos pos = event.getPos();
        Block replacer;
        Block ironOrBetter = ModBlocks.IRON_BREAKABLE_BLOCK.get();
        var enchants = player.getMainHandItem().get(DataComponents.ENCHANTMENTS);
        var server = level.getServer();
        var enchantmentHolder = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
        boolean silk = enchants.getLevel(enchantmentHolder) != 0;
        Random rand = new Random();
        int rng;

        if(!player.isCreative() && !player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            if(state.is(Blocks.STONE)) {
                block.popResource(level, pos, ModItems.ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_STONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.COBBLESTONE)) {
                block.popResource(level, pos, ModItems.ROCK.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.DEEPSLATE)) {
                block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_DEEPSLATE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.COBBLED_DEEPSLATE)) {
                block.popResource(level, pos, ModItems.DEEPSLATE_ROCK.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.SANDSTONE)) {
                block.popResource(level, pos, ModItems.SANDSTONE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_SANDSTONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.RED_SANDSTONE)) {
                block.popResource(level, pos, ModItems.RED_SANDSTONE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_RED_SANDSTONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.GRANITE)) {
                block.popResource(level, pos, ModItems.GRANITE_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_GRANITE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.DIORITE)) {
                block.popResource(level, pos, ModItems.DIORITE_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_DIORITE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.ANDESITE)) {
                block.popResource(level, pos, ModItems.ANDESITE_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_ANDESITE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.CALCITE)) {
                block.popResource(level, pos, ModItems.CALCITE_ROCK.toStack(1));
                replacer = ModBlocks.COBBLED_CALCITE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.TUFF)) {
                block.popResource(level, pos, ModItems.TUFF_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_TUFF.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.DRIPSTONE_BLOCK)) {
                block.popResource(level, pos, ModItems.DRIPSTONE_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_DRIPSTONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.NETHERRACK)) {
                block.popResource(level, pos, ModItems.NETHERROCK.toStack(1));
                replacer = ModBlocks.COBBLED_NETHERRACK.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.BLACKSTONE)) {
                block.popResource(level, pos, ModItems.BLACKROCK.toStack(1));
                replacer = ModBlocks.COBBLED_BLACKSTONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.BASALT)) {
                block.popResource(level, pos, ModItems.BASALT_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_BASALT.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.END_STONE)) {
                block.popResource(level, pos, ModItems.END_ROCK.toStack(1));
                replacer = ModBlocks.CRACKED_END_STONE.get();
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, replacer.defaultBlockState());
                }
                event.setCanceled(true);
            }

            if(state.is(Blocks.DIRT) || state.is(Blocks.COARSE_DIRT) || state.is(Blocks.ROOTED_DIRT) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.DIRT_PATH) || state.is(Blocks.MYCELIUM) || state.is(Blocks.PODZOL) || state.is(Blocks.FARMLAND)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.CLUMP_OF_DIRT.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.DIRT_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.CLUMP_OF_DIRT.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.MUD)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.CLUMP_OF_MUD.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.MUD_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.CLUMP_OF_MUD.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.CLAY_SLAB)) {
                rng = rand.nextInt(2) + 1;
                ItemStack clay = new ItemStack(Items.CLAY_BALL, rng);
                block.popResource(level, pos, clay);
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.GRAVEL)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.PILE_OF_GRAVEL.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.GRAVEL_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.PILE_OF_GRAVEL.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.SAND)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.PILE_OF_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.SAND_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.PILE_OF_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.RED_SAND)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.PILE_OF_RED_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.RED_SAND_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.PILE_OF_RED_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.WHITE_SAND)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.PILE_OF_WHITE_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(ModBlocks.MUD_SLAB)) {
                rng = rand.nextInt(2) + 1;
                block.popResource(level, pos, ModItems.PILE_OF_WHITE_SAND.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.MOSS_BLOCK)) {
                rng = rand.nextInt(5-2) + 2;
                block.popResource(level, pos, ModItems.CLUMP_OF_MOSS.toStack(rng));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.MOSS_CARPET)) {
                block.popResource(level, pos, ModItems.CLUMP_OF_MOSS.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            }

        } else if(!player.isCreative() && player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            if(state.is(Blocks.SANDSTONE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_SANDSTONE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.RED_SANDSTONE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_RED_SANDSTONE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.GRANITE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_GRANITE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.DIORITE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_DIORITE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.ANDESITE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_ANDESITE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.CALCITE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_CALCITE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.TUFF)) {
                block.popResource(level, pos, ModBlocks.COBBLED_TUFF.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.DRIPSTONE_BLOCK)) {
                block.popResource(level, pos, ModBlocks.COBBLED_DRIPSTONE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.NETHERRACK)) {
                block.popResource(level, pos, ModBlocks.COBBLED_NETHERRACK.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.BLACKSTONE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_BLACKSTONE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.BASALT)) {
                block.popResource(level, pos, ModBlocks.COBBLED_BASALT.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            } else if(state.is(Blocks.END_STONE)) {
                block.popResource(level, pos, ModBlocks.COBBLED_END_STONE.toStack(1));
                if(!level.isClientSide) {
                    level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                }
                event.setCanceled(true);
            }
        }
    }

    }
