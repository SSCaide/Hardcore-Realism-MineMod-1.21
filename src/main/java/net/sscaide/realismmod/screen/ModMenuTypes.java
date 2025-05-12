package net.sscaide.realismmod.screen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.screen.custom.ModAnvilMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(Registries.MENU, RealismMod.MOD_ID);


    public static final DeferredHolder<MenuType<?>, MenuType<ModAnvilMenu>> MOD_ANVIL_MENU =
            registerMenuType("mod_anvil_menu", ModAnvilMenu::new);


    private static <T extends AbstractContainerMenu>
        DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENU_TYPES.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENU_TYPES.register(eventBus);
    }
}