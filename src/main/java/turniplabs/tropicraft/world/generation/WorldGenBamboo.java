package turniplabs.tropicraft.world.generation;

import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class WorldGenBamboo extends WorldGenerator {
    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        for(int l = 0; l < 20; ++l) {
            int x1 = x + random.nextInt(4) - random.nextInt(4);
            int z1 = z + random.nextInt(4) - random.nextInt(4);
            if (world.isAirBlock(x1, y, z1)
                    && (
                    world.getBlockMaterial(x1 - 1, y - 1, z1) == Material.water
                            || world.getBlockMaterial(x1 + 1, y - 1, z1) == Material.water
                            || world.getBlockMaterial(x1, y - 1, z1 - 1) == Material.water
                            || world.getBlockMaterial(x1, y - 1, z1 + 1) == Material.water
            )) {
                int l1 = 5 + random.nextInt(random.nextInt(10) + 1);

                for(int i2 = 0; i2 < l1; ++i2) {
                    if (Mod_Tropicraft.bambooBlock.canBlockStay(world, x1, y + i2, z1)) {
                        world.setBlock(x1, y + i2, z1, Mod_Tropicraft.bambooBlock.blockID);
                    }
                }
            }
        }

        return true;
    }
}
