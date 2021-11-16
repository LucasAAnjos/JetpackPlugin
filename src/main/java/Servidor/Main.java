package Servidor;

import Servidor.Commands.Help;
import Servidor.Commands.getJetpack;
import Servidor.Commands.ToggleFX;
import Servidor.Events.InventoryClick;
import Servidor.Events.PlayerEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin  {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        regEvents();
        regCommands();
    }

    private void regEvents(){
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerEvents(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    private void regCommands(){
       getCommand("help").setExecutor(new Help());
       getCommand("togglefx").setExecutor(new ToggleFX());
       getCommand("getjetpack").setExecutor(new getJetpack());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§c Dofa");
    }

    private void loadConfig(){
        getConfig().options().copyDefaults(false);
        saveDefaultConfig();
    }

    public static Main getInstance() {
        return instance;
    }

}

