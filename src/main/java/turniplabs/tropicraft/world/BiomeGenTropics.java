package turniplabs.tropicraft.world;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;
import turniplabs.tropicraft.entity.*;
import turniplabs.tropicraft.world.generation.WorldGenTreeShapePalm;

import java.util.Random;

public class BiomeGenTropics extends BiomeGenBase {
    public BiomeGenTropics(int id) {
        super(id);
        spawnableMonsterList.clear();
        spawnableCreatureList.clear();

        spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10));
        spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10));
        spawnableMonsterList.add(new SpawnListEntry(EntityMoyai.class, 1));
        spawnableMonsterList.add(new SpawnListEntry(EntityFrogPoisonBlue.class, 17));
        spawnableMonsterList.add(new SpawnListEntry(EntityFrogPoisonRed.class, 17));
        spawnableMonsterList.add(new SpawnListEntry(EntityFrogPoisonYellow.class, 17));

        spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 51));
        spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 51));
        spawnableCreatureList.add(new SpawnListEntry(EntityFrog.class, 51));
        spawnableCreatureList.add(new SpawnListEntry(EntityIguana.class, 102));
        spawnableCreatureList.add(new SpawnListEntry(EntityStarfishBlue.class, 17));
        spawnableCreatureList.add(new SpawnListEntry(EntityStarfishPink.class, 17));
        spawnableCreatureList.add(new SpawnListEntry(EntityStarfishYellow.class, 17));
        spawnableCreatureList.add(new SpawnListEntry(EntityVervet.class, 102));
    }

    @Override
    public WorldGenerator getRandomWorldGenForTrees(Random random) {
        if (random.nextInt(3) == 0) {
            return random.nextInt(10) == 0
                    ? new WorldGenTreeShapeFancyRainforest(Block.leavesOak.blockID, Block.logOakMossy.blockID, 0)
                    : new WorldGenTreeShapeFancyRainforest(Block.leavesOak.blockID, Block.logOak.blockID, 0);
        } else if (random.nextInt(5) == 0) {
            return new WorldGenTreeShapePalm(Mod_Tropicraft.leavesPalm.blockID, Mod_Tropicraft.logPalm.blockID);
        } else {
            return random.nextInt(10) == 0
                    ? new WorldGenTreeShapeDefault(Block.leavesOak.blockID, Block.logOakMossy.blockID, 6)
                    : new WorldGenTreeShapeDefault(Block.leavesOak.blockID, Block.logOak.blockID, 6);
        }
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
