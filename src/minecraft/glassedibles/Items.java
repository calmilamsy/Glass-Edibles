package glassedibles;

import net.minecraft.src.Item;
import glassedibles.items.ItemBlueberry;
import glassedibles.items.ItemChoppingBoard;
import glassedibles.items.ItemGlassCookie;

/**
 * Master class for all my items.
 * Keeps things cleaner IMO.
 */
public class Items {

    public static Item itemChoppingBoard = new ItemChoppingBoard(ItemID.choppingBoard);
    public static Item itemGlassCookie = new ItemGlassCookie(ItemID.glassCookie);
    public static Item itemBlueberry = new ItemBlueberry(ItemID.blueberry);
}