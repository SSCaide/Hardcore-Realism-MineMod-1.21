package net.sscaide.realismmod.screen.custom;

import com.google.common.collect.Lists;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.blockentities.ModAnvilEntity;
import net.sscaide.realismmod.recipe.ModAnvilRecipe;
import net.sscaide.realismmod.recipe.ModAnvilRecipeInput;
import net.sscaide.realismmod.recipe.ModRecipes;
import net.sscaide.realismmod.screen.ModMenuTypes;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModAnvilMenu extends AbstractContainerMenu {
    public final ModAnvilEntity blockEntity;
    public static final int INPUT_SLOT = 0;
    public static final int TOOL_INPUT_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    private static final int INV_SLOT_START = 3;
    private static final int INV_SLOT_END = 30;
    private static final int USE_ROW_SLOT_START = 30;
    private static final int USE_ROW_SLOT_END = 39;
    private final ContainerLevelAccess access;
    private final DataSlot selectedRecipeIndex;
    private final Level level;
    private List<RecipeHolder<ModAnvilRecipe>> recipes;
    private ItemStack input;
    long lastSoundTime;
    final Slot inputSlot;
    final Slot toolInputSlot;
    final Slot resultSlot;
    Runnable slotUpdateListener;
    public final Container container;
    final ResultContainer resultContainer;

    public ModAnvilMenu(int containerId, Inventory inv, FriendlyByteBuf extraData) {
        this(containerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), ContainerLevelAccess.NULL);
    }

    public ModAnvilMenu(int containerId, Inventory inv, BlockEntity blockEntity, final ContainerLevelAccess access) {
        super(ModMenuTypes.MOD_ANVIL_MENU.get(), containerId);
        this.blockEntity = ((ModAnvilEntity) blockEntity);

        this.selectedRecipeIndex = DataSlot.standalone();
        this.recipes = Lists.newArrayList();
        this.input = ItemStack.EMPTY;
        this.slotUpdateListener = () -> {
        };
        this.container = new SimpleContainer(2) {
            public void setChanged() {
                super.setChanged();
                ModAnvilMenu.this.slotsChanged(this);
                ModAnvilMenu.this.slotUpdateListener.run();
            }
        };
        this.resultContainer = new ResultContainer();
        this.access = access;
        this.level = inv.player.level();
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 0, 20, 18));
        this.addSlot(new SlotItemHandler(this.blockEntity.inventory, 1, 20, 48));

        this.inputSlot = this.addSlot(new Slot(this.container, 0, 20, 18));
        this.toolInputSlot = this.addSlot(new Slot(this.container, 1, 20, 48));
        this.resultSlot = this.addSlot(new Slot(this.resultContainer, 2, 143, 33) {
            public boolean mayPlace(ItemStack p_40362_) {
                return false;
            }

            public void onTake(Player p_150672_, ItemStack p_150673_) {
                p_150673_.onCraftedBy(p_150672_.level(), p_150672_, p_150673_.getCount());
                ModAnvilMenu.this.resultContainer.awardUsedRecipes(p_150672_, this.getRelevantItems());
                ItemStack itemstack = ModAnvilMenu.this.inputSlot.remove(1);
                if (!itemstack.isEmpty()) {
                    ModAnvilMenu.this.setupResultSlot();
                }

                access.execute((p_40364_, p_40365_) -> {
                    long l = p_40364_.getGameTime();
                    if (ModAnvilMenu.this.lastSoundTime != l) {
                        p_40364_.playSound((Player)null, p_40365_, SoundEvents.UI_STONECUTTER_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ModAnvilMenu.this.lastSoundTime = l;
                    }

                });
                super.onTake(p_150672_, p_150673_);
            }

            private List<ItemStack> getRelevantItems() {
                return List.of(ModAnvilMenu.this.inputSlot.getItem());
            }
        });

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inv, k, 8 + k * 18, 142));
        }

        this.addDataSlot(this.selectedRecipeIndex);
    }

    public int getSelectedRecipeIndex() {
        return this.selectedRecipeIndex.get();
    }

    public List<RecipeHolder<ModAnvilRecipe>> getRecipes() {
        return this.recipes;
    }

    public int getNumRecipes() {
        return this.recipes.size();
    }

    public boolean hasInputItem() {
        return this.inputSlot.hasItem() && !this.recipes.isEmpty();
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                player, ModBlocks.STONE_ANVIL.get());
    }

    public boolean clickMenuButton(Player player, int id) {
        if (this.isValidRecipeIndex(id)) {
            this.selectedRecipeIndex.set(id);
            this.setupResultSlot();
        }

        return true;
    }

    private boolean isValidRecipeIndex(int recipeIndex) {
        return recipeIndex >= 0 && recipeIndex < this.recipes.size();
    }

    public void slotsChanged(Container inventory) {
        ItemStack itemstack = this.inputSlot.getItem();
        if (!itemstack.is(this.input.getItem())) {
            this.input = itemstack.copy();
            this.setupRecipeList(inventory, itemstack);
        }

    }

    private static ModAnvilRecipeInput createRecipeInput(Container container) {
        return new ModAnvilRecipeInput(container.getItem(0), container.getItem(1));
    }

    private void setupRecipeList(Container container, ItemStack stack) {
        this.recipes.clear();
        this.selectedRecipeIndex.set(-1);
        this.resultSlot.set(ItemStack.EMPTY);
        if (!stack.isEmpty()) {
            this.recipes = this.level.getRecipeManager().getRecipesFor(ModRecipes.MOD_ANVIL_TYPE.get(), createRecipeInput(container), this.level);
        }

    }

    void setupResultSlot() {
        if (!this.recipes.isEmpty() && this.isValidRecipeIndex(this.selectedRecipeIndex.get())) {
            RecipeHolder<ModAnvilRecipe> recipeholder = (RecipeHolder)this.recipes.get(this.selectedRecipeIndex.get());
            ItemStack itemstack = ((ModAnvilRecipe)recipeholder.value()).assemble(createRecipeInput(this.container), this.level.registryAccess());
            if (itemstack.isItemEnabled(this.level.enabledFeatures())) {
                this.resultContainer.setRecipeUsed(recipeholder);
                this.resultSlot.set(itemstack);
            } else {
                this.resultSlot.set(ItemStack.EMPTY);
            }
        } else {
            this.resultSlot.set(ItemStack.EMPTY);
        }

        this.broadcastChanges();
    }

    public MenuType<?> getType() {
        return ModMenuTypes.MOD_ANVIL_MENU.get();
    }

    public void registerUpdateListener(Runnable listener) {
        this.slotUpdateListener = listener;
    }

    public boolean canTakeItemForPickAll(ItemStack stack, Slot slot) {
        return slot.container != this.resultContainer && super.canTakeItemForPickAll(stack, slot);
    }

    // CREDIT GOES TO: diesieben07 | https://github.com/diesieben07/SevenCommons
    // must assign a slot number to each of the slots used by the GUI.
    // For this container, we can see both the tile inventory's slots as well as the player inventory slots and the hotbar.
    // Each time we add a Slot to the container, it automatically increases the slotIndex, which means
    //  0 - 8 = hotbar slots (which will map to the InventoryPlayer slot numbers 0 - 8)
    //  9 - 35 = player inventory slots (which map to the InventoryPlayer slot numbers 9 - 35)
    //  36 - 44 = TileInventory slots, which map to our TileEntity slot numbers 0 - 8)
    private static final int HOTBAR_SLOT_COUNT = 9;
    private static final int PLAYER_INVENTORY_ROW_COUNT = 3;
    private static final int PLAYER_INVENTORY_COLUMN_COUNT = 9;
    private static final int PLAYER_INVENTORY_SLOT_COUNT = PLAYER_INVENTORY_COLUMN_COUNT * PLAYER_INVENTORY_ROW_COUNT;
    private static final int VANILLA_SLOT_COUNT = HOTBAR_SLOT_COUNT + PLAYER_INVENTORY_SLOT_COUNT;
    private static final int VANILLA_FIRST_SLOT_INDEX = 0;
    private static final int TE_INVENTORY_FIRST_SLOT_INDEX = VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT;

    // THIS YOU HAVE TO DEFINE!
    private static final int TE_INVENTORY_SLOT_COUNT = 3;  // must be the number of slots you have!
    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, TE_INVENTORY_FIRST_SLOT_INDEX, TE_INVENTORY_FIRST_SLOT_INDEX
                    + TE_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < TE_INVENTORY_FIRST_SLOT_INDEX + TE_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, VANILLA_FIRST_SLOT_INDEX, VANILLA_FIRST_SLOT_INDEX + VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    /*public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            Item item = itemstack1.getItem();
            itemstack = itemstack1.copy();
            if (index == 0 || index == 1) {
                item.onCraftedBy(itemstack1, player.level(), player);
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (index == 0 || index == 1) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.level.getRecipeManager().getRecipeFor(ModRecipes.MOD_ANVIL_TYPE.get(), new ModAnvilRecipeInput(this.slots.get(0).getItem(), this.slots.get(1).getItem()), this.level).isPresent()) {
                if (!this.moveItemStackTo(itemstack1, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 2 && index < 29) {
                if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index >= 30 && index < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            }

            slot.setChanged();
            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(player, itemstack1);
            this.broadcastChanges();
        }

        return itemstack;
    }*/

    public void removed(Player player) {
        super.removed(player);
        this.resultContainer.removeItemNoUpdate(1);
        this.access.execute((p_40313_, p_40314_) -> this.clearContainer(player, this.container));
    }
}
