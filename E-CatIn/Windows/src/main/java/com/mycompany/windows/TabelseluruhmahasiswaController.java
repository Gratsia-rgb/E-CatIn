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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 * FXML Controller class
 *
 * @author Don Harry
 */
public class TabelseluruhmahasiswaController implements Initializable {

    Connection connection;
     @FXML
    private TableView<Tampilantabelseluruhmahasiswa> tabel;
    
    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> nim;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> nama;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> kegiatan;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> jenisKegiatan;

    @FXML
    private TableColumn<Tampilantabelseluruhmahasiswa, String> poin;
    
    ObservableList<Tampilantabelseluruhmahasiswa> list = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
         try {
               connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
             //Connection con = DBConnect.getInstance().getConnection();
             ResultSet rs = connection.createStatement().executeQuery("SELECT NIM,nama,kegiatan,jeniskegiatan,poin FROM mahasiswa");
             
             while (rs.next()) {
                list.add(new Tampilantabelseluruhmahasiswa(rs.getString("NIM"),rs.getString("nama"),rs.getString("kegiatan"),rs.getString("jeniskegiatan"), rs.getString("poin")));
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(TabelseluruhmahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        nim.setCellValueFactory(new PropertyValueFactory<>("nim"));
        nama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        kegiatan.setCellValueFactory(new PropertyValueFactory<>("kegiatan"));
        jenisKegiatan.setCellValueFactory(new PropertyValueFactory<>("jeniskegiatan"));
        poin.setCellValueFactory(new PropertyValueFactory<>("poin"));
        
        tabel.setItems(list);
     
    }    
    
    @FXML
    void buttonback(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("cariadmin.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();
        }

    @FXML
    private void buttonunduh(ActionEvent event) throws SQLException  {
         try {
               connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
             //Connection connection = DBConnect.getInstance().getConnection();

             JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\Windows\\src\\main\\resources\\Laporan\\LaporanMahasiswa.jrxml");
             String sql = "SELECT * FROM mahasiswa";
             JRDesignQuery newQuery = new JRDesignQuery();
             newQuery.setText(sql);
             jasdi.setQuery(newQuery);
             JasperReport js = JasperCompileManager.compileReport(jasdi);
             JasperPrint jp = JasperFillManager.fillReport(js, null, connection);
             JasperViewer.viewReport(jp);
         } catch (JRException ex) {
             Logger.getLogger(TabelseluruhmahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}

