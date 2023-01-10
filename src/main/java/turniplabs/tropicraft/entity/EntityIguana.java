package turniplabs.tropicraft.entity;

import net.minecraft.src.EntityAnimal;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

public class EntityIguana extends EntityAnimal {
    public EntityIguana(World world) {
        super(world);
        this.health = 9;
        this.texture = "/tropicraft/assets/entity/iguana.png";
        this.setSize(0.3f, 0.4f);
        this.moveSpeed = 0.25f;
        this.isImmuneToFire = true;
    }

    @Override
    protected void dropFewItems() {
        int i = this.getDropItemId();
        if (i > 0) {
            int j = this.rand.nextInt(5) + 1;

            for(int k = 0; k < j; ++k) {
                this.dropItem(i, 1);
            }
        }
    }

    @Override
    protected String getLivingSound() {
        return "tropicraft.iggyliving";
    }

    @Override
    protected String getHurtSound() {
        return "tropicraft.iggyattack";
    }

    @Override
    protected String getDeathSound() {
        return "tropicraft.iggydeath";
    }

    @Override
    protected int getDropItemId() {
        return Mod_Tropicraft.scale.itemID;
    }
}
