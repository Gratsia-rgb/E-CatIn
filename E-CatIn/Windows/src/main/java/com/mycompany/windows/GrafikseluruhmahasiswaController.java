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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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
public class GrafikseluruhmahasiswaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Connection connection;
    @FXML
    private BarChart<String, Double> grafikKegiatan;
    
    @FXML
    private CategoryAxis grafikNim;
    
    @FXML
    private NumberAxis grafikPoin;
    
    ObservableList<Tampilantabelseluruhmahasiswa> list = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        String query = "SELECT NIM,poin FROM mahasiswa";
        XYChart.Series<String, Double> series = new XYChart.Series<>();
       
        try {
          
            connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
            ResultSet rs = connection.createStatement().executeQuery(query);
            
            while(rs.next()){
                series.getData().add(new XYChart.Data<>(rs.getString("NIM"),rs.getDouble("poin")));
            }
            
            grafikKegiatan.getData().add(series);
        } catch (SQLException ex) {
            Logger.getLogger(GrafikseluruhmahasiswaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }    

    @FXML
    private void buttonback(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getResource("cariadmin.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();
    }

    @FXML
    private void buttonunduh(ActionEvent event) throws SQLException {
         try {
             connection =DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\DB\\dbnya.db");    
             JasperDesign jasdi = JRXmlLoader.load("C:\\Users\\Don Harry\\Documents\\NetBeansProjects\\E-CatIn\\E-CatIn\\Windows\\src\\main\\resources\\Laporan\\Grafik.jrxml");
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
