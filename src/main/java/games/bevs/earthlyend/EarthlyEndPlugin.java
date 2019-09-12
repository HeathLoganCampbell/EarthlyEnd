package games.bevs.earthlyend;

import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import games.bevs.earthlyend.generation.TheEndGenerator;

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
