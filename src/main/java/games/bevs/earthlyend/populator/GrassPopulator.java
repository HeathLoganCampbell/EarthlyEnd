package games.bevs.earthlyend.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.TreeType;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
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

				Block topBlock = world.getBlockAt(realX, heighestBlock - 1, realZ);
				while(topBlock.getType() != Material.STONE)
				{
					topBlock = topBlock.getRelative(0, -1, 0);
					if(topBlock.getY() < 20)
						break;
				}
				
				if(topBlock.getType() != Material.STONE)
					continue;

				topBlock.setType(Material.GRASS);
				for (int i = 1; i < MathUtils.random(4); i++)
					topBlock.getRelative(0, -i, 0).setType(Material.DIRT);
			}
		}
		
		int X, Y, Z;
		boolean isStone;
		for (int i = 1; i < 15; i++) {  // Number of tries
		    if (random.nextInt(100) < 60) {  // The chance of spawning
			X = random.nextInt(15);
			Z = random.nextInt(15);
			Y = random.nextInt(40)+20;  // Get randomized coordinates
			if (chunk.getBlock(X, Y, Z).getType() == Material.STONE) {
				isStone = true;
				while (isStone) {
					chunk.getBlock(X, Y, Z).setType(Material.COAL_ORE);
					if (random.nextInt(100) < 40)  {   // The chance of continuing the vein
						switch (random.nextInt(5)) {  // The direction chooser
						case 0: X++; break;
						case 1: Y++; break;
						case 2: Z++; break;
						case 3: X--; break;
						case 4: Y--; break;
						case 5: Z--; break;
						}
						isStone = (chunk.getBlock(X, Y, Z).getType() == Material.STONE) && (chunk.getBlock(X, Y, Z).getType() != Material.COAL_ORE);
					} else isStone = false;
				}
			}
		    }
		}
		
		for (int i = 1; i < 15; i++) {  // Number of tries
		    if (random.nextInt(100) < 60) {  // The chance of spawning
			X = random.nextInt(15);
			Z = random.nextInt(15);
			Y = random.nextInt(40)+20;  // Get randomized coordinates
			if (chunk.getBlock(X, Y, Z).getType() == Material.STONE) {
				isStone = true;
				while (isStone) {
					chunk.getBlock(X, Y, Z).setType(Material.IRON_ORE);
					if (random.nextInt(100) < 40)  {   // The chance of continuing the vein
						switch (random.nextInt(5)) {  // The direction chooser
						case 0: X++; break;
						case 1: Y++; break;
						case 2: Z++; break;
						case 3: X--; break;
						case 4: Y--; break;
						case 5: Z--; break;
						}
						isStone = (chunk.getBlock(X, Y, Z).getType() == Material.STONE) && (chunk.getBlock(X, Y, Z).getType() != Material.IRON_ORE);
					} else isStone = false;
				}
			}
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
	    
	    if (random.nextInt(100) < 10) 
	    {
	    	int realX = (chunk.getX() << 4) +  random.nextInt(15);
	        int realZ =(chunk.getZ() << 4) + random.nextInt(15);
	        int heighestBlock = world.getHighestBlockYAt(realX, realZ);
	        
	        Block block = world.getBlockAt(realX, heighestBlock, realZ);
	        new Lake(Material.STATIONARY_WATER).generate(world, random, realX, heighestBlock, realZ);
	    }
	}
}