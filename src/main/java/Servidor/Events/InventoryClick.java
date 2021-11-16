package Servidor.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import Servidor.Jetpack.giveJetpack;
import org.bukkit.event.inventory.InventoryType;


import static Servidor.Main.*;

public class InventoryClick implements Listener {

    @EventHandler
    public void onClickJetpackChoose(InventoryClickEvent e){
        if(!e.getView().getTitle().equalsIgnoreCase("Inventário da Jetpack")) return;

        e.setCancelled(true);

        String clickedJetpack = String.valueOf(e.getCurrentItem().getType());
        Player p = (Player) e.getWhoClicked();


        switch(clickedJetpack){
            case "LEGACY_IRON_CHESTPLATE":
                p.sendMessage("Você recebeu 1x " + getInstance().getConfig().getString("Config.Jetpack.Iron.Name"));
                p.getInventory().addItem(new giveJetpack("iron").getJetpack());
                break;

            case "LEGACY_GOLD_CHESTPLATE":
                p.sendMessage("Você recebeu 1x " + getInstance().getConfig().getString("Config.Jetpack.Gold.Name"));
                p.getInventory().addItem(new giveJetpack("gold").getJetpack());
                break;

            case "LEGACY_DIAMOND_CHESTPLATE":
                p.sendMessage("Você recebeu 1x " + getInstance().getConfig().getString("Config.Jetpack.Diamond.Name"));
                p.getInventory().addItem(new giveJetpack("diamond").getJetpack());
                break;

            case "LEGACY_AIR":
                p.sendMessage("Você recebeu 1x " + getInstance().getConfig().getString("Config.Jetpack.Netherite.Name"));
                p.getInventory().addItem(new giveJetpack("netherite").getJetpack());
                break;

            case "LEGACY_CHAINMAIL_CHESTPLATE":
                p.sendMessage("Você recebeu 1x " + getInstance().getConfig().getString("Config.Jetpack.Chainmail.Name"));
                p.getInventory().addItem(new giveJetpack("chainmail").getJetpack());
                break;
            default:
                p.sendMessage(clickedJetpack);
                break;
        }
        p.closeInventory();
    }

    @EventHandler
    public void unequipJetpack(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(p.isFlying() && e.getSlotType().equals(InventoryType.SlotType.ARMOR) && e.getCurrentItem().hasItemMeta()){
            p.setFlying(false);
        }
    }
}




