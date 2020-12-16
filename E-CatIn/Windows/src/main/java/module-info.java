module com.mycompany.windows {
requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;

    
    opens com.mycompany.windows to javafx.fxml;
    exports com.mycompany.windows;
    requires jasperreports;
}

