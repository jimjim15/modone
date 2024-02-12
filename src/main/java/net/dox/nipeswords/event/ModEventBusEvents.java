package net.dox.nipeswords.event;

import net.dox.nipeswords.entity.ModEntities;
import net.dox.nipeswords.entity.custom.BurgerEntity;
import net.dox.nipeswords.entity.custom.SkibidiEntity;
import net.dox.nipeswords.nipesWords;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = nipesWords.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.BURGER.get(), BurgerEntity.createAttributes().build());
        event.put(ModEntities.SKIBIDI.get(), SkibidiEntity.createAttributes().build());
    }
}
