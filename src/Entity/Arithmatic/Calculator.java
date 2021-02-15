package Entity.Arithmatic;

public class Calculator {

    public static String Calculate(String firstNumber, String secondNumber, String func) {
        String awnser = "";

        switch (func) {
            case "+":
                awnser = Double.toString(Double.parseDouble(firstNumber) + Double.parseDouble(secondNumber));
                break;

            case "-":
                awnser = Double.toString(Double.parseDouble(firstNumber) - Double.parseDouble(secondNumber));
                break;

            case "*":
                awnser = Double.toString(Double.parseDouble(firstNumber) * Double.parseDouble(secondNumber));
                break;

            case "/":
                awnser = Double.toString(Double.parseDouble(firstNumber) / Double.parseDouble(secondNumber));
                break;

        }

        return awnser;
    }

}
