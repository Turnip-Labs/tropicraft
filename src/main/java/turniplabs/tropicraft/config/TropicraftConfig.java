package turniplabs.tropicraft.config;

import io.github.prismwork.prismconfig.api.PrismConfig;
import io.github.prismwork.prismconfig.api.config.DefaultDeserializers;
import io.github.prismwork.prismconfig.api.config.DefaultSerializers;
import io.github.prismwork.prismconfig.libs.jankson.Comment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TropicraftConfig {
    public static Config load(File file) {
        if (!file.getName().endsWith(".json5"))
            throw new RuntimeException("Failed to read config");
        Config cfg = null;
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                String ls = System.getProperty("line.separator");
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                    stringBuilder.append(ls);
                }
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                reader.close();

                String content = stringBuilder.toString();
                cfg = PrismConfig.getInstance().serialize(
                        Config.class,
                        content,
                        DefaultSerializers.getInstance().json5(Config.class)
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if (cfg == null) cfg = new Config();
        save(file, cfg);
        return cfg;
    }

    public static void save(File file, Config cfg) {
        PrismConfig.getInstance().deserializeAndWrite(
                Config.class,
                cfg,
                DefaultDeserializers.getInstance().json5(Config.class),
                file
        );
    }

    public static int blockIDs = 999;
    public static int itemIDs = 999;


    public static int nextBlock() {
        return blockIDs++;
    }

    public static int nextItem() {
        return itemIDs++;
    }

    public static class Config {
        @Comment("Block IDs")
        public int portal = nextBlock();
        public int bamboo = nextBlock();
        public int bambooPlanks = nextBlock();
        public int bambooPlankSlab = nextBlock();
        public int bambooPlankStairs = nextBlock();
        public int coconut = nextBlock();
        public int dayflower = nextBlock();
        public int montbretia = nextBlock();
        public int orchid = nextBlock();
        public int chunkOHead = nextBlock();
        public int irisBottom = nextBlock();
        public int irisTop = nextBlock();
        public int palmLeaves = nextBlock();
        public int palmLog = nextBlock();
        public int palmSapling = nextBlock();
        public int pineappleBottom = nextBlock();
        public int pineappleTop = nextBlock();
        public int purifiedSand = nextBlock();
        public int thatch = nextBlock();
        public int thatchSlab = nextBlock();
        public int thatchStairs = nextBlock();
        @Comment("Item IDs")
        public int bambooItem = nextItem();
        public int bambooMug = nextItem();
        public int pinaColada = nextItem();
        public int coconutChunk = nextItem();
        public int rawFrog = nextItem();
        public int cookedFrog = nextItem();
        public int frogLeather = nextItem();
        public int irisItem = nextItem();
        public int pineappleItem = nextItem();
        public int pineappleSeeds = nextItem();
        public int scale = nextItem();
        public int scaleHelmet = nextItem();
        public int scaleChest = nextItem();
        public int scaleLegs = nextItem();
        public int scaleBoots = nextItem();
        public int shell = nextItem();
        public int shell2 = nextItem();
        public int shell3 = nextItem();
        public int shell4 = nextItem();
        public int seaStar = nextItem();
    }
}
