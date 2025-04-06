package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

import javax.annotation.Nullable;

public class CrackedStoneBlock extends Block {
    public static Block replacer;
    private static ItemStack rock;
    private static Block ironOrBetter = ModBlocks.IRON_BREAKABLE_BLOCK.get();

    public CrackedStoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        var enchants = player.getMainHandItem().get(DataComponents.ENCHANTMENTS);
        var server = level.getServer();
        var enchantmentHolder = server.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
        boolean silk = enchants.getLevel(enchantmentHolder) != 0;

        if(!player.isCreative() && player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState())) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        } else if(!player.isCreative() && !player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);

            if(state.is(ModBlocks.CRACKED_STONE)) {
                rock = ModItems.ROCK.toStack();
                replacer = Blocks.COBBLESTONE;
            } else if(state.is(ModBlocks.CRACKED_DEEPSLATE)) {
                rock = ModItems.DEEPSLATE_ROCK.toStack();
                replacer = Blocks.COBBLED_DEEPSLATE;
            } else if(state.is(ModBlocks.WHITE_SANDSTONE)) {
                rock = ModItems.WHITE_SANDSTONE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_WHITE_SANDSTONE.get();
            } else if(state.is(ModBlocks.CRACKED_GRANITE)) {
                rock = ModItems.GRANITE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_GRANITE.get();
            } else if(state.is(ModBlocks.CRACKED_DIORITE)) {
                rock = ModItems.DIORITE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_DIORITE.get();
            } else if(state.is(ModBlocks.CRACKED_ANDESITE)) {
                rock = ModItems.ANDESITE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_ANDESITE.get();
            } else if(state.is(ModBlocks.CRACKED_CALCITE)) {
                rock = ModItems.CALCITE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_CALCITE.get();
            } else if(state.is(ModBlocks.CRACKED_TUFF)) {
                rock = ModItems.TUFF_ROCK.toStack();
                replacer = ModBlocks.COBBLED_TUFF.get();
            } else if(state.is(ModBlocks.CRACKED_DRIPSTONE)) {
                rock = ModItems.DRIPSTONE_ROCK.toStack();
                replacer = ModBlocks.COBBLED_DRIPSTONE.get();
            } else if(state.is(Blocks.BLACKSTONE)) {
                rock = ModItems.BLACKROCK.toStack();
                replacer = ModBlocks.COBBLED_BLACKSTONE.get();
            } else if(state.is(ModBlocks.CRACKED_BASALT)) {
                rock = ModItems.BASALT_ROCK.toStack();
                replacer = ModBlocks.COBBLED_BASALT.get();
            } else if(state.is(ModBlocks.CRACKED_END_STONE)) {
                rock = ModItems.END_ROCK.toStack();
                replacer = ModBlocks.COBBLED_END_STONE.get();
            } else {
                rock = ModItems.ROCK.toStack();
                replacer = Blocks.COBBLESTONE;
            }
            popResource(level, pos, rock);

            if(!level.isClientSide) {
                level.setBlockAndUpdate(pos, replacer.defaultBlockState());
            }
        } else {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        }
    }

}
