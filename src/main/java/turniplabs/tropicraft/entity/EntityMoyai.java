package turniplabs.tropicraft.entity;

import net.minecraft.src.*;
import net.minecraft.src.helper.DamageType;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.List;

public class EntityMoyai extends EntityMob {
    private int angerLevel = 0;

    public EntityMoyai(World world) {
        super(world);
        this.isImmuneToFire = true;
        this.scoreValue = 300;
        this.health = 30;
        this.setSize(1.0F, 3.0F);
        this.moveSpeed = 0.0F;
    }

    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Anger", (short)this.angerLevel);
    }

    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.angerLevel = nbttagcompound.getShort("Anger");
    }

    @Override
    protected Entity findPlayerToAttack() {
        return this.angerLevel == 0 ? null : super.findPlayerToAttack();
    }

    @Override
    public boolean attackEntityFrom(Entity entity, int i, DamageType type) {
        if (entity instanceof EntityPlayer) {
            List<Entity> list;
            list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0, 32.0, 32.0));

            for (Entity entity1 : list) {
                if (entity1 instanceof EntityMoyai) {
                    EntityMoyai entityMoyai = (EntityMoyai) entity1;
                    entityMoyai.becomeAngryAt(entity);
                }
            }
            this.becomeAngryAt(entity);
        }
        return super.attackEntityFrom(entity, i, type);
    }

    private void becomeAngryAt(Entity entity) {
        this.entityToAttack = entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
    }

    @Override
    public String getEntityTexture() {
        if (this.angerLevel > 0) return "/assets/tropicraft/entity/moyai_angry.png";
        return "/assets/tropicraft/entity/moyai.png";
    }

    @Override
    protected String getLivingSound() {
        return "null";
    }

    @Override
    protected String getHurtSound() {
        return "tropicraft.headpain";
    }

    @Override
    protected String getDeathSound() {
        if (rand.nextInt(100) == 0) return "tropicraft.boom";
        return "tropicraft.headdeath";
    }

    @Override
    protected int getDropItemId() {
        return Mod_Tropicraft.headChunk.blockID;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }

    public void onLivingUpdate() {
        // set move speed to 0 if not angered
        if (angerLevel > 0) this.moveSpeed = 1.0f;
        else this.moveSpeed = 0.0F;

        super.onLivingUpdate();
    }

}
