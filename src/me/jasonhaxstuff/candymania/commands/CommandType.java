package me.jasonhaxstuff.candymania.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandType {

	public boolean use(CommandSender sender, Command cmd, String label, String[] args);
	public String getCmd();
}
