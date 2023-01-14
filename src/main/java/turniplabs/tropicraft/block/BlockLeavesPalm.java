package turniplabs.tropicraft.block;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockLeavesPalm extends BlockLeavesBase {

    public BlockLeavesPalm(int i, Material material, boolean flag) {
        super(i, material, flag);
    }

    @Override
    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.saplingPalm.blockID;
    }

    @Override
    public int getRenderColor(int i) {
        return ColorProperties.fRGB2iRGB(ColorProperties.pine.inventoryR, ColorProperties.pine.inventoryG, ColorProperties.pine.inventoryB);
    }

    @Override
    public int colorMultiplier(World world, IBlockAccess iblockaccess, int i, int j, int k) {
        int baseFoliageColor = ColorProperties.fRGB2iRGB(ColorProperties.pine.inventoryR, ColorProperties.pine.inventoryG, ColorProperties.pine.inventoryB);
        if (world != null) {
            double localTemperature = iblockaccess.getWorldChunkManager().getTemperature(i, k);
            double localHumidity = iblockaccess.getWorldChunkManager().getHumidity(i, k);
            Season season = world.getCurrentSeason();
            if (season != null) {
                float progress = world.getSeasonProgress();
                baseFoliageColor = ColorizerFoliage.getSeasonalColor(season, progress, localTemperature, localHumidity, ColorProperties.pine);
            }
        }
        return baseFoliageColor;
    }
}
