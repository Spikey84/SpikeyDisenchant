package Spikey.minecraft.disenchant;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import masecla.villager.classes.VillagerInventory;
import masecla.villager.classes.VillagerTrade;
import net.md_5.bungee.api.ChatColor;
import net.milkbowl.vault.economy.EconomyResponse;


public class Commands implements CommandExecutor {
	
    public ItemStack disEnchant(Player pl, ItemStack in) {
    	Player player = pl;
		//ItemStack enchanted = new ItemStack(player.getInventory().getItemInMainHand());
    	ItemStack enchanted = in;
		
		String prefix = ChatColor.DARK_RED+"["+ChatColor.RED+"Disenchantments"+ChatColor.DARK_RED+"] ";
		
		
		@Nonnull
		Map<Enchantment, Integer> enchantments = enchanted.getEnchantments();
		

				int numEnch = 0;
				for (Enchantment x : enchantments.keySet()) {
					enchanted.removeEnchantment(x);
					numEnch = numEnch+1;
				}
				player.sendRawMessage(prefix+ChatColor.WHITE+"Removed "+numEnch+" enchantments.");

			
			
			
		
		return enchanted;
    	
    	
    }
    
    public boolean enchanted(ItemStack in) {
		@Nonnull
		Map<Enchantment, Integer> enchantmentsTwo = in.getEnchantments();
		if(enchantmentsTwo.size()>0) {
			return true;
			
		}
		return false;
    	
    }


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (sender instanceof Player) {
			Player player = (Player) sender;
			List<VillagerTrade> trades = new ArrayList<>();
			
			ItemStack[] items = player.getInventory().getContents();
			//for(int i =0;i<items.length; i++) {
				//if(items[i] != null&&enchanted(items[i])) {
					ItemStack y = player.getInventory().getItemInMainHand();
					//trades.add(new VillagerTrade(y,disEnchant(player,y),10));
					//trades.add(new VillagerTrade(new ItemStack(Material.ANVIL), new ItemStack(Material.GLASS), 10));
				//	player.sendMessage("test");
				//}
				//}
			
			
			
			trades.add(new VillagerTrade(y,disEnchant(player,y),10));
			trades.add(new VillagerTrade(new ItemStack(Material.ANVIL), new ItemStack(Material.GLASS), 10));
			VillagerInventory inv = new VillagerInventory(trades, player);
			inv.setName("Disenchant");
			inv.open();
		}
		return false;
	}
	
	
}