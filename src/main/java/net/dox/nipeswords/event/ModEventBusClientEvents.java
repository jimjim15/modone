package net.dox.nipeswords.event;

import net.dox.nipeswords.entity.client.BurgerModel;
import net.dox.nipeswords.entity.client.ModModelLayers;
import net.dox.nipeswords.entity.client.SkibidiModel;
import net.dox.nipeswords.nipesWords;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = nipesWords.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.BURGER_LAYER, BurgerModel::createBodyLayer);
        event.registerLayerDefinition(ModModelLayers.SKIBIDI_LAYER, SkibidiModel::createBodyLayer);
    }
}