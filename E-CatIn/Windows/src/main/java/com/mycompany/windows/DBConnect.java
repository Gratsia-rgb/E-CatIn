package com.mycompany.windows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBConnect {
    protected Connection conn = null;

    public DBConnect(){
        try{
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");
        }catch(ClassNotFoundException | SQLException e){
            System.err.println(e.getClass().getName() + ": "+e.getMessage());
            System.exit(0);
        }
    }
    public Connection getConn(){
        return this.conn;
    }
    
        
}







