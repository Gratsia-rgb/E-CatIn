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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Gratsia
 */
public class SearchStudentController implements Initializable {
@FXML
    private TextField nim;
    @FXML
    private TextField output;
    
    @FXML
    public void CariMahasiswaController(MouseEvent event) throws SQLException, IOException {
        String inputnim;
        inputnim = nim.getText();      
        String sql = "SELECT mahasiswa.NIM, mahasiswa.poin FROM mahaisswa where nim" + "='" + inputnim;
        
        Connection connection = DBConnect.getInstance().getConnection();        
        Statement statement = connection.createStatement();        
        ResultSet resultset = statement.executeQuery(sql);
        
        while(resultset.next()){
            output.setText(resultset.getInt("NIM") + "|"+ resultset.getInt("poin") ); 
        }
    }
     @FXML
     public void buttonvalidasi(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("ValidasiMahasiswa.fxml"));
        Scene cari = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(cari);
        w.show();
    }
    @FXML
    public void buttonback(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("halamanawalmahasiswa.fxml"));
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
