package Controller;

import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class FlightsController implements Initializable {
    @FXML
    AnchorPane anchorPane;

    FlightList flightList;

    @FXML protected TableView<Flight> flightsTable;
    @FXML protected TableColumn<Flight, String> flightNumber;
    @FXML protected TableColumn<Flight, LocalDate> departureTime;
    @FXML protected TableColumn<Flight, LocalDate> arrivalTime;
    @FXML protected TableColumn<Flight, String> airplaneIDNumber;
    @FXML protected TableColumn<Flight, Crew> crew;
    @FXML protected TableColumn<Flight, String> departurePlace;
    @FXML protected TableColumn<Flight, String> arrivalPlace;
    @FXML protected TableColumn<Flight, PassengerList> passengers;
    @FXML protected TableColumn<Flight, String> status;

    @FXML
    Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;



    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        flightNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        departureTime.setCellValueFactory(new PropertyValueFactory<Flight, LocalDate>("departureTime"));
        arrivalTime.setCellValueFactory(new PropertyValueFactory<Flight, LocalDate>("arrivalTime"));
        airplaneIDNumber.setCellValueFactory(new PropertyValueFactory<Flight, String>("airplane ID number"));
        crew.setCellValueFactory(new PropertyValueFactory<Flight, Crew>("crew"));
        departurePlace.setCellValueFactory(new PropertyValueFactory<Flight, String>("departurePlace"));
        arrivalPlace.setCellValueFactory(new PropertyValueFactory<Flight, String>("arrivalPlace"));
        passengers.setCellValueFactory(new PropertyValueFactory<Flight, PassengerList>("passengers"));
        status.setCellValueFactory(new PropertyValueFactory<Flight, String>("status"));


        flightList= new FlightList();
        flightsTable.setItems(flightList.getFlights());




        flightsTable.getColumns().clear();
        flightsTable.getColumns().addAll(flightNumber, departureTime, arrivalTime, airplaneIDNumber, crew, departurePlace, arrivalPlace, passengers, status);

    }

    //Associate data with column

    public void addFlightButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Flights Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddAirportForm.fxml")));
        window.setScene(new Scene(loader.load()));
        AddFlightFormController controller = loader.getController();
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
                if(flight.getFlightNumber().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Flight> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(flightsTable.comparatorProperty());
        flightsTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
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
}
