package games.bevs.earthlyend;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import games.bevs.earthlyend.generation.TheEndGenerator;

/**
 * Big credit the the guys at glowstone, I really didn't want to recreate the end by hand
 * but they had a pretty nice set up ready to go after a bit of porting, the code is pretty
 * rought but this project is just for a little video.
 * 
 * @author Sprock
 *
 */
public class EarthlyEndPlugin extends JavaPlugin {
	@Override
	public void onEnable() 
	{
		
	}

	@Override
	public void onDisable() 
	{
		
	}
	
	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
	    return new TheEndGenerator();
	}
}
