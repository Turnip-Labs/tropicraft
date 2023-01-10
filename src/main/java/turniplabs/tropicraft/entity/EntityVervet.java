package turniplabs.tropicraft.entity;

import net.minecraft.src.*;
import net.minecraft.src.helper.DamageType;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntityVervet extends EntityAnimal {
    private int angerLevel = 0;

    public EntityVervet(World world) {
        super(world);
        this.health = 10;
        this.texture = "/tropicraft/assets/entity/vervet.png";
        this.setSize(0.8f, 0.8f);
    }

    private void becomeAngryAt(Entity entity) {
        this.entityToAttack = entity;
        this.angerLevel = 400 + this.rand.nextInt(400);
    }

    public boolean attackEntityFrom(Entity entity, int i, DamageType type) {
        if (entity instanceof EntityPlayer) {
            List<Entity> list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(32.0, 32.0, 32.0));

            for (Entity entity1 : list) {
                if (entity1 instanceof EntityVervet) {
                    EntityVervet entityVervet = (EntityVervet) entity1;
                    entityVervet.becomeAngryAt(entity);
                }
            }
            this.becomeAngryAt(entity);
            this.attackTime = 20;
        }
        return super.attackEntityFrom(entity, 2, DamageType.COMBAT);
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        if (this.angerLevel > 0) {
            player.attackEntityFrom(this, 2, DamageType.COMBAT);
        }
    }

    @Override
    public boolean interact(EntityPlayer entityplayer) {

        if (super.interact(entityplayer)) return true;
        else {
            ItemStack itemStack = entityplayer.inventory.getCurrentItem();

            if (itemStack != null && itemStack.itemID == Mod_Tropicraft.shellRare.itemID) {
                itemStack.consumeItem(entityplayer);
                if (itemStack.stackSize > 0) entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, rand.nextInt(2) == 0 ? new ItemStack(Item.nuggetGold, itemStack.stackSize) : new ItemStack(Item.diamond, itemStack.stackSize));

            } else if (itemStack != null && itemStack.itemID == Mod_Tropicraft.shellCommon.itemID
                    || itemStack != null && itemStack.itemID == Mod_Tropicraft.shellCommon2.itemID
                    || itemStack != null && itemStack.itemID == Mod_Tropicraft.shellCommon3.itemID
                    || itemStack != null && itemStack.itemID == Mod_Tropicraft.starfish.itemID) {
                if (itemStack.stackSize > 0) entityplayer.inventory.setInventorySlotContents(entityplayer.inventory.currentItem, rand.nextInt(2) == 0 ? new ItemStack(Item.cherry, itemStack.stackSize) : new ItemStack(Item.nuggetIron, itemStack.stackSize));
            }
        }
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbttagcompound) {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("Anger", (short)this.angerLevel);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbttagcompound) {
        super.readEntityFromNBT(nbttagcompound);
        this.angerLevel = nbttagcompound.getShort("Anger");
    }

    @Override
    protected String getLivingSound() {
        if (angerLevel > 0) {
            return "tropicraft.monkeyangry";
        } else
            return "tropicraft.monkeyliving";
    }

    @Override
    protected String getHurtSound() {
        return "tropicraft.monkeyhurt";
    }

    @Override
    protected String getDeathSound() {
        return "tropicraft.monkeyhurt";
    }

    @Override
    protected int getDropItemId() {
        return Item.leather.itemID;
    }
}
