package Model;

public class Model {
private static final int LIMIT=12;
private double firstNumber;
private double secondNumber;
private String result="";

    public String calculate(String number1, String number2, String operator) {
        firstNumber= Double.parseDouble(number1);
        secondNumber = Double.parseDouble(number2);
        switch (operator) {
            case "+":

                result = String.valueOf(firstNumber + secondNumber); break;
            case "-":

                result= String.valueOf(firstNumber - secondNumber); break;
            case "*":

                result = String.valueOf(firstNumber * secondNumber);break;
            case "/":
                if (secondNumber == 0) {

                    return "error";

                }else{
                    result=  String.valueOf(firstNumber / secondNumber);break;
                }



        }        System.out.println(result);
        if (result.length() > LIMIT) {
            result = result.substring(0, LIMIT);

        }
        return result;
    }


}
