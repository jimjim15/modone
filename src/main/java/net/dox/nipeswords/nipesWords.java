package net.dox.nipeswords;

import com.mojang.logging.LogUtils;
import net.dox.nipeswords.block.ModBlocks;
import net.dox.nipeswords.entity.ModEntities;
import net.dox.nipeswords.entity.client.BurgerRenderer;
import net.dox.nipeswords.entity.client.SkibidiRenderer;
import net.dox.nipeswords.item.ModCreativeModeTabs;
import net.dox.nipeswords.item.items;
import net.dox.nipeswords.sound.ModSounds;
import net.dox.nipeswords.villager.ModVillagers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;


@Mod(nipesWords.MOD_ID)
public class nipesWords
{

    public static final String MOD_ID = "nipeswords";

    private static final Logger LOGGER = LogUtils.getLogger();


    public nipesWords()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        items.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        ModBlocks.register(modEventBus);


        ModVillagers.register(modEventBus);
        ModCreativeModeTabs.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        ModEntities.register(modEventBus);
        ModSounds.register(modEventBus);


        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }


    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            EntityRenderers.register(ModEntities.BURGER.get(), BurgerRenderer:: new);
            EntityRenderers.register(ModEntities.SKIBIDI.get(), SkibidiRenderer:: new);
        }
    }
}
