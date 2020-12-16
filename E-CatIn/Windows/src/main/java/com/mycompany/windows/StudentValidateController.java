
package com.mycompany.windows;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class StudentValidateController implements Initializable {    

    @FXML
    private ImageView lihatgambar;
    @FXML
    private TextField deskripsi;
    @FXML
    private Button pilihgambar;
    @FXML
    private Label label_imagepath;
    String imagepath = null;
    
    @FXML
    private void cariGambar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new ExtensionFilter("*Images","*.png","*.jpg","*.jpeg"));
        File f = fc.showOpenDialog(null);
        if(f!=null){
            label_imagepath.setText("Selected File: " + f.getAbsolutePath());
            
        }
    }
    
    @FXML
    public void buttoncari(ActionEvent event) throws IOException{
        Parent p;
        p = FXMLLoader.load(getClass().getResource("searchstudent.fxml"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
       
