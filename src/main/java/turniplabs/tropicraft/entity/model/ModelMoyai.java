package turniplabs.tropicraft.entity.model;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelMoyai extends ModelBase {
    public ModelRenderer body = new ModelRenderer(34, 8);
    public ModelRenderer base;
    public ModelRenderer nose;
    public ModelRenderer mouth;
    public ModelRenderer top;
    public ModelRenderer leye;
    public ModelRenderer reye;

    public ModelMoyai() {
        this.body.addBox(-4.0F, 1.0F, -1.0F, 8, 17, 7, 0.0F);
        this.body.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.body.rotateAngleX = 0.0F;
        this.body.rotateAngleY = 0.0F;
        this.body.rotateAngleZ = 0.0F;
        this.body.mirror = false;
        this.base = new ModelRenderer(0, 0);
        this.base.addBox(-4.0F, 11.0F, -3.0F, 8, 8, 11, 0.0F);
        this.base.setRotationPoint(0.0F, 5.0F, -2.0F);
        this.base.rotateAngleX = 0.0F;
        this.base.rotateAngleY = 0.0F;
        this.base.rotateAngleZ = 0.0F;
        this.base.mirror = false;
        this.nose = new ModelRenderer(27, 2);
        this.nose.addBox(13.5F, -1.0F, -3.0F, 13, 2, 3, 0.0F);
        this.nose.setRotationPoint(0.0F, -14.8F, -1.0F);
        this.nose.rotateAngleX = 0.0F;
        this.nose.rotateAngleY = 0.0F;
        this.nose.rotateAngleZ = 1.570796F;
        this.nose.mirror = false;
        this.mouth = new ModelRenderer(56, 11);
        this.mouth.addBox(-1.5F, 4.0F, -1.0F, 3, 3, 1, 0.0F);
        this.mouth.setRotationPoint(0.0F, 7.5F, -0.5F);
        this.mouth.rotateAngleX = 0.0F;
        this.mouth.rotateAngleY = 0.0F;
        this.mouth.rotateAngleZ = 0.0F;
        this.mouth.mirror = false;
        this.top = new ModelRenderer(0, 17);
        this.top.addBox(-4.0F, -1.0F, -10.0F, 8, 5, 10, 0.0F);
        this.top.setRotationPoint(0.0F, -5.0F, 6.0F);
        this.top.rotateAngleX = 0.0F;
        this.top.rotateAngleY = 0.0F;
        this.top.rotateAngleZ = 0.0F;
        this.top.mirror = false;
        this.leye = new ModelRenderer(56, 7);
        this.leye.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.leye.setRotationPoint(1.0F, -1.0F, -2.0F);
        this.leye.rotateAngleX = 0.0F;
        this.leye.rotateAngleY = 0.0F;
        this.leye.rotateAngleZ = 0.0F;
        this.leye.mirror = true;
        this.reye = new ModelRenderer(56, 7);
        this.reye.addBox(-1.5F, -1.0F, -1.0F, 3, 3, 1, 0.0F);
        this.reye.setRotationPoint(-2.5F, 0.0F, -1.0F);
        this.reye.rotateAngleX = 0.0F;
        this.reye.rotateAngleY = 0.0F;
        this.reye.rotateAngleZ = 0.0F;
        this.reye.mirror = false;
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.base.render(f5);
        this.nose.render(f5);
        this.mouth.render(f5);
        this.top.render(f5);
        this.leye.render(f5);
        this.reye.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
    }
}