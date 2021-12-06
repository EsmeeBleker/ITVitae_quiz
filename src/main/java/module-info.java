module com.group.quiz {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.group.quiz to javafx.fxml;
    exports com.group.quiz;
}