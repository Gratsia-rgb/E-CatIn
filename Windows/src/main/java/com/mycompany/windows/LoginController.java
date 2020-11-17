package com.mycompany.windows;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    private LoginQuery loginQuery = new LoginQuery();
    
    
    @FXML
    private TextField masukanusername;

    @FXML
    private PasswordField masukanpassword;

    @FXML
    private Button login;

    @FXML
    private Label notifikasi;
    
    @FXML
    private void nexthalaman(ActionEvent event) throws IOException{
        if (masukanusername.getText().isBlank() == false && masukanpassword.getText().isBlank() == false){
            validasiLogin(masukanusername.getText(), masukanpassword.getText());
            //Parent root = FXMLLoader.load(getClass().getResource("/C:/Users/User/Documents/NetBeansProjects/E-CatIn/Windows/target/classes/com/mycompany/windows/halamanawaladmin.fxml"));
            notifikasi.setText("Berhasil Login");
        }
        else{
            notifikasi.setText("Masukan username dan password anda!");
        }
    }
    
 
    public void validasiLogin(String masukanusername, String masukanpassword)throws IOException{
        int isValid = loginQuery.queryUser(masukanusername, masukanpassword);
        if(isValid == 1){
            App.setRoot("halamanawaladmin");
        }
        else if(isValid == 0){
             App.setRoot("login");
        }
        else{
            notifikasi.setText("Pengguna tidak dapat ditemukan!");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                login.setOnAction(e->{
           if (masukanusername.getText().isBlank() == false && masukanpassword.getText().isBlank() == false){
               try {
                   validasiLogin(masukanusername.getText(), masukanpassword.getText());
               } catch (IOException ex) {
                   Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
               }   
           }
           else{
               notifikasi.setText("Masukan username dan password anda!");
           }
        });
    }
}























































































