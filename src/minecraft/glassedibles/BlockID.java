package glassedibles;

import net.minecraft.src.MLProp;

/**
 * I'd rather have tons of classes than a 1000 line long class.
 * PyMCL is my reason.
 *
 * This contains all my block IDs.
 */
public class BlockID {
    @MLProp(name = "blockAppleLeavesID", info = "Apple Leaves block ID", min = 0, max = 255)
    public static int appleLeaves = 150;
    @MLProp(name = "blockAppleSaplingID", info = "Apple Sapling block ID", min = 0, max = 255)
    public static int appleSapling = 151;
    @MLProp(name = "blockBlackberryBushID", info = "Blackberry Bush block ID", min = 0, max = 255)
    public static int blueberryBush = 152;
    @MLProp(name = "blockBlackberryBushEmptyID", info = "Empty Blackberry Bush block ID", min = 0, max = 255)
    public static int blueberryBushEmpty = 153;
}
