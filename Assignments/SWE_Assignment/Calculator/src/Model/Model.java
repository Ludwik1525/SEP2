package Model;

public class Model {
private static final int LIMIT=12;
//private double result;
//private String output;
    public double calculate(double number1, double number2, String operator) {
        switch (operator) {
            case "+":

                return number1 + number2;
            case "-":

                return (number1 - number2);
            case "*":

                return number1 * number2;
            case "/":
                if (number2 == 0) {

                    return 00;

                }

                return number1 / number2;

        }
//        output= String.valueOf(result);
//        System.out.println(output);
//        if (output.length() > LIMIT) {
//            output = output.substring(0, LIMIT);
//            result = Double.parseDouble(output);
//        }
        return 0;
    }


}
