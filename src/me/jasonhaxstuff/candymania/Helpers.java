package me.jasonhaxstuff.candymania;

import org.bukkit.Bukkit;

import me.jasonhaxstuff.candymania.candies.Bliss;
import me.jasonhaxstuff.candymania.candies.Chocolate;
import me.jasonhaxstuff.candymania.candies.FunBar;
import me.jasonhaxstuff.candymania.candies.Tylenol;

public class Helpers {
	
	Commands commands = new Commands();

	public void initCmds() {
		
		Bukkit.getPluginCommand("bliss").setExecutor(commands);
		Bukkit.getPluginCommand("chocolate").setExecutor(commands);
		Bukkit.getPluginCommand("funbar").setExecutor(commands);
		Bukkit.getPluginCommand("tylenol").setExecutor(commands);
	}
	
	public void initCandies() {
		
		Main.candies.add(new Bliss());
		Main.candies.add(new Chocolate());
		Main.candies.add(new FunBar());
		Main.candies.add(new Tylenol());
	}
}
