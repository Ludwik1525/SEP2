package Controller;

import Domain.Model.Airplane;
import Domain.Model.AirplaneList;
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

public class AddAirplaneFormController implements Initializable{

    @FXML AnchorPane anchorPane;
    @FXML TextField addIDNumber;
    @FXML TextField addModel;
    @FXML TextField addNumberOfSeats;
    @FXML DatePicker addPurchaseDate;
    @FXML DatePicker addLastMaintenance;
    ObservableList<Airplane> items;
    public AirplaneList airplaneList= new AirplaneList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList <Airplane> items) {
        this.items= items;
    }
    public void addAirplaneFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addAirplaneToTheList(ActionEvent actionEvent) {
        items.add(new Airplane(addIDNumber.getText(), addModel.getText(), addNumberOfSeats.getText(), addPurchaseDate.getValue(), addLastMaintenance.getValue()));

        airplaneList.updateList(items);

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }



}
