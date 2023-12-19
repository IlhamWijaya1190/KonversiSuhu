module com.example.konversisuhu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.konversisuhu to javafx.fxml;
    exports com.example.konversisuhu;
}