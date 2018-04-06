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

public class SkrattarDuForlorarDu implements Candy {

Helpers helpers = new Helpers();
	
	@Override
	public void use(Player player) {
		if(player.getInventory().getItemInMainHand().getAmount() != 1 && player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			player.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE, 1));
		} else if (player.getGameMode() != GameMode.CREATIVE) {
			player.getInventory().setItemInMainHand(null);
			player.getInventory().addItem(new ItemStack(Material.GLASS_BOTTLE, 1));
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1000, 3, true));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2, true));
		player.sendMessage(ChatColor.GREEN + "" + ChatColor.ITALIC + "You just drank some Skrattar. Feelin strong?");

	}
	
	public Material getItem() {
		return Material.POTION;
		
	}
	
	public ItemStack giveItem(int amount) {
	    ItemStack item = new ItemStack(Material.POTION, amount);
	    ItemMeta meta = item.getItemMeta();
	    
	    meta.setDisplayName(ChatColor.GREEN + "Skrattar Du, Förlorar Du");
	    ArrayList<String> lore = new ArrayList<String>();
	    lore.add(ChatColor.RED + "Don't drink kids");
	    meta.setLore(lore);
	    meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
	    meta.addEnchant(Enchantment.DURABILITY, 1, true);
	    item.setItemMeta(meta);
	    return item;
	}
	
	public String getName() {
		
		return "SkrattarDuForlorarDu";
	}

	@Override
	public Recipe getRecipe() {
		
		ShapelessRecipe recipe = new ShapelessRecipe(helpers.getNamespacedKey(this.getName()), this.giveItem(1));
		recipe.addIngredient(3, Material.GLASS);
		recipe.addIngredient(2, Material.IRON_INGOT);
		return recipe;
	}
}
