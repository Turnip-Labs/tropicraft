package turniplabs.tropicraft.world.generation;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFlower;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.Random;

public class WorldGenDouble extends WorldGenerator {
    private final int bottomBlock, topBlock;

    public WorldGenDouble(int bottomBlock, int topBlock) {
        this.bottomBlock = bottomBlock;
        this.topBlock = topBlock;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        for(int l = 0; l < 64; ++l) {
            int x1 = x + random.nextInt(8) - random.nextInt(8);
            int y1 = y + random.nextInt(4) - random.nextInt(4);
            int z1 = z + random.nextInt(8) - random.nextInt(8);
            if (world.isAirBlock(x1, y1, z1) && Block.blocksList[bottomBlock].canBlockStay(world, x1, y1, z1)) {
                world.setBlock(x1, y1, z1, bottomBlock);
                world.setBlock(x1, y1 + 1, z1, topBlock);
            }
        } return true;
    }
}
