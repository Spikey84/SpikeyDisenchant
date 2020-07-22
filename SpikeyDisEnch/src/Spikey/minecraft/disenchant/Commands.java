package Spikey.minecraft.disenchant;


import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import masecla.villager.classes.VillagerInventory;
import masecla.villager.classes.VillagerTrade;


public class Commands implements CommandExecutor {
	

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			List<VillagerTrade> trades = new ArrayList<>();
			//trades.add(new VillagerTrade(new ItemStack(Material.STONE),new ItemStack(Material.COBBLESTONE),10));
			//VillagerInventory inv = new VillagerInventory(trades, player);
			//inv.setName("Disenchant");
			//inv.open();
		}
		return false;
	}
	
	
}