package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityFrogPoisonYellow;

public class RenderFrogPoisonYellow extends RenderLiving {

    public RenderFrogPoisonYellow(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderFrogPoison(EntityFrogPoisonYellow entityFrog, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityFrog, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonYellow) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonYellow) entity, d, d1, d2, f, f1);
    }
}
