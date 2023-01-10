package turniplabs.tropicraft.entity;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

public class EntityFrog extends EntityAnimal {
    public EntityFrog(World world) {
        super(world);
        this.health = 4;
        this.texture = "/tropicraft/assets/entity/frog.png";
        this.setSize(0.3f, 0.3f);
    }

    @Override
    protected String getLivingSound() {
        return "tropicraft.frog";
    }

    @Override
    protected String getHurtSound() {
        return "null";
    }

    @Override
    protected String getDeathSound() {
        return "null";
    }

    @Override
    protected int getDropItemId() {
        return this.fire > 0 ? Mod_Tropicraft.frogLegCooked.itemID : Mod_Tropicraft.frogLeg.itemID;
    }
}
