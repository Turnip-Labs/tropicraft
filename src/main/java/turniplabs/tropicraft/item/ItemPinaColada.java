package turniplabs.tropicraft.item;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

public class ItemPinaColada extends Item {

    public ItemPinaColada(int i) {
        super(i);
        maxStackSize = 1;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        super.onItemRightClick(itemstack, world, entityplayer);
        world.playSoundAtEntity(entityplayer,"tropicraft.sipping",1.0f,1.0f);
        return new ItemStack(Mod_Tropicraft.bambooMug);
    }
}
