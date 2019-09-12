package games.bevs.earthlyend.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

import games.bevs.earthlyend.utils.MathUtils;

public class GrassPopulator extends BlockPopulator {

	public GrassPopulator() {

	}

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				int realX = (chunk.getX() << 4) + x;
				int realZ = (chunk.getZ() << 4) + z;
				int heighestBlock = world.getHighestBlockYAt(realX, realZ);

				if (2 > heighestBlock)
					continue;

				if (world.getBlockAt(realX, heighestBlock - 1, realZ).getType() != Material.STONE)
					continue;

				world.getBlockAt(realX, heighestBlock, realZ).setType(Material.GRASS);
				for (int i = 1; i < MathUtils.random(4); i++)
					world.getBlockAt(realX, heighestBlock - i, realZ).setType(Material.DIRT);
			}
		}

		int amount = random.nextInt(4)+1;  // Amount of trees
	    for (int i = 1; i < amount; i++) {
	        int realX = (chunk.getX() << 4) +  random.nextInt(15);
	        int realZ =(chunk.getZ() << 4) + random.nextInt(15);
	        int heighestBlock = world.getHighestBlockYAt(realX, realZ);
	        
	        Block block = world.getBlockAt(realX, heighestBlock, realZ);
			world.generateTree(block.getLocation(), TreeType.TREE);
	    }
	}
}