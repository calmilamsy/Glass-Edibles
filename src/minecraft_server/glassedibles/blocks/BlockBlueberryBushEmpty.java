package glassedibles.blocks;

import glassedibles.Blocks;
import net.minecraft.src.*;

import java.util.Random;

public class BlockBlueberryBushEmpty extends Block {

    /**
     * Blueberry Bush block.
     * More or less a leaf block that changes states.
     * Can grow on other bushes, dirt, grass and farmland.
     * Can be picked up with shears. Drops sticks otherwise.
     *
     * @param id Block ID to use.
     * @see BlockBlueberryBushFull
     * @see BlockAppleLeaves
     */
    public BlockBlueberryBushEmpty(int id) {
        super(id, 0, Material.leaves);
        setStepSound(Block.leaves.stepSound);
        setTickOnLoad(true);
        setBlockName("blockBlueberryBush");
        setHardness(0.3F);
    }

    public void updateTick(World world, int i, int j, int k, Random random) {
        if (!(world.getBlockId(i, j - 1, k) == Block.grass.blockID)
                && !(world.getBlockId(i, j - 1, k) == Block.dirt.blockID)
                && !(world.getBlockId(i, j - 1, k) == Block.tilledField.blockID)
                && !(world.getBlockId(i, j, k) == Blocks.blockBlueberryBushEmpty.blockID)
                && !(world.getBlockId(i, j, k) == Blocks.blockBlueberryBushFull.blockID)) {
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this, 1));
            world.setBlockWithNotify(i, j, k, 0);
            return;
        }
        if (random.nextInt(10) == 1) {
            world.setBlockWithNotify(i, j, k, Blocks.blockBlueberryBushFull.blockID);
        }
    }

    public int quantityDropped(Random random) {
        return random.nextInt(4) + 1;
    }

    public int idDropped(int i, Random random) {
        return Item.stick.shiftedIndex;
    }

    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
        if (entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.field_31022_bc/*Shears*/.shiftedIndex) {
            entityplayer.addStat(StatList.mineBlockStatArray[blockID], 1);
            dropBlockAsItem_do(world, i, j, k, new ItemStack(this.blockID, 1, l & 3));
        } else {
            super.harvestBlock(world, entityplayer, i, j, k, l);
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
