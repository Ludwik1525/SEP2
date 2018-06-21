package Controller.Add;

import Controller.Manage.M_Airplanes;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class A_Airplane implements Initializable{

    @FXML AnchorPane anchorPane;
    @FXML TextField addIDNumber;
    @FXML TextField addModel;
    @FXML TextField addNumberOfSeats;
    @FXML DatePicker addPurchaseDate;
    @FXML DatePicker addLastMaintenance;
    private Model modelManager;
    private M_Airplanes controller;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(M_Airplanes controller,Model modelManager) {
        this.controller = controller;
        this.modelManager = modelManager;
    }
    public void addAirplaneFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void addAirplaneToTheList(ActionEvent actionEvent) {
        modelManager.getAirplanes().getAirplanes().add(new Airplane(addIDNumber.getText(), addModel.getText(),
                Integer.parseInt(addNumberOfSeats.getText()), addPurchaseDate.getValue(), addLastMaintenance.getValue()));

        modelManager.addAirplane(new Airplane(addIDNumber.getText(), addModel.getText(),
                Integer.parseInt(addNumberOfSeats.getText()), addPurchaseDate.getValue(), addLastMaintenance.getValue()));

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }



}
