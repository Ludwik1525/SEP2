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
    ObservableList<Airplane> items;
    public Model modelManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelManager = new ModelManager();
    }
    public void setItems(ObservableList <Airplane> items) {
        this.items= items;
    }
    public void addAirplaneFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addAirplaneToTheList(ActionEvent actionEvent) {
        modelManager.addAirplane(new Airplane(addIDNumber.getText(), addModel.getText(),
                Integer.parseInt(addNumberOfSeats.getText()), addPurchaseDate.getValue(), addLastMaintenance.getValue()));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Manage/M_Airplanes.fxml"));
            loader.load();
            M_Airplanes controller = loader.getController();
            controller.refreshTable(modelManager.getAirplanes().getAirplanes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.close();
    }



}
