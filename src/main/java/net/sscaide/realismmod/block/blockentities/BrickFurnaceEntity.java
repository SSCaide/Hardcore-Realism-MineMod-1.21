package net.sscaide.realismmod.block.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
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
import net.sscaide.realismmod.block.custom.BrickFurnace;
import net.sscaide.realismmod.item.ModItems;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipe;
import net.sscaide.realismmod.recipe.BrickFurnaceRecipeInput;
import net.sscaide.realismmod.recipe.ModAnvilRecipeInput;
import net.sscaide.realismmod.recipe.ModRecipes;
import net.sscaide.realismmod.util.ModTags;

import java.util.Optional;
import java.util.Random;

public class BrickFurnaceEntity extends BlockEntity {
    public final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 1;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();

            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };
    public final ItemStackHandler remnantInv = new ItemStackHandler(2) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) {
            return 8;
        }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();

            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };
    private int fuel = 0;
    private int progress = 0;
    private int maxProgress;
    private int ticker = 20;
    private int charcoal;
    private int charcoalprogress;
    private int ash;
    private int ashprogress;

        public BrickFurnaceEntity(BlockPos pos, BlockState blockState) {
            super(ModBlockEntities.BRICK_FURNACE_ENTITY.get(), pos, blockState);
        }

        public void clearContents() {
            inventory.setStackInSlot(0, ItemStack.EMPTY);
        }
        public void clearCharcoal() {
            remnantInv.setStackInSlot(0, ItemStack.EMPTY);
        }
        public void clearAsh() {
            remnantInv.setStackInSlot(1, ItemStack.EMPTY);
        }

        public void drops() {
            SimpleContainer inv = new SimpleContainer((inventory.getSlots()));
            for(int i = 0; i < inventory.getSlots(); i++ ) {
                inv.setItem(i, inventory.getStackInSlot(i));
            }
            for(int i = 0; i < remnantInv.getSlots(); i++ ) {
                inv.setItem(i, remnantInv.getStackInSlot(i));
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
                ticker = 20;
                if ((hasRecipe() && fuel > 0 && progress < maxProgress) || (hasRecipe() && fuel > 0 && progress < maxProgress)) {
                    fuel -= 20;
                    progress += 20;
                    processRemnants(level, pos);
                } else if (hasRecipe() && progress >= maxProgress) {
                    craftItem();
                    progress = 0;
                    if (fuel > 0) {
                        fuel -= 20;
                        processRemnants(level, pos);
                    } else {
                        level.setBlockAndUpdate(pos, state.setValue(BrickFurnace.LIT, false).setValue(BrickFurnace.FUELED, false));
                        level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, .5f, .9f);
                    }
                    level.playSound(null, pos, SoundEvents.ARROW_HIT_PLAYER, SoundSource.BLOCKS, .025f, .9f);
                } else if (hasRecipe() && fuel < 1 && progress > 0 && progress < maxProgress) {
                    progress -= 10;
                    level.setBlockAndUpdate(pos, state.setValue(BrickFurnace.LIT, false).setValue(BrickFurnace.FUELED, false));
                } else if (fuel > 0) {
                    fuel -= 20;
                    processRemnants(level, pos);
                } else if (fuel < 1) {
                    level.setBlockAndUpdate(pos, state.setValue(BrickFurnace.LIT, false).setValue(BrickFurnace.FUELED, false));
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

        private void processRemnants(Level level, BlockPos pos) {
            Random rand = new Random();

            if(charcoal > 0 && rand.nextInt(3) == 0) {
                charcoal--;
                charcoalprogress++;
                if(charcoalprogress==15) {
                    ItemStack remnant = new ItemStack(Items.CHARCOAL, 1);
                    level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, .1f, .9f);
                    remnantInv.insertItem(0, remnant, false);
                    charcoalprogress = 0;
                }
            } else if(ash > 0 && rand.nextInt(3) == 0) {
                ash--;
                ashprogress++;
                if(ashprogress==10) {
                    level.playSound(null, pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, .1f, .9f);
                    remnantInv.insertItem(1, ModItems.PILE_OF_ASH.toStack(1), false);
                    ashprogress = 0;
                }
            }
        }

        public void addCharcoal(int amount) {
            charcoal += amount;
        }

        public void addAsh(int amount) {
            ash += amount;
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
            remnantInv.deserializeNBT(registries, tag.getCompound("remnant_inventory"));
            fuel = tag.getInt("fuel");
            progress = tag.getInt("progress");
            ticker = tag.getInt("ticker");
            charcoal = tag.getInt("charcoal");
            charcoalprogress = tag.getInt("charcoal_progress");
            ash = tag.getInt("ash");
            ashprogress = tag.getInt("ash_progress");
        }

        // Save values into the passed CompoundTag here.
        @Override
        public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
            super.saveAdditional(tag, registries);
            tag.put("inventory", inventory.serializeNBT(registries));
            tag.put("remnant_inventory", remnantInv.serializeNBT(registries));
            tag.putInt("fuel", fuel);
            tag.putInt("progress", progress);
            tag.putInt("ticker", ticker);
            tag.putInt("charcoal", charcoal);
            tag.putInt("charcoal_progress", charcoalprogress);
            tag.putInt("ash", ash);
            tag.putInt("ash_progress", ashprogress);
        }

        // Create an update tag here. For block entities with only a few fields, this can just call #saveAdditional.
        @Override
        public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
            CompoundTag tag = new CompoundTag();
            saveAdditional(tag, registries);
            return tag;
        }
}
