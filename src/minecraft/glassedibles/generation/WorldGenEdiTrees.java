package glassedibles.generation;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

import java.util.Random;

public class WorldGenEdiTrees extends WorldGenerator {
    private int leavesID;
    private int logID;
    private int minHeight = 5;

    /**
     * Tree generation. Can be used to generate any kind of vanilla oak shaped tree.
     * @param leavesID Block ID to be used as the leaves.
     * @param logID Block ID to be used as the logs.
     * @param minHeight The absolute minimum height the tree can be.
     */
    public WorldGenEdiTrees(int leavesID, int logID, int minHeight) {
        this(leavesID, logID);
        this.minHeight = minHeight;
    }

    public WorldGenEdiTrees(int leavesID, int logID) {
        this.leavesID = leavesID;
        this.logID = logID;
    }

    public boolean generate(World world, Random random, int xCoord, int count, int yCoord) {
        for (; count > 0; count--) {
            int y;
            for (y = 128; world.getBlockId(xCoord, y - 1, yCoord) == 0; y--) {
            }
            if (!grow(world, random, xCoord, y, yCoord)) {
                count -= 3;
            }
            xCoord += random.nextInt(15) - 7;
            yCoord += random.nextInt(15) - 7;
        }

        return true;
    }

    public boolean grow(World world, Random random, int xCoord, int count, int zCoord) {
        int treeHeight = random.nextInt(3) + minHeight;
        boolean flag = true;
        if (count < 1 || count + treeHeight + 1 > 128) {
            return false;
        }
        for (int i1 = count; i1 <= count + 1 + treeHeight; i1++) {
            byte byte0 = 1;
            if (i1 == count) {
                byte0 = 0;
            }
            if (i1 >= (count + 1 + treeHeight) - 2) {
                byte0 = 2;
            }
            for (int i2 = xCoord - byte0; i2 <= xCoord + byte0 && flag; i2++) {
                for (int l2 = zCoord - byte0; l2 <= zCoord + byte0 && flag; l2++) {
                    if (i1 >= 0 && i1 < 128) {
                        int j3 = world.getBlockId(i2, i1, l2);
                        if (j3 != 0 && j3 != leavesID) {
                            flag = false;
                        }
                    } else {
                        flag = false;
                    }
                }

            }

        }

        if (!flag) {
            return false;
        }
        int j1 = world.getBlockId(xCoord, count - 1, zCoord);
        if (j1 != Block.grass.blockID && j1 != Block.dirt.blockID || count >= 128 - treeHeight - 1) {
            return false;
        }
        world.setBlock(xCoord, count - 1, zCoord, Block.dirt.blockID);
        for (int k1 = (count - 3) + treeHeight; k1 <= count + treeHeight; k1++) {
            int j2 = k1 - (count + treeHeight);
            int i3 = 1 - j2 / 2;
            for (int k3 = xCoord - i3; k3 <= xCoord + i3; k3++) {
                int l3 = k3 - xCoord;
                for (int i4 = zCoord - i3; i4 <= zCoord + i3; i4++) {
                    int j4 = i4 - zCoord;
                    if ((Math.abs(l3) != i3 || Math.abs(j4) != i3 || random.nextInt(2) != 0 && j2 != 0) && !Block.opaqueCubeLookup[world.getBlockId(k3, k1, i4)]) {
                        world.setBlockWithNotify(k3, k1, i4, leavesID);
                    }
                }

            }

        }

        for (int l1 = 0; l1 < treeHeight; l1++) {
            int k2 = world.getBlockId(xCoord, count + l1, zCoord);
            if (k2 == 0 || k2 == leavesID) {
                world.setBlockWithNotify(xCoord, count + l1, zCoord, logID);
            }
        }

        return true;
    }

}
