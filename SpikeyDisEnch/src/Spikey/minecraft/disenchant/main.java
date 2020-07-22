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
	public static Economy econ = null;

	@Override
	public void onEnable() {
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
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
	
	 private boolean setupEconomy() {
	        if (getServer().getPluginManager().getPlugin("Vault") == null) {
	            return false;
	        }
	        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	        if (rsp == null) {
	            return false;
	        }
	        econ = rsp.getProvider();
	        return econ != null;
	    }
	    public static Economy getEconomy() {
	        return econ;
	    }
	    public int costPull() {
	    	return config.getInt("cost");
	    }
	    public ItemStack disEnchant(Player pl, ItemStack in) {
	    	Player player = pl;
			//ItemStack enchanted = new ItemStack(player.getInventory().getItemInMainHand());
	    	ItemStack enchanted = in;
			int cost = 1000;
			
			String prefix = ChatColor.DARK_RED+"["+ChatColor.RED+"Disenchantments"+ChatColor.DARK_RED+"] ";
			
			
			@Nonnull
			Map<Enchantment, Integer> enchantments = enchanted.getEnchantments();
			
			if (enchantments.isEmpty()) {
				player.sendRawMessage(prefix+ChatColor.WHITE+"Item is not enchanted.");
				
			} else {
				EconomyResponse r = main.econ.withdrawPlayer(player, cost);
				if(r.transactionSuccess()) {
					
					int numEnch = 0;
					for (Enchantment x : enchantments.keySet()) {
						enchanted.removeEnchantment(x);
						numEnch = numEnch+1;
					}
					player.sendRawMessage(prefix+ChatColor.WHITE+"Removed "+numEnch+" enchantments.");
					//player.getInventory().setItemInMainHand(enchanted);	
				} else {
					player.sendMessage(prefix+ChatColor.WHITE+"You do not have sufficient funds.");
				}
				
				
				
			}
			return enchanted;
	    	
	    	
	    }

}
