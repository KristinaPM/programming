module com.example.lab6_var4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab6_var4 to javafx.fxml;
    exports com.example.lab6_var4;
}