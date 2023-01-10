package turniplabs.tropicraft.entity.model;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelFrog extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer bodyBack;
    public ModelRenderer face;
    public ModelRenderer leftEye;
    public ModelRenderer rightEye;
    public ModelRenderer frontLegLeft;
    public ModelRenderer frontLegRight;
    public ModelRenderer backLegLeft;
    public ModelRenderer backLegRight;
    public ModelRenderer frontFootLeft;
    public ModelRenderer frontFootRight;
    public ModelRenderer backFootLeft;
    public ModelRenderer backFootRight;

    public ModelFrog() {
        float f1 = 0.0f;
        float f2 = 23.0f;
        float f3 = 3.0f;

        this.body = new ModelRenderer(0,0);
        this.bodyBack = new ModelRenderer(0,7);
        this.face = new ModelRenderer(0,9);
        this.leftEye = new ModelRenderer(9,3);
        this.rightEye = new ModelRenderer(0,11);
        this.frontLegLeft = new ModelRenderer(6,7);
        this.frontLegRight = new ModelRenderer(0,0);
        this.backLegLeft = new ModelRenderer(10,7);
        this.backLegRight = new ModelRenderer(9,10);
        this.frontFootLeft = new ModelRenderer(8,1);
        this.frontFootRight = new ModelRenderer(8,2);
        this.backFootLeft = new ModelRenderer(0,4);
        this.backFootRight = new ModelRenderer(8,0);

        this.body.addBox(-1.0f, -2.5f, -6.0f, 2,2,5, 0.0f);
        this.bodyBack.addBox(-1.0f,-1.5f,-1.0f,2,1,1,0.0f);
        this.face.addBox(-1.0f,-1.5f,-7.0f,2,1,1,0.0f);
        this.leftEye.addBox(0.5f,-2.5f,-5.5f,1,1,1, 0.0f);
        this.rightEye.addBox(-1.5f, -2.5f,-5.5f,1,1,1, 0.0f);

        this.frontLegLeft.addBox(0.0F, 19.0F, -5.0F, 1, 3, 1, 0.0f);
        this.frontLegRight.addBox(-3.0F, 18.0F, -1.0F, 1, 3, 1,0.0f);
        this.backLegLeft.addBox(2.0F, 20.0F, -1.0F, 1, 2, 1,0.0f);
        this.backLegRight.addBox(-3.0F, 20.0F, -1.0F, 1, 2, 1,0.0f);

        this.frontFootLeft.addBox(-0.5F, 22.0F, -6.0F, 2, 0, 1,0.0f);
        this.frontFootRight.addBox(-3.5F, 21.0F, -2.0F, 2, 0, 1,0.0f);
        this.backFootLeft.addBox(-0.5f, 22.0F, -3.0F, 2, 0, 1,0.0f);
        this.backFootRight.addBox(-3.5F, 22.0F, -2.0F, 2, 0, 1,0.0f);

        this.body.setRotationPoint(f1, f2, f3);
        this.bodyBack.setRotationPoint(f1, f2, f3);
        this.face.setRotationPoint(f1, f2, f3);
        this.leftEye.setRotationPoint(f1, f2, f3);
        this.rightEye.setRotationPoint(f1, f2, f3);
        this.frontLegLeft.setRotationPoint(1.0f,2.0f,3.0f);
        this.frontLegRight.setRotationPoint(1.0f,3.0f,-1.0f);
        this.backLegLeft.setRotationPoint(-1.0f,2.0f,3.0f);
        this.backLegRight.setRotationPoint(1.0f,2.0f,3.0f);
        this.frontFootLeft.setRotationPoint(1.0f,2.0f,3.0f);
        this.frontFootRight.setRotationPoint(1.0f,3.0f,-1.0f);
        this.backFootLeft.setRotationPoint(1.0f,2.0f,4.0f);
        this.backFootRight.setRotationPoint(1.0f,2.0f,3.0f);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.bodyBack.render(f5);
        this.face.render(f5);
        this.leftEye.render(f5);
        this.rightEye.render(f5);
        this.frontLegLeft.render(f5);
        this.frontLegRight.render(f5);
        this.backLegLeft.render(f5);
        this.backLegRight.render(f5);
        this.frontFootLeft.render(f5);
        this.frontFootRight.render(f5);
        this.backFootLeft.render(f5);
        this.backFootRight.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        this.body.rotateAngleX = -0.15f;
        this.bodyBack.rotateAngleX = -0.15f;
        this.face.rotateAngleX = -0.15f;
        this.leftEye.rotateAngleX = -0.15f;
        this.rightEye.rotateAngleX = -0.15f;
        this.frontLegLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.1F * f1;
        this.frontLegRight.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.1F * f1;
        this.backLegLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.1F * f1;
        this.backLegRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.1F * f1;
        this.frontFootLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.1F * f1;
        this.frontFootRight.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.1F * f1;
        this.backFootLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.1F * f1;
        this.backFootRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.1F * f1;
    }
}
