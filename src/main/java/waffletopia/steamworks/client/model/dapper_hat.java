package waffletopia.steamworks.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class dapper_hat extends BipedModel<LivingEntity>
{
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	
	public dapper_hat()
	{
		super(1);
		this.textureWidth = 64;
		this.textureHeight = 64;
		
		this.bone = new ModelRenderer(this, 0, 0);
		this.bone.setRotationPoint(0F, 0F, 0F);
		//this.bone.setRotationPoint(-16F, 24F, -16F);
		this.bone.addBox(-8.0F, -10.0F, -8.0F, 16, 2, 16);
		bone.setTextureSize(64, 64);
		this.bone2 = new ModelRenderer(this, 0, 18);
		//this.bone2.setRotationPoint(-13F, 26F, -14F);
		this.bone2.setRotationPoint(0F, 0F, 0F);
		this.bone2.addBox(-5F, -20.0F, -6F, 10, 10, 12);
		bone2.setTextureSize(64, 64);
		
		this.bone.addChild(this.bone2);
	}
	
	@Override
	public void render(MatrixStack matrixStack,
	                   IVertexBuilder buffer,
	                   int packedLight,
	                   int packedOverlay,
	                   float red,
	                   float green,
	                   float blue,
	                   float alpha)
	{
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.showModel = true;
		bipedHeadwear.showModel = false;
		
		bipedHead = bone;
		super.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}