package me.jasonhaxstuff.candymania.candies;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Candy {

	public void use(Player player);
	public Material getItem();
	public ItemStack giveItem(int amount);
}
