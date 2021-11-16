package Servidor;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class createItem {

    private ItemStack newItem;
    private ItemMeta newItemMeta;

    public createItem(Material material, int quantity) {
        newItem = new ItemStack(material, quantity);
        newItemMeta = newItem.getItemMeta();
    }

    public createItem setName(String name){
        newItemMeta.setDisplayName(name);
        newItem.setItemMeta(newItemMeta);
        return this;
    }

    public createItem setLore(List<String> lore){
        newItemMeta.setLore(lore);
        newItem.setItemMeta(newItemMeta);
        return this;
    }

    public ItemStack getNewItem() {
        return newItem;
    }
}
