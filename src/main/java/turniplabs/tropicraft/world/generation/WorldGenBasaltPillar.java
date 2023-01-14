package turniplabs.tropicraft.world.generation;

import net.minecraft.shared.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.BlockGrass;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.Random;

public class WorldGenBasaltPillar extends WorldGenerator {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        int x1;
        int y1;
        int height = random.nextInt(3) + 5;
        int z2;

        x1 = world.getBlockId(x, y - 1, z);
        if ((Block.blocksList[x1] instanceof BlockGrass || x1 == Block.basalt.blockID) && y < Minecraft.WORLD_HEIGHT_BLOCKS - height - 1) {
            world.setBlockWithNotify(x, y - 1, z, Block.basalt.blockID);

            for (y1 = 0; y1 < height - 1; ++y1) {
                z2 = world.getBlockId(x, y + y1, z);
                if (z2 == 0) world.setBlockWithNotify(x, y + y1, z, Block.basalt.blockID);
            }
            return true;
        }
        return false;
    }
}
