package me.jasonhaxstuff.candymania;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;

import me.jasonhaxstuff.candymania.commands.EnderPop;
import me.jasonhaxstuff.candymania.commands.Bliss;
import me.jasonhaxstuff.candymania.commands.Chocolate;
import me.jasonhaxstuff.candymania.commands.CommandType;
import me.jasonhaxstuff.candymania.commands.FunBar;
import me.jasonhaxstuff.candymania.commands.Taffy;
import me.jasonhaxstuff.candymania.commands.Tylenol;

public class Commands implements Listener,CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		ArrayList<CommandType> commands = new ArrayList<CommandType>();
		commands.add(new Bliss());
		commands.add(new Chocolate());
		commands.add(new FunBar());
		commands.add(new Tylenol());
		commands.add(new EnderPop());
		commands.add(new Taffy());
		
		
		for (int i = 0; i < commands.size(); i++) {
			if (cmd.getName().toLowerCase().equals(commands.get(i).getCmd())) {
				commands.get(i).use(sender, cmd, label, args);
			}
		}
		return false;
	}
}
