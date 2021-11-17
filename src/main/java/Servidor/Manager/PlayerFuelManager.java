package Servidor.Manager;

import Servidor.Database.MYSQL;
import Servidor.Objects.PlayerFuel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.List;

import static Servidor.Main.*;

public class PlayerFuelManager {
    public static void insert(){

        PlayerFuel coal = new PlayerFuel("coal", 10);
        PlayerFuel glowstone = new PlayerFuel("glowstone", 5);

        List<PlayerFuel> list = Arrays.asList(coal, glowstone);

        try{
            getDatabase().openConnection();
            Connection connection = getDatabase().getConnection();

            PreparedStatement ps = null;

            for(PlayerFuel pf : list){
                ps = connection.prepareStatement("INSERT INTO info VALUES('"+pf.getName()+"', '"+pf.getFuel()+"')");
                ps.execute();
            }
            ps.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            getDatabase().closeConnection();
        }


    }
}
