package Controller.Manage;

import Controller.Edit.E_CrewMember;
import Domain.Mediator.DatabaseAdapter;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import Controller.Add.A_CrewMember;

public class M_CrewMembers implements Initializable {

    private Model modelManager;
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

    @FXML
    Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;
    @FXML Button editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.modelManager = new ModelManager();

        name.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("name"));
        position.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("position"));
        address.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("address"));
        id.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("id"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<CrewMember, String>("email"));
        birthday.setCellValueFactory(new PropertyValueFactory<CrewMember, LocalDate>("birthdate"));

        crewMembersTable.setItems(modelManager.getCrewMembers().getCrewMembers());

        makeFilteredList(modelManager.getCrewMembers().getCrewMembers());
    }

    //Associate data with column

    public void addCrewMemberButtonPressed() throws IOException {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New Crew Member Form");
        FXMLLoader loader = new FXMLLoader((getClass().getResource("../../View/FXML/Administrator/Add/A_CrewMember.fxml")));
        window.setScene(new Scene(loader.load()));
        A_CrewMember controller = loader.getController();
        controller.setItems(this, modelManager);
        window.showAndWait();
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
        editButton.setVisible(true);
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeCrewMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        CrewMember selected = crewMembersTable.getSelectionModel().getSelectedItem();
        modelManager.removeCrewMember(selected);
        crewMembersTable.setItems(modelManager.getCrewMembers().getCrewMembers());
        makeFilteredList(modelManager.getCrewMembers().getCrewMembers());
    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }

    public void editButtonPressed() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Edit/E_CrewMember.fxml"));
        loader.load();
        E_CrewMember controller = loader.getController();
        controller.initData(this,modelManager);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Crew Member");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
    public CrewMember getSelectedMember() {
        return crewMembersTable.getSelectionModel().getSelectedItem();
    }
}
