package turniplabs.tropicraft.block;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockCoconut extends Block {
    public BlockCoconut(int i, Material material) {
        super(i, material);
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.coconutChunk.itemID;
    }

    @Override
    public int quantityDropped(int metadata, Random random) {
        return 4;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
