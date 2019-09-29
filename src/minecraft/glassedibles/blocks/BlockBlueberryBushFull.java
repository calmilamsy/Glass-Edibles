package glassedibles.blocks;

import net.minecraft.src.*;
import glassedibles.*;

import java.util.Random;

public class BlockBlueberryBushFull extends Block {

    /**
     * Blueberry Bush block.
     * More or less a leaf block that changes states.
     * Can grow on other bushes, dirt, grass and farmland.
     * Can be picked up with shears. Drops Blueberries and reverts to an empty bush otherwise.
     *
     * @param id Block ID to use.
     * @see BlockBlueberryBushFull
     * @see BlockAppleLeaves
     */
    public BlockBlueberryBushFull(int id) {
        super(id, ModLoader.addOverride("/terrain.png", "/glassedibles/blueberrybush.png"), Material.leaves);
        setStepSound(Block.leaves.stepSound);
        setTickOnLoad(true);
        setBlockName("blockBlueberryBush");
        ModLoader.AddName(this, "Blueberry Bush");
        setHardness(0.3F);
    }

    public int quantityDropped(Random random) {
        return 1;
    }

    public int idDropped(int i, Random random) {
        return this.blockID;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
        if (world.multiplayerWorld) {
            return;
        }
        if (entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.shears.shiftedIndex) {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this.blockID, 1, l & 3));
        } else {
            float f = 0.7F;
            double d = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
            EntityItem entityitem = new EntityItem(world, (double)i + d, (double)j + d1, (double)k + d2, new ItemStack(Items.itemBlueberry, world.rand.nextInt(3) + 1));
            entityitem.delayBeforeCanPickup = 10;
            world.entityJoinedWorld(entityitem);
            world.setBlockWithNotify(i, j, k, Blocks.blockBlueberryBushEmpty.blockID);
        }
    }

    protected int damageDropped(int i) {
        return i & 3;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public int getBlockTextureFromSideAndMetadata(int i, int j) {
        return blockIndexInTexture;
    }

    public void onEntityWalking(World world, int i, int j, int k, Entity entity) {
        super.onEntityWalking(world, i, j, k, entity);
    }
}
