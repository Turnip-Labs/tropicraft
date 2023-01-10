package turniplabs.tropicraft.block;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import turniplabs.tropicraft.Mod_Tropicraft;

import java.util.Random;

public class BlockDouble extends Block {
    public boolean isTop;
    public BlockDouble(int i, boolean isTop, Material material) {
        super(i, material);
        this.isTop = false;
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
    public void onNeighborBlockChange(World world, int i, int j, int k, int l) {
        int i1 = world.getBlockMetadata(i, j, k);
        if (this.isTop) {
            Block otherBlock = Block.blocksList[world.getBlockId(i, j - 1, k)];
            if (!(otherBlock instanceof BlockDouble)) {
                world.setBlockWithNotify(i, j, k, 0);
            }
        } else {
            Block otherBlock = Block.blocksList[world.getBlockId(i, j + 1, k)];
            if (!(otherBlock instanceof BlockDouble)) {
                world.setBlockWithNotify(i, j, k, 0);
            }

            if (!world.canPlaceOnSurfaceOfBlock(i, j - 1, k)) {
                world.setBlockWithNotify(i, j, k, 0);
                this.dropBlockAsItem(world, i, j, k, i1);
                if (otherBlock instanceof BlockDouble) {
                    world.setBlockWithNotify(i, j + 1, k, 0);
                }
            }
        }
    }

    @Override
    public boolean canPlaceBlockAt(World world, int i, int j, int k) {
        return super.canPlaceBlockAt(world, i, j, k) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    @Override
    public boolean canBlockStay(World world, int i, int j, int k) {
        return (world.getFullBlockLightValue(i, j, k) >= 8 || world.canBlockSeeTheSky(i, j, k)) && this.canThisPlantGrowOnThisBlockID(world.getBlockId(i, j - 1, k));
    }

    protected boolean canThisPlantGrowOnThisBlockID(int i) {
        return Block.blocksList[i] != null && Block.blocksList[i].plantable;
    }
}
