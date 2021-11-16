package Servidor.Jetpack;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import static Servidor.Main.*;

public class fuelConsume {
    private double fuelQuantity = 0;
    private final Player p;
    private final Material fuel;
    private boolean avaiableFuel;

    public fuelConsume(Player player, Material material) {
        p = player;
        fuel = material;
        for(int c = 0; c <= 41; c++){
            if(player.getInventory().getItem(c) == null) continue;
            ItemStack ref = player.getInventory().getItem(c);
            if(ref.getType() == material)  fuelQuantity += ref.getAmount();
        }
    }

    public void startFuelConsume(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(getInstance(), () -> {
            if(fuelQuantity > 0){
                avaiableFuel = true;
            }else avaiableFuel = false;

            for(int c = 0; c <= 41; c++){
                if(p.getInventory().getItem(c) == null) continue;
                ItemStack ref = p.getInventory().getItem(c);
                if(ref.getType() == fuel){
                    p.getInventory().removeItem(new ItemStack (Material.COAL, 1));
                    p.updateInventory();
                }
            }
        }, 0, 20 * 4);
    }

    public boolean getFuelAvaiable() {
        return avaiableFuel;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }
}

