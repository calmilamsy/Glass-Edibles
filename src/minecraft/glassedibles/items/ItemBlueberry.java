package glassedibles.items;

import net.minecraft.src.ItemFood;
import net.minecraft.src.ModLoader;

public class ItemBlueberry extends ItemFood {

    /**
     * Blueberry Item.
     * Drops from full blueberry bushes.
     *
     * @// TODO: 26/09/2019 Blueberry Cake and Blueberry Cookie.
     * @param id
     */
    public ItemBlueberry(int id) {
        super(id, 2, false);
        setItemName("itemBlueberry");
        setMaxStackSize(4);
        setIconIndex(ModLoader.addOverride("/gui/items.png", "/glassedibles/blueberry.png"));

        ModLoader.AddName(this, "Blueberry");
    }
}
