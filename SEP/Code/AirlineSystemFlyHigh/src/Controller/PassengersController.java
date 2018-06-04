package Controller;

import Domain.Model.Crew;
import Domain.Model.CrewMember;
import Domain.Model.Passenger;
import Domain.Model.PassengerList;
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
    @FXML
    AnchorPane anchorPane;
    @FXML protected TableView<Passenger> passengerTable;
    @FXML protected TableColumn<Passenger, String> name;
    @FXML protected TableColumn<Passenger, String> id;
    @FXML protected TableColumn<Passenger, String> idType;
    @FXML protected TableColumn<Passenger, String> nationality;
    @FXML protected TableColumn<Passenger, LocalDate> birthdate;
    @FXML protected TableColumn<Passenger, Integer> phoneNumber;
    @FXML protected TableColumn<Passenger, String> email;
    @FXML protected TableColumn<Passenger, Integer> seatNo;
    @FXML protected TableColumn<Passenger, Integer> luggageSize;
    @FXML protected TableColumn<Passenger, String> paymentMethod;
    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @FXML
    Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setCellValueFactory(new PropertyValueFactory<Passenger, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<Passenger, String>("id"));
        idType.setCellValueFactory(new PropertyValueFactory<Passenger, String>("idType"));
        nationality.setCellValueFactory(new PropertyValueFactory<Passenger, String>("nationality"));
        birthdate.setCellValueFactory(new PropertyValueFactory<Passenger, LocalDate>("birthdate"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<Passenger, String>("email"));
        seatNo.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("seatNo"));
        luggageSize.setCellValueFactory(new PropertyValueFactory<Passenger, Integer>("luggaeSize"));
        paymentMethod.setCellValueFactory(new PropertyValueFactory<Passenger, String>("paymentMethod"));


        passengers= new PassengerList();
        passengerTable.setItems(passengers.getPassengers();

        makeFilteredList(passengers.getPassengers();

    }

    //Associate data with column



    public void makeFilteredList(ObservableList<CrewMember> list){
        FilteredList<CrewMember> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(crewMember -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(crewMember.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<CrewMember> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(crewMembersTable.comparatorProperty());
        crewMembersTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        ObservableList<CrewMember> crewMembers= crew.getCrewMembers();
        ObservableList<CrewMember> selected= crewMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(crewMembers::remove);
        makeFilteredList(crewMembers);
        crew.updateList(crewMembers);

    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }

    public void editButtonPressed() throws IOException {
        CrewMember selectedCrewMember = crewMembersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../View/FXML/Administrator/EditCrewMemberForm.fxml"));
        loader.load();
        EditCrewMemberController controller = loader.getController();
        controller.initData(selectedCrewMember,crew);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Crew Member");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }


    // SEE CREW

    public void seeCrewGoBack(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/ManageCrewMembers.fxml"))));
    }
}
