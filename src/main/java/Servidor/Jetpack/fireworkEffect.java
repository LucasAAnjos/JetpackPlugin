package Servidor.Jetpack;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class fireworkEffect {

    public fireworkEffect(Player player) {
        Location loc = player.getLocation();
        loc.setY(loc.getY()-1);
        loc.getWorld().playEffect(loc, Effect.FIREWORK_SHOOT, 32);
    }

}
