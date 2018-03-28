package me.jasonhaxstuff.candymania;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import net.md_5.bungee.api.ChatColor;

public class Commands implements Listener,CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().toLowerCase().equals("bliss")) {
			if(sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length != 1) {
					player.sendMessage(ChatColor.RED + "Usage: /bliss <amount>");
					return false;
				}
				int amount = Integer.parseInt(args[0]);
				if (amount >= 1) {
					player.getInventory().addItem(Main.candies.get(0).giveItem(amount));
					return true;
				} else if (amount <= 0) {
					player.getInventory().addItem(Main.candies.get(0).giveItem(1));
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "Only players can eat candy!");
					return true;
				}
			}
		} else if(cmd.getName().toLowerCase().equals("chocolate")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length != 1) {
					player.sendMessage(ChatColor.RED + "Usage: /chocolate <amount>");
					return false;
				}
				int amount = Integer.parseInt(args[0]);
				if (amount >= 1) {
					player.getInventory().addItem(Main.candies.get(1).giveItem(amount));
					return true;
				} else if (amount <= 0) {
					player.getInventory().addItem(Main.candies.get(1).giveItem(1));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can eat candy!");
				return true;
			}
		} else if (cmd.getName().toLowerCase().equals("funbar")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length != 1) {
					player.sendMessage(ChatColor.RED + "Usage: /funbar <amount>");
					return false;
				}
				int amount = Integer.parseInt(args[0]);
				if (amount >= 1) {
					player.getInventory().addItem(Main.candies.get(2).giveItem(amount));
					return true;
				} else if (amount <= 0) {
					player.getInventory().addItem(Main.candies.get(2).giveItem(1));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can eat candy!");
				return true;
			}
		} else if(cmd.getName().toLowerCase().equals("tylenol")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				if (args.length != 1) {
					player.sendMessage(ChatColor.RED + "Usage: /tylenol <amount>");
					return false;
				}
				int amount = Integer.parseInt(args[0]);
				if (amount >= 1) {
					player.getInventory().addItem(Main.candies.get(3).giveItem(amount));
					return true;
				} else if (amount <= 0) {
					player.getInventory().addItem(Main.candies.get(3).giveItem(1));
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "Only players can use Tylenol!");
				return true;
			}
		}
		
		return false;
	}
}
