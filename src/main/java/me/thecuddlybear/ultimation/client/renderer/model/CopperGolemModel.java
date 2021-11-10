package me.thecuddlybear.ultimation.client.renderer.model;// Made with Blockbench 4.0.1
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import me.thecuddlybear.ultimation.Ultimation;
import me.thecuddlybear.ultimation.entity.CopperGolem;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class CopperGolemModel<T extends CopperGolem> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(Ultimation.MOD_ID, "copper_golem"), "main");
	private final ModelPart head;
	private final ModelPart arm_left;
	private final ModelPart arm_right;
	private final ModelPart body;
	private final ModelPart leg_left;
	private final ModelPart leg_right;

	public CopperGolemModel(ModelPart root) {
		this.head = root.getChild("head");
		this.arm_left = root.getChild("arm_left");
		this.arm_right = root.getChild("arm_right");
		this.body = root.getChild("body");
		this.leg_left = root.getChild("leg_left");
		this.leg_right = root.getChild("leg_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, -5.0F, -4.5F, 9.0F, 5.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(10, 25).addBox(-1.1F, -2.1F, -6.7F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(26, 14).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-1.0F, -8.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 15.0F, 0.0F));

		PartDefinition arm_left = partdefinition.addOrReplaceChild("arm_left", CubeListBuilder.create().texOffs(0, 25).addBox(-11.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, 15.0F, 0.0F));

		PartDefinition arm_right = partdefinition.addOrReplaceChild("arm_right", CubeListBuilder.create().texOffs(23, 22).addBox(9.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.0F, 15.0F, 0.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-12.0F, 2.0F, -2.5F, 8.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(8.0F, 13.0F, 0.0F));

		PartDefinition bone15 = body.addOrReplaceChild("bone15", CubeListBuilder.create(), PartPose.offset(-2.0F, 4.0F, 0.0F));

		PartDefinition bone14 = body.addOrReplaceChild("bone14", CubeListBuilder.create(), PartPose.offset(2.0F, 4.0F, 0.0F));

		PartDefinition bone5 = body.addOrReplaceChild("bone5", CubeListBuilder.create(), PartPose.offset(4.0F, 0.0F, 0.0F));

		PartDefinition bone13 = body.addOrReplaceChild("bone13", CubeListBuilder.create(), PartPose.offset(-4.0F, 0.0F, 0.0F));

		PartDefinition leg_left = partdefinition.addOrReplaceChild("leg_left", CubeListBuilder.create(), PartPose.offset(-2.0F, 21.0F, 0.0F));

		PartDefinition bone9 = leg_left.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(10, 32).addBox(-2.0F, 1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition bone8 = leg_left.addOrReplaceChild("bone8", CubeListBuilder.create(), PartPose.offset(4.0F, -2.0F, 0.0F));

		PartDefinition bone7 = leg_left.addOrReplaceChild("bone7", CubeListBuilder.create(), PartPose.offset(-2.0F, -6.0F, 0.0F));

		PartDefinition leg_right = partdefinition.addOrReplaceChild("leg_right", CubeListBuilder.create(), PartPose.offset(2.0F, 21.0F, 0.0F));

		PartDefinition bone12 = leg_right.addOrReplaceChild("bone12", CubeListBuilder.create().texOffs(27, 0).addBox(-2.0F, 1.0F, -1.5F, 4.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

		PartDefinition bone10 = leg_right.addOrReplaceChild("bone10", CubeListBuilder.create(), PartPose.offset(4.0F, -2.0F, 0.0F));

		PartDefinition bone11 = leg_right.addOrReplaceChild("bone11", CubeListBuilder.create(), PartPose.offset(-2.0F, -6.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.xRot = headPitch * Mth.DEG_TO_RAD;
		this.head.yRot = headPitch * Mth.DEG_TO_RAD;

		this.leg_left.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg_right.xRot = Mth.sin(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.arm_left.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.arm_right.xRot = Mth.sin(limbSwing * 0.6662F) * 1.4F  * limbSwingAmount;
		//TODO: Body swing --> Model changes
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		arm_left.render(poseStack, buffer, packedLight, packedOverlay);
		arm_right.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		leg_left.render(poseStack, buffer, packedLight, packedOverlay);
		leg_right.render(poseStack, buffer, packedLight, packedOverlay);
	}
}