package turniplabs.tropicraft.world;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.NoiseGeneratorOctaves2;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

import static net.minecraft.src.BiomeGenBase.*;

public class WorldChunkManagerTropics extends WorldChunkManager {

    public WorldChunkManagerTropics(World world) {
        this.worldObj = world;
        this.field_4194_e = new NoiseGeneratorOctaves2(new Random(world.getRandomSeed() * 9871L), 4);
        this.field_4193_f = new NoiseGeneratorOctaves2(new Random(world.getRandomSeed() * 39811L), 4);
        this.field_4192_g = new NoiseGeneratorOctaves2(new Random(world.getRandomSeed() * 543321L), 2);
    }

    @Override
    public BiomeGenBase[] updateBlockGeneratorDataFromHeight(
            BiomeGenBase[] abiomegenbase, int[] heights, int oceanHeight, int maxTerrainHeight, int x, int y, int width, int length
    ) {
        if (abiomegenbase == null || abiomegenbase.length < width * length) abiomegenbase = new BiomeGenBase[width * length];

        temperature = field_4194_e.func_4112_a(temperature, x, y, width, width, 0.025, 0.025, 0.25);
        humidity = field_4193_f.func_4112_a(humidity, x, y, width, width, 0.05, 0.05, 0.3);
        biomeTemperature = field_4194_e.func_4112_a(biomeTemperature, x, y, width, width, 0.00625, 0.00625, 0.25);
        biomeHumidity = field_4193_f.func_4112_a(biomeHumidity, x, y, width, width, 0.0125, 0.0125, 0.3);
        fuzziness = field_4192_g.func_4112_a(fuzziness, x, y, width, length, 0.25, 0.25, 0.5);
        int i1 = 0;

        for(int j1 = 0; j1 < width; ++j1) {
            for(int k1 = 0; k1 < length; ++k1) {
                int terrainHeight = heights[j1 * 16 + k1];
                int aboveOceanHeight = maxTerrainHeight - oceanHeight;
                int aboveOceanTerrainHeight = terrainHeight - oceanHeight;
                float modifier = aboveOceanTerrainHeight <= 0 ? 1.0F : (float) aboveOceanTerrainHeight / (float) aboveOceanHeight;

                double d = fuzziness[i1] * 1.1 + 0.5;
                double d1 = 0.01;
                double d2 = 1.0 - d1;
                double d3 = (temperature[i1] * 0.15 + 0.7) * d2 + d * d1;
                d3 *= modifier;
                d1 = 0.002;
                d2 = 1.0 - d1;
                double d4 = (this.humidity[i1] * 0.15 + 0.5) * d2 + d * d1;
                d4 *= modifier;
                d3 = 1.0 - (1.0 - d3) * (1.0 - d3);
                if (d3 < 0.0) d3 = 0.0;

                if (d4 < 0.0) d4 = 0.0;

                if (d3 > 1.0) d3 = 1.0;

                if (d4 > 1.0) d4 = 1.0;

                temperature[i1] = d3;
                humidity[i1] = d4;
                abiomegenbase[i1++] = biomeLookup(d3, d4);
            }
        }
        return abiomegenbase;
    }

    @Override
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] abiomegenbase, int x, int z, int width, int length) {
        if (abiomegenbase == null || abiomegenbase.length < width * length) {
            abiomegenbase = new BiomeGenBase[width * length];
        }

        this.temperature = this.field_4194_e.func_4112_a(this.temperature, x, z, width, width, 0.025, 0.025, 0.25);
        this.humidity = this.field_4193_f.func_4112_a(this.humidity, x, z, width, width, 0.05, 0.05, 0.3);
        this.fuzziness = this.field_4192_g.func_4112_a(this.fuzziness, x, z, width, length, 0.25, 0.25, 0.5);
        int i1 = 0;

        for(int j1 = 0; j1 < width; ++j1) {
            for(int k1 = 0; k1 < length; ++k1) {
                double d = this.fuzziness[i1] * 1.1 + 0.5;
                double d1 = 0.01;
                double d2 = 1.0 - d1;
                double d3 = (this.temperature[i1] * 0.15 + 0.7) * d2 + d * d1;
                d1 = 0.002;
                d2 = 1.0 - d1;
                double d4 = (this.humidity[i1] * 0.15 + 0.5) * d2 + d * d1;
                d3 = 1.0 - (1.0 - d3) * (1.0 - d3);
                if (d3 < 0.0) {
                    d3 = 0.0;
                }

                if (d4 < 0.0) {
                    d4 = 0.0;
                }

                if (d3 > 1.0) {
                    d3 = 1.0;
                }

                if (d4 > 1.0) {
                    d4 = 1.0;
                }

                this.temperature[i1] = d3;
                this.humidity[i1] = d4;
                abiomegenbase[i1++] = biomeLookup(d3, d4);
            }
        }

        return abiomegenbase;
    }

    public static BiomeGenBase biomeLookup(double d, double d1) {
        int i = (int)(d * 63.0);
        int j = (int)(d1 * 63.0);
        return biomeGet(i, j);
    }

    public static BiomeGenBase biomeGet(float temperature, float humidity) {
        temperature *= humidity;
        if (temperature >= 80 && humidity < 15) return Mod_Tropicraft.biomeVolcano;
        if (temperature <=40) return seasonalForest;
        else return Mod_Tropicraft.biomeTropics;
    }
}
