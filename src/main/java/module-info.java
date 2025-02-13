module com.example.csc311_mod3hw {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.csc311_mod3hw to javafx.fxml;
    exports com.example.csc311_mod3hw;
}