package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityStarfishPink;

public class RenderStarfishPink extends RenderLiving {

    public RenderStarfishPink(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderStarfish(EntityStarfishPink entityStarfish, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityStarfish, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderStarfish((EntityStarfishPink) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderStarfish((EntityStarfishPink) entity, d, d1, d2, f, f1);
    }
}
