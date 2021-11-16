package Servidor.Commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Help implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if(!(cs instanceof Player)) return false;
        Player p = (Player) cs;

        ItemStack pau = new ItemStack(Material.STICK, 1);
        ItemMeta metaPau = pau.getItemMeta();

        metaPau.setDisplayName("§l§6Pau");
        metaPau.setLore(Arrays.asList("Bem duro e grosso"));
        pau.setItemMeta(metaPau);

        if(command.getName().equalsIgnoreCase("help")){
            if(args.length == 0){
                p.sendMessage("Digite /help pau - para querer pau e não saber pedir");
                p.sendMessage("Digite /help queropau - pedir pau");
                return true;
            }

            if(args.length == 1){
                if(args[0].equalsIgnoreCase("pau")){
                    p.sendMessage("Digite /help queropau para pedir pau");
                    return true;
                }
                if(args[0].equalsIgnoreCase("queropau")){
                    p.getInventory().addItem(pau);
                    p.sendMessage("Você recebeu x1 §l§6Pau");
                    return true;
                }
            }
        }

        return false;
    }
}
