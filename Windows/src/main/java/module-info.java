module com.mycompany.windows {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.windows to javafx.fxml;
    exports com.mycompany.windows;
}
