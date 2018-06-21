package Controller.Edit;

import Controller.Manage.M_Airplanes;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class E_Airplane implements Initializable {

    @FXML AnchorPane editAirplanesPanel;
    @FXML TextField idField;
    @FXML TextField modelField;
    @FXML TextField seatsField;
    @FXML DatePicker purchaseDateField;
    @FXML DatePicker lastMaintenanceField;
    private Model modelManager;
    private M_Airplanes controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(M_Airplanes controller, Model modelManager) {
       this.controller = controller;
       this.modelManager = modelManager;
       idField.setText(controller.getSelectedAirplane().getIDNumber());
       modelField.setText(controller.getSelectedAirplane().getModel());
       seatsField.setText(controller.getSelectedAirplane().getNumberOfSeats()+"");
       purchaseDateField.setValue(controller.getSelectedAirplane().getPurchaseDate());
       lastMaintenanceField.setValue(controller.getSelectedAirplane().getLastMaintenance());
    }
    public void confirmButtonPressed() {
        modelManager.getAirplanes().getAirplanes().remove(controller.getSelectedAirplane());
        modelManager.getAirplanes().getAirplanes().add(new Airplane(idField.getText(), modelField.getText(),
                Integer.parseInt(seatsField.getText()), purchaseDateField.getValue(), lastMaintenanceField.getValue()));
        modelManager.updateAirplane(new Airplane(idField.getText(), modelField.getText(),
                Integer.parseInt(seatsField.getText()), purchaseDateField.getValue(), lastMaintenanceField.getValue()));

        Stage stage = (Stage) editAirplanesPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editAirplanesPanel.getScene().getWindow();
        stage.close();
    }


}
