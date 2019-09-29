package glassedibles.blocks;

import net.minecraft.src.*;
import glassedibles.Blocks;
import glassedibles.generation.WorldGenEdiTrees;

import java.util.Random;

public class BlockAppleSapling extends BlockFlower {

    /**
     * Apple sapling block.
     * Most of the code is copy-pasted from BlockSapling.
     *
     * @param id
     * @see BlockSapling
     */
    public BlockAppleSapling(int id) {
        super(id, ModLoader.addOverride("/terrain.png", "/glassedibles/applesapling.png"));
        float f = 0.4F;
        setTickOnLoad(true);
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
        setStepSound(Block.sapling.stepSound);
        setBlockName("blockAppleSapling");
        ModLoader.AddName(this, "Apple Sapling");
    }

    public void updateTick(World world, int xCoord, int yCoord, int zCoord, Random random) {
        if (world.multiplayerWorld) {
            return;
        }
        super.updateTick(world, xCoord, yCoord, zCoord, random);
        if (world.getBlockLightValue(xCoord, yCoord + 1, zCoord) >= 9 && random.nextInt(30) == 0) {
            int l = world.getBlockMetadata(xCoord, yCoord, zCoord);
            if ((l & 8) == 0) {
                world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, l | 8);
            } else {
                growTree(world, xCoord, yCoord, zCoord, random);
            }
        }
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j) {
        return blockIndexInTexture;
    }

    public void growTree(World world, int xCoord, int yCoord, int zCoord, Random random) {
        if (world.multiplayerWorld) {
            return;
        }
        int l = world.getBlockMetadata(xCoord, yCoord, zCoord) & 3;
        world.setBlock(xCoord, yCoord, zCoord, 0);
        WorldGenEdiTrees obj = new WorldGenEdiTrees(Blocks.blockAppleLeaves.blockID, Block.wood.blockID, 3);
        if (!obj.grow(world, random, xCoord, yCoord, zCoord)) {
            world.setBlockAndMetadata(xCoord, yCoord, zCoord, blockID, l);
        }
    }

    protected int damageDropped(int i) {
        return i & 3;
    }

    public boolean blockActivated(World world, int xCoord, int yCoord, int zCoord, EntityPlayer entityplayer) {
        if (world.multiplayerWorld) {
            return false;
        }
        ItemStack itemStack = entityplayer.getCurrentEquippedItem();
        if (itemStack != null && itemStack.itemID == Item.dyePowder.shiftedIndex && itemStack.getItemDamage() == 15) {
            growTree(world, xCoord, yCoord, zCoord, world.rand);
            itemStack.stackSize--;
            return true;
        }
        return false;
    }
}