package glassedibles.items;

import net.minecraft.src.Block;
import net.minecraft.src.ItemFood;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

import static glassedibles.Items.itemChoppingBoard;

public class ItemGlassCookie extends ItemFood {

    /**
     * Glass Cookie Item. Used as a suicide item.
     *
     * @param id Item ID to use.
     */
    public ItemGlassCookie(int id) {
        super(id, -10, false);
        setItemName("itemGlassCookie");
        setIconIndex(ModLoader.addOverride("/gui/items.png", "/glassedibles/glasscookie.png"));
        setMaxStackSize(1);

        ModLoader.AddShapelessRecipe(new ItemStack(this, 1), new Object[]{Block.glass, itemChoppingBoard.setContainerItem(itemChoppingBoard)});
        ModLoader.AddName(this, "Glass Cookie");
    }
}
