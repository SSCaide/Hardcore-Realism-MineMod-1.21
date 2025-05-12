package net.sscaide.realismmod.block.blockentities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.sscaide.realismmod.block.blockentities.BrickFurnaceEntity;
import net.sscaide.realismmod.block.custom.BrickFurnace;

public class BrickFurnaceEntityRenderer implements BlockEntityRenderer<BrickFurnaceEntity> {
    public BrickFurnaceEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(BrickFurnaceEntity entity, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        /*ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = entity.inventory.getStackInSlot(0);
        Direction facing = entity.getBlockState().getValue(BrickFurnace.FACING);

        poseStack.pushPose();;
        if(facing.equals(Direction.EAST)) {
            poseStack.translate(1f, .15f, .5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(90));
        } else if(facing.equals(Direction.WEST)) {
            poseStack.translate(0f, .15f, .5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(90));
        } else if(facing.equals(Direction.NORTH)) {
            poseStack.translate(.5f, .15f, 0f);
        } else if(facing.equals(Direction.SOUTH)) {
            poseStack.translate(.5f, .15f, 1f);
        }
        poseStack.scale(.5f, .5f, .5f);

        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, getLightLevel(entity.getLevel(),
                entity.getBlockPos()), OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, entity.getLevel(), 1);
        poseStack.popPose();*/
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
