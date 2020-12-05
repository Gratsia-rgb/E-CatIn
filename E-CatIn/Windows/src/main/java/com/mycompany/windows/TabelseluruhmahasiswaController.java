package com.mycompany.windows;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TabelseluruhmahasiswaController {

    @FXML
    private TableView<Tampilantabelseluruhmahasiswa> tabel;
    
    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, Integer> nim;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> nama;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> kegiatan;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> jenisKegiatan;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> waktu;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> poin;

    ObservableList<Tampilantabelseluruhmahasiswa> data;
    
    @FXML
    void buttonback(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("cariadmin.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();

    }
    
    
    @FXML

    public void initialize(URL url, ResourceBundle rb) {
        try{
        Connection connection = DBConnect.getInstance().getConnection();  
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM mahasiswa ";
        ResultSet resultset = statement.executeQuery(sql); 
        
        while(resultset.next()){
          data.add(new Tampilantabelseluruhmahasiswa(resultset.getInt(1), resultset.getInt(2),resultset.getString(3),
            resultset.getString(4), resultset.getString(5),resultset.getString(6),resultset.getString(7)));    
        }
        }catch (SQLException e){
             System.err.println("error" + e);
        }
        
        nim.setCellValueFactory(new PropertyValueFactory<>("NIM"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kegiatan.setCellValueFactory(new PropertyValueFactory<>("kegiatan"));
        jenisKegiatan.setCellValueFactory(new PropertyValueFactory<>("jeniskegiatan"));
        poin.setCellValueFactory(new PropertyValueFactory<>("poin"));
        
        tabel.setItems(data);
    }  
}