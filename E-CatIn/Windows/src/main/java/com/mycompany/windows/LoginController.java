package com.mycompany.windows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
    
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException, ClassNotFoundException {
        String username, password;
        
        username = tf_username.getText();
        password = pf_password.getText();
        
        
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
            statement = connection.createStatement();
            String sql;
            
            sql = "SELECT * FROM admin where username" + "='" + username + "'and password = '" +password+"'";
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                App.setRoot("halamanawaladmin");
            }        
            else{
                sql = "SELECT * FROM mahasiswa where nama" + "='" + username + "'and password = '" +password+"'";
                ResultSet resultSet1 = statement.executeQuery(sql);
                if(resultSet1.next()){
                     App.setRoot("startstudent");
                }else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Info");
                    alert.setHeaderText(null);
                    alert.setContentText("Data Anda Belum Tersimpan");
                    alert.show();
                }
            }    
}
}