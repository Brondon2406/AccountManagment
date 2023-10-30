package model.databaseConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.utils.UtilsAccount;

public class DatabaseConnection {
    private static Connection CONNECT = null;
    
    public static Connection connectToDataBase()
    { 
        String url = "jdbc:mysql://localhost:3306/BANKACCOUNTMANAGER"; 
        String user = "root"; 
        String pass = ""; 
        try { 
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection(url, user, pass); 
            return con;
        } 
        catch (ClassNotFoundException | SQLException e) { 
            e.printStackTrace(); 
            return null;
        } 
    } 
    public static Connection getConnection() 
    { 
    	if(UtilsAccount.isEmpty(CONNECT)) {
    		CONNECT = connectToDataBase();
    	}
    	return CONNECT;
    } 
}
