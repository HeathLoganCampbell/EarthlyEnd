package games.bevs.earthlyend.populator;
import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class TheEndPopulator extends BlockPopulator {

    public TheEndPopulator() {
    	
    }

    @Override
    public void populate(World world, Random random, Chunk chunk) {
    	if (random.nextInt(5) == 0) {
            int x = (chunk.getX() << 4) + random.nextInt(16);
            int z = (chunk.getZ() << 4) + random.nextInt(16);
            int y = world.getHighestBlockYAt(x, z);
            new ObsidianPillar().generate(world, random, x, y, z);
        }

        // spawn the enderdragon
        if (chunk.getX() == 0 && chunk.getZ() == 0) {
            // TODO: uncomment when entities are functional
            //final Location loc = new Location(world, (chunk.getX() << 4) + 8, 128, (chunk.getZ() << 4) + 8, random.nextFloat() * 360, 0);
            //world.spawnEntity(loc, EntityType.ENDER_DRAGON);
        }
    }
}