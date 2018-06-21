package Controller.Add;

import Controller.Manage.M_Airports;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.Airport;
import Domain.Model.AirportList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A_Airport implements Initializable {
    @FXML AnchorPane anchorPane;
    @FXML TextField codeField;
    @FXML TextField nameField;
    @FXML TextField cityField;
    @FXML TextField postcodeField;
    @FXML TextField countryField;
    @FXML TextField numberOfGatesField;
    private M_Airports controller;
    private Model modelManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    public void setItems(M_Airports controller, Model modelManager) {
        this.controller = controller;
        this.modelManager = modelManager;
    }
    public void addAirportFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addAirportToTheList(ActionEvent actionEvent) {
        modelManager.getAirports().getAirports().add(new Airport(codeField.getText(), nameField.getText(), cityField.getText(),postcodeField.getText()
                , countryField.getText(), Integer.parseInt(numberOfGatesField.getText())));

        modelManager.addAirport(new Airport(codeField.getText(), nameField.getText(), cityField.getText(),postcodeField.getText()
                , countryField.getText(), Integer.parseInt(numberOfGatesField.getText())));

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }
}
