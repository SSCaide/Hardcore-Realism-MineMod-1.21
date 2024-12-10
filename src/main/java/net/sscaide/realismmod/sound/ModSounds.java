package net.sscaide.realismmod.sound;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.sscaide.realismmod.RealismMod;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, RealismMod.MOD_ID);

    public static final Supplier<SoundEvent> WASTELAND_FUNK = registerSoundEvent("wasteland_funk");
    public static final ResourceKey<JukeboxSong> WASTELAND_FUNK_KEY = createSong("wasteland_funk");

    //public static final Supplier<SoundEvent> SHARPENED_ROCK_CRAFTING = registerSoundEvent("sharpened_rock_crafting");

    /*public static final Supplier<SoundEvent> TIN_BLOCK_BREAK = registerSoundEvent("tin_block_break");
    public static final Supplier<SoundEvent> TIN_BLOCK_STEP = registerSoundEvent("tin_block_step");
    public static final Supplier<SoundEvent> TIN_BLOCK_PLACE = registerSoundEvent("tin_block_place");
    public static final Supplier<SoundEvent> TIN_BLOCK_HIT = registerSoundEvent("tin_block_hit");
    public static final Supplier<SoundEvent> TIN_BLOCK_FALL = registerSoundEvent("tin_block_fall");

    public static final DeferredSoundType TIN_BLOCK_SOUNDS = new DeferredSoundType(1f, 1f,
            ModSounds.TIN_BLOCK_BREAK, ModSounds.TIN_BLOCK_STEP, ModSounds.TIN_BLOCK_PLACE,
            ModSounds.TIN_BLOCK_HIT, ModSounds.TIN_BLOCK_FALL);*/

    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, name));
    }

    private static Supplier<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
