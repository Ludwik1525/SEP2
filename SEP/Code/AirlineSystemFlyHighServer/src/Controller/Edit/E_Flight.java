package Controller.Edit;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.LocalTime;


public class E_Flight {

    @FXML
    AnchorPane anchorPane;
    @FXML
    TextField flightNumberField;
    @FXML
    DatePicker departureDateField;
    @FXML
    DatePicker arrivalDateField;
    @FXML
    ComboBox<String> countryFrom = new ComboBox<>();
    @FXML
    ComboBox<Airport> airportFrom = new ComboBox<>();
    @FXML
    ComboBox<String> countryTo = new ComboBox<>();
    @FXML
    ComboBox<Airport> airportTo = new ComboBox<>();
    @FXML
    ComboBox<String> departureHourBox = new ComboBox<>();
    @FXML
    ComboBox<String> departureMinutesBox = new ComboBox<>();
    @FXML
    ComboBox<String> arrivalHourBox = new ComboBox<>();
    @FXML
    ComboBox<String> arrivalMinutesBox = new ComboBox<>();
    @FXML
    ChoiceBox<String> airplaneId = new ChoiceBox<>();
    private DatabaseAdapter adapter = new DatabaseAdapter();
    @FXML
    TextField statusField;
    private Flight flight;
    private FlightList flightList;
    private ObservableList<Flight> flights;


    AirplaneList airplaneList = new AirplaneList();
    AirportList airportList = new AirportList();


    public void initData(Flight flight, FlightList flightList) {
        this.flight = flight;
        this.flightList = flightList;
        this.flights = flightList.getFlights();
        flightNumberField.setText(String.valueOf(this.flight.getFlightNumber()));
        departureDateField.setValue(flight.getDepartureDate());
        departureHourBox.getItems().setAll(makeStringArray(12));
        departureMinutesBox.getItems().setAll(makeStringArray(59));
        departureHourBox.setValue(flight.getDepartureTime().getHour() + "");
        departureMinutesBox.setValue(flight.getDepartureTime().getMinute() + "");
        arrivalDateField.setValue(flight.getDepartureDate());
        arrivalMinutesBox.getItems().setAll(makeStringArray(59));
        arrivalHourBox.getItems().setAll(makeStringArray(12));
        arrivalHourBox.setValue(flight.getArrivalTime().getHour() + "");
        arrivalMinutesBox.setValue(flight.getArrivalTime().getMinute() + "");
        for (int i = 0; i < airportList.getLength(); i++) {
            countryFrom.getItems().add(airportList.getCountry(i));
            countryTo.getItems().add(airportList.getCountry(i));
        }
        countryFrom.setValue(flight.getDeparturePlace().getCountry());
        countryTo.setValue(flight.getArrivalPlace().getCountry());
        airportFrom.setValue(flight.getDeparturePlace());
        airportTo.setValue(flight.getArrivalPlace());
        statusField.setText(flight.getStatus());
    }

    public void confirmButtonPressed() {
        Crew crew = flight.getCrew();
        Flight toBeEdited = new Flight(flightNumberField.getText(), departureDateField.getValue(),
                LocalTime.of(Integer.parseInt(departureHourBox.getSelectionModel().getSelectedItem())
                        , Integer.parseInt(departureMinutesBox.getSelectionModel().getSelectedItem()), 0)
                , arrivalDateField.getValue(), LocalTime.of(Integer.parseInt(arrivalHourBox.getSelectionModel().getSelectedItem())
                , Integer.parseInt(arrivalMinutesBox.getSelectionModel().getSelectedItem()), 0)
                , "A34B", airportFrom.getSelectionModel().getSelectedItem()
                , airportTo.getSelectionModel().getSelectedItem(), statusField.getText(), 150.0);
        adapter.updateFlight(toBeEdited);
        flights.remove(flight);
        flights.add(toBeEdited);
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void getAirports() {
        for (int i = 0; i < airportList.getLength(); i++) {
            countryFrom.getItems().add(airportList.getCountry(i));
            countryTo.getItems().add(airportList.getCountry(i));
        }
        countryFrom.getSelectionModel().select(0);
        countryTo.getSelectionModel().select(0);
    }

    public Airport findAirport(String country, String airport) {
        for (int i = 0; i < airportList.getLength(); i++) {
            if (country.equals(airportList.getCountry(i)) && airport.equals(airportList.getCity(i))) {
                return airportList.getAirport(i);
            }
        }
        return null;
    }

    public void confirmAirplane(ActionEvent actionEvent) {
    }

    public void getAirplanes() {
        for (int i = 0; i < airplaneList.getLength(); i++) {
            airplaneId.getItems().add(airplaneList.getId(i));
        }
        airplaneId.getSelectionModel().select(0);

    }

    public void goBack() {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    private void makeDates(DatePicker dp) {
        dp.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(date.compareTo(today) < 0);
            }
        });
    }

    public void initAirportsFrom() {
        airportFrom.getItems().clear();
        String country = countryFrom.getSelectionModel().getSelectedItem();
        for (int i = 0; i < airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportFrom.getItems().add(airportList.getAirports().get(i));
            }
        }

    }

    public void initAirportsTo() {
        airportTo.getItems().clear();
        String country = countryTo.getSelectionModel().getSelectedItem();
        for (int i = 0; i < airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportTo.getItems().add(airportList.getAirports().get(i));
            }
        }
        airportTo.getItems().remove(airportFrom.getSelectionModel().getSelectedItem());
    }

    private String[] makeStringArray(int until) {
        String[] array = new String[until + 1];
        for (int i = 0; i < array.length; i++) {
            if (i < 10) {
                array[i] = "0" + i;
            } else {
                array[i] = i + "";
            }
        }
        return array;
    }
}
