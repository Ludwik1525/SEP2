package Controller.Administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageAirplanesController {
    @FXML
    AnchorPane anchorPane;
    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addButtonPressed(ActionEvent actionEvent) {
    }

    public void removeButtonPressed(ActionEvent actionEvent) {
    }
}
