package Controller;

import Domain.Model.Airport;
import Domain.Model.AirportList;
import Domain.Model.Flight;
import Domain.Model.FlightList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddFlightFormController implements Initializable {
    @FXML AnchorPane anchorPane;
    @FXML TextField numberField;
    @FXML TextField departureTimeField;
    @FXML TextField arrivalTimeField;
    @FXML TextField departurePlaceField;
    @FXML TextField arrivalPlaceField;
    @FXML TextField statusField;

    ObservableList<Flight> items;
    FlightList flightList= new FlightList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList <Flight> items) {
        this.items= items;
    }
    public void addAirportFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

//    public void addAirportToTheList(ActionEvent actionEvent) {
//        items.add(new Flight(numberField.getText(), departureTimeField.getText(), arrivalTimeField.getText()
//        , )));
//        airportList.updateList(items);
//        Stage stage = (Stage) anchorPane.getScene().getWindow();
//        stage.close();
//
//    }

    public void goBack(ActionEvent actionEvent) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void register(ActionEvent actionEvent) {
    }
}
