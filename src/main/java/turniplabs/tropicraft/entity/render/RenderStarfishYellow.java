package turniplabs.tropicraft.entity.render;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModelBase;
import net.minecraft.src.RenderLiving;
import turniplabs.tropicraft.entity.EntityStarfishYellow;

public class RenderStarfishYellow extends RenderLiving {

    public RenderStarfishYellow(ModelBase modelbase, float f) {
        super(modelbase, f);
    }

    public void renderStarfish(EntityStarfishYellow entityStarfish, double d, double d1, double d2, float f, float f1) {
        super.doRenderLiving(entityStarfish, d, d1, d2, f, f1);
    }

    public void doRenderLiving(EntityLiving entityliving, double d, double d1, double d2, float f, float f1) {
        this.renderStarfish((EntityStarfishYellow) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(Entity entity, double d, double d1, double d2, float f, float f1) {
        this.renderStarfish((EntityStarfishYellow) entity, d, d1, d2, f, f1);
    }
}
