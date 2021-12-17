module com.group.quiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires commons.lang3;


    opens com.group.quiz to javafx.fxml;
    exports com.group.quiz;
    exports Model;
    opens Model to javafx.fxml;
}