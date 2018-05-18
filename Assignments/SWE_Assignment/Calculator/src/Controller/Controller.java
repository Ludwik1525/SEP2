package Controller;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;


public class Controller {

    @FXML
    AnchorPane anchorPane2;
    private int timecounter = 300000;
    Timer timer = new Timer();
    private Model model = new Model();
    @FXML
    Text output;
    private String number1 = "0";
    private String number2 = "0";
    private boolean start = true;
    public static final int LIMIT = 12;
    private boolean operatorUsedFirstTime = true;
    private boolean numberOneInUse = false;
    private String operator;
    private String result = "";
    String value;

    @FXML
    private void processNumpad(ActionEvent event) {
        if (start) {
            output.setText("");
            start = false;
        }
        if (output.getText().length() > LIMIT) {
            output.setText(output.getText().substring(0, LIMIT));
        }
        if (numberOneInUse == false) {
            value = ((Button) event.getSource()).getText();
            output.setText(output.getText() + value);
            numberOneInUse = true;
            resetTimer();
        } else {
            value = ((Button) event.getSource()).getText();
            output.setText(output.getText() + value);
            number2= output.getText();
            result = model.calculate(number1, number2, operator);
            resetTimer();
        }
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (operatorUsedFirstTime == true) {
            if (!value.equals("=")) {
                operator = value;
                number1 = output.getText();
                output.setText(operator);
                start = true;
            }
            operatorUsedFirstTime = false;

        } else {
            if (value.equals("=")) {
                output.setText(String.valueOf(result));
                if(result=="error"){
                    number1="0";
                    number2="0";
                    result="0";
                    numberOneInUse=false;
                    operatorUsedFirstTime=true;
                }
                start = true;
            } else {
                number1 = result;
                operator = value;
                numberOneInUse = true;
                output.setText(operator);
                start = true;
            }

        }
        resetTimer();
    }

    @FXML
    private void setTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                output.setText("");
                anchorPane2.setDisable(true);
            }
        };
        timer.schedule(task, timecounter);
    }

    @FXML
    private void resetTimer() {
        timer.cancel();
        timer = new Timer();
        setTimer();
    }

    @FXML
    private void turnOn() {
        output.setText("0");
        anchorPane2.setDisable(false);
        setTimer();
        number1="0";
        number2="0";
        result="0";
        start=true;
        numberOneInUse=false;
        operatorUsedFirstTime=true;

        System.out.println("calculator on");

    }
}
