package me.jasonhaxstuff.candymania.candies;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class FunBar implements Candy {

	@Override
	public void use(Player player) {
		
		if(player.getInventory().getItemInMainHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInMainHand(null);
		}
		player.sendMessage(ChatColor.RED + "Wow, this is trippy. Shoulda read the nutrition facts.");
		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1000, 2), true);
		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000, 5), true);
		player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 500, 2));
	}
	
	public Material getItem() {
		return Material.MAGMA_CREAM;
		
	}

	@Override
	public ItemStack giveItem(int amount) {
		
		ItemStack item = new ItemStack(Material.MAGMA_CREAM, amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.RED + "F" + ChatColor.YELLOW + "u" + ChatColor.GREEN + "n" + ChatColor.WHITE + "Bar");
		ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to eat a FunBar!");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    item.setItemMeta(meta);
	    return item;
	}
}
