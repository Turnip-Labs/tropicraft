package turniplabs.tropicraft.mixin;

import net.minecraft.src.Season;
import net.minecraft.src.WorldType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import turniplabs.tropicraft.Mod_Tropicraft;
import turniplabs.tropicraft.world.WorldProviderTropics;

@Mixin(value = WorldType.class, remap = false)
final class WorldTypeMixin {
    @Shadow
    public static WorldType[] worldTypes;

    @Inject(method = "<clinit>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/src/WorldType;<init>(ILjava/lang/String;)V", ordinal = 0))
    private static void changeWorldTypeListLength(CallbackInfo ci) {
        worldTypes = new WorldType[15];
    }

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void changeWorldTypeList(CallbackInfo ci) {
        Mod_Tropicraft.worldTropics = new WorldType(14, "tropics");
        Mod_Tropicraft.worldTropics.setLanguageKey("worldType.tropics");
        Mod_Tropicraft.worldTropics.setWorldProvider(new WorldProviderTropics());
        Mod_Tropicraft.worldTropics.setSeasonList(Season.surfaceSummer);
    }
}