package turniplabs.tropicraft.item;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;

public class ItemIris extends Item {
    public ItemIris(int i) {
        super(i);
    }

    @Override
    public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int x, int y, int z, int l, double heightPlaced) {
        if (l != 1) return false;
        else {
            ++y;
            Block blockBottom = Mod_Tropicraft.irisBottom;
            Block blockTop = Mod_Tropicraft.irisTop;

            if (!blockBottom.canPlaceBlockAt(world, x, y, z)) return false;
            else {
                world.editingBlocks = true;
                world.setBlockWithNotify(x, y, z, blockBottom.blockID);
                world.setBlockWithNotify(x, y + 1, z, blockTop.blockID);
                world.editingBlocks = false;
                world.notifyBlocksOfNeighborChange(x, y, z, l);
                world.notifyBlocksOfNeighborChange(x, y + 1, z, l);

                world.playSoundEffect(
                        x + 0.5f,
                        y + 0.5f,
                        z + 0.5f,
                        blockBottom.stepSound.func_1145_d(),
                        (blockBottom.stepSound.getVolume() + 1.0f) / 2,
                        blockBottom.stepSound.getPitch() * 0.8f);
            }
        }
        itemstack.consumeItem(entityplayer);
        return true;
    }
}
