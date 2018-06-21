package Controller.Manage;

import Controller.Controller;
import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Controller.PassengersFormController;

public class M_Passengers implements Initializable {

    private Model modelManager;
    @FXML AnchorPane managePassengersPanel;
    @FXML protected TableView<Passenger> passengersTable;
    @FXML protected TableColumn<Passenger, String> nameColumn;
    @FXML protected TableColumn<Passenger, String> idColumn;
    @FXML protected TableColumn<Passenger, String> idTypeColumn;
    @FXML protected TableColumn<Passenger, String> nationalityColumn;
    @FXML protected TableColumn<Passenger, LocalDate> birthdateColumn;
    @FXML protected TableColumn<Passenger, Integer> phoneNumberColumn;
    @FXML protected TableColumn<Passenger, String> emailColumn;
    @FXML protected TableColumn<Passenger, Integer> seatNumberColumn;
    @FXML protected TableColumn<Passenger, Integer> luggageSizeColumn;
    @FXML protected TableColumn<Passenger, String> paymentMethodColumn;
    @FXML private TextField searchField;
    private M_Flights controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initData(Flight flight) {

        this.modelManager = new ModelManager();

        nameColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("id"));
        idTypeColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("idType"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("nationality"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<Passenger, LocalDate>("birthdate"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("email"));
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("seatNo"));
        luggageSizeColumn.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("luggageSize"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("paymentMethod"));


        System.out.println(modelManager.getFlights().getFlights().get(1).getPassengers().getPassengers());
        passengersTable.setItems(modelManager.getFlights().getFlights().get(1).getPassengers().getPassengers());
        makeFilteredList(modelManager.getFlights().getFlights().get(1).getPassengers().getPassengers());
    }



    public void makeFilteredList(ObservableList<Passenger> list){
        FilteredList<Passenger> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(passenger -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(passenger.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<Passenger> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(passengersTable.comparatorProperty());
        passengersTable.setItems(sortedList);
    }

    public void detailsButtonPressed() throws IOException {
        Passenger selectedPassenger = passengersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/PassengerDetailsForm.fxml"));
        loader.load();
        PassengersFormController controller = loader.getController();
        controller.initData(selectedPassenger,modelManager.getPassengers());
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Passenger details");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }

    public void goBack(ActionEvent actionEvent) throws IOException{
        Stage stage = (Stage) managePassengersPanel.getScene().getWindow();
        stage.close();

    }
}
