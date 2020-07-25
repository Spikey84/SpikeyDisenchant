package Spikey.minecraft.disenchant;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import masecla.villager.classes.VillagerInventory;
import masecla.villager.classes.VillagerTrade;


public class Commands implements CommandExecutor {
	
    public ItemStack disEnchant(ItemStack in) {//returns unenchanted ItemStack
    	ItemStack enchanted = in;
		
		@Nonnull
		Map<Enchantment, Integer> enchantments = enchanted.getEnchantments();
				int numEnch = 0;
				for (Enchantment x : enchantments.keySet()) {
					enchanted.removeEnchantment(x);
					numEnch = numEnch+1;
				}	
		return enchanted;
    }
    
    public boolean isEnchanted(ItemStack in) {//returns true if ItemStack has no enchantments
		@Nonnull
		Map<Enchantment, Integer> enchantmentsTwo = in.getEnchantments();
		if(enchantmentsTwo.size()>0) {
			return true;
		}
		return false;
    }

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {//opens gui with trades for all enchanted items
		if (sender instanceof Player) {
			Player player = (Player) sender;
			List<VillagerTrade> trades = new ArrayList<>();
			ItemStack[] items = player.getInventory().getContents();
			for(int i =0;i<items.length; i++) {//loops through the player's inventory
				if(items[i] != null&&isEnchanted(items[i])) {
					ItemStack y = items[i];
					trades.add(new VillagerTrade(new ItemStack(y),disEnchant(new ItemStack(y)),10));
				}
			}
			VillagerInventory inv = new VillagerInventory(trades, player);
			inv.setName("Disenchant");
			inv.open();
		}
		return false;
	}
}