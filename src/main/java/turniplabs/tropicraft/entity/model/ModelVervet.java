package turniplabs.tropicraft.entity.model;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelVervet extends ModelBase {
    public ModelRenderer face;
    public ModelRenderer head;
    public ModelRenderer body;
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer tailClosest;
    public ModelRenderer tailEnd;

    public ModelVervet() {
        this.face = new ModelRenderer(0,0);
        this.head = new ModelRenderer(0,12);
        this.body = new ModelRenderer(0,0);
        this.armLeft = new ModelRenderer(10,20);
        this.armRight = new ModelRenderer(6,19);
        this.legLeft = new ModelRenderer(0,19);
        this.legRight = new ModelRenderer(18,12);
        this.tailClosest = new ModelRenderer(18,0);
        this.tailEnd = new ModelRenderer(11,14);

        this.face.addBox(-2.0f,8.0f,-3.0f,4,4,1,0.0f);
        this.head.addBox(-3.0f, 7.0f, -2.0f,6,5,2,0.0f);
        this.body.addBox(-2.0f, 8.0f,1.0f, 4,2,10,0.0f);
        this.armLeft.addBox(2.0f, 10.0f, -1.0f,1,7,1,0.0f);
        this.armRight.addBox(-3.0f, 10.0f, -1.0f,1,7,1,0.0f);
        this.legLeft.addBox(2.0f,14.0f,-2.0f,1,5,2, 0.0f);
        this.legRight.addBox(-3.0f,14.0f,-2.0f,1,5,2,0.0f);
        this.tailClosest.addBox(-1.0f, 15.0f, -6.0f,2,1,4,0.0f);
        this.tailEnd.addBox(-0.5f, 15.0f, 0.0f,1,1,5,0.0f);

        this.face.setRotationPoint(0.0f, 7.0f,-5.0f);
        this.head.setRotationPoint(0.0f,7.0f,-5.0f);
        this.body.setRotationPoint(0.0f,8.0f, -5.0f);
        this.armLeft.setRotationPoint(0.0f,7.0f,-2.5f);
        this.armRight.setRotationPoint(0.0f,7.0f,-2.5f);
        this.legLeft.setRotationPoint(0.0f,5.0f,3.0f);
        this.legRight.setRotationPoint(0.0f,5.0f,3.0f);
        this.tailClosest.setRotationPoint(0.0f,3.0f,3.0f);
        this.tailEnd.setRotationPoint(0.0f,3.0f,3.0f);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.face.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.armLeft.render(f5);
        this.armRight.render(f5);
        this.legLeft.render(f5);
        this.legRight.render(f5);
        this.tailClosest.render(f5);
        this.tailEnd.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.face.rotateAngleY = f3 / 114.59156f;
        this.head.rotateAngleY = f3 / 114.59156f;
        this.body.rotateAngleX = -0.3f;
        this.tailClosest.rotateAngleX = 0.3f;
        this.tailEnd.rotateAngleX = 0.15f;
        this.armLeft.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.2F * f1;
        this.armRight.rotateAngleX = MathHelper.cos(f * 0.6662F) * 0.2F * f1;
        this.legLeft.rotateAngleX = MathHelper.cos(f + 3.141593F) * 0.2F * f1;
        this.legRight.rotateAngleX = MathHelper.cos(f + 3.141593F) * 0.2F * f1;
    }
}
