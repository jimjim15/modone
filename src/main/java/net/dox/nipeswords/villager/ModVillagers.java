package net.dox.nipeswords.villager;

import com.google.common.collect.ImmutableSet;
import net.dox.nipeswords.block.ModBlocks;
import net.dox.nipeswords.nipesWords;
import net.dox.nipeswords.sound.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES = DeferredRegister.create(ForgeRegistries.POI_TYPES, nipesWords.MOD_ID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS = DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, nipesWords.MOD_ID);

    public static final RegistryObject<PoiType> DEALER_POI = POI_TYPES.register("dealer_poi",() ->new PoiType(ImmutableSet.copyOf(ModBlocks.NIPES_BLOCK.get().getStateDefinition().getPossibleStates()),1,1));


    public static final RegistryObject<VillagerProfession> DEALER =
            VILLAGER_PROFESSIONS.register("dealer", () -> new VillagerProfession("=dealer",
                    holder -> holder.get() == DEALER_POI.get(), holder -> holder.get() == DEALER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), ModSounds.DEALER_TRADE.get()));

    @Nullable
    public SoundEvent workSound() {
        return ModSounds.DEALER_TRADE.get();
    }
    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
