package me.jasonhaxstuff.candymania.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.jasonhaxstuff.candymania.Main;
import net.md_5.bungee.api.ChatColor;

public class SkrattarDuForlorarDu implements CommandType {

	@Override
	public boolean use(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if (args.length != 1) {
				player.sendMessage(ChatColor.RED + "Usage: /skrattar <amount>");
				return false;
			}
			int amount = 0;
			try {
				amount = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				player.sendMessage(ChatColor.RED + "That's not a number!");
				return false;
			}
			if (amount >= 1) {
				player.getInventory().addItem(Main.candies.get(6).giveItem(amount));
				return true;
			} else if (amount <= 0) {
				player.getInventory().addItem(Main.candies.get(6).giveItem(1));
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Only players can drink potions!");
			return false;
		}
		return false;
	}

	@Override
	public String getCmd() {
		
		return "skrattar";
	}
}
