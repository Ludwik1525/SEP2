package Controller.Manage;

import Controller.BookFlightController;
import Domain.Model.Airport;
import Domain.Model.AirportList;
import Domain.Model.Flight;
import Domain.Model.FlightList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class M_UserMain implements Initializable{
    @FXML AnchorPane anchorPane;
    @FXML AnchorPane personalInfo;
    @FXML private DatePicker returnDateField;
    @FXML private DatePicker departureDateField;
    @FXML private Label returnDateLabel;
    @FXML private Label airportFromLabel;
    @FXML private Label airportToLabel;
    @FXML ComboBox<String> countryFrom=new ComboBox<>();
    @FXML ComboBox <String> airportFrom=new ComboBox<>();
    @FXML ComboBox <String> countryTo=new ComboBox<>();
    @FXML ComboBox <String> airportTo=new ComboBox<>();

    AirportList airportList= new AirportList();
    FlightList flightList = new FlightList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i=0; i<airportList.getLength(); i++){
            countryFrom.getItems().add(airportList.getCountry(i));
            countryTo.getItems().add(airportList.getCountry(i));
        }
        countryFrom.setPromptText("Select country");
        countryTo.setPromptText("Select country");
        makeDates(departureDateField);
        makeDates(returnDateField);


    }

//    public void filterAirportsFrom(){
//        if(!countryFrom.getSelectionModel().isEmpty()){
//            airportFrom.getItems().clear();
//            for(int i=0; i<airportList.getLength();i++){
//                if(countryFrom.getValue().equals(airportList.getCountry(i))){
//                    airportFrom.getItems().add(airportList.getCity(i));
//                    System.out.println("added");
//                }
//            }
//        }
//    }
//    public void filterAirportsTo(){
//        if(!countryTo.getSelectionModel().isEmpty()){
//            airportTo.getItems().clear();
//            for(int i=0; i<airportList.getLength();i++) {
//                if (countryTo.getValue().equals(airportList.getCountry(i))) {
//                    airportTo.getItems().add(airportList.getCity(i));
//                }
//            }
//        }
//    }

    public void ReturnDateChangeVisibility() {
        if (returnDateField.isVisible() == true) {
            returnDateLabel.setVisible(false);
            returnDateField.setVisible(false);
        } else {
            returnDateLabel.setVisible(true);
            returnDateField.setVisible(true);
        }

    }

    public void UserMainGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/LogIn.fxml"))));
    }

    public void bookFlightButtonPressed(ActionEvent actionEvent) {
        personalInfo.setVisible(true);
    }

    public void initAirportsFrom() {
        airportFromLabel.setVisible(true);
        airportFrom.setVisible(true);
        airportFrom.getItems().clear();
        String country = countryFrom.getSelectionModel().getSelectedItem();
        for(int i=0; i<airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportFrom.getItems().add(airportList.getAirports().get(i).getShortInfo());
            }
        }

    }

    public void initAirportsTo() {
        airportToLabel.setVisible(true);
        airportTo.setVisible(true);
        airportTo.getItems().clear();
        String country = countryTo.getSelectionModel().getSelectedItem();
        for(int i=0; i<airportList.getLength(); i++) {
            if (airportList.getAirports().get(i).getCountry().equals(country)) {
                airportTo.getItems().add(airportList.getAirports().get(i).getShortInfo());
            }
        }
        airportTo.getItems().remove(airportFrom.getSelectionModel().getSelectedItem());
    }

    public void searchFlightButtonPressed() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../View/FXML/BookFlight.fxml"));
        loader.setController(new BookFlightController());

        BookFlightController controller = loader.getController();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(loader.load()));

        LocalDate departureDate = departureDateField.getValue();
        String departureAirport = airportFrom.getSelectionModel().getSelectedItem();
        String arrivalAirport = airportTo.getSelectionModel().getSelectedItem();

        System.out.println(departureAirport+arrivalAirport+departureDate);

        controller.parseData(departureDate,departureAirport,arrivalAirport);
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
    private boolean toDisable(LocalDate date) {
        for (int i = 0; i < flightList.getFlights().size(); i++) {
            return (!(date.equals(flightList.getFlights().get(i).getDepartureTime())));
        }
        return false;
    }
}
