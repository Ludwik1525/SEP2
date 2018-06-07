package Controller.Add;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class A_Flight implements Initializable {
    @FXML AnchorPane anchorPane;
    @FXML TextField statusField;


    Crew crew= new Crew();

    private Flight flight;
    @FXML TextField flightNumberField;
    @FXML DatePicker departureDateField;
    @FXML DatePicker arrivalDateField;
    @FXML ComboBox<String> countryFrom = new ComboBox<>();
    @FXML ComboBox<Airport> airportFrom = new ComboBox<>();
    @FXML ComboBox<String> countryTo = new ComboBox<>();
    @FXML ComboBox<Airport> airportTo = new ComboBox<>();
    @FXML ComboBox<String> departureHourBox = new ComboBox<>();
    @FXML ComboBox<String> departureMinutesBox = new ComboBox<>();
    @FXML ComboBox<String> arrivalHourBox = new ComboBox<>();
    @FXML ComboBox<String> arrivalMinutesBox = new ComboBox<>();

    AirportList airportList = new AirportList();

    ObservableList<Flight> items;
    FlightList flightList= new FlightList();
    DatabaseAdapter adapter= new DatabaseAdapter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Callback<ListView<Airport>, ListCell<Airport>> factory = lv -> new ListCell<Airport>() {

            @Override
            protected void updateItem(Airport item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getShortInfo());
            }
        };
        airportFrom.setCellFactory(factory);
        airportTo.setCellFactory(factory);

        items = flightList.getFlights();
        for(int i=0; i<airportList.getLength(); i++){
            if (!(countryFrom.getItems().contains(airportList.getCountry(i)))) {
                countryFrom.getItems().add(airportList.getCountry(i));
                countryTo.getItems().add(airportList.getCountry(i));
            }

        }
        countryFrom.setPromptText("Select country");
        countryTo.setPromptText("Select country");
        departureHourBox.getItems().setAll(makeStringArray(12));
        arrivalHourBox.getItems().setAll(makeStringArray(12));
        departureMinutesBox.getItems().setAll(makeStringArray(59));
        arrivalMinutesBox.getItems().setAll(makeStringArray(59));
    }
    public void setItems(ObservableList <Flight> items) {
        this.items= items;
    }


    public void goBack(ActionEvent actionEvent) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void register(ActionEvent actionEvent) {
    }

    public void addCrew(ActionEvent actionEvent) throws IOException{
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add Crew");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../View/FXML/Administrator/Add/A_Flight_Crew.fxml")));
        window.setScene(new Scene(loader.load()));
        A_Flight_Crew controller = loader.getController();
        controller.setItems(crew.getCrewMembers());
        window.showAndWait();
    }

    public void getAirportsFrom() {
        airportFrom.getItems().clear();
        String country = countryFrom.getSelectionModel().getSelectedItem();
        for(int i=0; i<airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportFrom.getItems().add(airportList.getAirports().get(i));
            }
        }
    }

    public void getAirportsTo() {
        airportTo.getItems().clear();
        String country = countryTo.getSelectionModel().getSelectedItem();
        for(int i=0; i<airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportTo.getItems().add(airportList.getAirports().get(i));
            }
        }
        airportTo.getItems().remove(airportFrom.getSelectionModel().getSelectedItem());
    }

    public void addFlightButtonPressed() {
        Flight toBeAdded = new Flight(flightNumberField.getText(),departureDateField.getValue(),
                LocalTime.of(Integer.parseInt(departureHourBox.getSelectionModel().getSelectedItem())
                        ,Integer.parseInt(departureMinutesBox.getSelectionModel().getSelectedItem()),0)
                ,arrivalDateField.getValue(),LocalTime.of(Integer.parseInt(arrivalHourBox.getSelectionModel().getSelectedItem())
                ,Integer.parseInt(arrivalMinutesBox.getSelectionModel().getSelectedItem()),0),
                flightNumberField.getText(),airportFrom.getSelectionModel().getSelectedItem(),airportTo.getSelectionModel().getSelectedItem(),"inactive",150);
        System.out.println("flight to be added: "+toBeAdded.toString());
        items.add(toBeAdded);
        adapter.addFlight(toBeAdded);
        flightList.updateList(items);
    }

    private String[] makeStringArray(int until) {
        String[] array = new String[until+1];
        for (int i=0; i<array.length;i++) {
            if (i<10) {
                array[i] = "0"+i;
            }
            else {
                array[i] = i+"";
            }
        }
        return array;
    }


}
