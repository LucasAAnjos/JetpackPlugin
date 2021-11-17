package Servidor.Database;

import java.sql.*;

public class MYSQL {

    public static String username = "root";
    public static String password = "vertrigo";

    private Connection connection;
    private final String user;
    private final String pass;
    private final String host;
    private final String db;
    private final int port;
    private int query;

    public MYSQL(String user, String pass, String host, int port, String db){
        this.user = user;
        this.pass = pass;
        this.host = host;
        this.port = port;
        this.db = db;
        this.query = 0;
        loadDB();
    }

    public void openConnection(){
        try{
            query++;
            if(connection != null && !connection.isClosed()) return;

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db + "?autoReconnect=true&useSSL=false", user, pass);
        }catch (ClassNotFoundException | SQLException e){
            query--;
            e.getStackTrace();
            System.out.println("Ocorreu um erro ao abrir");
        }
    }

    public void closeConnection(){
        query--;
        if(query <= 0){
            try{
                if(connection != null && !connection.isClosed()) connection.close();
            }catch (Exception e) { System.out.println("Houve um erro ao fechar a conexão"); }

        }
    }

    public Connection getConnection() {
        return this.connection;
    }

    public void loadDB(){
        openConnection();
        createTables();
        closeConnection();
    }

    private void createTable(String rows, String columns){
        try{
            if(connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS " + rows + " (" + columns + ");");
            }
        }catch (SQLException e){
            System.out.println("Ocorreu um erro ao criar a tabela");
        }
    }

    private void createTables(){
        createTable("Info", "Name varchar(16), fuel int");
    }
}
