package turniplabs.tropicraft.entity;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

public class EntityStarfishPink extends EntityLiving {
    public EntityStarfishPink(World world) {
        super(world);
        this.health = 1;
        this.moveSpeed = 0.1f;
        this.setSize(0.6f,0.6f);
        this.texture = "/assets/tropicraft/entity/starfish_pink.png";
        this.canBreatheUnderwater();
    }

    @Override
    protected void dropFewItems() {
        int i = this.getDropItemId();
        this.dropItem(i, 1);
    }

    @Override
    protected int getDropItemId() {
        return Mod_Tropicraft.starfish.itemID;
    }

    @Override
    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlockId(var1, var2 - 1, var3) == Mod_Tropicraft.sandPurified.blockID && this.worldObj.getFullBlockLightValue(var1, var2, var3) > 8 && super.getCanSpawnHere();
    }

    @Override
    protected String getDeathSound() {
        return "null";
    }

    @Override
    protected String getHurtSound() {
        return "null";
    }

    @Override
    protected String getLivingSound() {
        return "null";
    }

    @Override
    public void onLivingUpdate() {
        this.rotationYaw = 0.0f;
        super.onLivingUpdate();
    }
}
