package me.jasonhaxstuff.candymania;

import java.util.ArrayList;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

import me.jasonhaxstuff.candymania.candies.Candy;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	private Helpers helpers = new Helpers();
	public static ArrayList<Candy> candies = new ArrayList<Candy>();

	@Override
	public void onEnable() {
		
		helpers.initCmds();
		helpers.initCandies();
		helpers.initRecipes();
		getServer().getConsoleSender().sendMessage("[CandyMania] " + ChatColor.GREEN + "CandyMania enabled!");
		getServer().getPluginManager().registerEvents(new Commands(), this);
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@Override
	public void onDisable(){
		
		getServer().getConsoleSender().sendMessage("[CandyMania] " + ChatColor.GREEN + "CandyMania disabled!");
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getHand() == EquipmentSlot.HAND) {
			for (int i = 0; i < candies.size(); i++) {
				if (player.getInventory().getItemInMainHand().getType() == candies.get(i).getItem() && player.getInventory().getItemInMainHand().containsEnchantment(Enchantment.DURABILITY)) {
					event.setCancelled(true);
					candies.get(i).use(player);
				}
			}
			
		}
		
	}
}