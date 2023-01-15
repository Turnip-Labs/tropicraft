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

    public static class Config {
        @Comment("Block IDs")
        public int portal = 1000;
        public int bamboo = 1001;
        public int bambooPlanks = 1002;
        public int bambooPlankSlab = 1003;
        public int bambooPlankStairs = 1004;
        public int coconut = 1005;
        public int dayflower = 1006;
        public int montbretia = 1007;
        public int orchid = 1008;
        public int chunkOHead = 1009;
        public int irisBottom = 1010;
        public int irisTop = 1011;
        public int palmLeaves = 1012;
        public int palmLog = 1013;
        public int palmSapling = 1014;
        public int pineappleBottom = 1015;
        public int pineappleTop = 1016;
        public int purifiedSand = 1017;
        public int thatch = 1018;
        public int thatchSlab = 1019;
        public int thatchStairs = 1020;
        @Comment("Item IDs")
        public int bambooItem = 1000;
        public int bambooMug = 1001;
        public int pinaColada = 1002;
        public int coconutChunk = 1003;
        public int rawFrog = 1004;
        public int cookedFrog = 1005;
        public int frogLeather = 1006;
        public int irisItem = 1007;
        public int pineappleItem = 1008;
        public int pineappleSeeds = 1009;
        public int scale = 1010;
        public int scaleHelmet = 1011;
        public int scaleChest = 1012;
        public int scaleLegs = 1013;
        public int scaleBoots = 1014;
        public int shell = 1015;
        public int shell2 = 1016;
        public int shell3 = 1017;
        public int shell4 = 1018;
        public int seaStar = 1019;
    }
}
