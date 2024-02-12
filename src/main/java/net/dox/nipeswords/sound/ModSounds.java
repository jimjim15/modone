package net.dox.nipeswords.sound;

import net.dox.nipeswords.nipesWords;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, nipesWords.MOD_ID);

    public static final RegistryObject<SoundEvent> DEALER_TRADE = registerSoundEvents("dealer_trade");
    public static final RegistryObject<SoundEvent> BURGER_DEATH = registerSoundEvents("burger_death");
    public static final RegistryObject<SoundEvent> BURGER_HURT = registerSoundEvents("burger_hurt");
    public static final RegistryObject<SoundEvent> BURGER_AMBIENT = registerSoundEvents("burger_ambient");
    public static final RegistryObject<SoundEvent> SKIBIDI_DEATH = registerSoundEvents("skibidi_death");
    public static final RegistryObject<SoundEvent> SKIBIDI_HURT = registerSoundEvents("skibidi_hurt");
    public static final RegistryObject<SoundEvent> SKIBIDI_AMBIENT = registerSoundEvents("skibidi_ambient");




    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(nipesWords.MOD_ID,name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
