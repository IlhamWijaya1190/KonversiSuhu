module com.example.moduleinfojava {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moduleinfojava to javafx.fxml;
    exports com.example.moduleinfojava;
}