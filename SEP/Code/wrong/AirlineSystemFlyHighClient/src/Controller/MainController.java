package Controller;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.Airplane;
import Domain.Model.ClubMember;
import Domain.Model.ClubMemberList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;

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

    DatabaseAdapter adapter= new DatabaseAdapter();

    //    @FXML
//    private ComboBox country;
//
//    public void initialize(){
//        country.setItems("Country 1");
//    }
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
    public void RegistrationGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
    }

    public void register() {

    }



    //Club MemberMain
    public void ClubMemberMainGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
    }

    //Manage Club Members
    public void ManageClubMembersGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    //Manage PassengerList
    public void ManagePassengersGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    //Manage flights
    public void ManageFlightsGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addFlightButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Addha New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/Add/A_Flight.fxml")));
        window.setScene(new Scene(loader.load()));
        MainController controller = loader.getController();
        window.showAndWait();
    }

    public void removeFlightButtonPressed(ActionEvent actionEvent) {
    }

    public void addFlightFormGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    //Manage M_Airports


    //////////////////////////////////////////////////////////Manage M_Airplanes


    //Manage Crew Members
    public void ManageCrewMembersGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addCrewMemberButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/Add/A_CrewMember.fxml")));
        window.setScene(new Scene(loader.load()));
        MainController controller = loader.getController();
        window.showAndWait();
    }

    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) {
    }


    public void removeClubMemberButtonPressed(ActionEvent actionEvent) {
    }

    public void addCrewMemberFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

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


    //Add Club Member Form
    @FXML TextField name;
    @FXML TextField idNumber;
    @FXML DatePicker birthdate;
    @FXML TextField phoneNumber;
    @FXML TextField email;
    @FXML TextField address;
    LocalDate membershipDate= LocalDate.of(Calendar.YEAR, Calendar.DAY_OF_MONTH, Calendar.MONTH);




    public void goBack(ActionEvent actionEvent) {
    }

    public void register(ActionEvent actionEvent) {


        ClubMember temp = new ClubMember(name.getText(), idNumber.getText(), birthdate.getValue()
                , Integer.parseInt(phoneNumber.getText()), email.getText(), address.getText()
                , membershipDate, true);

        adapter.addClubMember(temp);


        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }


    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }


}
