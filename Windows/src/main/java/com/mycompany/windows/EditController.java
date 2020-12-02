
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
import javafx.stage.Stage;

public class EditController implements Initializable {
    
    private TextField nim;
    private TextField output;
    
    public void CariData() throws SQLException{
        String inputnim;
        inputnim = nim.getText();   
        String tampil = null;
        
        Connection connection = DBConnect.getInstance().getConnection();        
        Statement statement = connection.createStatement();  
        String sql = "SELECT NIM,poin FROM mahasiswa WHERE nim" + "='" + inputnim + "'";
        ResultSet resultset = statement.executeQuery(sql);
        
        while(resultset.next()){
            tampil = resultset.getString("NIM"); 
        }
        output.setText(tampil);
    }
    
    public void EditData() throws SQLException{
        
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
    public void buttoncatat(ActionEvent event) throws IOException{
        Parent p = FXMLLoader.load(getClass().getResource("Catat.fxml"));
        Scene catat = new Scene(p);
        Stage w = (Stage)((Node)event.getSource()).getScene().getWindow();
        w.setScene(catat);
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
        // TODO
    }    
    
}
