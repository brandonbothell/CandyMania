package me.jasonhaxstuff.candymania.candies;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import net.md_5.bungee.api.ChatColor;

public class Tylenol implements Candy {

	@Override
	public void use(Player player) {
		
		if(player.getInventory().getItemInHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInHand(null);
		}
		player.removePotionEffect(PotionEffectType.CONFUSION);
		if (player.getGameMode() != GameMode.CREATIVE) {
			player.setHealth(player.getHealth() - 5.0);
		}
		player.sendMessage(ChatColor.GREEN + "You just took some Tylenol. Hopefully you feel better now.");

	}

	@Override
	public Material getItem() {
		return Material.PAPER;
		
	}

	@Override
	public ItemStack giveItem(int amount) {
		
		ItemStack item = new ItemStack(Material.PAPER, amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_GRAY + "Tylenol");
		ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to take Tylenol");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(meta);
	    return item;
	}

}
