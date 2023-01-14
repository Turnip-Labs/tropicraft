package turniplabs.tropicraft.world.generation;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class WorldGenTreeShapePalm extends WorldGenerator {
    protected int leavesID;
    protected int logID;
    protected int coconutID;

    public WorldGenTreeShapePalm(int leavesID, int logID) {
        this.leavesID = leavesID;
        this.logID = logID;
        this.coconutID = Mod_Tropicraft.coconut.blockID;
    }

    @Override
    public boolean generate(World world, Random random, int x, int y, int z) {
        byte byte0 = 5;
        boolean flag = true;

        if (y >= 1 && y + byte0 + 1 <= 128) {
            int i1;
            int l1;
            for (i1 = y; i1 <= y + 1 + byte0; ++i1) {
                byte j1 = 1;
                if (i1 == y) {
                    j1 = 0;
                }

                if (i1 >= y + 1 + byte0 - 2) {
                    j1 = 2;
                }

                for (l1 = x - j1; l1 <= x + j1 && flag; ++l1) {
                    for (int i2 = z - j1; i2 <= z + j1 && flag; ++i2) {
                        if (i1 >= 0 && i1 < 128) {
                            int j2 = world.getBlockId(l1, i1, i2);
                            if (j2 != 0 && j2 != leavesID) {
                                flag = false;
                            }
                        } else {
                            flag = false;
                        }
                    }
                }
            }
            if(!flag) {
                return false;
            } else {
                i1 = world.getBlockId(x, y - 1, z);
                if (i1 == Mod_Tropicraft.sandPurified.blockID && y < 128 - byte0 - 1) {
                    world.setBlock(x, y - 1, z, Mod_Tropicraft.sandPurified.blockID);
                    world.setBlock(x, y + 9, z, leavesID);
                    world.setBlock(x, y + 8, z + 1, leavesID);
                    world.setBlock(x, y + 8, z + 2, leavesID);
                    world.setBlock(x, y + 8, z + 3, leavesID);
                    world.setBlock(x, y + 7, z + 4, leavesID);
                    world.setBlock(x + 1, y + 8, z, leavesID);
                    world.setBlock(x + 2, y + 8, z, leavesID);
                    world.setBlock(x + 3, y + 8, z, leavesID);
                    world.setBlock(x + 4, y + 7, z, leavesID);
                    world.setBlock(x, y + 8, z - 1, leavesID);
                    world.setBlock(x, y + 8, z - 2, leavesID);
                    world.setBlock(x, y + 8, z - 3, leavesID);
                    world.setBlock(x, y + 7, z - 4, leavesID);
                    world.setBlock(x - 1, y + 8, z, leavesID);
                    world.setBlock(x - 1, y + 8, z - 1, leavesID);
                    world.setBlock(x - 1, y + 8, z + 1, leavesID);
                    world.setBlock(x + 1, y + 8, z - 1, leavesID);
                    world.setBlock(x + 1, y + 8, z + 1, leavesID);
                    world.setBlock(x - 2, y + 8, z, leavesID);
                    world.setBlock(x - 3, y + 8, z, leavesID);
                    world.setBlock(x - 4, y + 7, z, leavesID);
                    world.setBlock(x + 2, y + 8, z + 2, leavesID);
                    world.setBlock(x + 2, y + 8, z - 2, leavesID);
                    world.setBlock(x - 2, y + 8, z + 2, leavesID);
                    world.setBlock(x - 2, y + 8, z - 2, leavesID);
                    world.setBlock(x + 3, y + 7, z + 3, leavesID);
                    world.setBlock(x + 3, y + 7, z - 3, leavesID);
                    world.setBlock(x - 3, y + 7, z + 3, leavesID);
                    world.setBlock(x - 3, y + 7, z - 3, leavesID);

                    for (int var13 = 0; var13 < byte0 + 6; ++var13) {
                        l1 = world.getBlockId(x, y + var13, z);
                        if (l1 == 0 || l1 == leavesID) {
                            world.setBlock(x, y + var13 - 2, z, logID);
                            if (var13 > byte0 - 1 && var13 < byte0 + 1) {
                                random.nextInt(1);
                                int pr = random.nextInt(4);
                                switch (pr) {
                                    case 0:
                                        world.setBlock(x - 1, y + var13 + 2, z, coconutID);
                                        break;
                                    case 1:
                                        world.setBlock(x - 1, y + var13 + 2, z, coconutID);
                                        world.setBlock(x, y + var13 + 2, z - 1, coconutID);
                                        break;
                                    case 2:
                                        world.setBlock(x - 1, y + var13 + 2, z, coconutID);
                                        world.setBlock(x, y + var13 + 2, z - 1, coconutID);
                                        world.setBlock(x + 1, y + var13 + 2, z, coconutID);
                                        break;
                                    default:
                                        world.setBlock(x - 1, y + var13 + 2, z, coconutID);
                                        world.setBlock(x, y + var13 + 2, z - 1, coconutID);
                                        world.setBlock(x + 1, y + var13 + 2, z, coconutID);
                                        world.setBlock(x, y + var13 + 2, z + 1, coconutID);
                                        break;
                                }
                            }
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
}
