package net.dox.nipeswords.item;

import net.dox.nipeswords.nipesWords;
import net.dox.nipeswords.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NIPES = TierSortingRegistry.registerTier(
            new ForgeTier(6, 3200, 10f, 5f, 35,
                    ModTags.Blocks.NEEDS_NIPES_TOOL, () -> Ingredient.of(items.NIPES.get())),
            new ResourceLocation(nipesWords.MOD_ID, "sapphire"), List.of(Tiers.NETHERITE), List.of());
}
