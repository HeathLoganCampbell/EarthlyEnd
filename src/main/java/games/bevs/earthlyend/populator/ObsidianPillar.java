package games.bevs.earthlyend.populator;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;

import games.bevs.earthlyend.utils.MathUtils;

public class ObsidianPillar {
	
	private static final Material[] PILLAR_BLOCKS = new Material[]{Material.SMOOTH_BRICK, Material.SMOOTH_BRICK, Material.SMOOTH_BRICK, Material.SMOOTH_BRICK,Material.SMOOTH_BRICK, Material.COBBLESTONE, Material.COBBLESTONE, Material.COBBLESTONE, Material.AIR}; 

    public void generate(World world, Random random, int sourceX, int sourceY, int sourceZ) {
        if (world.getBlockAt(sourceX, sourceY, sourceZ).isEmpty() && world.getBlockAt(sourceX, sourceY - 1, sourceZ).getType() == Material.STONE) {

            int height = random.nextInt(32) + 6;
            int radius = random.nextInt(4) + 1;

            // check under the pillar that there's no gap
            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    if (i * i + j * j <= (radius * radius + 1) && world.getBlockAt(sourceX + i, sourceY - 1, sourceZ + j).getType() != Material.STONE) {
                        return;
                    }
                }
            }

            // build a pillar
            for (int k = 0; k < height && sourceY + k < 256; k++) {
                for (int i = -radius; i <= radius; i++) {
                    for (int j = -radius; j <= radius; j++) {
                        if (i * i + j * j <= radius * radius + 1) {
                            final Block block = world.getBlockAt(sourceX + i, sourceY + k, sourceZ + j);
                            block.setType(PILLAR_BLOCKS[MathUtils.random(PILLAR_BLOCKS.length) - 1]);
                        }
                    }
                }
            }

            // TODO: uncomment when entities are functional
            
            final Location loc = new Location(world, sourceX + 0.5D, sourceY + height, sourceZ + 0.5D, random.nextFloat() * 360, 0);
            world.spawnEntity(loc, EntityType.ENDER_CRYSTAL);
            //
            // It still unclear to me what they are doing with a bedrock inlaid with obsidian under
            // the endercrystals. I've let that bedrock on top of the pillar to remember about this...
            final Block block = world.getBlockAt(sourceX, sourceY + height, sourceZ);
            block.setType(Material.BEDROCK);
        }
    }
}