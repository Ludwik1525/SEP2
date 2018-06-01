package Controller;

import Domain.Model.Airport;
import Domain.Model.AirportList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditAirportController implements Initializable {

    @FXML AnchorPane editAirportPanel;
    @FXML TextField codeField;
    @FXML TextField nameField;
    @FXML TextField cityField;
    @FXML TextField postcodeField;
    @FXML TextField countryField;
    @FXML TextField numberOfGatesField;
    Airport airport;
    AirportList airportList;
    ObservableList<Airport> airports;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Airport airport, AirportList airportList) {
        this.airport = airport;
        this.airportList = airportList;
        this.airports = airportList.getAirports();
        codeField.setText(airport.getCode());
        nameField.setText(airport.getName());
        cityField.setText(airport.getCity());
        postcodeField.setText(airport.getPostcode());
        countryField.setText(airport.getCountry());
        numberOfGatesField.setText(airport.getNumberOfGates()+"");
    }

    public void confirmButtonPressed() {
        airports.remove(airport);
        airports.add(new Airport(codeField.getText(), nameField.getText(), cityField.getText(),postcodeField.getText()
                , countryField.getText(), Integer.parseInt(numberOfGatesField.getText())));
        Stage stage = (Stage) editAirportPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editAirportPanel.getScene().getWindow();
        stage.close();
    }
}
