package Controller;

import Domain.Model.Flight;
import Domain.Model.Passenger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class BookFlightFormController implements Initializable {

    @FXML AnchorPane anchorPane;
    @FXML TextField nameField;
    @FXML TextField idNumberField;
    @FXML ComboBox<String> idTypeBox = new ComboBox<>();
    @FXML TextField nationalityField;
    @FXML DatePicker birthdateField;
    @FXML TextField phoneNumberField;
    @FXML TextField emailField;
    @FXML ComboBox<String> seatNoBox = new ComboBox<>();
    @FXML TextField luggageSizeField;
    private Flight flight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idTypeBox.setItems(FXCollections.observableArrayList("Passport","ID"));
        seatNoBox.setItems(FXCollections.observableArrayList("1","16","22"));
    }

    public void initData(Flight flight) {
        this.flight = flight;
        System.out.println(flight);
    }

    public void confirmButtonPressed() {
        Passenger toBeAdded = new Passenger(nameField.getText(), idNumberField.getText()
                , idTypeBox.getSelectionModel().getSelectedItem(),nationalityField.getText(),birthdateField.getValue()
                ,Integer.parseInt(phoneNumberField.getText()), emailField.getText(), Integer.parseInt(seatNoBox.getSelectionModel().getSelectedItem())
                , Integer.parseInt(luggageSizeField.getText()),"Bank Transfer");

        System.out.println(toBeAdded);
        flight.addPasanger(toBeAdded);
        System.out.println("Booking successful");

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
        System.out.println(flight.getPassengers().getPassengers().get(0));
    }

    public void cancelButtonPressed() {

    }




}
