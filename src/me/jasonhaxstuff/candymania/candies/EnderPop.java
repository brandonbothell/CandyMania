package me.jasonhaxstuff.candymania.candies;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.jasonhaxstuff.candymania.Helpers;
import net.md_5.bungee.api.ChatColor;

public class EnderPop implements Candy {
	
	Helpers helpers = new Helpers();

	@Override
	public void use(Player player) {
		if(player.getInventory().getItemInMainHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInMainHand(null);
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 3));
		helpers.closeRandTp(player);
		if (player.getGameMode() != GameMode.CREATIVE) {
			player.setHealth(player.getHealth() - 5.0);
		}
		player.sendMessage(ChatColor.DARK_PURPLE + "You just ate an EnderPop... Where are we?");

	}
	
	public Material getItem() {
		return Material.STICK;
		
	}
	
	public ItemStack giveItem(int amount) {
	    ItemStack item = new ItemStack(Material.STICK, amount);
	    ItemMeta meta = item.getItemMeta();
	    
	    meta.setDisplayName(ChatColor.GREEN + "EnderPop");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to eat an EnderPop!");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    item.setItemMeta(meta);
	    return item;
	}

	@Override
	public Recipe getRecipe() {
		
		return null;
	}
}
