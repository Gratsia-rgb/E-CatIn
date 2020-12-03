/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.windows;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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


public class SearchStudentController implements Initializable {

    @FXML
    private TextField output;
    @FXML
    private TextField output1;
    @FXML
    private TextField nim;
    @FXML
    public void CariMahsiswa(ActionEvent event) throws SQLException, IOException {
        
        String inputnim;
        inputnim = nim.getText();   
        String tampil1 = null;
        String tampil2 = null;
        
        Connection connection = DBConnect.getInstance().getConnection();        
        Statement statement = connection.createStatement();  
        String sql = "SELECT nama,poin FROM mahasiswa WHERE nim = '" + inputnim + "';";
        ResultSet resultset = statement.executeQuery(sql);        
        while(resultset.next()){
            tampil1 = resultset.getString("nama");
            tampil2 = resultset.getString("poin");
        }        
        output.setText(tampil1);
        output1.setText(tampil2);

    }
     @FXML
     public void buttonvalidasi(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("studentvalidate.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    @FXML
    public void buttonback(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("startstudent.fxml"));
        Scene back = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(back);
        w.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
