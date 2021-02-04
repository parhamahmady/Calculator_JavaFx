

import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Test Page");

        Button myButton = new Button("Click on Me");
        myButton.setOnAction(e -> System.out.println("Hello"));
        StackPane layout = new StackPane();
        layout.getChildren().addAll(myButton);
        Scene scene = new Scene(layout, 300, 300);

        stage.setScene(scene);
        stage.show();
    }

}
