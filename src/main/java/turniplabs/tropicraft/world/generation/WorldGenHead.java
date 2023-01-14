package turniplabs.tropicraft.world.generation;

import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

import static net.minecraft.src.Block.*;

public class WorldGenHead extends WorldGenerator {

    // TODO - Replace with with something like an array for loop!
        @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        byte byte0 = 5;
        if(y >= 1 && y + byte0 + 1 <= 128) {
            if(y >= 128 - byte0 - 1) {
                return false;
            } else {
                if ((!world.isAirBlock(x, y + 1, z) || !world.isAirBlock(x, y, z)) && !world.isAirBlock(x, y - 1, z) && (world.getBlockId(x, y, z) == dirt.blockID || world.getBlockId(x, y, z) == grass.blockID)) {
                    int y1 = y + 1;
                    world.setBlock(x, y1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 2, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 3, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 3, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 3, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 4, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 3, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 3, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 2, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 4, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 4, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 4, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 5, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 5, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 5, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 5, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 3, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 4, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 6, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 6, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 6, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 6, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 6, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x + 1, y1 + 5, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x + 1, y1 + 5, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x + 1, y1 + 4, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x + 1, y1 + 4, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 2, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 + 6, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 3, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 3, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 2, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 3, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 4, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 5, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 6, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 6, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 6, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 5, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 5, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 4, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 4, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 1, z + 4, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 2, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 2, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 4, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 3, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 3, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 3, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 4, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 5, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 6, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 6, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 + 6, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 4, y1 + 5, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 4, y1 + 4, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 4, y1 + 4, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 4, y1 + 5, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 + 1, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 + 1, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1, z - 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 1, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 1, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 1, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 1, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 2, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 2, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 2, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 2, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 2, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 2, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 3, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 3, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 3, z + 2, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 3, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 3, z + 1, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 3, y1 - 3, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 2, y1 - 3, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x - 1, y1 - 3, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x, y1 - 3, z, Mod_Tropicraft.headChunk.blockID);

                    world.setBlock(x, y1 + 5, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 4, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 5, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 3, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 4, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 3, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 2, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 3, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 2, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 + 1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 5, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 4, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 3, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 4, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 3, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 2, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 3, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 2, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 + 1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x, y1 + 4, z, fluidLavaFlowing.blockID);
                    world.setBlock(x, y1 + 4, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 3, y1 + 4, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 3, y1 + 4, z + 1, fluidLavaFlowing.blockID);
                    world.setBlock(x - 3, y1 + 5, z, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 - 1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 - 1, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 2, y1 - 2, z + 2, fluidLavaFlowing.blockID);
                    world.setBlock(x - 1, y1 - 2, z + 2, fluidLavaFlowing.blockID);

                    int rbi = random.nextInt(4);
                    switch (rbi) {
                        case 0:
                            world.setBlock(x, y1 + 5, z + 1, blockGold.blockID);
                            world.setBlock(x - 3, y1 + 5, z + 1, blockGold.blockID);
                            break;
                        case 1:
                            world.setBlock(x, y1 + 5, z + 1, blockDiamond.blockID);
                            world.setBlock(x - 3, y1 + 5, z + 1, blockDiamond.blockID);
                            break;
                        case 2:
                            world.setBlock(x, y1 + 5, z + 1, blockIron.blockID);
                            world.setBlock(x - 3, y1 + 5, z + 1, blockIron.blockID);
                            break;
                        default:
                            world.setBlock(x, y1 + 5, z + 1, glowstone.blockID);
                            world.setBlock(x - 3, y1 + 5, z + 1, glowstone.blockID);
                            break;
                    }
                }
                return true;
            }
        } else {
            return false;
        }
    }
}
