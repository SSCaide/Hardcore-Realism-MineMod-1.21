package net.sscaide.realismmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RealismMod.MOD_ID);

    public static final Supplier<CreativeModeTab> SSCR_ITEMS_TAB = CREATIVE_MODE_TAB.register("sscr_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CLUMP_OF_DIRT.get()))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CLUMP_OF_DIRT);
                        output.accept(ModItems.ROCK);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.TIN_INGOT);
                    }).build());

    public static final Supplier<CreativeModeTab> SSCR_BLOCKS_TAB = CREATIVE_MODE_TAB.register("sscr_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.TIN_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "sscr_items_tab"))
                    .title(Component.translatable("creativetab.sscaiderealism.sscr_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.RAW_TIN_BLOCK);
                        output.accept(ModBlocks.TIN_BLOCK);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }


}
