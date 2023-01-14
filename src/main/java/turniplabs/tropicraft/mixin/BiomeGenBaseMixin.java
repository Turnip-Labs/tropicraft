package turniplabs.tropicraft.mixin;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.Weather;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import turniplabs.tropicraft.world.BiomeGenTropics;
import turniplabs.tropicraft.world.BiomeGenVolcano;

import static net.minecraft.src.BiomeGenBase.*;
import static net.minecraft.src.BiomeGenBase.glacier;
import static net.minecraft.src.Weather.*;
import static turniplabs.tropicraft.Mod_Tropicraft.*;

@Mixin(value = BiomeGenBase.class, remap = false)
public class BiomeGenBaseMixin {

    @Mutable
    @Final
    @Shadow
    public static BiomeGenBase[] biomeList;

    @Shadow
    private static BiomeGenBase[] biomeLookupTable;

    private static void generateLookup() {
        for(int i = 0; i < 64; ++i) {
            for(int j = 0; j < 64; ++j) {
                biomeLookupTable[i + j * 64] = BiomeGenBase.getBiome((float)i / 63.0F, (float)j / 63.0F);
            }
        }
        desert.topBlock = desert.fillerBlock = (short) Block.sand.blockID;
        outback.topBlock = (short)Block.dirtScorched.blockID;
        outback.fillerBlock = (short)Block.dirtScorched.blockID;
        glacier.topBlock = glacier.fillerBlock = (short)Block.sand.blockID;
        biomeVolcano.topBlock = biomeVolcano.fillerBlock = (short)Block.basalt.blockID;
    }

    @Inject(method = "<clinit>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/src/BiomeGenRainforest;<init>(I)V", ordinal = 0))
    private static void changeBiomesListLength(CallbackInfo ci) {
        biomeList = new BiomeGenBase[19];
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void setBiome(CallbackInfo ci) {
        biomeVolcano = (BiomeGenVolcano) ((BiomeGenVolcano) ((BiomeGenVolcano) new BiomeGenVolcano(17).setColor(14246435)).setBiomeName("Volcanic Plains")).setBlockedWeathers(new Weather[]{weatherRain, weatherSnow, weatherStorm});
        biomeTropics = (BiomeGenTropics) ((BiomeGenTropics) ((BiomeGenTropics) new BiomeGenTropics(18).setColor(588342)).setBiomeName("Tropics")).setBlockedWeathers(new Weather[]{weatherSnow});
        generateLookup();
    }
}
