package Servidor;

import Servidor.Commands.Help;
import Servidor.Commands.getJetpack;
import Servidor.Commands.ToggleFX;
import Servidor.Database.MYSQL;
import Servidor.Events.InventoryClick;
import Servidor.Events.PlayerEvents;
import Servidor.Manager.PlayerFuelManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin  {

    private static Main instance;
    private static MYSQL database;

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        regEvents();
        regCommands();
        database = new MYSQL("root", "vertrigo", "localhost", 3306, "server");
        PlayerFuelManager.insert();
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

    public static MYSQL getDatabase() {
        return database;
    }
}

