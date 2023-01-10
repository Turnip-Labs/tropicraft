package turniplabs.tropicraft.block;

import net.minecraft.src.Material;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockIris extends BlockDouble {
    public BlockIris(int i, boolean isTop, Material material) {
        super(i, isTop, material);
    }

    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.iris.itemID;
    }
}
