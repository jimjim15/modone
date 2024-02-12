package net.dox.nipeswords.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.dox.nipeswords.item.items;
import net.dox.nipeswords.nipesWords;
import net.dox.nipeswords.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = nipesWords.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(), 10), new ItemStack(items.METH.get(), 1), 3, 10, 2));
            trades.get(2).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),8),new ItemStack(items.METH.get(),2),3,10,2));
            trades.get(3).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),6),new ItemStack(items.METH.get(),3),3,10,2));
            trades.get(4).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),4),new ItemStack(items.METH.get(),4),3,10,2));
            trades.get(5).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),2),new ItemStack(items.METH.get(),5),3,10,2));

        }

        if(event.getType() == ModVillagers.DEALER.get()){
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();


            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(), 5), new ItemStack(items.METH.get(), 2), 3, 10, 2));
            trades.get(2).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),4),new ItemStack(items.METH.get(),4),3,10,2));
            trades.get(3).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),3),new ItemStack(items.METH.get(),6),3,10,2));
            trades.get(4).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),2),new ItemStack(items.METH.get(),8),3,10,2));
            trades.get(5).add((pTrader,pRandom) -> new MerchantOffer(new ItemStack(items.MONEY.get(),1),new ItemStack(items.METH.get(),10),3,10,2));

        }
    }
}
