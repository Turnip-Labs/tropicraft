package turniplabs.tropicraft.world;

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
    public boolean generate(World world, Random random, int i, int j, int k) {
        byte byte0 = 5;
        boolean flag = true;

        if (j >= 1 && j + byte0 + 1 <= 128) {
            int i1;
            int l1;
            for (i1 = j; i1 <= j + 1 + byte0; ++i1) {
                byte j1 = 1;
                if (i1 == j) {
                    j1 = 0;
                }

                if (i1 >= j + 1 + byte0 - 2) {
                    j1 = 2;
                }

                for (l1 = i - j1; l1 <= i + j1 && flag; ++l1) {
                    for (int i2 = k - j1; i2 <= k + j1 && flag; ++i2) {
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
                i1 = world.getBlockId(i, j - 1, k);
                if (i1 == Mod_Tropicraft.sandPurified.blockID && j < 128 - byte0 - 1) {
                    world.setBlock(i, j - 1, k, Mod_Tropicraft.sandPurified.blockID);
                    world.setBlock(i, j + 9, k, leavesID);
                    world.setBlock(i, j + 8, k + 1, leavesID);
                    world.setBlock(i, j + 8, k + 2, leavesID);
                    world.setBlock(i, j + 8, k + 3, leavesID);
                    world.setBlock(i, j + 7, k + 4, leavesID);
                    world.setBlock(i + 1, j + 8, k, leavesID);
                    world.setBlock(i + 2, j + 8, k, leavesID);
                    world.setBlock(i + 3, j + 8, k, leavesID);
                    world.setBlock(i + 4, j + 7, k, leavesID);
                    world.setBlock(i, j + 8, k - 1, leavesID);
                    world.setBlock(i, j + 8, k - 2, leavesID);
                    world.setBlock(i, j + 8, k - 3, leavesID);
                    world.setBlock(i, j + 7, k - 4, leavesID);
                    world.setBlock(i - 1, j + 8, k, leavesID);
                    world.setBlock(i - 1, j + 8, k - 1, leavesID);
                    world.setBlock(i - 1, j + 8, k + 1, leavesID);
                    world.setBlock(i + 1, j + 8, k - 1, leavesID);
                    world.setBlock(i + 1, j + 8, k + 1, leavesID);
                    world.setBlock(i - 2, j + 8, k, leavesID);
                    world.setBlock(i - 3, j + 8, k, leavesID);
                    world.setBlock(i - 4, j + 7, k, leavesID);
                    world.setBlock(i + 2, j + 8, k + 2, leavesID);
                    world.setBlock(i + 2, j + 8, k - 2, leavesID);
                    world.setBlock(i - 2, j + 8, k + 2, leavesID);
                    world.setBlock(i - 2, j + 8, k - 2, leavesID);
                    world.setBlock(i + 3, j + 7, k + 3, leavesID);
                    world.setBlock(i + 3, j + 7, k - 3, leavesID);
                    world.setBlock(i - 3, j + 7, k + 3, leavesID);
                    world.setBlock(i - 3, j + 7, k - 3, leavesID);

                    for (int var13 = 0; var13 < byte0 + 6; ++var13) {
                        l1 = world.getBlockId(i, j + var13, k);
                        if (l1 == 0 || l1 == leavesID) {
                            world.setBlock(i, j + var13 - 2, k, logID);
                            if (var13 > byte0 - 1 && var13 < byte0 + 1) {
                                random.nextInt(1);
                                int pr = random.nextInt(4);
                                if(pr == 0) {
                                    world.setBlock(i - 1, j + var13 + 2, k, coconutID);
                                } else if (pr == 1) {
                                    world.setBlock(i - 1, j + var13 + 2, k, coconutID);
                                    world.setBlock(i, j + var13 + 2, k - 1, coconutID);
                                } else if (pr == 2) {
                                    world.setBlock(i - 1, j + var13 + 2, k, coconutID);
                                    world.setBlock(i, j + var13 + 2, k - 1, coconutID);
                                    world.setBlock(i + 1, j + var13 + 2, k, coconutID);
                                } else {
                                    world.setBlock(i - 1, j + var13 + 2, k, coconutID);
                                    world.setBlock(i, j + var13 + 2, k - 1, coconutID);
                                    world.setBlock(i + 1, j + var13 + 2, k, coconutID);
                                    world.setBlock(i, j + var13 + 2, k + 1, coconutID);
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
