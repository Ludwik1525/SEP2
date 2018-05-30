package Controller;

import Domain.Model.*;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

public class CrewMembersController implements Initializable {

    Crew crew;
    @FXML AnchorPane anchorPane;
    @FXML protected TableView<CrewMember> crewMembersTable;
    @FXML protected TableColumn<CrewMember, String> name;
    @FXML protected TableColumn<CrewMember, String> position;
    @FXML protected TableColumn<CrewMember, String> address;
    @FXML protected TableColumn<CrewMember, String> id;
    @FXML protected TableColumn<CrewMember, String> phoneNumber;
    @FXML protected TableColumn<CrewMember, String> email;
    @FXML protected TableColumn<CrewMember, LocalDate> birthday;
    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("name"));
        position.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("position"));
        address.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("address"));
        id.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("id"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("email"));
        birthday.setCellValueFactory(new PropertyValueFactory<CrewMember, LocalDate>("birthdate"));

        crew = new Crew();
        crewMembersTable.setItems(crew.getCrewMembers());

        crewMembersTable.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        position.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());

        crewMembersTable.getColumns().clear();
        crewMembersTable.getColumns().addAll( name, position, address, id, phoneNumber, email, birthday);

    }

    //Associate data with column

    public void addCrewMemberButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Crew Member Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddCrewMemberForm.fxml")));
        window.setScene(new Scene(loader.load()));
        AddCrewMemberController controller = loader.getController();
        controller.setItems(crew.getCrewMembers());
        window.showAndWait();
    }

    public void removeAirportButtonPressed() throws IOException {
        ObservableList<CrewMember> crewMembers= crew.getCrewMembers();
        ObservableList<CrewMember> selected= crewMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(crewMembers::remove);
        makeFilteredList(crewMembers);
        crew.updateList(crewMembers);

    }
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

    public void GoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        ObservableList<CrewMember> crewMembers= crew.getCrewMembers();
        ObservableList<CrewMember> selected= crewMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(crewMembers::remove);
        makeFilteredList(crewMembers);
        crew.updateList(crewMembers);
    }
}
