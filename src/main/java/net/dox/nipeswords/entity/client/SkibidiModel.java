package net.dox.nipeswords.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.dox.nipeswords.entity.animations.ModAnimationDefinitions1;
import net.dox.nipeswords.entity.custom.BurgerEntity;
import net.dox.nipeswords.entity.custom.SkibidiEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SkibidiModel<T extends Entity> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor

    private final ModelPart skibidi;
    private final ModelPart head;

    public SkibidiModel(ModelPart root) {
        this.skibidi = root.getChild("skibidi");
        this.head = root.getChild("skibidi").getChild("head");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition skibidi = partdefinition.addOrReplaceChild("skibidi", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition seat = skibidi.addOrReplaceChild("seat", CubeListBuilder.create().texOffs(46, 9).addBox(-5.0F, -2.0F, -6.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 12).addBox(-5.0F, -2.0F, 4.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-10.0F, -10.0F, 6.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 41).addBox(-9.0F, -2.0F, -3.0F, 3.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition cube_r1 = seat.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(34, 0).addBox(-7.0F, -12.0F, -22.0F, 14.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -11.0F, -20.0F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, -1.5708F, -1.5708F, 0.0F));

        PartDefinition cube_r2 = seat.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 42).addBox(-5.0F, -10.0F, 4.0F, 10.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        PartDefinition head = skibidi.addOrReplaceChild("head", CubeListBuilder.create().texOffs(30, 47).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 0.0F));

        PartDefinition neck = skibidi.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(36, 25).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -9.0F, 0.0F));

        PartDefinition base = skibidi.addOrReplaceChild("base", CubeListBuilder.create().texOffs(36, 9).addBox(5.0F, -4.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(36, 9).addBox(-6.0F, -4.0F, -4.0F, 1.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(34, 37).addBox(-5.0F, 0.0F, -3.0F, 9.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 29).addBox(-6.0F, 4.0F, -4.0F, 12.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 0.0F));

        PartDefinition cube_r3 = base.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 15).addBox(-5.0F, -9.0F, -5.0F, 10.0F, 4.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

        this.animate(((SkibidiEntity ) entity).attackAnimationState, ModAnimationDefinitions1.SKIBIDI_ATTACK, ageInTicks, 2f);
    }

    private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
        pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
        pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

        this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        skibidi.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return skibidi;
    }
};

