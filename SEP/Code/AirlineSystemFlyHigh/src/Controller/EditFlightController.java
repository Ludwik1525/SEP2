package Controller;

import Domain.Model.Flight;
import Domain.Model.FlightList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class EditFlightController implements Initializable {

    @FXML AnchorPane editFlightPanel;
    @FXML TextField flightNumberField;
    @FXML TextField arrivalPlaceField;
    @FXML TextField departurePlaceField;
    @FXML DatePicker departureTimeField;
    @FXML DatePicker arrivalTimeField;
    @FXML TextField planeField;
    @FXML TextField crewField;
    @FXML TextField passengersField;
    @FXML TextField statusField;
    private Flight flight;
    private FlightList flightList;
    private ObservableList<Flight> flights;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Flight flight, FlightList flightList) {
        this.flight = flight;
        this.flightList = flightList;
        this.flights = flightList.getFlights();
        flightNumberField.setText(this.flight.getFlightNumber());
        arrivalPlaceField.setText(flight.getArrivalPlace());
        departurePlaceField.setText(flight.getDeparturePlace());
        departureTimeField.setValue(flight.getDepartureTime());
        arrivalTimeField.setValue(flight.getArrivalTime());
        planeField.setText(flight.getAirplaneIdNumber());
        crewField.setText("Not implemented yet");
        passengersField.setText("Not implemented yet");
        statusField.setText(flight.getStatus());
    }

//    public void confirmButtonPressed() {
//        flights.remove(flight);
//        flights.add(new Flight(flightNumberField.getText(),departureTimeField.getValue(),arrivalTimeField.getValue()
//                ,(Airplane) planeField.getText()));
//    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editFlightPanel.getScene().getWindow();
        stage.close();
    }
}
