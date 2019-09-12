package games.bevs.earthlyend.populator;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TreePopulator extends BlockPopulator {

    public TreePopulator() {
    	
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
	    int amount = random.nextInt(4)+1;  // Amount of trees
	    for (int i = 1; i < amount; i++) {
	        int X = random.nextInt(15) + (chunk.getX() << 4);
	        int Z = random.nextInt(15) + (chunk.getZ() << 4);
	        int Y = world.getMaxHeight() + 1; 
	        world.getBlockAt(X, Y, Z).setType(Material.GOLD_BLOCK);
//	        world.generateTree(chunk.getBlock(X, Y + 1, Z).getLocation(), TreeType.TREE);
	    }
    }
}