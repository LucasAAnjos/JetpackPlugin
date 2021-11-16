package Servidor.Jetpack;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class playerHasJetpack {

    private final boolean playerHasJetpack;
    public playerHasJetpack(Player player) {
        ItemStack playerChestplate = player.getInventory().getChestplate();
        playerHasJetpack = player.getInventory().getChestplate() != null && playerChestplate.getItemMeta().hasLore();
    }

    public boolean hasJetpack() {
        return playerHasJetpack;
    }
}
