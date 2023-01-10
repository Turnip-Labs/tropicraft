package turniplabs.tropicraft.item;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

public class ItemFoodPineapple extends ItemFood {
    public ItemFoodPineapple(int id, int healAmount, boolean favouriteWolfMeat) {
        super(id, healAmount, favouriteWolfMeat);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        if (entityplayer.health < 20 && itemstack.consumeItem(entityplayer)) {
            entityplayer.heal(this.healAmount);
            return new ItemStack(Mod_Tropicraft.pineappleSeeds);
        }
        else return itemstack;
    }
}
