package turniplabs.tropicraft.entity.model;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelIguana extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer headGib;
    public ModelRenderer body;
    public ModelRenderer bodyFront;
    public ModelRenderer bodyGib;
    public ModelRenderer tailClosest;
    public ModelRenderer tailMid;
    public ModelRenderer tailEnd;
    public ModelRenderer tailGib;
    public ModelRenderer legFrontLeft;
    public ModelRenderer legFrontRight;
    public ModelRenderer legBackLeft;
    public ModelRenderer legBackRight;

    public ModelIguana() {
        this.head = new ModelRenderer(10,0);
        this.headGib = new ModelRenderer(0,2);
        this.body = new ModelRenderer(0,0);
        this.bodyFront = new ModelRenderer(0,0);
        this.bodyGib = new ModelRenderer(0,2);
        this.tailClosest = new ModelRenderer(10,9);
        this.tailMid = new ModelRenderer(0,11);
        this.tailEnd = new ModelRenderer(6,16);
        this.tailGib = new ModelRenderer(0,0);
        this.legFrontLeft = new ModelRenderer(12,16);
        this.legFrontRight = new ModelRenderer(16,6);
        this.legBackLeft = new ModelRenderer(18,0);
        this.legBackRight = new ModelRenderer(0,17);

        this.head.addBox(-1.0f,19.0f,-4.0f,2,2,4, 0.0f);
        this.headGib.addBox(0.0f, 21.0f, -2.0f,0,1,2,0.0f);
        this.body.addBox(-1.0f, 20.0f, -4.0f,2,3,6, 0.0f);
        this.bodyFront.addBox(-1.0f, 20.0f, -5.0f,2,2,1, 0.0f);
        this.bodyGib.addBox(0.0f, 18.0f, -5.0f, 0,2,7, 0.0f);
        this.tailClosest.addBox(-0.5f, 20.0f, 0.0f,1,3,4,0.0f);
        this.tailMid.addBox(-0.5f, 20.0f, 4.0f,1,2,4,0.0f);
        this.tailEnd.addBox(-0.5f, 20.0f, 8.0f, 1,1,4,0.0f);
        this.tailGib.addBox(0.0f, 19.0f, 0.0f,0,1,3,0.0f);
        this.legFrontLeft.addBox(2.0f, 20.0f, -1.0f, 1,2,2,0.0f);
        this.legFrontRight.addBox(-3.0f, 20.0f,-1.0f,1,2,2, 0.0f);
        this.legBackLeft.addBox(2.0f,20.0f,-1.0f,1,2,2,0.0f);
        this.legBackRight.addBox(-3.0f,20.0f,-1.0f,1,2,2,0.0f);

        this.head.setRotationPoint(0.0f,0.0f,-5.0f);
        this.headGib.setRotationPoint(0.0f, 0.0f, -5.0f);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bodyFront.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.bodyGib.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tailClosest.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.tailMid.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.tailEnd.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.tailGib.setRotationPoint(0.0f, 0.0f, 2.0f);
        this.legFrontLeft.setRotationPoint(-1.0f,2.0f,-3.0f);
        this.legFrontRight.setRotationPoint(1.0f,2.0f,-3.0f);
        this.legBackLeft.setRotationPoint(-1.0f,2.0f,2.0f);
        this.legBackRight.setRotationPoint(1.0f,2.0f,2.0f);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.head.render(f5);
        this.headGib.render(f5);
        this.body.render(f5);
        this.bodyFront.render(f5);
        this.bodyGib.render(f5);
        this.tailClosest.render(f5);
        this.tailMid.render(f5);
        this.tailEnd.render(f5);
        this.tailGib.render(f5);
        this.legFrontLeft.render(f5);
        this.legFrontRight.render(f5);
        this.legBackLeft.render(f5);
        this.legBackRight.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.tailClosest.rotateAngleY = MathHelper.cos(f * 0.6662f) * 1.0f * f1;
        this.tailMid.rotateAngleY = MathHelper.cos(f * 0.6662f) * 1.10f * f1;
        this.tailEnd.rotateAngleY = MathHelper.cos(f * 0.6662f) * 1.20f * f1;
        this.tailGib.rotateAngleY = MathHelper.cos(f * 0.6662f) * 1.0f * f1;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.2f * f1;
        this.legFrontRight.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.2f * f1;
        this.legBackLeft.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.2f * f1;
        this.legBackRight.rotateAngleX = MathHelper.cos(f * 0.6662F + 3.141593F) * 0.2f * f1;
    }
}