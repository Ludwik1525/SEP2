package Controller;

import Domain.Model.Flight;
import Domain.Model.Passenger;
import Domain.Model.PassengerList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PassengersFormController implements Initializable {

    @FXML AnchorPane passengerDetailsPanel;
    @FXML TextField nameField;
    @FXML TextField idTypeField;
    @FXML TextField idNumberField;
    @FXML TextField nationalityField;
    @FXML TextField birthdateField;
    @FXML TextField phoneNumberField;
    @FXML TextField emailField;
    @FXML TextField seatNumberField;
    @FXML TextField luggageSizeField;
    @FXML TextField paymentMethodField;
    private Passenger passenger;
    private PassengerList passengerList;
    private ObservableList<Passenger> passengers;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Passenger passenger, PassengerList passengerList) {
        this.passenger = passenger;
        this.passengerList = passengerList;
        this.passengers = passengerList.getPassengers();
        nameField.setText(passenger.getName());
        idTypeField.setText(passenger.getIdType());
        idNumberField.setText(passenger.getId());
        nationalityField.setText(passenger.getNationality());
        birthdateField.setText(passenger.getBirthday().toString());
        phoneNumberField.setText(String.valueOf(passenger.getPhoneNumber()));
        emailField.setText(passenger.getEmail());
        seatNumberField.setText(String.valueOf(passenger.getSeatNo()));
        luggageSizeField.setText(passenger.getLuggageSize()+"");
        paymentMethodField.setText(passenger.getPaymentMethod());
    }

    public void okButtonPressed() {
        Stage stage = (Stage) passengerDetailsPanel.getScene().getWindow();
        stage.close();
    }
}
