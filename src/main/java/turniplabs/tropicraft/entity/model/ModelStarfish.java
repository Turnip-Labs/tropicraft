package turniplabs.tropicraft.entity.model;

import net.minecraft.src.ModelBase;
import net.minecraft.src.ModelRenderer;

public class ModelStarfish extends ModelBase {
    public ModelRenderer cube1;
    public ModelRenderer cube2;
    public ModelRenderer cube3;
    public ModelRenderer cube4;
    public ModelRenderer cube5;
    public ModelRenderer cube6;
    public ModelRenderer cube7;
    public ModelRenderer cube8;
    public ModelRenderer cube9;

    public ModelStarfish() {
        float f1 = 0.0f;
        float f2 = 24.0f;

        this.cube1 = new ModelRenderer(0,12);
        this.cube2 = new ModelRenderer(0,3);
        this.cube3 = new ModelRenderer(6,3);
        this.cube4 = new ModelRenderer(10,4);
        this.cube5 = new ModelRenderer(0,9);
        this.cube6 = new ModelRenderer(6,7);
        this.cube7 = new ModelRenderer(0,0);
        this.cube8 = new ModelRenderer(0,6);
        this.cube9 = new ModelRenderer(12,7);

        this.cube1.addBox(-1.0F, -1.0f, -1.0F, 2, 1, 2, 0.0F);
        this.cube2.addBox(-2.0F, -0.5f, -2.0F, 4, 1, 2, 0.0F);
        this.cube3.addBox(1.0F, -0.5f, -3.0F, 2, 1, 2, 0.0F);
        this.cube4.addBox(2.0F, -0.5f, -4.0F, 2, 1, 2, 0.0F);
        this.cube5.addBox(-3.0F, -0.5f, -3.0F, 2, 1, 2, 0.0F);
        this.cube6.addBox(-4.0F, -0.5f, -4.0F, 2, 1, 2, 0.0F);
        this.cube7.addBox(-5.0F, -0.5f, 0.0F, 10, 1, 2, 0.0F);
        this.cube8.addBox(-1.0F, -0.5f, 3.0F, 2, 1, 2, 0.0F);
        this.cube9.addBox(-1.5F, -0.5f, 2.0F, 3, 1, 1, 0.0F);

        this.cube1.setRotationPoint(f1,f2,f1);
        this.cube2.setRotationPoint(f1,f2,f1);
        this.cube3.setRotationPoint(f1,f2,f1);
        this.cube4.setRotationPoint(f1,f2,f1);
        this.cube5.setRotationPoint(f1,f2,f1);
        this.cube6.setRotationPoint(f1,f2,f1);
        this.cube7.setRotationPoint(f1,f2,f1);
        this.cube8.setRotationPoint(f1,f2,f1);
        this.cube9.setRotationPoint(f1,f2,f1);
    }

    public void render(float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.cube1.render(f5);
        this.cube2.render(f5);
        this.cube3.render(f5);
        this.cube4.render(f5);
        this.cube5.render(f5);
        this.cube6.render(f5);
        this.cube7.render(f5);
        this.cube8.render(f5);
        this.cube9.render(f5);
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5);
    }
}
