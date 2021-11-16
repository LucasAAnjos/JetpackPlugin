package Servidor.Events;

import Servidor.createItem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import Servidor.Jetpack.*;
import org.bukkit.inventory.ItemStack;

import static Servidor.Main.*;


public class PlayerEvents implements Listener {
    @EventHandler
    public void flyAtJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("§cSeja bem vindo ao servidor, " + "§f" + p.getDisplayName());

        p.setAllowFlight(true);
        p.setFlying(false);
    }

    @EventHandler
    public void jetpackFlying(PlayerToggleFlightEvent e){
        Player p = e.getPlayer();
        boolean fuel = new fuelConsume(p, Material.COAL).getFuelAvaiable();

        if(!(new playerHasJetpack(p).hasJetpack()) && !fuel){
            e.setCancelled(true);
        }

        if(p.isFlying()) Bukkit.getScheduler().cancelTasks(getInstance());
        new fuelConsume(p, Material.COAL).startFuelConsume();

    }

    @EventHandler
    public void particlesAtFly(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if((!(p.isFlying() && new playerHasJetpack(p).hasJetpack()))) return;
        new fuelBar(p, new fuelConsume(p, Material.COAL).getFuelQuantity());

        Location loc = p.getLocation();
        loc.setY(loc.getY() + 1);
        loc.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 1);

    }



}
