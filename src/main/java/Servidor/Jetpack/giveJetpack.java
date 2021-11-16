package Servidor.Jetpack;

import Servidor.createItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static Servidor.Main.getInstance;

public class giveJetpack {
    private ItemStack jetpack;

    public giveJetpack(String jetpackID) {

        switch (jetpackID){
            case "iron":
                jetpack = new createItem(Material.IRON_CHESTPLATE, 1).setName(getInstance().getConfig().getString("Config.Jetpack.Iron.Name")).setLore(Arrays.asList(getInstance().getConfig().getString("Config.Jetpack.Iron.Lore"))).getNewItem();
                break;

            case "gold":
                jetpack = new createItem(Material.GOLDEN_CHESTPLATE, 1).setName(getInstance().getConfig().getString("Config.Jetpack.Gold.Name")).setLore(Arrays.asList(getInstance().getConfig().getString("Config.Jetpack.Gold.Lore"))).getNewItem();
                break;

            case "diamond":
                jetpack = new createItem(Material.DIAMOND_CHESTPLATE, 1).setName(getInstance().getConfig().getString("Config.Jetpack.Diamond.Name")).setLore(Arrays.asList(getInstance().getConfig().getString("Config.Jetpack.Diamond.Lore"))).getNewItem();
                break;

            case "netherite":
                jetpack = new createItem(Material.NETHERITE_CHESTPLATE, 1).setName(getInstance().getConfig().getString("Config.Jetpack.Netherite.Name")).setLore(Arrays.asList(getInstance().getConfig().getString("Config.Jetpack.Netherite.Lore"))).getNewItem();
                break;

            case "chainmail":
                jetpack = new createItem(Material.CHAINMAIL_CHESTPLATE, 1).setName(getInstance().getConfig().getString("Config.Jetpack.Chainmail.Name")).setLore(Arrays.asList(getInstance().getConfig().getString("Config.Jetpack.Chainmail.Lore"))).getNewItem();
                break;

            default:
                return;
        }
    }

    public ItemStack getJetpack() {
        return jetpack;
    }
}
