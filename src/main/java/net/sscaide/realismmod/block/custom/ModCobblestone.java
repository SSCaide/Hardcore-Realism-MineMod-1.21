package net.sscaide.realismmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.stats.Stats;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ColoredFallingBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.item.ModItems;

import javax.annotation.Nullable;
import java.util.Objects;

public class ModCobblestone extends ColoredFallingBlock {
    private static ItemStack rock;
    private static Block ironOrBetter = ModBlocks.IRON_BREAKABLE_STONE.get();

    public ModCobblestone(ColorRGBA dustColor, Properties properties) {
        super(dustColor, properties);
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        boolean silk;
        if(player.getMainHandItem() != ItemStack.EMPTY) {
            var enchants = player.getMainHandItem().get(DataComponents.ENCHANTMENTS);
            var server = level.getServer();
            var enchantmentHolder = Objects.requireNonNull(server).registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(Enchantments.SILK_TOUCH);
            silk = Objects.requireNonNull(enchants).getLevel(enchantmentHolder) != 0;
        } else { silk = false; }

        if(player.isCreative()) { return; }

        if(player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState())) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        } else if(!player.getMainHandItem().isCorrectToolForDrops(ironOrBetter.defaultBlockState()) && !silk) {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);

            if(state.is(ModBlocks.MOD_COBBLESTONE)) {
                rock = ModItems.ROCK.toStack();
            } else if(state.is(ModBlocks.MOD_COBBLED_DEEPSLATE)) {
                rock = ModItems.DEEPSLATE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_SANDSTONE)) {
                rock = ModItems.SANDSTONE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_RED_SANDSTONE)) {
                rock = ModItems.RED_SANDSTONE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_WHITE_SANDSTONE)) {
                rock = ModItems.WHITE_SANDSTONE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_GRANITE)) {
                rock = ModItems.GRANITE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_DIORITE)) {
                rock = ModItems.DIORITE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_ANDESITE)) {
                rock = ModItems.ANDESITE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_CALCITE)) {
                rock = ModItems.CALCITE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_TUFF)) {
                rock = ModItems.TUFF_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_DRIPSTONE)) {
                rock = ModItems.DRIPSTONE_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_NETHERRACK)) {
                rock = ModItems.NETHERROCK.toStack();
            }else if(state.is(ModBlocks.COBBLED_BLACKSTONE)) {
                rock = ModItems.BLACKROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_BASALT)) {
                rock = ModItems.BASALT_ROCK.toStack();
            } else if(state.is(ModBlocks.COBBLED_END_STONE)) {
                rock = ModItems.END_ROCK.toStack();
            } else {
                rock = ModItems.ROCK.toStack();
            }
            popResource(level, pos, rock);

        } else {
            player.awardStat(Stats.BLOCK_MINED.get(this));
            player.causeFoodExhaustion(0.005F);
            dropResources(state, level, pos, blockEntity, player, tool);
        }
    }

}
