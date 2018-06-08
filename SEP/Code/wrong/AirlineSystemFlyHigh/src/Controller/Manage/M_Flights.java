package Controller.Manage;

import Controller.CrewMembersFlightController;
//import Controller.Edit.E_Flight;
import Controller.Edit.E_Flight;
import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Controller.Add.A_Flight;

public class M_Flights implements Initializable {
    @FXML
    AnchorPane anchorPane;

    FlightList flightList;

    @FXML protected TableView<Flight> flightsTable;
    @FXML protected TableColumn<Flight, String> flightNumber;
    @FXML protected TableColumn<Flight, String> departureTime;
    @FXML protected TableColumn<Flight, String> arrivalTime;
    @FXML protected TableColumn<Flight, String> airplaneIDNumber;
    @FXML protected TableColumn<Flight, String> departurePlaceName;
    @FXML protected TableColumn<Flight, String> arrivalPlaceName;
    @FXML protected TableColumn<Flight, String> status;

    @FXML protected Button seeCrew;
    @FXML protected Button seePassengers;
    @FXML protected Button editButton;
    @FXML Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;
    @FXML TextField searchField;



    @FXML private Button removeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        flightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        departureTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("departureDateTime"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalDateTime"));
        airplaneIDNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("airplaneIdNumber"));
        departurePlaceName.setCellValueFactory(new PropertyValueFactory<Flight, String>("departurePlace"));
        arrivalPlaceName.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalPlace"));
        status.setCellValueFactory(new PropertyValueFactory<Flight, String>("status"));


        flightList= new FlightList();
        flightsTable.setItems(flightList.getFlights());

        makeFilteredList(flightList.getFlights());

    }

    //Associate data with column

    public void addFlightButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Flight Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../View/FXML/Administrator/Add/A_Flight.fxml")));
        window.setScene(new Scene(loader.load()));
        A_Flight controller = loader.getController();
        controller.setItems(flightList.getFlights());
        window.showAndWait();
    }

    public void removeFlightButtonPressed() throws IOException {
        ObservableList<Flight> flights= flightList.getFlights();
        ObservableList<Flight> selected= flightsTable.getSelectionModel().getSelectedItems();
        selected.forEach(flights::remove);
        makeFilteredList(flights);
        flightList.updateList(flights);

    }
    public void makeFilteredList(ObservableList<Flight> list){
        FilteredList<Flight> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(flight -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(String.valueOf(flight.getFlightNumber()).toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Flight> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(flightsTable.comparatorProperty());
        flightsTable.setItems(sortedList);
    }

    public void buttonsAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
        seeCrew.setVisible(true);
        seePassengers.setVisible(true);
        editButton.setVisible(true);
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeFlightButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        ObservableList<Flight> flights= flightList.getFlights();
        ObservableList<Flight> selected= flightsTable.getSelectionModel().getSelectedItems();
        selected.forEach(flights::remove);
        makeFilteredList(flights);
        flightList.updateList(flights);
    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }

    public void editButtonPressed() throws IOException {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Edit/E_Flight.fxml"));
        loader.load();
        E_Flight controller = loader.getController();
        controller.initData(selectedFlight,flightList);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit flight");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }

    public void seeCrewButtonPressed(ActionEvent actionEvent) throws IOException {
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Manage/M_Flight_CrewMembers.fxml"));
        loader.load();
        CrewMembersFlightController controller = loader.getController();
        controller.initData(selectedFlight);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("See Crew");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }

    public void seePassengersButtonPressed(ActionEvent actionEvent) throws IOException{
        Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Manage/M_Passengers.fxml"));
        loader.load();
        M_Passengers controller = loader.getController();
        controller.initData(selectedFlight);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("See Passenger");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
}
