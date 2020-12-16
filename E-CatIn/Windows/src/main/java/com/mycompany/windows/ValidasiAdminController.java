/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windows;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gratsia
 */
public class ValidasiAdminController implements Initializable {
    
    Connection connection;    
    @FXML
    private Label notif;
    @FXML
    private Label foto; 
    @FXML
    private Label deskripsi; 

    @FXML
    void cekValidasi (ActionEvent event) throws IOException, SQLException, ClassNotFoundException{
        
            String tampil1 = null;
            String tampil2 = null;
            Class.forName("org.sqlite.JDBC");
            connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
            Statement statement = connection.createStatement();  
            String sql = "SELECT * FROM validasi";
            ResultSet resultset = statement.executeQuery(sql);     
            if(!resultset.next()){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Info");
                    alert.setHeaderText(null);
                    alert.setContentText("Belum ada data untuk divalidasi");
                    alert.show();
            }else {
                while(resultset.next()){
                    tampil1 = resultset.getString("validasi");
                    tampil2 = resultset.getString("deskripsi");
            }
            foto.setText(tampil1);
            deskripsi.setText(tampil2);
    }
    }
    @FXML
    public void buttoncari(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("cariadmin.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    @FXML
    public void buttoncatat(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("catat.fxml"));
        Scene catat = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(catat);
        w.show();
    }
    @FXML
    public void buttonedit(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("edit.fxml"));
        Scene edit = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(edit);
        w.show();
    }
    @FXML
    public void buttonhapus(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("hapus.fxml"));
        Scene hapus = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(hapus);
        w.show();
    }
    @FXML
    public void buttonvalidasi(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("validasiadmin.fxml"));
        Scene va = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(va);
        w.show();
    }
    @FXML 
    public void buttonback(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("halamanawaladmin.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

