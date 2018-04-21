package me.jasonhaxstuff.candymania;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.plugin.java.JavaPlugin;

import me.jasonhaxstuff.candymania.candies.Candy;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin implements Listener {
	
	private Helpers helpers = new Helpers();
	public static Main instance = null;
	public static ArrayList<Candy> candies = new ArrayList<Candy>();
	public static ArrayList<Player> prixxed = new ArrayList<Player>();

	@Override
	public void onEnable() {
		
		helpers.initCmds();
		helpers.initCandies();
		helpers.initRecipes();
		instance = this;
		getServer().getConsoleSender().sendMessage("[CandyMania] " + ChatColor.GREEN + "CandyMania enabled!");
		getServer().getPluginManager().registerEvents(new Commands(), this);
		getServer().getPluginManager().registerEvents(this, this);
		
	}
	
	@Override
	public void onDisable(){
		
		getServer().getConsoleSender().sendMessage("[CandyMania] " + ChatColor.GREEN + "CandyMania disabled!");
	}
	
	public static Main getInstance() {
		return instance;
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
			
		} else if (player.getInventory().getItemInMainHand().getType() == Material.ARROW) {
			if (prixxed.contains(player)) {
				player.launchProjectile(Arrow.class).setPickupStatus(Arrow.PickupStatus.DISALLOWED);;
			}
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		
		if (event.getEntityType() == EntityType.ENDERMAN) {
			
			Random rand = new Random();
			if (rand.nextInt(3) == 2) {
				event.getDrops().add(candies.get(4).giveItem(2));
			}
		}
	}

}