package me.jasonhaxstuff.candymania.candies;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Chocolate implements Candy {

	@Override
	public void use(Player player) {
		
		if(player.getInventory().getItemInHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInHand(null);
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000, 2));
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000, 3));
		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1000, 20));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 10, 2));
		player.sendMessage(ChatColor.BLACK + "Ooohhhh the chocolate. Feels right man.");

	}
	
	public Material getItem() {
		return Material.SUGAR;
		
	}

	@Override
	public ItemStack giveItem(int amount) {
		
		ItemStack item = new ItemStack(Material.SUGAR, amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.DARK_PURPLE + "Chocolate");
		ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to eat some Chocolate!");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    item.setItemMeta(meta);
	    return item;
	}

}
