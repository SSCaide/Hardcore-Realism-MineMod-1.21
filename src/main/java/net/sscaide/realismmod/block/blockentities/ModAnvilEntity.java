package net.sscaide.realismmod.block.blockentities;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.sscaide.realismmod.block.ModBlocks;
import net.sscaide.realismmod.block.custom.ModAnvilBlock;
import net.sscaide.realismmod.screen.custom.ModAnvilMenu;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class ModAnvilEntity extends BlockEntity implements MenuProvider {
    public final ItemStackHandler inventory = new ItemStackHandler(2) {
        @Override
        protected int getStackLimit(int slot, ItemStack stack) { return 64; }

        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            ;
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };
    private static final int INGREDIENT_INPUT_SLOT = 0; public static int getIngredientSlot() { return INGREDIENT_INPUT_SLOT; }
    private static final int TOOL_INPUT_SLOT = 1; public static int getToolSlot() { return TOOL_INPUT_SLOT; }

    private int damage;
    private int material; //1=weaker than stone, 2=stone, 3=copper, 4=iron/bronze, 5=steel, 6=stronger than steel, 7=netherite
    private int maxDamage;

    public ModAnvilEntity(BlockPos pos, BlockState blockState, int material, int maxDamage) {
        super(ModBlockEntities.MOD_ANVIL_ENTITY.get(), pos, blockState);
        this.material = material;
        this.maxDamage = maxDamage;

    }
    public ModAnvilEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.MOD_ANVIL_ENTITY.get(), pos, blockState);
    }

    public void clearContents() {
        inventory.setStackInSlot(0, ItemStack.EMPTY);
    }

    public void damage(int material, int craftingMaterial, Level level, BlockPos pos, BlockState state) {
        Random rand = new Random();
        if(material-craftingMaterial == 1 && rand.nextInt(3) == 0) {
            damage++;
        } else if(material == craftingMaterial && rand.nextInt(2) == 0) {
            damage += 2;
        } else if(craftingMaterial > material) {
            craftingMaterial -= material;
            damage += craftingMaterial*3;
        }

        if(damage >= maxDamage) {
            damage -= maxDamage;
            level.setBlockAndUpdate(pos, state.setValue(ModAnvilBlock.DAMAGE, state.getValue(ModAnvilBlock.DAMAGE) + 1));
            if(state.is(ModBlocks.STONE_ANVIL)) {

            } else {
                level.playSound(null, pos, SoundEvents.ANVIL_BREAK, SoundSource.BLOCKS, 1f, 1f);
            }
        }

        var check = state.getValue(ModAnvilBlock.DAMAGE);
        if(check == 3) {
            level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
            drops();
        }
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer((inventory.getSlots()));
        for(int i = 0; i < inventory.getSlots(); i++ ) {
            inv.setItem(i, inventory.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.sscaiderealism.mod_anvil_display");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ModAnvilMenu(i, inventory, this, ContainerLevelAccess.NULL);
    }

    // Read values from the passed CompoundTag here.
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        // Will default to 0 if absent. See the NBT article for more information.
        inventory.deserializeNBT(registries, tag.getCompound("inventory"));
        damage = tag.getInt("damage");
        material = tag.getInt("material");
        maxDamage = tag.getInt("maxDamage");
    }

    // Save values into the passed CompoundTag here.
    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.put("inventory", inventory.serializeNBT(registries));
        tag.putInt("damage", damage);
        tag.putInt("material", material);
        tag.putInt("maxDamage", maxDamage);
    }

    // Create an update tag here. For block entities with only a few fields, this can just call #saveAdditional.
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        saveAdditional(tag, registries);
        return tag;
    }
}
