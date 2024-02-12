package net.dox.nipeswords.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.dox.nipeswords.entity.custom.BurgerEntity;
import net.dox.nipeswords.entity.custom.SkibidiEntity;
import net.dox.nipeswords.nipesWords;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class SkibidiRenderer extends MobRenderer<SkibidiEntity, SkibidiModel<SkibidiEntity>> {


    public SkibidiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new SkibidiModel<>((pContext.bakeLayer(ModModelLayers.SKIBIDI_LAYER))), 0.5f);
    }



    @Override
    public ResourceLocation getTextureLocation(SkibidiEntity skibidiEntity) {
        return new ResourceLocation(nipesWords.MOD_ID,"textures/entity/skibidi.png");
    }

    @Override
    public void render(SkibidiEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()) {
            pPoseStack.scale(0.5f, 0.5f, 0.5f);
        }
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }
}