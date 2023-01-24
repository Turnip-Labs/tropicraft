package turniplabs.tropicraft.mixin;

import net.minecraft.src.Block;
import net.minecraft.src.BlockFluidStill;
import net.minecraft.src.BlockPortal;
import net.minecraft.src.World;
import org.spongepowered.asm.mixin.Mixin;
import turniplabs.tropicraft.Mod_Tropicraft;

@Mixin(value = BlockFluidStill.class, remap = false)
public class BlockFluidStillMixin {

    public void onBlockAdded(World world, int i, int j, int k) {
        if (world.getBlockId(i, j - 1, k) == Block.brickSandstone.blockID) {
            ((BlockPortal) Mod_Tropicraft.tropicsPortal).tryToCreatePortal(world, i, j, k);
        }
    }
}
