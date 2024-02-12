package net.dox.nipeswords.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dox.nipeswords.entity.custom.BurgerEntity;
import net.dox.nipeswords.nipesWords;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BurgerRenderer extends MobRenderer<BurgerEntity, BurgerModel<BurgerEntity>> {


    public BurgerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new BurgerModel<>((pContext.bakeLayer(ModModelLayers.BURGER_LAYER))), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(BurgerEntity burgerEntity) {

        return new ResourceLocation(nipesWords.MOD_ID,"textures/entity/burger.png");
    }

    @Override
    public void render(BurgerEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {

        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}
