package glassedibles.items;

import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class ItemChoppingBoard extends Item {

    /**
     * Chopping Board item. Mostly useless.
     *
     * @param id Item ID to use.
     */
    public ItemChoppingBoard(int id) {
        super(id);
        setIconIndex(ModLoader.addOverride("/gui/items.png", "/glassedibles/choppingboard.png"));
        setItemName("itemChoppingBoard");
        setMaxStackSize(1);

        ModLoader.AddRecipe(new ItemStack(this, 1), new Object[]{"X ", " Y", 'X', Item.ingotIron, 'Y', Block.wood});
        ModLoader.AddName(this, "Chopping Board");
    }
}
