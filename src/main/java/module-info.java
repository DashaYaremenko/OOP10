module com.example.oop10 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.oop10 to javafx.fxml;
    exports com.example.oop10;
}