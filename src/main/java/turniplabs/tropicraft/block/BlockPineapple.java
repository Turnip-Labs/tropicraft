package turniplabs.tropicraft.block;

import net.minecraft.src.Material;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockPineapple extends BlockDouble {
    public boolean isTop;

    public BlockPineapple(int i, boolean isTop, Material material) {
        super(i, isTop, material);
    }
    @Override
    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.pineapple.itemID;
    }
}
