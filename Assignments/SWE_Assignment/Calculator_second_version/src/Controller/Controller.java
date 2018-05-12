package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button plus;
    @FXML
    private Button minus;
    @FXML
    private Button multiply;
    @FXML
    private Button divide;
    @FXML
    private Button equals;
    @FXML
    private Button clear;
    @FXML
    private Text input;
    @FXML
    private Label prom;

    private double number1;
    private double number2;
    private String operation;

    @FXML
    public void clickZero(){
        String oldValue = input.getText();
        String set = "0";
        input.setText(oldValue + set);
    }

    public void clickOne() {
        String oldValue = input.getText();
        String set = "1";
        input.setText(oldValue + set);
    }

    public void clickTwo() {
        String oldValue = input.getText();
        String set = "2";
        input.setText(oldValue + set);

    }

    public void clickThree() {
        String oldvalue = input.getText();
        String set = "3";
        input.setText(oldvalue + set);
    }

    public void clickFour() {
        String oldvalue = input.getText();
        String set = "4";
        input.setText(oldvalue + set);
    }

    public void clickFive() {
        String oldvalue = input.getText();
        String set = "5";
        input.setText(oldvalue + set);
    }

    public void clickSix() {
        String oldvalue = input.getText();
        String set = "6";
        input.setText(oldvalue + set);
    }

    public void clickSeven() {
        String oldvalue = input.getText();
        String set = "7";
        input.setText(oldvalue + set);
    }

    public void clickEight() {
        String oldvalue = input.getText();
        String set = "8";
        input.setText(oldvalue + set);
    }

    public void clickNine() {
        String oldvalue = input.getText();
        String set = "9";
        input.setText(oldvalue + set);
    }

    public void clickPlus() {
        String value = input.getText();
        double valueNumber = Integer.parseInt(value);
        this.number1 = valueNumber;
        input.setText("");
        prom.setText(value + "+");
        operation = "+";
    }

    public void clickMinus() {
        String value = input.getText();
        double valueNumber = Integer.parseInt(value);
        this.number1 = valueNumber;
        input.setText("");
        prom.setText(value + "-");
        operation = "-";
    }

    public void clickDivide() {
        String value = input.getText();
        double valueNumber = Integer.parseInt(value);
        this.number1 = valueNumber;
        input.setText("");
        prom.setText(value + "/");
        operation = "/";
    }

    public void clickMultiply() {
        String value = input.getText();
        double valueNumber = Integer.parseInt(value);
        this.number1 = valueNumber;
        input.setText("");
        prom.setText(value + "*");
        operation = "*";
    }

    public void clickEqual() {
        switch (operation) {
            case "+":
                String value = input.getText();
                this.number2 = Integer.parseInt(value);
                double result = this.number1 + this.number2;
                input.setText(String.valueOf(result));
                String oldprom = prom.getText();
                prom.setText(oldprom + value);
                break;
            case "-":
                String valueMinus = input.getText();
                this.number2 = Integer.parseInt(valueMinus);
                double resultMinus = this.number1 - this.number2;
                input.setText(String.valueOf(resultMinus));
                String oldpromMinus = prom.getText();
                prom.setText(oldpromMinus + valueMinus);
                break;
            case "/":
                String valueDivide = input.getText();
                this.number2 = Integer.parseInt(valueDivide);
                double resultDivide = this.number1 / this.number2;
                input.setText(String.valueOf(resultDivide));
                String oldpromDivide = prom.getText();
                prom.setText(oldpromDivide + valueDivide);
                break;
            case "*":
                String valueMultiply = input.getText();
                this.number2 = Integer.parseInt(valueMultiply);
                double resultMultiply = this.number1 * this.number2;
                input.setText(String.valueOf(resultMultiply));
                String oldpromMultiply = prom.getText();
                prom.setText(oldpromMultiply + valueMultiply);
                break;
        }

    }
    public void clickClear(){
        input.setText("");
        prom.setText("");
        this.number1=0;
        this.number2=0;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("whatever");
    }
}
