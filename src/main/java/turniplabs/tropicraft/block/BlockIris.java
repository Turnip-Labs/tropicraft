package turniplabs.tropicraft.block;

import net.minecraft.src.*;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockIris extends Block {
    public boolean isTop;
    public BlockIris(int i, boolean isTop, Material material) {
        super(i, material);
        this.isTop = isTop;
        this.setBlockBounds(0.5F - 0.2f, 0.0F, 0.5F - 0.2f, 0.5F + 0.2f, 1.0F, 0.5F + 0.2f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return 1;
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k) {
        return null;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, int l) {
        Block otherBlock;
        if (this.isTop) otherBlock = Block.blocksList[world.getBlockId(x, y - 1, z)];
        else otherBlock = Block.blocksList[world.getBlockId(x, y + 1, z)];

        if (!(otherBlock instanceof BlockIris) || world.getBlockId(x, y - 1, z) == 0) {
            world.setBlockWithNotify(x, y, z, 0);
            if (!isTop) world.dropItem(x, y, z, new ItemStack(Mod_Tropicraft.flowerIris));
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        if (world.blockExists(x, y + 1, z) && world.getBlockId(x, y + 1, z) != 0) return false;
        else return super.canPlaceBlockAt(world, x, y, z) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z) {
        return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(x, y - 1, z));
    }

    @Override
    public int idDropped(int i, Random random) {
        return Mod_Tropicraft.flowerIris.itemID;
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i) {
        return Block.blocksList[i] != null && Block.blocksList[i].plantable;
    }
}
