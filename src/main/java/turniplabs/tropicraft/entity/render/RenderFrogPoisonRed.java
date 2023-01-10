package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityFrogPoisonRed;

public class RenderFrogPoisonRed extends RenderLiving {

    public RenderFrogPoisonRed(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderFrogPoison(EntityFrogPoisonRed entityFrog, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityFrog, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonRed) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonRed) entity, d, d1, d2, f, f1);
    }
}
