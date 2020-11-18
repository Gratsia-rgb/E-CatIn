package com.mycompany.windows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnect {
    private DBConnect(){
        
    }
    public static DBConnect getInstance(){
        return new DBConnect();
    }

    public Connection getConnection(){
        String connect_string = "jdbc:sqlite:C:\\Users\\User\\Documents\\NetBeansProjects\\E-CatIn\\DB\\dbnya.db";
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            connection = DriverManager.getConnection(connect_string);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
             e.printStackTrace();
        }
        
        return connection;
    }

}









