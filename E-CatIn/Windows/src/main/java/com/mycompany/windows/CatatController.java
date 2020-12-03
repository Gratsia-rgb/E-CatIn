package com.mycompany.windows;

import com.mycompany.windows.DBConnect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class CatatController implements Initializable {
    
    Connection connection = DBConnect.getInstance().getConnection(); 
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
    public void Catat(ActionEvent event) throws SQLException, IOException {
        String inputnim = nim.getText();  
        String inputnama = nama.getText();
        String inputnamakegiatan = namakegiatan.getText();
        String inputjeniskegiatan = jeniskegiatan.getText();
        String inputpoin = poin.getText();
        Insert(inputnim,inputnama,inputnim,inputpoin,inputnamakegiatan,inputjeniskegiatan);
    }
    public void Insert(String inputnim, String inputnama, String inputpassword, String inputpoin, String inputnamakegiatan, String inputjeniskegiatan) throws SQLException{     
        String sql = "INSERT INTO mahasiswa(nim,nama,password,poin,kegiatan,jeniskegiatan) VALUES (?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, inputnim);
        statement.setString(2, inputnama);
        statement.setString(3, inputpassword);
        statement.setString(4, inputpoin);
        statement.setString(5, inputnamakegiatan);
        statement.setString(6, inputjeniskegiatan);
        statement.executeUpdate();
    }
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
        
    }
}