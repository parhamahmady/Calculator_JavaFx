import Boundry.GUI.MainScene;
import Controllers.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        // MainController mainController = new MainController(args);
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Super Calc");
        MainScene mainScene = Controller.makeController();
        stage.setScene(mainScene.getScene());
        stage.show();
    }

}
