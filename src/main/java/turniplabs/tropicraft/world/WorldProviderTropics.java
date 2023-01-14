package turniplabs.tropicraft.world;

import net.minecraft.src.IChunkProvider;
import net.minecraft.src.WorldProvider;

public class WorldProviderTropics extends WorldProvider {

    @Override
    public IChunkProvider getChunkProvider() {
        return new ChunkProviderGenerateTropics(worldObj, worldObj.getRandomSeed(), 64, 128, 64);
    }

    @Override
    protected void registerWorldChunkManager() {
        this.worldChunkMgr = new WorldChunkManagerTropics(worldObj);
    }

    @Override
    public boolean canRespawnHere() {
        return false;
    }
}
