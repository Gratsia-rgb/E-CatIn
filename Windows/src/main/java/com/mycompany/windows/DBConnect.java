package com.mycompany.windows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
private static Connection connection = null;

    
    public static Connection getConnection(){
        try {
            Class.forName("org.sqlite.JDBC"); 
            String connect_string ="jdbc:sqlite:C:\\Users\\User\\Documents\\NetBeansProjects\\E-CatIn\\DB\\dbnya.db";
            connection = DriverManager.getConnection(connect_string);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
       
       return connection;
    }

}







