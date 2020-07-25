package Spikey.minecraft.disenchant;


import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;



public class main extends JavaPlugin {
    FileConfiguration config = getConfig();

	@Override
	public void onEnable() {

		getLogger().info("[Test] Enabled");
		getLogger().info("[Test] © 2020 Spikey");
        this.getCommand("disenchant").setExecutor(new Commands());
        config.addDefault("Cost",1000);
        config.options().copyDefaults(true);
        saveConfig();
	}

	@Override
	public void onDisable() {
		getLogger().info("[Test] Enabled");
		getLogger().info("[Test] © 2020 Spikey");
	
		}
	
	    public int costPull() {
	    	return config.getInt("cost");
	    }

}
