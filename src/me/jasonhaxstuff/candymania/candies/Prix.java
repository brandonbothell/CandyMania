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

public class Prix implements Candy {

	Helpers helpers = new Helpers();
	
	@Override
	public void use(Player player) {
		if(player.getInventory().getItemInMainHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInMainHand(null);
		}
		helpers.addPrixxed(player);
		player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 3, true));
		player.sendMessage(ChatColor.DARK_PURPLE + "You just ate some Prix. Try hitting.");

	}
	
	public Material getItem() {
		return Material.ARROW;
		
	}
	
	public ItemStack giveItem(int amount) {
	    ItemStack item = new ItemStack(Material.ARROW, amount);
	    ItemMeta meta = item.getItemMeta();
	    
	    meta.setDisplayName(ChatColor.YELLOW + "Prix");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.WHITE + "Right click while hovering");
	    lore.add(ChatColor.WHITE + "over a block to eat Prix!");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    item.setItemMeta(meta);
	    return item;
	}
	
	public String getName() {
		
		return "Prix";
	}

	@Override
	public Recipe getRecipe() {
		
		ShapelessRecipe recipe = new ShapelessRecipe(helpers.getNamespacedKey(this.getName()), this.giveItem(1));
		recipe.addIngredient(8, Material.ARROW);
		recipe.addIngredient(1, Material.IRON_INGOT);
		return recipe;
	}
}
