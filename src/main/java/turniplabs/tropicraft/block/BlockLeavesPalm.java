package turniplabs.tropicraft.block;

import net.minecraft.src.Block;
import net.minecraft.src.BlockLeavesBase;
import net.minecraft.src.Material;

import java.util.Random;

public class BlockLeavesPalm extends BlockLeavesBase {
    public BlockLeavesPalm(int i, Material material, boolean flag) {
        super(i, material, flag);
    }

    public int idDropped(int i, Random random) {
        return Block.saplingPine.blockID;
    }

}
