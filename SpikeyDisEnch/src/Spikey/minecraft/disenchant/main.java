package Spikey.minecraft.disenchant;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;





public class main extends JavaPlugin {
    FileConfiguration config = getConfig();

	@Override
	public void onEnable() {

		getLogger().info("[Test] Enabled");
		getLogger().info("[Test] © 2020 Spikey");
        this.getCommand("disenchant").setExecutor(new Commands());
        config.options().copyDefaults(true);
        saveConfig();
	}

	@Override
	public void onDisable() {
		getLogger().info("[Test] Enabled");
		getLogger().info("[Test] © 2020 Spikey");
	
		}
}