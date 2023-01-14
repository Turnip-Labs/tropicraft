package turniplabs.tropicraft.world.generation;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

import static net.minecraft.src.Block.*;

public class WorldGenHead extends WorldGenerator {

    public boolean generate(World world, Random random, int x, int y, int z) {
            if ((!world.isAirBlock(x, y + 1, z) || !world.isAirBlock(x, y, z)) && !world.isAirBlock(x, y - 1, z) && (world.getBlockId(x, y, z) == dirt.blockID || world.getBlockId(x, y, z) == grass.blockID)) {
                y -= 2;
                int workX;
                int workY;
                int workZ;

                // main body
                for (workY = -5; workY < 7; workY++) {
                    for (workX = 0; workX < 4; workX++) {
                        world.setBlockRaw(x + workX, y + workY, z + 1, Mod_Tropicraft.headChunk.blockID);
                        world.setBlockRaw(x + workX, y + workY, z + 2, Mod_Tropicraft.headChunk.blockID);
                    }

                    world.setBlockRaw(x + 1, y + workY, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlockRaw(x + 3, y + workY, z, Mod_Tropicraft.headChunk.blockID);

                    world.setBlockRaw(x + 1, y + workY, z + 3, Mod_Tropicraft.headChunk.blockID);
                    world.setBlockRaw(x + 3, y + workY, z + 3, Mod_Tropicraft.headChunk.blockID);

                    if (workY > -5) {
                        world.setBlockRaw(x + 1, y + workY, z + 1, Block.fluidLavaStill.blockID);
                        world.setBlockRaw(x + 1, y + workY, z + 2, Block.fluidLavaStill.blockID);
                    }
                }

                // mouth
                for (workY = 2; workY < 4; workY++) {
                    for (workZ = 0; workZ < 4; workZ++) {
                        world.setBlock(x, y + workY, z + workZ, Mod_Tropicraft.headChunk.blockID);
                        world.setBlock(x - 1, y + workY, z + workZ, Mod_Tropicraft.headChunk.blockID);
                    }
                }

                // inner ears
                for (workY = 4; workY < 7; workY++) {
                    world.setBlock(x + 2, y + workY, z, Mod_Tropicraft.headChunk.blockID);
                    world.setBlock(x + 2, y + workY, z + 3, Mod_Tropicraft.headChunk.blockID);
                }

                // back
                world.setBlock(x, y + 4, z, Mod_Tropicraft.headChunk.blockID);
                world.setBlock(x, y + 4, z + 3, Mod_Tropicraft.headChunk.blockID);

                world.setBlock(x - 1, y + 5, z + 1, Mod_Tropicraft.headChunk.blockID);
                world.setBlock(x - 1, y + 5, z + 2, Mod_Tropicraft.headChunk.blockID);

                // big cube
                for (workY = 5; workY < 9; workY++) {
                    for (workX = 0; workX < 3; workX++) {
                        for (workZ = 0; workZ < 4; workZ++)
                            world.setBlock(x + 2 + workX, y + workY, z + workZ, Mod_Tropicraft.headChunk.blockID);
                    }
                }

                // ears
                for (workY = 6; workY < 8; workY++) {
                    for (workX = 1; workX < 3; workX++) {
                        world.setBlock(x + 1 + workX, y + workY, z - 1, Mod_Tropicraft.headChunk.blockID);
                        world.setBlock(x + 1 + workX, y + workY, z + 4, Mod_Tropicraft.headChunk.blockID);
                    }
                }

                // big cube lava
                for (workY = 6; workY < 8; workY++) {
                    for (workZ = 1; workZ < 3; workZ++) {
                        for (workX = 1; workX < 4; workX++) {
                            world.setBlock(x + workX, y + workY, z + workZ, fluidLavaStill.blockID);
                        }
                    }
                }

                // nose top
                for (workZ = 1; workZ < 3; workZ++)
                    world.setBlock(x + 1, y + 7, z + workZ, Mod_Tropicraft.headChunk.blockID);

                // eyes
                int[] eyeMaterial = {blockDiamond.blockID, blockGold.blockID, blockIron.blockID, glowstone.blockID};
                int eye = eyeMaterial[random.nextInt(4)];

                world.setBlock(x + 2, y + 7, z, eye);
                world.setBlock(x + 2, y + 7, z + 3, eye);

                return true;
            }

            return false;
        }
}
