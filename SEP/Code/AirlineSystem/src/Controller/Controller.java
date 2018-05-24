package Controller;

import Domain.Model.Airplane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongDataLabel;
    @FXML Button removeButton;
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

    //User Main
    @FXML
    private DatePicker returnDatePicker;
    @FXML
    private Label returnDateLabel;

    public void ReturnDateChangeVisibility() {
        if (returnDatePicker.isVisible() == true) {
            returnDateLabel.setVisible(false);
            returnDatePicker.setVisible(false);
        } else {
            returnDateLabel.setVisible(true);
            returnDatePicker.setVisible(true);
        }

    }

    public void UserMainGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
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

    //Manage Passengers
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
        window.setTitle("Add New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddFlightForm.fxml")));
        window.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
        window.showAndWait();
    }

    public void removeFlightButtonPressed(ActionEvent actionEvent) {
    }

    public void addFlightFormGoBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    //Manage Airports
    public void ManageAirportsGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addAirportButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddAirportForm.fxml")));
        window.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
        window.showAndWait();
    }

    public void removeAirportButtonPressed(ActionEvent actionEvent) throws IOException {

    }

    public void addAirportFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    //////////////////////////////////////////////////////////Manage Airplanes
//    @FXML TableColumn IDNumber= new TableColumn();
//    @FXML TableColumn model;
//    @FXML TableColumn numberOfSeats;
//    @FXML TableColumn purchaseDate;
//    @FXML TableColumn lastMaintenance;
    @FXML TableView flightsTable;

    public void initialize(URL url, ResourceBundle resourceBundle){
        TableColumn IDNumber= new TableColumn("IDNumber");
        TableColumn model= new TableColumn("Model");
        TableColumn numberOfSeats= new TableColumn("Number of seats");
        TableColumn purchaseDate= new TableColumn("Purchase date");
        TableColumn lastMaintenance= new TableColumn("Last maintenance");
        flightsTable.getColumns().addAll(IDNumber,model,numberOfSeats,purchaseDate,lastMaintenance);

        final ObservableList<Airplane> data= FXCollections.observableArrayList();
        new Airplane("IDNumber","model", 14, new Date(1223,03,21), new Date(1234,01,02));

        IDNumber.setCellValueFactory(new PropertyValueFactory<Airplane, String>("IDNumber"));
        model.setCellValueFactory(new PropertyValueFactory<Airplane, String>("model"));
        numberOfSeats.setCellFactory(new PropertyValueFactory<Airplane,Integer>("numberOfSeats"));
        purchaseDate.setCellValueFactory(new PropertyValueFactory<Airplane, Date>("purchaseDate"));
        lastMaintenance.setCellValueFactory(new PropertyValueFactory<Airplane, Date>("lastMaintenance"));

        flightsTable.setItems(data);

    }
    //Associate data with column
    public void ManageAirplanesGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addAirplaneButtonPressed(ActionEvent actionEvent) throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddAirplaneForm.fxml")));
        window.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
        window.showAndWait();
    }

    public void removeAirplaneButtonPressed() {

    }

    public void addAirplaneFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    //Manage Crew Members
    public void ManageCrewMembersGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }

    public void addCrewMemberButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Club Member");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddCrewMember.fxml")));
        window.setScene(new Scene(loader.load()));
        Controller controller = loader.getController();
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
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageFlights.fxml"))));
    }

    public void ManageAirportsButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageAirports.fxml"))));
    }

    public void ManageClubMembersButtonController() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageClubMembers.fxml"))));
    }

    public void ManageAirplanesButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageAirplanes.fxml"))));
    }

    public void ManageCrewMembersButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageCrewMembers.fxml"))));
    }

    public void ManageAdministratorsButtonController(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageCrewMembers.fxml"))));
    }


    //Add Club Member Form
    public void goBack(ActionEvent actionEvent) {
    }

    public void register(ActionEvent actionEvent) {
    }


    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }
}
