package Controller;

import Domain.Model.Crew;
import Domain.Model.CrewMember;
import Domain.Model.Flight;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ManageCrewMembersFlightController implements Initializable {

    Flight flight;
    Crew crew;
    @FXML
    AnchorPane anchorPane;
    @FXML
    protected TableView<CrewMember> crewMembersTable;
    @FXML
    protected TableColumn<CrewMember, String> name;
    @FXML
    protected TableColumn<CrewMember, String> position;
    @FXML
    protected TableColumn<CrewMember, String> address;
    @FXML
    protected TableColumn<CrewMember, String> id;
    @FXML
    protected TableColumn<CrewMember, String> phoneNumber;
    @FXML
    protected TableColumn<CrewMember, String> email;
    @FXML
    protected TableColumn<CrewMember, LocalDate> birthday;
    @FXML
    private Button removeButton;
    @FXML
    private TextField searchField;

    @FXML
    Label confirmationLabel;
    @FXML
    Button forsake;
    @FXML
    Button confirm;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Flight flight) {
        this.flight = flight;

        name.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("name"));
        position.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("position"));
        address.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("address"));
        id.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("id"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("email"));
        birthday.setCellValueFactory(new PropertyValueFactory<CrewMember, LocalDate>("birthdate"));

        crew = flight.getCrew();
        crewMembersTable.setItems(crew.getCrewMembers());

//        makeFilteredList(crew.getCrewMembers());

    }

    public void removeCrewMemberButtonPressed() throws IOException {
        ObservableList<CrewMember> crewMembers = crew.getCrewMembers();
        ObservableList<CrewMember> selected = crewMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(crewMembers::remove);
        makeFilteredList(crewMembers);
        crew.updateList(crewMembers);
    }

    public void makeFilteredList(ObservableList<CrewMember> list) {
        FilteredList<CrewMember> filteredList = new FilteredList<>(list, p -> true);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(crewMember -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                if (crewMember.getName().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                }
                return false;
            });
        });
        SortedList<CrewMember> sortedList = new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(crewMembersTable.comparatorProperty());
        crewMembersTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
    }

    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }

    public void confirmButtonPressed(ActionEvent actionEvent) {
        ObservableList<CrewMember> crewMembers = crew.getCrewMembers();
        ObservableList<CrewMember> selected = crewMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(crewMembers::remove);
        makeFilteredList(crewMembers);
        crew.updateList(crewMembers);

    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }
}
