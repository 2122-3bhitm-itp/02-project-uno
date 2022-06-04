module at.htl.quiz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.htl.quiz to javafx.fxml;
    exports at.htl.quiz;
    exports at.htl.quiz.ui;
    opens at.htl.quiz.ui to javafx.fxml;
}