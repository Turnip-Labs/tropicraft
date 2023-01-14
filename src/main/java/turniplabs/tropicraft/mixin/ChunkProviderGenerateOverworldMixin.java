package turniplabs.tropicraft.mixin;

import net.minecraft.src.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import turniplabs.tropicraft.world.generation.WorldGenBamboo;
import turniplabs.tropicraft.world.generation.WorldGenDouble;

import java.util.Random;

import static turniplabs.tropicraft.Mod_Tropicraft.pineappleBottom;
import static turniplabs.tropicraft.Mod_Tropicraft.pineappleTop;

@Mixin(value = ChunkProviderGenerateOverworld.class, remap = false)
public class ChunkProviderGenerateOverworldMixin {

    @Shadow protected World worldObj;
    @Shadow protected Random rand;
    @Shadow protected int terrainMaxHeight;

    @Inject(method = "populate", at = @At("HEAD"))
    private void addBamboo(IChunkProvider ichunkprovider, int chunkX, int chunkZ, CallbackInfo ci) {
        int mX = chunkX * 16;
        int mZ = chunkZ * 16;
        BiomeGenBase mBiomes = worldObj.getWorldChunkManager().getBiomeGenAt(mX + 16, mZ + 16);

        byte bBamboo = 0;
        if ((mBiomes == BiomeGenBase.rainforest)) bBamboo = 1;

        for(int i0 = 0; i0 < bBamboo; ++i0) {
            int x1 = mX + rand.nextInt(16) + 8;
            int z1 = mZ + rand.nextInt(16) + 8;
            int y1 = worldObj.getHeightValue(x1, z1);
            new WorldGenBamboo().generate(worldObj, this.rand, x1, y1, z1);
        }

        if (rand.nextInt(5) == 0) {
            int x1 = mX + rand.nextInt(16) + 8;
            int y1 = rand.nextInt(terrainMaxHeight);
            int z1 = mZ + rand.nextInt(16) + 8;

            new WorldGenDouble(pineappleBottom.blockID, pineappleTop.blockID).generate(worldObj, rand, x1, y1, z1);
        }
    }
}
