package turniplabs.tropicraft.block;

import net.minecraft.src.BlockSugarcane;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockBamboo extends BlockSugarcane {
    public BlockBamboo(int i) {
        super(i);
    }

    @Override
    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.bambooItem.itemID;
    }
}
