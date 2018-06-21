package Controller;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.ClubMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;


public class MainController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongDataLabel;
    @FXML Button removeButton;

    //Log In
    public void LogInButtonController() throws IOException {
        if (username.getText().equals("a") && password.getText().equals("a")) {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
        } else if (username.getText().equals("ha") && password.getText().equals("ha")) {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/HeadAdministratorMain.fxml"))));
        } else if (username.getText().equals("m") && password.getText().equals("m")) {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/ClubMemberMain.fxml"))));
        } else {
            wrongDataLabel.setVisible(true);
            username.setText("");
            password.setText("");
        }

    }

    public void SkipButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/UserMain.fxml"))));
    }

    public void RegisterButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/RegistrationForm.fxml"))));
    }

    //Registration Form


    public void register() {

    }



    //Club MemberMain
    public void ClubMemberMainGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
    }

    //Head Administrator/Administrator Main
    public void LogOut() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
    }

    public void ManageFlightsButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_Flights.fxml"))));
    }

    public void ManageAirportsButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_Airports.fxml"))));
    }

    public void ManageClubMembersButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_ClubMembers.fxml"))));
    }

    public void ManageAirplanesButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_Airplanes.fxml"))));
    }

    public void ManageCrewMembersButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_CrewMembers.fxml"))));
    }

    public void ManageAdministratorsButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/Manage/M_Administrators.fxml"))));
    }

    public void goBack(ActionEvent actionEvent) {
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }


}
