package Controller;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class PassengersController implements Initializable {


    PassengerList passengers;
    @FXML AnchorPane managePassengersPanel;
    @FXML protected TableView<Passenger> passengersTable;
    @FXML protected TableColumn<Passenger, String> nameColumn;
    @FXML protected TableColumn<Passenger, String> idColumn;
    @FXML protected TableColumn<Passenger, String> idTypeColumn;
    @FXML protected TableColumn<Passenger, String> nationalityColumn;
    @FXML protected TableColumn<Passenger, LocalDate> birthdateColumn;
    @FXML protected TableColumn<Passenger, String> phoneNumberColumn;
    @FXML protected TableColumn<Passenger, String> emailColumn;
    @FXML protected TableColumn<Passenger, String> seatNumberColumn;
    @FXML protected TableColumn<Passenger, Integer> luggageSizeColumn;
    @FXML protected TableColumn<Passenger, String> paymentMethodColumn;
    @FXML private TextField searchField;
    private Flight flight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initData(Flight flight) {
        this.flight = flight;
        nameColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("id"));
        idTypeColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("idType"));
        nationalityColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("nationality"));
        birthdateColumn.setCellValueFactory(new PropertyValueFactory<Passenger, LocalDate>("birthdate"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("email"));
        seatNumberColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("seatNo"));
        luggageSizeColumn.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("luggageSize"));
        paymentMethodColumn.setCellValueFactory(new PropertyValueFactory<Passenger, String>("paymentMethod"));

        passengers = flight.getPassengers();
        passengersTable.setItems(passengers.getPassengers());

        makeFilteredList(passengers.getPassengers());
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

//    public void removeButtonAppear(MouseEvent mouseEvent) {
//        removeButton.setVisible(true);
//    }
//
//    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) throws IOException {
//        confirmationLabel.setVisible(true);
//        forsake.setVisible(true);
//        confirm.setVisible(true);
//    }
//    public void confirmButtonPressed(ActionEvent actionEvent) {
//        ObservableList<Passenger> allPassengers= passengers.getPassengers();
//        ObservableList<Passenger> selected= passengersTable.getSelectionModel().getSelectedItems();
//        selected.forEach(allPassengers::remove);
//        makeFilteredList(allPassengers);
//        passengers.setPassengers(allPassengers);
//
//    }
//
//    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
//        confirmationLabel.setVisible(false);
//        forsake.setVisible(false);
//        confirm.setVisible(false);
//    }

    public void detailsButtonPressed() throws IOException {
        Passenger selectedPassenger = passengersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/FXML/Administrator/PassengerDetailsForm.fxml"));
        loader.load();
        PassengersFormController controller = loader.getController();
        controller.initData(selectedPassenger,passengers);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Passenger details");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }

}
