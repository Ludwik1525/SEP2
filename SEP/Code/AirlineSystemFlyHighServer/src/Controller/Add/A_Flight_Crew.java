package Controller.Add;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class A_Flight_Crew implements Initializable {
    @FXML
    AnchorPane addCrew;
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
    Crew crew= new Crew();
    ObservableList<CrewMember> items;
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

        makeFilteredList(crew.getCrewMembers());
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
    public void setItems(ObservableList <CrewMember> items) {
        this.items= items;
    }

    public void goBack(ActionEvent actionEvent) {
            Stage stage = (Stage) addCrew.getScene().getWindow();
            stage.close();

    }
}
