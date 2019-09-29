package net.minecraft.src;

import glassedibles.*;
import glassedibles.generation.WorldGenEdiBush;
import glassedibles.generation.WorldGenEdiTrees;

import java.util.Random;

/**
 * My mod class.
 * When making items and blocks, I refer to Blocks.(block).blocKID
 * instead of BlockID.(block) to make my mod IDResolver friendly.
 * 
 * @// TODO: 26/09/2019 Add Strawberries, Raspberries and various other things.
 * @see BaseModMp
 */
public class mod_GlassEdibles extends BaseModMp {
    public static final Blocks blocks = new Blocks();
    public static final Items items = new Items();

    @Override
    public String Version() {
        return "0.1";
    }
    
    public mod_GlassEdibles() {
        Blocks.registerBlocks();

        ItemFood.appleRed.setMaxStackSize(4);
        try {
            ModLoader.setPrivateValue(ItemFood.class, ItemFood.appleRed, "healAmount", 2);
        } catch (Exception e) {
            try {
                ModLoader.setPrivateValue(ItemFood.class, ItemFood.appleRed, "a", 2);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        ModLoader.AddRecipe(new ItemStack(Item.ingotIron, 16), new Object[] {"X", 'X', Block.dirt});
        ModLoader.AddRecipe(new ItemStack(Blocks.blockAppleSapling, 1), new Object[] {"X", 'X', Item.appleRed});
    }

    /**
     * Generation code for the trees and bushes.
     * Credit to IC2 for their clean method.
     *
     * @param world The target world.
     * @param random The world's seeded random object.
     * @param chunkX The chunk's X to generate stuff in.
     * @param chunkZ The chunk's Y to generate stuff in.
     */
    public void GenerateSurface(World world, Random random, int chunkX, int chunkZ) {
        BiomeGenBase biomegenbase = world.getWorldChunkManager().getBiomeGenAt(chunkX + 16, chunkZ + 16);
        int appleTreeGen = 0;
        if(biomegenbase == BiomeGenBase.forest || biomegenbase == BiomeGenBase.seasonalForest || biomegenbase == BiomeGenBase.plains || biomegenbase == BiomeGenBase.swampland || biomegenbase == BiomeGenBase.savanna || biomegenbase == BiomeGenBase.shrubland)
        {
            appleTreeGen += random.nextInt(2);
        }
        if(random.nextInt(100) + 1 <= appleTreeGen * 2)
        {
            (new WorldGenEdiTrees(Blocks.blockAppleLeaves.blockID, Block.wood.blockID, 4)).generate(world, random, chunkX + random.nextInt(16), appleTreeGen, chunkZ + random.nextInt(16));
        }
        int blackberryBushGen = 0;
        if(biomegenbase == BiomeGenBase.forest || biomegenbase == BiomeGenBase.seasonalForest || biomegenbase == BiomeGenBase.plains || biomegenbase == BiomeGenBase.swampland || biomegenbase == BiomeGenBase.savanna || biomegenbase == BiomeGenBase.shrubland)
        {
            blackberryBushGen += random.nextInt(2);
        }
        if(random.nextInt(100) + 1 <= blackberryBushGen * 2)
        {
            (new WorldGenEdiBush(Blocks.blockBlueberryBushFull.blockID)).generate(world, random, chunkX + random.nextInt(16), blackberryBushGen, chunkZ + random.nextInt(16));
        }
    }

}
