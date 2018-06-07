package Controller;

import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
import Domain.Model.Airport;
import Domain.Model.AirportList;
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

public class AddAirportFormController implements Initializable {
    @FXML AnchorPane anchorPane;
    @FXML TextField code;
    @FXML TextField name;
    @FXML TextField city;
    @FXML TextField postcode;
    @FXML TextField country;
    @FXML TextField numberOfGates;
    ObservableList<Airport> items;
    public AirportList airportList= new AirportList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList <Airport> items) {
        this.items= items;
    }
    public void addAirportFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addAirportToTheList(ActionEvent actionEvent) {
        items.add(new Airport(code.getText(), name.getText(), city.getText(), postcode.getText(), country.getText(), Integer.parseInt(numberOfGates.getText())));

        airportList.updateList(items);

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }
}
