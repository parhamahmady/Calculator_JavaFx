package Controllers;

import Boundry.GUI.MainScene;

public class Controller {

    private String firstNum, secondNum, func;
    private boolean isActive; // to deactivate the calculator
    private MainScene mainScene;

    /**
     * Constructor
     * 
     * @param mainScene that should be under control
     */
    public Controller(MainScene mainScene) {
        this.mainScene = mainScene;
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

        mainScene.getMonitor().setText(firstNum + " " + func + " " + secondNum); // set it to the monitor
        // System.out.println(firstNum + " " + func + " " + secondNum);

    }

    /**
     * Reset fields
     */
    private void reset() {
        func = firstNum = secondNum = " ";
        isActive = true;
    }
}
