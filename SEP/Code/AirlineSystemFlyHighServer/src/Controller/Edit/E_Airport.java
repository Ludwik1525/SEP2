package Controller.Edit;

import Controller.Manage.M_Airports;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
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

public class E_Airport implements Initializable {

    @FXML AnchorPane editAirportPanel;
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

    public void initData(M_Airports controller, Model modelManager) {
        this.controller = controller;
        this.modelManager = modelManager;
        codeField.setText(controller.getSelectedAirport().getCode());
        nameField.setText(controller.getSelectedAirport().getName());
        cityField.setText(controller.getSelectedAirport().getCity());
        postcodeField.setText(controller.getSelectedAirport().getPostcode());
        countryField.setText(controller.getSelectedAirport().getCountry());
        numberOfGatesField.setText(controller.getSelectedAirport().getNumberOfGates()+"");
    }

    public void confirmButtonPressed() {
        modelManager.getAirports().getAirports().remove(controller.getSelectedAirport());

        modelManager.getAirports().getAirports().add(new Airport(codeField.getText(), nameField.getText(), cityField.getText(),postcodeField.getText()
                        , countryField.getText(), Integer.parseInt(numberOfGatesField.getText())));

        modelManager.updateAirport(new Airport(codeField.getText(), nameField.getText(), cityField.getText(),postcodeField.getText()
                , countryField.getText(), Integer.parseInt(numberOfGatesField.getText())));

        Stage stage = (Stage) editAirportPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editAirportPanel.getScene().getWindow();
        stage.close();
    }
}
