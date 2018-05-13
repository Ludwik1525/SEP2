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
    private Text output;
    private double number1 = 0;
    private String operator = "";
    private boolean start = true;
    private int timecounter = 300000;
    Timer timer = new Timer();
    private static final int LIMIT= 12;

    @FXML
    AnchorPane anchorPane2;
    @FXML
    Button clear;

    private Model model = new Model();

    @FXML
    private void processNumpad(ActionEvent event) {

        if (start) {
            output.setText("");
            start = false;
        }
        if (output.getText().length() > LIMIT) {
            output.setText(output.getText().substring(0, LIMIT));
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
        resetTimer();
    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty())
                return;

            operator = value;
            number1 = Double.parseDouble(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty())
                return;

            output.setText(String.valueOf(model.calculate(number1, Double.parseDouble(output.getText()), operator)));
            operator = "";
            start = true;
        }
        setTimer();
    }

    @FXML
    private void turnOn() {
        output.setText("0");

        anchorPane2.setDisable(false);
        setTimer();

    }

    @FXML
    private void setTimer() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                output.setText("");
                anchorPane2.setDisable(true);
                clear.setDisable(true);
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


}
