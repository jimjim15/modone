package net.dox.nipeswords.block;

import net.dox.nipeswords.item.items;
import net.dox.nipeswords.nipesWords;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, nipesWords.MOD_ID);
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
    public static final RegistryObject<Block> NIPES_BLOCK = registerBlock("nipes_block",() ->  new Block(BlockBehaviour.Properties.copy(Blocks.OBSIDIAN)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
         return items.ITEMS.register(name, ()-> new BlockItem(block.get(),new Item.Properties()));
    }

}
