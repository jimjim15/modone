package net.dox.nipeswords.item;

import net.dox.nipeswords.block.ModBlocks;
import net.dox.nipeswords.nipesWords;
import net.minecraft.client.gui.components.tabs.Tab;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, nipesWords.MOD_ID);
    public static final RegistryObject<CreativeModeTab> NIPES_TAB = CREATIVE_MODE_TABS.register("nipes_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(items.NIPES.get()))
            .title(Component.translatable("creativetab.nipes_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(items.NIPES.get());
                output.accept(items.RAW_NIPES.get());
                output.accept(items.NIPES_SWORD.get());
                output.accept(items.NIPES_SHIELD.get());
                output.accept(items.NIPES_HOE.get());
                output.accept(items.METH.get());
                output.accept(items.MONEY.get());
                output.accept(items.BURGER_SPAWN_EGG.get());
                output.accept(items.SKIBIDI_SPAWN_EGG.get());
                output.accept(ModBlocks.NIPES_BLOCK.get());


            })
            .build());
    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
