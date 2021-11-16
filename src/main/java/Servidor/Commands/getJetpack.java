package Servidor.Commands;

import Servidor.Entities.jetpackInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getJetpack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        if(!(cs instanceof Player)) return false;
        Player p = (Player) cs;

        if(command.getName().equalsIgnoreCase("getJetpack")){
            p.openInventory(new jetpackInventory().getInventory());
            return true;
        }

        return false;
    }
}
