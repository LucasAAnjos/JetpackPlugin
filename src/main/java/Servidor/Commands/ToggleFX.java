package Servidor.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleFX implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        boolean state = false;
        if(!(cs instanceof Player)){
            return false;
        }

        Player p = (Player) cs;

        if(command.getName().equalsIgnoreCase("togglefx")){
            if(state){
                p.sendMessage("Efeitos Desativados");

                return true;
            }
            else{
                p.sendMessage("Efeitos Ativados");
                return true;
            }
        }
        return false;
    }
}
