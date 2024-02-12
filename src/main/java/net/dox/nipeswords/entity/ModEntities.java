package net.dox.nipeswords.entity;

import net.dox.nipeswords.entity.custom.BurgerEntity;
import net.dox.nipeswords.entity.custom.SkibidiEntity;
import net.dox.nipeswords.nipesWords;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, nipesWords.MOD_ID);

    public static final RegistryObject<EntityType<BurgerEntity>> BURGER =
            ENTITY_TYPES.register("burger", () -> EntityType.Builder.of(BurgerEntity::new, MobCategory.MONSTER)
                    .sized(1.5f, 2f).build("burger"));

    public static final RegistryObject<EntityType<SkibidiEntity>> SKIBIDI =
            ENTITY_TYPES.register("skibidi", () -> EntityType.Builder.of(SkibidiEntity::new, MobCategory.MONSTER)
                    .sized(1f, 2f).build("skibidi"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
