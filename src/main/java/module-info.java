module com.example.lab_assignment_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab_assignment_3 to javafx.fxml;
    exports com.example.lab_assignment_3;
}