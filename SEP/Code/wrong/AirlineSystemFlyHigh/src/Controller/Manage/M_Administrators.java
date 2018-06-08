package Controller.Manage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class M_Administrators
{
    @FXML
    AnchorPane anchorPane;
    public void goBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void confirmButtonPressed(ActionEvent actionEvent) {
    }

    public void forsakeButtonPressed(ActionEvent actionEvent) {
    }
}
