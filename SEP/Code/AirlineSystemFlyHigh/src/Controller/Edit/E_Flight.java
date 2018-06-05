package Controller.Edit;

import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class E_Flight {

    @FXML   AnchorPane editFlightPanel;

    @FXML   TextField flightNumberField;
    @FXML   TextField departurePlaceField;
    @FXML   TextField arrivalPlaceField;
    @FXML   DatePicker departureTimeField;
    @FXML   DatePicker arrivalTimeField;
    @FXML   TextField planeField;
    @FXML   TextField statusField;

    private Flight flight;
    private FlightList flightList;
    private ObservableList<Flight> flights;

    @FXML   AnchorPane departureAirport;
    @FXML   AnchorPane arrivalAirport;
    @FXML   AnchorPane  airplane;
    @FXML   ChoiceBox<String> countryFrom = new ChoiceBox<>();
    @FXML   ChoiceBox<String> airportFrom = new ChoiceBox<>();
    @FXML   ChoiceBox<String> countryTo = new ChoiceBox<>();
    @FXML   ChoiceBox<String> airportTo = new ChoiceBox<>();
    @FXML   ChoiceBox <String> airplaneId = new ChoiceBox<>();

    AirplaneList airplaneList= new AirplaneList();
    AirportList airportList = new AirportList();


    public void initData(Flight flight, FlightList flightList) {
        this.flight = flight;
        this.flightList = flightList;
        this.flights = flightList.getFlights();
        flightNumberField.setText(this.flight.getFlightNumber());
        arrivalPlaceField.setText(flight.getArrivalPlace().getShortInfo());
        departurePlaceField.setText(flight.getDeparturePlace().getShortInfo());
        departureTimeField.setValue(flight.getDepartureTime());
        arrivalTimeField.setValue(flight.getArrivalTime());
        planeField.setText(flight.getAirplaneIdNumber());
        statusField.setText(flight.getStatus());
    }

    public void confirmButtonPressed() {
        flights.remove(flight);
        //flights.add(new Flight(flightNumberField.getText(), departureTimeField.getValue(),arrivalTimeField.getValue(), departurePlaceField.getText(), arrivalPlaceField.getText(),   planeField.getText(), statusField.getText()));
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editFlightPanel.getScene().getWindow();
        stage.close();
    }

    public void showAirplanes(ActionEvent actionEvent) {
        airplane.setVisible(true);
        getAirplanes();
    }

    public void showArrivalAirports(ActionEvent actionEvent) {
        departureAirport.setVisible(false);
        arrivalAirport.setVisible(true);
        getAirports();
    }

    public void showDepartureAirports(ActionEvent actionEvent) {
        arrivalAirport.setVisible(false);
        departureAirport.setVisible(true);
        getAirports();
    }

    public void getAirports() {
        for (int i = 0; i < airportList.getLength(); i++) {
            countryFrom.getItems().add(airportList.getCountry(i));
            countryTo.getItems().add(airportList.getCountry(i));
        }
        countryFrom.getSelectionModel().select(0);
        countryTo.getSelectionModel().select(0);
    }

    public void filterAirportsFrom() {

        if (!countryFrom.getSelectionModel().isEmpty()) {
            airportFrom.getItems().clear();
            for (int i = 0; i < airportList.getLength(); i++) {
                if (countryFrom.getValue().equals(airportList.getCountry(i))) {
                    System.out.println("this code is not duplicated, lol");
                    airportFrom.getItems().add(airportList.getCity(i));
                }
            }
        }
    }

    public void filterAirportsTo() {
        if (!countryTo.getSelectionModel().isEmpty()) {
            airportTo.getItems().clear();
            for (int i = 0; i < airportList.getLength(); i++) {
                if (countryTo.getValue().equals(airportList.getCountry(i))) {
                    airportTo.getItems().add(airportList.getCity(i));
                }System.out.println("this code is not duplicated, lol");
            }
        }
    }
    public void confirmDeparturePlace(ActionEvent actionEvent) {
        String country= countryFrom.getValue();
        String airport= airportFrom.getValue();
        flight.setDeparturePlace(findAirport(country, airport));
// change old flight to the new one in the flight list
    }
    public void confirmArrivalPlace(ActionEvent actionEvent) {
        String country= countryFrom.getValue();
        String airport= airportFrom.getValue();
        flight.setDeparturePlace(findAirport(country, airport));
// change old flight to the new one in the flight list
    }
    public Airport findAirport(String country, String airport){
        for(int i=0; i<airportList.getLength();i++){
            if(country.equals(airportList.getCountry(i))&& airport.equals(airportList.getCity(i))){
                return airportList.getAirport(i);
            }
        }return null;
    }

    public void confirmAirplane(ActionEvent actionEvent) {
    }

    public void getAirplanes() {
        for (int i = 0; i < airplaneList.getLength(); i++) {
            airplaneId.getItems().add(airplaneList.getId(i));
        }
        airplaneId.getSelectionModel().select(0);

    }
}
