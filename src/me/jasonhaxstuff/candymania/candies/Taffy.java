package me.jasonhaxstuff.candymania.candies;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.jasonhaxstuff.candymania.Helpers;
import net.md_5.bungee.api.ChatColor;

public class Taffy implements Candy {

	Helpers helpers = new Helpers();
	
	@Override
	public void use(Player player) {
		
		if(player.getInventory().getItemInMainHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInMainHand(null);
		}
		player.sendMessage(ChatColor.YELLOW + "FeelsGoodMan.");
		player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1000, 2, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 250, 2, true));
	}

	@Override
	public Material getItem() {
		
		return Material.LEATHER;
	}

	@Override
	public ItemStack giveItem(int amount) {
		
		ItemStack item = new ItemStack(Material.LEATHER, amount);
		ItemMeta meta = item.getItemMeta();
		
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Taffy");
		ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to eat some Taffy!");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    item.setItemMeta(meta);
	    return item;
	}

	public String getName() {
		
		return "Taffy";
	}

	@Override
	public Recipe getRecipe() {
		
		ShapelessRecipe recipe = new ShapelessRecipe(helpers.getNamespacedKey(this.getName()), this.giveItem(1));
		recipe.addIngredient(3, Material.LEATHER);
		return recipe;
	}

}
