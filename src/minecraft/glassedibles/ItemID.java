package glassedibles;

import net.minecraft.src.MLProp;

/**
 * I'd rather have tons of classes than a 1000 line long class.
 * PyMCL is my reason.
 *
 * This contains all my item IDs.
 */
public class ItemID {

    @MLProp(name = "itemChoppingBoardID", info = "Chopping Board item ID", min = 257, max = 32767)
    public static int choppingBoard = 5000;
    @MLProp(name = "itemGlassCookieID", info = "Glass Cookie item ID", min = 257, max = 32767)
    public static int glassCookie = 5001;
    @MLProp(name = "itemBlueberryID", info = "Glass Cookie item ID", min = 257, max = 32767)
    public static int blueberry = 5002;
}
