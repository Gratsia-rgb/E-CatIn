package com.mycompany.windows;

import com.mycompany.windows.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField tf_username;

    @FXML
    private PasswordField pf_password;

    @FXML
    private Label notifikasi;

    @FXML
    void login(MouseEvent event) throws SQLException, IOException {
        String username, password;
        
        username = tf_username.getText();
        password = pf_password.getText();
        
        Connection connection = DBConnect.getInstance().getConnection();
        
        Statement statement = connection.createStatement();
        
        ResultSet resultSet = statement.executeQuery("SELECT * FROM admin where username" + "='" + username + "'and password = '" +password+"'");
    
        if(resultSet.next()){
            App.setRoot("halamanawaladmin");

        }
        
        else{
            notifikasi.setText("Gagal Masuk, Data Anda Belum Tersimpan !");
        }
    
    }

    @FXML
    void nexthalaman(ActionEvent event) {

    }

}






































