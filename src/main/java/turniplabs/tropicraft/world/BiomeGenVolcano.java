package turniplabs.tropicraft.world;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.Weather;
import net.minecraft.src.WorldGenerator;
import turniplabs.tropicraft.entity.EntityMoyai;
import turniplabs.tropicraft.world.generation.WorldGenBasaltPillar;

import java.util.Random;

public class BiomeGenVolcano extends BiomeGenBase {

    public BiomeGenVolcano(int id) {
        super(id);
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityMoyai.class, 3));
    }

    @Override
    public WorldGenerator getRandomWorldGenForTrees(Random random) {
        return new WorldGenBasaltPillar();
    }

    @Override
    public BiomeGenBase setBiomeName(String s) {
        return super.setBiomeName(s);
    }

    @Override
    public BiomeGenBase setBlockedWeathers(Weather[] blocked) {
        return super.setBlockedWeathers(Weather.weatherList);
    }

    @Override
    public BiomeGenBase setColor(int i) {
        return super.setColor(i);
    }
}
