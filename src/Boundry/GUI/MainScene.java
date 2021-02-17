package Boundry.GUI;

import Controllers.Controller;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class MainScene {

    private Scene scene;
    private BorderPane borderPane;
    private Label monitor;

    private Controller controller;

    public MainScene(Controller Maincontroller) {

        this.controller = Maincontroller;

        borderPane = new BorderPane();

        monitor = new Label("0"); // Default first time result is 0
        monitor.setTextAlignment(TextAlignment.CENTER);
        monitor.setMinSize(300, 100);
        borderPane.setTop(monitor);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        // Adding Function Buttons
        Button cancel = new Button("C");
        cancel.setMinSize(50, 50);
        cancel.setOnAction(e -> controller.functionHandler("C"));
        gridPane.add(cancel, 0, 0);

        Button equal = new Button("=");
        equal.setMinSize(50, 50);
        equal.setOnAction(e -> controller.functionHandler("="));
        gridPane.add(equal, 1, 2);

        Button plus = new Button("+");
        plus.setMinSize(50, 50);
        plus.setOnAction(e -> controller.functionHandler("+"));
        gridPane.add(plus, 0, 1);

        Button mines = new Button("-");
        mines.setMinSize(50, 50);
        mines.setOnAction(e -> controller.functionHandler("-"));
        gridPane.add(mines, 0, 2);

        Button multi = new Button("*");
        multi.setMinSize(50, 50);
        multi.setOnAction(e -> controller.functionHandler("*"));
        gridPane.add(multi, 1, 0);

        Button devide = new Button("/");
        devide.setMinSize(50, 50);
        devide.setOnAction(e -> controller.functionHandler("/"));
        gridPane.add(devide, 1, 1);

        // Adding Number Buttons

        int m = 0;
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                Button b = new Button(Integer.toString(m));
                b.setMinSize(50, 50);
                // b.setOnAction(e -> System.out.println(b.getText()));
                b.setOnAction(e -> controller.addNumber(b.getText()));

                gridPane.add(b, j + 2, i);
                m++;
            }
        }

        borderPane.setCenter(gridPane);

        scene = new Scene(borderPane, 300, 300);
    }

    public Scene getScene() {
        return scene;
    }

    public Label getMonitor() {
        return monitor;
    }
}
