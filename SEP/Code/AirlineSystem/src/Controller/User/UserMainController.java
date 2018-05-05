package Controller.User;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class UserMainController {
    @FXML private DatePicker returnDatePicker;
    @FXML private Label returnDateLabel;

    @FXML AnchorPane anchorPane;

    public void ReturnDateChangeVisibility(){
        if(returnDatePicker.isVisible()==true){
            returnDateLabel.setVisible(false);
            returnDatePicker.setVisible(false);
        }else{
            returnDateLabel.setVisible(true);
            returnDatePicker.setVisible(true);
        }

    }
    public void goBack() throws IOException{
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/LogIn.fxml"))));
    }

}
