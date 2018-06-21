package Controller.Edit;

import Controller.Controller;
import Controller.Manage.M_Flights;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
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
    private M_Flights controller;
    private Model modelManager;



    public void initData(M_Flights controller,Model modelManager) {
        this.controller = controller;
        this.modelManager = modelManager;
        flightNumberField.setText(controller.getSelectedFlight().getFlightNumber()+"");
        departureDateField.setValue(controller.getSelectedFlight().getDepartureDate());
        departureHourBox.getItems().setAll(makeStringArray(12));
        departureMinutesBox.getItems().setAll(makeStringArray(59));
        departureHourBox.setValue(controller.getSelectedFlight().getDepartureTime().getHour() + "");
        departureMinutesBox.setValue(controller.getSelectedFlight().getDepartureTime().getMinute() + "");
        arrivalDateField.setValue(controller.getSelectedFlight().getDepartureDate());
        arrivalMinutesBox.getItems().setAll(makeStringArray(59));
        arrivalHourBox.getItems().setAll(makeStringArray(12));
        arrivalHourBox.setValue(controller.getSelectedFlight().getArrivalTime().getHour() + "");
        arrivalMinutesBox.setValue(controller.getSelectedFlight().getArrivalTime().getMinute() + "");
        for (int i = 0; i < modelManager.getAirports().getAirports().size(); i++) {
            countryFrom.getItems().add(modelManager.getAirports().getAirports().get(i).getCountry());
            countryTo.getItems().add(modelManager.getAirports().getAirports().get(i).getCountry());
        }
        countryFrom.setValue(controller.getSelectedFlight().getDeparturePlace().getCountry());
        countryTo.setValue(controller.getSelectedFlight().getArrivalPlace().getCountry());
        airportFrom.setValue(controller.getSelectedFlight().getDeparturePlace());
        airportTo.setValue(controller.getSelectedFlight().getArrivalPlace());
        statusField.setText(controller.getSelectedFlight().getStatus());
    }

    public void confirmButtonPressed() {
        modelManager.getFlights().getFlights().remove(controller.getSelectedFlight());

        modelManager.getFlights().getFlights().add(new Flight(flightNumberField.getText(), departureDateField.getValue(),
                LocalTime.of(Integer.parseInt(departureHourBox.getSelectionModel().getSelectedItem())
                        , Integer.parseInt(departureMinutesBox.getSelectionModel().getSelectedItem()), 0)
                , arrivalDateField.getValue(), LocalTime.of(Integer.parseInt(arrivalHourBox.getSelectionModel().getSelectedItem())
                , Integer.parseInt(arrivalMinutesBox.getSelectionModel().getSelectedItem()), 0)
                , "A34B", airportFrom.getSelectionModel().getSelectedItem()
                , airportTo.getSelectionModel().getSelectedItem(), statusField.getText(), 150.0));

       modelManager.updateFlight(new Flight(flightNumberField.getText(), departureDateField.getValue(),
               LocalTime.of(Integer.parseInt(departureHourBox.getSelectionModel().getSelectedItem())
                       , Integer.parseInt(departureMinutesBox.getSelectionModel().getSelectedItem()), 0)
               , arrivalDateField.getValue(), LocalTime.of(Integer.parseInt(arrivalHourBox.getSelectionModel().getSelectedItem())
               , Integer.parseInt(arrivalMinutesBox.getSelectionModel().getSelectedItem()), 0)
               , "A34B", airportFrom.getSelectionModel().getSelectedItem()
               , airportTo.getSelectionModel().getSelectedItem(), statusField.getText(), 150.0));

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void getAirports() {
        for (int i = 0; i < modelManager.getAirports().getAirports().size(); i++) {
            countryFrom.getItems().add(modelManager.getAirports().getAirports().get(i).getCountry());
            countryTo.getItems().add(modelManager.getAirports().getAirports().get(i).getCountry());
        }
        countryFrom.getSelectionModel().select(0);
        countryTo.getSelectionModel().select(0);
    }

    public Airport findAirport(String country, String airport) {
        for (int i = 0; i < modelManager.getAirports().getAirports().size(); i++) {
            if (country.equals(modelManager.getAirports().getAirports().get(i).getCountry()) && airport.equals(modelManager.getAirports().getAirports().get(i).getCity())) {
                return modelManager.getAirports().getAirport(i);
            }
        }
        return null;
    }

    public void confirmAirplane(ActionEvent actionEvent) {
    }

    public void getAirplanes() {
        for (int i = 0; i < modelManager.getAirplanes().getAirplanes().size(); i++) {
            airplaneId.getItems().add(modelManager.getAirplanes().getId(i));
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
        for (int i = 0; i < modelManager.getAirports().getAirports().size(); i++) {
            if (modelManager.getAirports().getAirports().get(i).getCountry().equals(country)) {
                airportFrom.getItems().add(modelManager.getAirports().getAirports().get(i));
            }
        }

    }

    public void initAirportsTo() {
        airportFrom.getItems().clear();
        String country = countryFrom.getSelectionModel().getSelectedItem();
        for (int i = 0; i < modelManager.getAirports().getAirports().size(); i++) {
            if (modelManager.getAirports().getAirports().get(i).getCountry().equals(country)) {
                airportFrom.getItems().add(modelManager.getAirports().getAirports().get(i));
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
