package net.sscaide.realismmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.hoglin.HoglinBase;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.entity.custom.BoarEntity;
import net.sscaide.realismmod.entity.custom.GeckoEntity;

public class BoarModel<T extends BoarEntity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "boar"), "main");

    private final ModelPart head;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
    private final ModelPart body;
    private final ModelPart mane;
    private final ModelPart front_left_leg;
    private final ModelPart front_right_leg;
    private final ModelPart back_left_leg;
    private final ModelPart back_right_leg;

    public BoarModel(ModelPart root) {
        this.body = root.getChild("Body");
        this.head = this.body.getChild("Head");
        this.left_ear = this.body.getChild("Left Ear");
        this.right_ear = this.body.getChild("Right Ear");
        this.mane = this.body.getChild("Mane");
        this.front_left_leg = this.body.getChild("Front Left Leg");
        this.front_right_leg = this.body.getChild("Front Right Leg");
        this.back_left_leg = this.body.getChild("Back Left Leg");
        this.back_right_leg = this.body.getChild("Back Right Leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(65, 3).addBox(-5.0F, 0.0F, -17.0F, 10.0F, 6.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(1, 13).addBox(4.0F, -6.0F, -12.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(10, 13).addBox(-6.0F, -6.0F, -12.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, -8.5F));

        PartDefinition left_ear = partdefinition.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(1, 6).addBox(-2.0F, 2.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, 1.0F, -11.5F));

        PartDefinition right_ear = partdefinition.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(1, 1).addBox(-4.0F, 2.0F, -2.0F, 6.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-7.0F, 1.0F, -11.5F));

        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(8, 5).addBox(-5.0F, -4.0F, -13.0F, 10.0F, 11.0F, 22.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 4.5F));

        PartDefinition mane = partdefinition.addOrReplaceChild("mane", CubeListBuilder.create().texOffs(90, 33).addBox(0.0F, 5.0F, -9.0F, 0.0F, 8.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, -2.5F));

        PartDefinition front_left_leg = partdefinition.addOrReplaceChild("front_left_leg", CubeListBuilder.create().texOffs(44, 44).addBox(-2.0F, 2.0F, -1.75F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 10.0F, -4.75F));

        PartDefinition front_right_leg = partdefinition.addOrReplaceChild("front_right_leg", CubeListBuilder.create().texOffs(69, 44).addBox(-2.0F, 2.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 10.0F, -4.5F));

        PartDefinition back_left_leg = partdefinition.addOrReplaceChild("back_left_leg", CubeListBuilder.create().texOffs(1, 46).addBox(-3.5F, 1.0F, -5.5F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.5F, 13.0F, 14.0F));

        PartDefinition back_right_leg = partdefinition.addOrReplaceChild("back_right_leg", CubeListBuilder.create().texOffs(23, 46).addBox(-0.5F, 1.0F, -5.5F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.5F, 13.0F, 14.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        left_ear.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        right_ear.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        mane.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        front_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        front_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        back_left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
        back_right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return body;
    }

    @Override
    public void setupAnim(BoarEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.applyHeadRotation(netHeadYaw, headPitch);

        this.right_ear.zRot = -0.6981317F - limbSwingAmount * Mth.sin(limbSwing);
        this.left_ear.zRot = 0.6981317F + limbSwingAmount * Mth.sin(limbSwing);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        int i = ((HoglinBase)entity).getAttackAnimationRemainingTicks();
        float f = 1.0F - (float)Mth.abs(10 - 2 * i) / 10.0F;
        this.head.xRot = Mth.lerp(f, 0.87266463F, -0.34906584F);
        if (entity.isBaby()) {
            this.head.y = Mth.lerp(f, 2.0F, 5.0F);
            this.mane.z = -3.0F;
        } else {
            this.head.y = 2.0F;
            this.mane.z = -7.0F;
        }

        float f1 = 1.2F;
        this.front_right_leg.xRot = Mth.cos(limbSwing) * 1.2F * limbSwingAmount;
        this.front_left_leg.xRot = Mth.cos(limbSwing + (float)Math.PI) * 1.2F * limbSwingAmount;
        this.back_right_leg.xRot = this.front_left_leg.xRot;
        this.back_left_leg.xRot = this.front_right_leg.xRot;
    }

    private void applyHeadRotation(float headYaw, float headPitch) {
        headYaw = Mth.clamp(headYaw, -30f, 30f);
        headPitch = Mth.clamp(headPitch, -25f, 45);

        this.head.yRot = headYaw * ((float)Math.PI / 180f);
        this.head.xRot = headPitch *  ((float)Math.PI / 180f);
    }
}
