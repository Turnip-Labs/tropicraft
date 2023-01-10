package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityFrogPoisonBlue;

public class RenderFrogPoisonBlue extends RenderLiving {

    public RenderFrogPoisonBlue(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderFrogPoison(EntityFrogPoisonBlue entityFrog, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityFrog, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonBlue) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderFrogPoison((EntityFrogPoisonBlue) entity, d, d1, d2, f, f1);
    }
}
