package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityFrog;

public class RenderFrog extends RenderLiving {
    
    public RenderFrog(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderFrog(EntityFrog entityFrog, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityFrog, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderFrog((EntityFrog) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderFrog((EntityFrog) entity, d, d1, d2, f, f1);
    }
}
