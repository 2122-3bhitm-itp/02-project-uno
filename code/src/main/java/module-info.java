module at.htlleonding.quiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.htlleonding.quiz to javafx.fxml;
    exports at.htlleonding.quiz.model;
    opens at.htlleonding.quiz.model to javafx.fxml;
}