package com.mycompany.windows;

import com.mycompany.windows.DBConnect;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class CatatController implements Initializable {
    @FXML
    private TextField nim;
    @FXML
    private TextField nama;
    @FXML
    private TextField namakegiatan;
    @FXML
    private TextField jeniskegiatan;
    @FXML
    private TextField poin;
    
    
    @FXML
    public void buttoncari(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("CariAdmin.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    
    @FXML
    public void buttonedit(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        Scene edit = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(edit);
        w.show();
    }
    @FXML
    public void buttonhapus(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("Hapus.fxml"));
        Scene hapus = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(hapus);
        w.show();
    }
    @FXML
    public void buttonvalidasi(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("ValidasiAdmin.fxml"));
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
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

          
}