package Entity;

public class SharedData {
    private String num1, num2, action;
    private static SharedData sharedData = null;

    private SharedData() {
        num1 = num2 = action = "";
    }

    public static SharedData getSharedData() {
        if (sharedData == null)
            sharedData = new SharedData();
        return sharedData;
    }

    public String getNum1() {
        return num1;
    }

    public String getAction() {
        return action;
    }

    public String getNum2() {
        return num2;
    }
}
