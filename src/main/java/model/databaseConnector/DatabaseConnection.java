package model.databaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection CONNECT = null;
    
    static
    { 
        String url = "jdbc:mysql://localhost:80/"; 
        String user = "root"; 
        String pass = ""; 
        try { 
            Class.forName("com.mysql.jdbc.Driver"); 
            CONNECT = DriverManager.getConnection(url, user, pass); 
        } 
        catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace(); 
        } 
    } 
    public static Connection getConnection() 
    { 
        return CONNECT; 
    } 
}
