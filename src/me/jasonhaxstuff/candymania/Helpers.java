package me.jasonhaxstuff.candymania;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;

import me.jasonhaxstuff.candymania.candies.Bliss;
import me.jasonhaxstuff.candymania.candies.Chocolate;
import me.jasonhaxstuff.candymania.candies.EnderPop;
import me.jasonhaxstuff.candymania.candies.FunBar;
import me.jasonhaxstuff.candymania.candies.Prix;
import me.jasonhaxstuff.candymania.candies.SkrattarDuForlorarDu;
import me.jasonhaxstuff.candymania.candies.Taffy;
import me.jasonhaxstuff.candymania.candies.Tylenol;

public class Helpers {
	
	Commands commands = new Commands();

	public void initCmds() {
		
		Bukkit.getPluginCommand("bliss").setExecutor(commands);
		Bukkit.getPluginCommand("chocolate").setExecutor(commands);
		Bukkit.getPluginCommand("funbar").setExecutor(commands);
		Bukkit.getPluginCommand("tylenol").setExecutor(commands);
		Bukkit.getPluginCommand("enderpop").setExecutor(commands);
		Bukkit.getPluginCommand("taffy").setExecutor(commands);
		Bukkit.getPluginCommand("skrattar").setExecutor(commands);
		Bukkit.getPluginCommand("prix").setExecutor(commands);
	}
	
	public void initCandies() {
		
		Main.candies.add(new Bliss());
		Main.candies.add(new Chocolate());
		Main.candies.add(new FunBar());
		Main.candies.add(new Tylenol());
		Main.candies.add(new EnderPop());
		Main.candies.add(new Taffy());
		Main.candies.add(new SkrattarDuForlorarDu());
		Main.candies.add(new Prix());
	}
	
	public void initRecipes() {
		
		for (int i = 0; i < Main.candies.size(); i++) {
			if (Main.candies.get(i).getRecipe() != null) {
				Bukkit.addRecipe(Main.candies.get(i).getRecipe());
			}
		}
	}
	
	public Location closeRandTp(Player player) {
		
		Random rand = new Random();
		int x = player.getLocation().getBlockX(), y = player.getLocation().getBlockY(), z = player.getLocation().getBlockZ();
		x += rand.nextInt(101) - 50;
		z += rand.nextInt(101) - 50;
		player.teleport(new Location(player.getWorld(), x, y, z));
		return player.getLocation();
	}
	
	public void addPrixxed(Player player) {
		Main.prixxed.add(player);
		Bukkit.getScheduler().runTaskLaterAsynchronously(Main.getInstance(), new Runnable() {
			public void run() {
				Main.prixxed.remove(player);
			}
		}, 200L);
	}
	
	public NamespacedKey getNamespacedKey(String candy) {
		
		String key = Integer.toString(candy.hashCode());
        return NamespacedKey.minecraft(key);
	}
}
