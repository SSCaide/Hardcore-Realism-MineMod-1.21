package net.sscaide.realismmod.block.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sscaide.realismmod.block.custom.Bloomery;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipe;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipeInput;
import net.sscaide.realismmod.recipe.ModRecipes;
import net.sscaide.realismmod.util.ModTags;

import java.util.Optional;

public class BloomeryEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            ;
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };
    private int fuel = 0;
    private int progress = 0;
    private int maxProgress;
    private int ticker = 20;

        public BloomeryEntity(BlockPos pos, BlockState blockState) {
            super(ModBlockEntities.BLOOMERY_ENTITY.get(), pos, blockState);
        }

        public void clearContents() {
            inventory.setStackInSlot(0, ItemStack.EMPTY);
        }

        public void drops() {
            SimpleContainer inv = new SimpleContainer((inventory.getSlots()));
            for(int i = 0; i < inventory.getSlots(); i++ ) {
                inv.setItem(i, inventory.getStackInSlot(i));
            }
            Containers.dropContents(this.level, this.worldPosition, inv);
        }

        public <T extends BlockEntity> void tick(Level level, BlockPos pos, BlockState state) {
            if(hasRecipe()) {
                maxProgress = getCurrentRecipe().get().value().cookDuration();
            }
            if (ticker > 0) {
                ticker--;
            } else {
                ItemStack stored = inventory.getStackInSlot(0);
                ticker = 20;
                if (hasRecipe() && fuel > 0 && progress < maxProgress) {
                    fuel -= 20;
                    progress += 20;
                } else if (hasRecipe() && progress >= maxProgress) {
                    craftItem();
                    progress = 0;
                    if (fuel > 0) {
                        fuel -= 20;
                    } else {
                        level.setBlockAndUpdate(pos, state.setValue(Bloomery.LIT, false).setValue(Bloomery.FUELED, false));
                        level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, .5f, .9f);
                    }
                    level.playSound(null, pos, SoundEvents.ARROW_HIT_PLAYER, SoundSource.BLOCKS, .025f, .8f);
                } else if (hasRecipe()) {
                    progress -= 10;
                    level.setBlockAndUpdate(pos, state.setValue(Bloomery.LIT, false).setValue(Bloomery.FUELED, false));
                } else if (fuel > 0) {
                    fuel -= 20;
                } else if (fuel < 1) {
                    level.setBlockAndUpdate(pos, state.setValue(Bloomery.LIT, false).setValue(Bloomery.FUELED, false));
                    level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, .5f, .9f);
                }
            }
        }

    private boolean hasRecipe() {
        Optional<RecipeHolder<BrickFurnaceRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        return true;
    }

    private Optional<RecipeHolder<BrickFurnaceRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager().getRecipeFor(ModRecipes.BRICK_FURNACE_TYPE.get(),
                new BrickFurnaceRecipeInput(inventory.getStackInSlot(0)), level);
    }

    private void craftItem() {
        Optional<RecipeHolder<BrickFurnaceRecipe>> recipe = getCurrentRecipe();
        clearContents();;
        inventory.insertItem(0, recipe.get().value().output(), false);
    }

        private void smelt(ItemStack item) {
            if (item.is(ModTags.Items.COPPER_NUGGET_SMELTABLES)) {
                clearContents();
                inventory.insertItem(0, ModItems.COPPER_NUGGET.toStack(1), false);
            } else if (item.is(ModTags.Items.COPPER_INGOT_SMELTABLES)) {
                ItemStack copper = new ItemStack(Items.COPPER_INGOT, 1);
                clearContents();
                inventory.insertItem(0, copper, false);
            } else if (item.is(ModItems.RAW_TIN_NUGGET)) {
                clearContents();
                inventory.insertItem(0, ModItems.TIN_NUGGET.toStack(1), false);
            } else if (item.is(ModItems.RAW_TIN)) {
                clearContents();
                inventory.insertItem(0, ModItems.TIN_INGOT.toStack(1), false);
            } else if (item.is(ModItems.RAW_GOLD_NUGGET)) {
                ItemStack gold = new ItemStack(Items.GOLD_NUGGET, 1);
                clearContents();
                inventory.insertItem(0, gold, false);
            } else if (item.is(Items.RAW_GOLD)) {
                ItemStack gold = new ItemStack(Items.GOLD_INGOT, 1);
                clearContents();
                inventory.insertItem(0, gold, false);
            } else if (item.is(ModTags.Items.IRON_NUGGET_SMELTABLES)) {
                ItemStack iron = new ItemStack(Items.IRON_NUGGET, 1);
                clearContents();
                inventory.insertItem(0, iron, false);
            } else if (item.is(ModTags.Items.IRON_INGOT_SMELTABLES)) {
                ItemStack iron = new ItemStack(Items.IRON_INGOT, 1);
                clearContents();
                inventory.insertItem(0, iron, false);
            }
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int i) {
            fuel = i;
        }

        public void setProgress(int i) {
            progress = i;
        }

        // Read values from the passed CompoundTag here.
        @Override
        public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
            super.loadAdditional(tag, registries);
            // Will default to 0 if absent. See the NBT article for more information.
            inventory.deserializeNBT(registries, tag.getCompound("inventory"));
            fuel = tag.getInt("fuel");
            progress = tag.getInt("progress");
            ticker = tag.getInt("ticker");
        }

        // Save values into the passed CompoundTag here.
        @Override
        public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
            super.saveAdditional(tag, registries);
            tag.put("inventory", inventory.serializeNBT(registries));
            tag.putInt("fuel", fuel);
            tag.putInt("progress", progress);
            tag.putInt("ticker", ticker);
        }

        // Create an update tag here. For block entities with only a few fields, this can just call #saveAdditional.
        @Override
        public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
            CompoundTag tag = new CompoundTag();
            saveAdditional(tag, registries);
            return tag;
        }
}
