package Servidor.Jetpack;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class fuelBar {

    public fuelBar(Player player, double playerFuel) {

        double barLenght = 40.0;
        double fuelPerc = playerFuel/256;
        StringBuilder bar = new StringBuilder();

        for (int c = 0; c < barLenght; c++) {
            if (c <= barLenght*fuelPerc) bar.append("§a§l|");
            else bar.append("§a.");
        }

        bar.append("§a  " + String.valueOf(100 * fuelPerc + "%"));

        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(String.valueOf(bar)));
    }
}


