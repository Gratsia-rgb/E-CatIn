package com.mycompany.windows;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class CatatController extends DBConnect{
    @FXML
    private TextField NIM;
    @FXML
    private TextField nama;
    @FXML
    private TextField kegiatan;
    private ComboBox comboBox;
    @FXML
    private TextField poin;
    @FXML
    private Label namaadmin;
    @FXML
    private Label output;
    @FXML
    private Label label_imagepath;
    String image_path = null;
    @FXML
    private TextField jeniskegiatan;
    
    public CatatController() {
        String sql = "CREATE TABLE IF NOT EXISTS mahasiswa ("
                + "ID_mahasiswa INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NIM INTEGER NOT NULL,"
                + "nama TEXT NOT NULL,"
                + "password TEXT,"
                + "poin INTEGER,"
                + "kegiatan STRING,"
                + "jeniskegiatan STRING"
                + ");";
        try {
            Statement stmt = super.getConn().createStatement();
            stmt.execute(sql);
        } catch(SQLException e) {
            System.out.print(e.getMessage());
        }
        System.out.println("Success");
    }
     public void tambahmhs(mahasiswa tambah) {
        String sql = "INSERT INTO mahasiswa (NIM, nama, kegiatan, jeniskegiatan, poin) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = super.getConn().prepareStatement(sql)) {
            pstmt.setInt(1, tambah.getNim());
            pstmt.setString(2, tambah.getNama());
            pstmt.setString(3, tambah.getKegiatan());
            pstmt.setString(4, tambah.getJeniskegiatan());
            pstmt.setInt(5, tambah.getPoin());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void Catat(ActionEvent event) throws SQLException, IOException {
       mahasiswa nmhs = new mahasiswa (NIM.getPrefColumnCount(),
                nama.getText(),
                kegiatan.getText(),
                jeniskegiatan.getText(),
                poin.getPrefColumnCount());
       tambahmhs(nmhs);
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
    
  // @Override
    public void initialize(URL url, ResourceBundle rb) {

        
    }

    @FXML
    private void cariGambar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("*Images","*.png","*.jpg","*.jpeg"));
        File f = fc.showOpenDialog(null);
        if(f!=null){
            label_imagepath.setText("Selected File: " + f.getAbsolutePath());
        
        }
    }
}