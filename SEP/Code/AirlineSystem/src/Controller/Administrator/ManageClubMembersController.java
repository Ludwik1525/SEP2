package Controller.Administrator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ManageClubMembersController {
    @FXML
    AnchorPane anchorPane;
    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void removeButtonPressed(ActionEvent actionEvent) {
    }

    public void addButtonPressed(ActionEvent actionEvent) throws IOException {
    Stage window= new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Add New Club Member");
    FXMLLoader loader= new FXMLLoader((getClass().getResource("../../View/FXML/Administrator/AddClubMemberForm.fxml")));
    window.setScene(new Scene(loader.load()));
    AddClubMemberFormControlller controller= loader.getController();
    window.showAndWait();
    }
}
