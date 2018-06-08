package Controller.Edit;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class E_Airplane implements Initializable {

    @FXML AnchorPane editAirplanesPanel;
    @FXML TextField idField;
    @FXML TextField modelField;
    @FXML TextField seatsField;
    @FXML DatePicker purchaseDateField;
    @FXML DatePicker lastMaintenanceField;
    private Airplane airplane;
    private ObservableList<Airplane> airplanes;
    private AirplaneList airplaneList;
    DatabaseAdapter adapter= new DatabaseAdapter();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Airplane airplane, AirplaneList airplaneList) {
        this.airplane = airplane;
        this.airplaneList = airplaneList;
        this.airplanes = airplaneList.getAirplanes();
        idField.setText(airplane.getIDNumber());
        modelField.setText(airplane.getModel());
        seatsField.setText(airplane.getNumberOfSeats()+"");
        purchaseDateField.setValue(airplane.getPurchaseDate());
        lastMaintenanceField.setValue(airplane.getLastMaintenance());
    }
    public void confirmButtonPressed() {
        airplanes.remove(airplane);
        Airplane temp = new Airplane(idField.getText(), modelField.getText(), Integer.parseInt(seatsField.getText()), purchaseDateField.getValue(), lastMaintenanceField.getValue());
        adapter.updateAirplane(temp);
        airplanes.add(temp);
        Stage stage = (Stage) editAirplanesPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editAirplanesPanel.getScene().getWindow();
        stage.close();
    }


}
