package net.dox.nipeswords.item;

import net.dox.nipeswords.entity.ModEntities;
import net.dox.nipeswords.item.custom.NipesSword;
import net.dox.nipeswords.nipesWords;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, nipesWords.MOD_ID);
    public static final RegistryObject<Item> NIPES = ITEMS.register("nipes",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NIPES = ITEMS.register("raw_nipes",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MONEY = ITEMS.register("moneys",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METH = ITEMS.register("meth",() -> new Item(new Item.Properties().food(ModFoods.CRYSTAL_METH)));

    public static final RegistryObject<Item> BURGER_SPAWN_EGG = ITEMS.register("burger_spawn_egg",() -> new ForgeSpawnEggItem(ModEntities.BURGER,0x639b7b,0xdfdeae, new Item.Properties()));

    public static final RegistryObject<Item> SKIBIDI_SPAWN_EGG = ITEMS.register("skibidi_spawn_egg",() -> new ForgeSpawnEggItem(ModEntities.SKIBIDI,0xFFFFFF,0x5F9EA0, new Item.Properties()));


    public static final RegistryObject<Item> NIPES_SWORD = ITEMS.register("nipes_sword",() -> new NipesSword(ModToolTiers.NIPES, 10, 1, new Item.Properties()));

  //  public static final RegistryObject<Item> NIPES_AXE = ITEMS.register("nipes_axe",() -> new AxeItem(ModToolTiers.NIPES, 2, 1, new Item.Properties()));
  public static final RegistryObject<Item> NIPES_SHIELD = ITEMS.register("nipes_shield",() -> new ShieldItem(new Item.Properties()));
    public static final RegistryObject<Item> NIPES_HOE = ITEMS.register("nipes_hoe",() -> new HoeItem(ModToolTiers.NIPES, 10, 1, new Item.Properties()));
  //  public static final RegistryObject<Item> NIPES_SHOVEL = ITEMS.register("nipes_shovel",() -> new ShovelItem(ModToolTiers.NIPES, 1, 1, new Item.Properties()));
    //public static final RegistryObject<Item> NIPES_PICKAXE = ITEMS.register("nipes_pickaxe",() -> new PickaxeItem(ModToolTiers.NIPES, 1, 1, new Item.Properties()));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
