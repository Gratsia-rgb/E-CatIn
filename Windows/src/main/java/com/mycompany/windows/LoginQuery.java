
package com.mycompany.windows;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginQuery {
    private Connection connection;
    
    public LoginQuery(){
        connection = DBConnect.getConnection();
    }

    public int queryUser(String masukanusername, String masukanpassword){
    String verifikasiLogin = "SELECT username,password FROM admin";
        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifikasiLogin);
            while(queryResult.next()){
                if(queryResult.getString("username") != null && queryResult.getString("password") != null){
                    return 1;
                }
                else if(queryResult.getInt(1) == 1 && queryResult.getInt(2) == 0){
                    return 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
        return -1;
}
}

















