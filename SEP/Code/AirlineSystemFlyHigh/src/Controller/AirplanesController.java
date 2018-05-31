package Controller;

import Domain.Model.Airplane;
import Domain.Model.AirplaneList;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AirplanesController implements Initializable {

    @FXML AnchorPane anchorPane;

    AirplaneList airplaneList;

    @FXML protected TableView<Airplane> airplanesTable;
    @FXML protected TableColumn<Airplane, String> IDNumber;
    @FXML protected TableColumn<Airplane, String> model;
    @FXML protected TableColumn<Airplane, String> numberOfSeats;
    @FXML  protected TableColumn<Airplane, LocalDate> purchaseDate;
    @FXML  protected TableColumn<Airplane, LocalDate> lastMaintenance;
    @FXML private Button remove;
    @FXML private TextField searchField;
    @FXML Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        IDNumber.setCellValueFactory(new PropertyValueFactory<Airplane, String>("IDNumber"));
        model.setCellValueFactory(new PropertyValueFactory<Airplane, String>("model"));
        numberOfSeats.setCellValueFactory(new PropertyValueFactory<Airplane, String>("numberOfSeats"));
        purchaseDate.setCellValueFactory(new PropertyValueFactory<Airplane, LocalDate>("purchaseDate"));
        lastMaintenance.setCellValueFactory(new PropertyValueFactory<Airplane, LocalDate>("lastMaintenance"));

        airplaneList= new AirplaneList();
        airplanesTable.setItems(airplaneList.getAirplanes());

//        airplanesTable.setEditable(true);
//        IDNumber.setCellFactory(TextFieldTableCell.forTableColumn());
//        model.setCellFactory(TextFieldTableCell.forTableColumn());
//        numberOfSeats.setCellFactory(TextFieldTableCell.forTableColumn());
//
//        airplanesTable.getColumns().clear();
//        airplanesTable.getColumns().addAll(IDNumber, model, numberOfSeats, purchaseDate, lastMaintenance);

    }

    //Associate data with column

    public void addAirplaneButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Airplane Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddAirplaneForm.fxml")));
        window.setScene(new Scene(loader.load()));
        AddAirplaneFormController controller = loader.getController();
        controller.setItems(airplaneList.getAirplanes());
        window.showAndWait();
    }


    public void makeFilteredList(ObservableList<Airplane> list){
        FilteredList <Airplane> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(airplane -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(airplane.getIDNumber().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Airplane> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(airplanesTable.comparatorProperty());
        airplanesTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        remove.setVisible(true);
    }


    public void ManageAirplanesGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }
    public void removeAirplaneButtonPressed() throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        ObservableList<Airplane> airplanes= airplaneList.getAirplanes();
        ObservableList<Airplane> selected= airplanesTable.getSelectionModel().getSelectedItems();
        selected.forEach(airplanes::remove);
        makeFilteredList(airplanes);
        airplaneList.updateList(airplanes);

    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }
//    public void changeIDNumberEvent(CellEditEvent editedCell){
//        Airplane airplane= airplanesTable.getSelectionModel().getSelectedItem();
//        airplane.setIDNumber(editedCell.getNewValue().toString());
//
//        airplaneList.updateList(airplanesTable.getItems());
//    }


    public void editButtonPressed() throws IOException  {
        Airplane selectedAirplane = airplanesTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/FXML/Administrator/EditAirplaneForm.fxml"));
        loader.load();
        EditAirplaneController controller = loader.getController();
        controller.initData(selectedAirplane,airplaneList);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit airplane");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }



}
