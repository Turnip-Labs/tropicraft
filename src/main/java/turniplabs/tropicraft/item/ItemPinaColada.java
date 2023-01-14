package turniplabs.tropicraft.item;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;

public class ItemPinaColada extends Item {

    public ItemPinaColada(int i) {
        super(i);
        maxStackSize = 1;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        // teleport the player to the tropics if the sun is setting.
        long time = world.getWorldTime();
        if ( time > 10500 && time < 11100 && world.getCurrentSeason() == Season.surfaceSummer) {
            entityplayer.setInPortal(Mod_Tropicraft.tropicsPortal.blockID);
        }

        // play sounds
        world.playSoundAtEntity(entityplayer,"tropicraft.sipping",1.0f,1.0f);

        // don't consume pina collada if the player is on creative.
        if (entityplayer.getGamemode().consumeBlocks)
            return new ItemStack(Mod_Tropicraft.bambooMug);
        else return itemstack;
    }
}
