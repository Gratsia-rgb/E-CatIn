
package com.mycompany.windows;

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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController implements Initializable {
   
    Connection connection = DBConnect.getInstance().getConnection(); 

    @FXML 
    private TextField nim;
    @FXML 
    private TextField poin;   
    @FXML  
    public void Cari(ActionEvent event) throws SQLException, IOException {
        
        String inputnim = nim.getText();  
        String outputpoin = null;
               
        Statement statement = connection.createStatement();  
        String sql = "SELECT * FROM mahasiswa WHERE nim = '" + inputnim + "';";
        ResultSet resultset = statement.executeQuery(sql); 
        while(resultset.next()){
            outputpoin = resultset.getString("poin");
        }
        poin.setText(outputpoin);
    }
    
    public void Edit(ActionEvent event) throws SQLException, IOException {
        Editt(nim.getText(),poin.getText());
        
       
    }
    
    public void Editt(String inputnim, String inputpoin) throws SQLException{     
        String sql = "UPDATE mahasiswa SET poin = ? " + "WHERE nim = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, inputpoin);
        statement.setString(2, inputnim);
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
