package glassedibles;

import glassedibles.blocks.BlockAppleLeaves;
import glassedibles.blocks.BlockAppleSapling;
import glassedibles.blocks.BlockBlueberryBushEmpty;
import glassedibles.blocks.BlockBlueberryBushFull;
import net.minecraft.src.Block;
import net.minecraft.src.ModLoader;

/**
 * Master class for all my items.
 * Keeps things cleaner IMO.
 */
public class Blocks {
    /**
     * Registers blocks to ModLoader so that ItemBlocks are generated.
     *
     * @see ModLoader
     */
    public static void registerBlocks() {
        ModLoader.RegisterBlock(Blocks.blockAppleSapling);
        ModLoader.RegisterBlock(Blocks.blockAppleLeaves);
        ModLoader.RegisterBlock(Blocks.blockBlueberryBushFull);
        ModLoader.RegisterBlock(Blocks.blockBlueberryBushEmpty);
    }

    public static Block blockAppleLeaves = new BlockAppleLeaves(BlockID.appleLeaves);
    public static Block blockAppleSapling = new BlockAppleSapling(BlockID.appleSapling);
    public static Block blockBlueberryBushFull = new BlockBlueberryBushFull(BlockID.blueberryBush);
    public static Block blockBlueberryBushEmpty = new BlockBlueberryBushEmpty(BlockID.blueberryBushEmpty);
}
