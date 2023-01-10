package turniplabs.tropicraft.entity;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import net.minecraft.src.helper.DamageType;
import turniplabs.tropicraft.Mod_Tropicraft;

public class EntityFrogPoisonBlue extends EntityFrog{
    public EntityFrogPoisonBlue(World world) {
        super(world);
        this.texture = "/tropicraft/assets/entity/poison_frog_blue.png";
    }

    @Override
    protected void dropFewItems() {
        int i = this.getDropItemId();
        if (i > 0) {
            int j = 1;

            for(int k = 0; k < j; ++k) {
                this.dropItem(i, 1);
            }
        }
    }

    @Override
    protected int getDropItemId() {
        return Mod_Tropicraft.frogSkin.itemID;
    }

    //TODO - Tone down the distance and possibly do proper poison damage
    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        player.attackEntityFrom(this, 2, DamageType.GENERIC);
    }
}