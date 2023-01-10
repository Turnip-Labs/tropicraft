package turniplabs.tropicraft.block;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;
import turniplabs.tropicraft.world.*;

import java.util.Random;

public class BlockSaplingPalm extends BlockSaplingBase {

    public BlockSaplingPalm(int i) {
        super(i);
    }

    @Override
    public void growTree(World world, int i, int j, int k, Random random) {
        WorldGenerator obj;
        world.setBlock(i, j, k, 0);
        obj = new WorldGenTreeShapePalm(Mod_Tropicraft.leavesPalm.blockID, Mod_Tropicraft.logPalm.blockID);
        obj.func_517_a(1.0, 1.0, 1.0);
        if (!obj.generate(world, random, i, j, k)) {
            world.setBlock(i, j, k, this.blockID);
        }
    }

    @Override
    public boolean canThisPlantGrowOnThisBlockID(int i) {
        return i == Mod_Tropicraft.sandPurified.blockID || super.canThisPlantGrowOnThisBlockID(i);
    }
}