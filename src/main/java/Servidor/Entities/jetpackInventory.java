package Servidor.Entities;

import Servidor.Jetpack.giveJetpack;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class jetpackInventory {
    private Inventory inventory;

    public jetpackInventory() {
        inventory = Bukkit.createInventory(null, 1*9, "Inventário da Jetpack");
        insertItems();
    }

    private jetpackInventory insertItems(){
        inventory.setItem(0, new giveJetpack("iron").getJetpack());
        inventory.setItem(2, new giveJetpack("gold").getJetpack());
        inventory.setItem(4, new giveJetpack("diamond").getJetpack());
        inventory.setItem(6, new giveJetpack("netherite").getJetpack());
        inventory.setItem(8, new giveJetpack("chainmail").getJetpack());
        return this;
    }


    public Inventory getInventory() {
        return inventory;
    }
}
