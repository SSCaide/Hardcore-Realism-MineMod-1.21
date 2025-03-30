package net.sscaide.realismmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.sscaide.realismmod.RealismMod;
import net.sscaide.realismmod.entity.custom.BoarEntity;


public class BoarRenderer extends MobRenderer<BoarEntity, BoarModel<BoarEntity>> {
    public BoarRenderer(EntityRendererProvider.Context context) {
        super(context, new BoarModel<>(context.bakeLayer(BoarModel.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BoarEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(RealismMod.MOD_ID, "textures/entity/boar/boar.png");
    }

    @Override
    public void render(BoarEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.45f, 0.45f, 0.45f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}