package Controller.Add;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A_Flight implements Initializable {
    @FXML AnchorPane anchorPane;
    @FXML TextField numberField;
    @FXML TextField departureTimeField;
    @FXML TextField arrivalTimeField;
    @FXML TextField departurePlaceField;
    @FXML TextField arrivalPlaceField;
    @FXML TextField statusField;


    Crew crew= new Crew();

    private Flight flight;
    @FXML AnchorPane departureAirport;
    @FXML AnchorPane arrivalAirport;
    @FXML ChoiceBox<String> countryFrom = new ChoiceBox<>();
    @FXML ChoiceBox<String> airportFrom = new ChoiceBox<>();
    @FXML ChoiceBox<String> countryTo = new ChoiceBox<>();
    @FXML ChoiceBox<String> airportTo = new ChoiceBox<>();
    @FXML ChoiceBox<String> departureHourBox = new ChoiceBox<>();
    @FXML ChoiceBox<String> departureMinutesBox = new ChoiceBox<>();
    @FXML ChoiceBox<String> arrivalHourBox = new ChoiceBox<>();
    @FXML ChoiceBox<String> arrivalMinutesBox = new ChoiceBox<>();

    AirportList airportList = new AirportList();

    ObservableList<Flight> items;
    FlightList flightList= new FlightList();

    @Override
    public void initialize(URL location, ResourceBundle resources) { ;
        departureHourBox.getItems().setAll(makeStringArray(12));
        arrivalHourBox.getItems().setAll(makeStringArray(12));
        departureMinutesBox.getItems().setAll(makeStringArray(59));
        arrivalMinutesBox.getItems().setAll(makeStringArray(59));
        showArrivalAirports();
        showDepartureAirports();
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
    public void showArrivalAirports() {
        arrivalAirport.setVisible(true);
        getAirports();
    }

    public void showDepartureAirports() {
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
