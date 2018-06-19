package Controller.Manage;

import Controller.Edit.E_Airplane;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Controller.Add.A_Airplane;

public class M_Airplanes implements Initializable {

    @FXML AnchorPane anchorPane;
    @FXML public TableView<Airplane> airplanesTable;
    @FXML protected TableColumn<Airplane, String> IDNumberField;
    @FXML protected TableColumn<Airplane, String> modelField;
    @FXML protected TableColumn<Airplane, Integer> numberOfSeatsField;
    @FXML protected TableColumn<Airplane, LocalDate> purchaseDateField;
    @FXML protected TableColumn<Airplane, LocalDate> lastMaintenanceField;
    @FXML private Button remove;
    @FXML private TextField searchField;
    @FXML Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;
    @FXML Button editButton;

    private Model modelManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        modelManager = new ModelManager();

        IDNumberField.setCellValueFactory(new PropertyValueFactory<Airplane, String>("IDNumber"));
        modelField.setCellValueFactory(new PropertyValueFactory<Airplane, String>("model"));
        numberOfSeatsField.setCellValueFactory(new PropertyValueFactory<Airplane, Integer>("numberOfSeats"));
        purchaseDateField.setCellValueFactory(new PropertyValueFactory<Airplane, LocalDate>("purchaseDate"));
        lastMaintenanceField.setCellValueFactory(new PropertyValueFactory<Airplane, LocalDate>("lastMaintenance"));

        airplanesTable.setItems(modelManager.getAirplanes().getAirplanes());
        makeFilteredList(modelManager.getAirplanes().getAirplanes());

    }

    //Associate data with column

    public void addAirplaneButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Airplane Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../View/FXML/Administrator/Add/A_Airplane.fxml")));
        window.setScene(new Scene(loader.load()));
        A_Airplane controller = loader.getController();
        controller.setItems(modelManager.getAirplanes().getAirplanes());
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
        editButton.setVisible(true);
    }


    public void ManageAirplanesGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }
    public void removeAirplaneButtonPressed() throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        Airplane selected = airplanesTable.getSelectionModel().getSelectedItem();
        modelManager.removeAirplane(selected);
        airplanesTable.setItems(modelManager.getAirplanes().getAirplanes());
        makeFilteredList(modelManager.getAirplanes().getAirplanes());
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
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Edit/E_Airplane.fxml"));
        loader.load();
        E_Airplane controller = loader.getController();
        controller.initData(selectedAirplane,modelManager.getAirplanes());
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit airplane");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }

    public void refreshTable(ObservableList<Airplane> airplanes) {
        airplanesTable.setItems(airplanes);
    }



}
