package turniplabs.tropicraft.world;

import net.minecraft.shared.Minecraft;
import net.minecraft.src.*;
import turniplabs.tropicraft.world.generation.WorldGenBamboo;
import turniplabs.tropicraft.world.generation.WorldGenDouble;
import turniplabs.tropicraft.world.generation.WorldGenHead;

import static net.minecraft.src.Block.*;
import static turniplabs.tropicraft.Mod_Tropicraft.*;

public class ChunkProviderGenerateTropics extends ChunkProviderGenerateOverworld {
    public ChunkProviderGenerateTropics(World world, long l, int oceanHeight, int terrainMaxHeight, int terrainMiddle) {
        super(world, l, oceanHeight, terrainMaxHeight, terrainMiddle);
    }

    @Override
    public void replaceBlocksForBiome(int chunkX, int chunkZ, short[] ashort0, BiomeGenBase[] abiomegenbase) {
        int oceanBlockHeight = this.oceanHeight;
        double d = 0.03125;
        this.sandBeachNoise = beachNoise.generateNoiseOctaves(sandBeachNoise, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, d, d, 1.0);
        this.soilThicknessNoise = soilNoise.generateNoiseOctaves(soilThicknessNoise, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, d * 2.0, d * 2.0, d * 2.0);
        this.stoneLayerNoise = soilNoise.generateNoiseOctaves(stoneLayerNoise, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, d * 4.0, d * 4.0, d * 4.0);

        for(int xIndex = 0; xIndex < 16; ++xIndex) {
            for(int zIndex = 0; zIndex < 16; ++zIndex) {
                BiomeGenBase biomegenbase = abiomegenbase[xIndex + zIndex * 16];
                boolean genSand = this.sandBeachNoise[xIndex + zIndex * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                int genStone = (int)(this.soilThicknessNoise[xIndex + zIndex * 16] / 3.0 + 3.0 + this.rand.nextDouble() * 0.25);
                boolean flagBasalt = this.stoneLayerNoise[xIndex + zIndex * 16] + this.rand.nextDouble() * 0.2 > 0.0;
                int layerControlBasalt = (int)(this.stoneLayerNoise[xIndex + zIndex] + this.rand.nextDouble() * 0.5);
                int i0 = -1;
                short topBlock = biomegenbase.topBlock;
                short fillerBlock = biomegenbase.fillerBlock;

                for(int i1 = this.terrainMaxHeight - 1; i1 >= 0; --i1) {
                    int i2 = (zIndex * 16 + xIndex) * Minecraft.WORLD_HEIGHT_BLOCKS + i1;
                    if (i1 <= this.rand.nextInt(5)) ashort0[i2] = (short)Block.bedrock.blockID;
                    else {
                        short short3 = ashort0[i2];
                        if (short3 == 0) i0 = -1;
                        else if (short3 == Block.stone.blockID) {
                            if (i0 == -1) {
                                if (genStone <= 0) {
                                    topBlock = 0;
                                    fillerBlock = (short)Block.stone.blockID;
                                } else if (i1 >= oceanBlockHeight - 4 && i1 <= oceanBlockHeight + 1) {
                                    topBlock = biomegenbase.topBlock;
                                    fillerBlock = biomegenbase.fillerBlock;
                                    if (genSand && biomegenbase != BiomeGenBase.swampland) {
                                        topBlock = (short) sandPurified.blockID;
                                        fillerBlock = (short) sandPurified.blockID;
                                    }
                                }

                                if (i1 < oceanBlockHeight && topBlock == 0) topBlock = (short)Block.fluidWaterStill.blockID;

                                i0 = genStone;
                                if (i1 >= oceanBlockHeight - 1) ashort0[i2] = topBlock;
                                else {
                                    ashort0[i2] = fillerBlock;
                                }
                            } else if (i0 <= 0) {
                                if (i1 <= 30 + layerControlBasalt - this.rand.nextInt(3) && i1 >= layerControlBasalt - this.rand.nextInt(3) && flagBasalt) {
                                    ashort0[i2] = (short)Block.basalt.blockID;
                                }
                            } else {
                                --i0;
                                ashort0[i2] = fillerBlock;
                                if (i0 == 0 && fillerBlock == sandPurified.blockID) {
                                    i0 = this.rand.nextInt(8);
                                    if (biomegenbase == BiomeGenBase.desert) {
                                        i0 += 2;
                                    }

                                    fillerBlock = (short)((byte)Block.sandstone.blockID);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void populate(IChunkProvider ichunkprovider, int chunkX, int chunkZ) {
        BlockSand.fallInstantly = false;
        int x = chunkX * 16;
        int z = chunkZ * 16;
        BiomeGenBase biomeGenBase = worldObj.getWorldChunkManager().getBiomeGenAt(x + 16, z + 16);
        long l0 = rand.nextLong() / 2L * 2L + 1L;
        long l1 = this.rand.nextLong() / 2L * 2L + 1L;
        rand.setSeed((long)chunkX * l0 + (long)chunkZ * l1 ^ worldObj.getRandomSeed());

        // Lakes
        int lakeChance = 4;

        if (biomeGenBase == biomeVolcano) lakeChance = 8;

        if (rand.nextInt(lakeChance) != 0 && biomeGenBase != biomeVolcano) {
            int x1 = x + rand.nextInt(16) * 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) * 8;
            new WorldGenLakes(fluidWaterStill.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(lakeChance) != 0 && biomeGenBase == biomeVolcano) {
            int x1 = x + rand.nextInt(16) * 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int y2 = rand.nextInt(rand.nextInt(terrainMaxHeight - terrainMaxHeight / 16) + terrainMaxHeight / 16);
            int z1 = z + rand.nextInt(16) * 8;
            new WorldGenLakes(fluidLavaStill.blockID).generate(worldObj, rand, x1, y1, z1);

            if (y2 < 64 || rand.nextInt(10) == 0)
                new WorldGenLakes(fluidLavaStill.blockID).generate(worldObj, rand, x1, y2, z1);
        }

        // World gen (ores n stuff)
        // Clay, dirt, coal, and iron
        for (int i0 = 0; i0 < 20 * heightModifier; ++i0) {
            int x1 = x + rand.nextInt(16);
            int y1 = rand.nextInt(terrainMaxHeight);
            int y2 = rand.nextInt(terrainMaxHeight / 2);
            int z1 = z + rand.nextInt(16);
            new WorldGenClay(32).generate(worldObj, rand, x1, y1, z1);
            new WorldGenMinable(dirt.blockID, 32, false).generate(worldObj, rand, x1, y1, z1);
            new WorldGenMinable(oreCoalStone.blockID, 14, true).generate(worldObj, rand, x1, y1, z1);
            new WorldGenMinable(oreIronStone.blockID, 6, true).generate(worldObj, rand, x1, y2, z1);
        }

        // Gravel
        for (int i1 = 0; i1 < 10 * heightModifier; ++i1) {
            int x1 = x + rand.nextInt(16);
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16);
            new WorldGenMinable(gravel.blockID, 32, false).generate(worldObj, rand, x1, y1, z1);
        }

        // Redstone
        for (int i2 = 0; i2 < 8 * heightModifier; ++i2) {
            int x1 = x + rand.nextInt(16);
            int y1 = rand.nextInt(terrainMaxHeight / 8);
            int z1 = z + rand.nextInt(16);
            new WorldGenMinable(oreRedstoneStone.blockID, 8, true).generate(worldObj, rand, x1, y1, z1);
        }

        // Gold
        for (int i3 = 0; i3 < 2 * heightModifier; ++i3) {
            int x1 = x + rand.nextInt(16);
            int y1 = rand.nextInt(terrainMaxHeight / 4);
            int z1 = z + rand.nextInt(16);
            new WorldGenMinable(oreGoldStone.blockID, 10, true).generate(worldObj, rand, x1, y1, z1);
        }

        // Diamond, moss, and lapis
        for (int i4 = 0; i4 < heightModifier; ++i4) {
            int x1 = x + rand.nextInt(16);
            int y1 = rand.nextInt(terrainMaxHeight / 8);
            int y2 = rand.nextInt(terrainMaxHeight / 8) + rand.nextInt(terrainMaxHeight / 8);
            int y3 = rand.nextInt(terrainMaxHeight) / 2;
            int z1 = z + rand.nextInt(16);
            new WorldGenMinable(oreDiamondStone.blockID, 9, true).generate(worldObj, rand, x1, y1, z1);
            new WorldGenMinable(oreLapisStone.blockID, 8, true).generate(worldObj, rand, x1, y2, z1);
            new WorldGenMinable(mossStone.blockID, 32, true).generate(worldObj, rand, x1, y3, z1);
        }

        // Tree Density for biomes
        double d0 = 0.5;
        int i5 = (int) (mobSpawnerNoise.func_806_a((double) x * d0, (double) z * d0 / 8.0 + rand.nextDouble() * 4.0 + 4.0) / 3.0);
        int treeDensity = 0;

        if (treeDensityOverride != -1) treeDensity = this.treeDensityOverride;

        else {
            if (rand.nextInt(8) == 0) ++treeDensity;

            if (biomeGenBase == biomeTropics) treeDensity += i5 + 5;

            if (biomeGenBase == biomeVolcano) treeDensity += i5 + 1;

            if (biomeGenBase == BiomeGenBase.seasonalForest) treeDensity += i5 + 2;
        }

        for (int i6 = 0; i6 < treeDensity; ++i6) {
            int x1 = x + rand.nextInt(16) + 8;
            int z1 = z + rand.nextInt(16) + 8;
            assert biomeGenBase != null;
            WorldGenerator worldGenerator = biomeGenBase.getRandomWorldGenForTrees(rand);
            worldGenerator.func_517_a(1.0d, 1.0d, 1.0d);
            worldGenerator.generate(worldObj, rand, x1, worldObj.getHeightValue(x1, z1), z1);
        }


        // Random gen (reeds, bamboo, .etc)
        // Reeds
        byte bReeds = 0;
        if (biomeGenBase == biomeTropics) bReeds = 1;

        for (int i7 = 0; i7 < bReeds; ++i7) {
            int x1 = x + rand.nextInt(16) + 8;
            int z1 = z + rand.nextInt(16) + 8;
            int h1 = worldObj.getHeightValue(x1, z1);
            new WorldGenReedTall().generate(worldObj, rand, x1, h1, z1);
            new WorldGenBamboo().generate(worldObj, rand, x1, h1, z1);
        }

        // Meadow flowers
        byte bMeadow = 0;
        if (biomeGenBase == BiomeGenBase.seasonalForest) bMeadow = 2;

        for (int i8 = 0; i8 < bMeadow; ++i8) {
            int blockID;
            int rand1 = rand.nextInt(4);
            switch (rand1) {
                default:
                    blockID = flowerRed.blockID;
                    break;
                case 0:
                    blockID = flowerYellow.blockID;
                    break;
                case 1:
                    blockID = dayFlower.blockID;
                    break;
                case 2:
                    blockID = montbretia.blockID;
                    break;
                case 3:
                    blockID = orchid.blockID;
                    break;
            }

            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(Minecraft.WORLD_HEIGHT_BLOCKS);
            int z1 = z + rand.nextInt(16) + 8;
            new WorldGenTallGrass(blockID).generate(worldObj, rand, x1, y1, z1);
        }

        // Tall Grass
        byte bGrass = 0;
        if (biomeGenBase == biomeTropics) bGrass = 10;

        if (biomeGenBase == BiomeGenBase.seasonalForest) bGrass = 2;

        for (int i9 = 0; i9 < bGrass; ++i9) {
            int blockID;

            if (biomeGenBase == biomeTropics && rand.nextInt(3) != 0) blockID = tallgrassFern.blockID;
            else blockID = tallgrass.blockID;

            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;
            new WorldGenTallGrass(blockID).generate(worldObj, rand, x1, y1, z1);
        }


        // Random Gen (flowers n stuff)

        if (rand.nextInt(64) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int z1 = z + rand.nextInt(16) + 8;
            int h1 = worldObj.getHeightValue(x1, z1);
            new WorldGenSponge().generate(worldObj, rand, x1, h1, z1);
        }

        if (rand.nextInt(8) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenFlowers(mushroomRed.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(5) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenReed().generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(5) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenDouble(irisBottom.blockID, irisTop.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(5) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenDouble(pineappleBottom.blockID, pineappleTop.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(4) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenFlowers(mushroomBrown.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        if (rand.nextInt(2) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenFlowers(flowerRed.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        // heads
        if (rand.nextInt(100) == 0) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenHead().generate(worldObj, rand, x1, y1, z1);
        }

        // Underground liquids

        for(int i10  = 0; i10 < 50; ++i10) {
            if (biomeGenBase != biomeVolcano) {
                int x1 = x + rand.nextInt(16) + 8;
                int y1 = rand.nextInt(rand.nextInt(terrainMaxHeight - terrainMaxHeight / 16) + terrainMaxHeight / 16);
                int z1 = z + rand.nextInt(16) + 8;
                new WorldGenLiquids(Block.fluidWaterFlowing.blockID).generate(worldObj, rand, x1, y1, z1);
            }
        }

        for (int i11 = 0; i11 < 35; ++ i11) {
            int x1 = x + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(rand.nextInt(rand.nextInt(terrainMaxHeight - terrainMaxHeight / 8) + terrainMaxHeight / 16) + terrainMaxHeight / 16);
            int z1 = z + rand.nextInt(16) + 8;

            new WorldGenLiquids(fluidLavaFlowing.blockID).generate(worldObj, rand, x1, y1, z1);
        }

        // Temperature check

        generatedTemperatures = worldObj.getWorldChunkManager().getTemperatures(generatedTemperatures, x + 8, z + 8, 16, 16);
    }
}
