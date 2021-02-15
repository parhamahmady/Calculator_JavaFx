package Controllers;

import java.io.IOException;

import Boundry.GUI.MainScene;
import Entity.Network.Client;

public class Controller {

    private String firstNum, secondNum, func;
    private boolean isActive; // to deactivate the calculator
    private MainScene mainScene;
    private Client socketClient;
    private static Controller controller;

    /**
     * Constructor
     * 
     * @param mainScene that should be under control
     */
    private Controller() throws IOException {
        socketClient = new Client("127.0.0.1", 2002);
        this.mainScene = new MainScene(this);
        reset();
    }

    /**
     * Add the given number to previous numbers public
     * 
     * @param number will added to the previous numbers
     */
    public void addNumber(String number) {
        if (!isActive)
            return;

        if (func.equals(" ")) {
            firstNum += number;
        } else {
            secondNum += number;
        }
        updateMonitor();
        // System.out.println(firstNum + " " + func + " " + secondNum);

    }

    public void functionHandler(String function) {
        if (function.equals("C")) { // in case of Cancle
            reset();
            mainScene.getMonitor().setText("0");
            return;
        }
        if (function.equals("=")) {
            System.out.println("Equals");
            String[] message = new String[4];
            message[0] = "calc"; // to tell server calculate
            message[1] = firstNum;
            message[2] = secondNum;
            message[3] = function;
            return;
        }
        func = function;
        updateMonitor();
    }

    /**
     * Just Update the Monitor with new values
     */
    private void updateMonitor() {
        mainScene.getMonitor().setText(firstNum + " " + func + " " + secondNum); // set it to the monitor
    }

    /**
     * Reset fields
     */
    private void reset() {
        func = firstNum = secondNum = " ";
        isActive = true;
    }

    public static MainScene makeController() throws IOException {
        if (controller == null) {
            controller = new Controller();
        }
        return controller.getMainScene();
    }

    private MainScene getMainScene() {
        return mainScene;
    }
}
