package Boundry.GUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class Window extends Application {

    public Window(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Super Calc");
        stage.setScene(new MainScene().getScene());

        stage.show();
    }

}
