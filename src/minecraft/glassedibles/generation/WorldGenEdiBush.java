package glassedibles.generation;

import net.minecraft.src.Block;
import net.minecraft.src.World;

import java.util.Random;

public class WorldGenEdiBush {
    private int bushID;
    private int clusterSize;

    /**
     * Berry Bush generation. Could be used for just about any 1-block worldgen block.
     * @param bushID Block ID for the bush to be generated.
     */
    public WorldGenEdiBush(int bushID) {
        this.bushID = bushID;
    }

    public boolean generate(World world, Random random, int xCoord, int count, int zCoord) {
        for (; count > 0; count--) {
            int y;
            for (y = 128; world.getBlockId(xCoord, y - 1, zCoord) == 0; y--) {
            }
            if (!grow(world, random, xCoord, y, zCoord)) {
                count -= 3;
            }
            xCoord += random.nextInt(15) - 7;
            zCoord += random.nextInt(15) - 7;
        }

        return true;
    }

    public boolean grow(World world, Random random, int xCoord, int yCoord, int zCoord) {
        if (world.getBlockId(xCoord, yCoord - 1, zCoord) == Block.grass.blockID) {
            world.setBlock(xCoord, yCoord, zCoord, bushID);
            return true;
        }
        return false;
    }
}
