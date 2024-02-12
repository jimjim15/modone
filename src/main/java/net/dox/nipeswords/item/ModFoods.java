package net.dox.nipeswords.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties CRYSTAL_METH = new FoodProperties.Builder().meat().nutrition(-2)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION,100),10).effect(() -> new MobEffectInstance(MobEffects.POISON,300),10).fast().build();
}
