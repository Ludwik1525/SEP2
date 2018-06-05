package Controller.Manage;

import Controller.Edit.E_ClubMember;
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

public class M_ClubMembers implements Initializable {
    @FXML
    AnchorPane anchorPane;

    ClubMemberList clubMemberList;

    @FXML private TableView<ClubMember> clubMembersTable;
    @FXML private TableColumn<ClubMember, String> nameColumn;
    @FXML private TableColumn<ClubMember, LocalDate> birthdayColumn;
    @FXML private TableColumn<ClubMember, String> phoneNumberColumn;
    @FXML private TableColumn<ClubMember, String> emailColumn;
    @FXML private TableColumn<ClubMember, LocalDate> membershipDateColumn;
    @FXML private TableColumn<ClubMember, String> addressColumn;
//    @FXML private TableColumn<ClubMember, String> sub;
    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @FXML
    Label confirmationLabel;
    @FXML Button forsake;
    @FXML Button confirm;
    @FXML Button editButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("name"));
        birthdayColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, LocalDate>("birthday"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("phoneNumber"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("email"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("address"));
        membershipDateColumn.setCellValueFactory(new PropertyValueFactory<ClubMember, LocalDate>("membershipDate"));
       // sub.setCellFactory(new PropertyValueFactory<ClubMember, String>("Subscription"));

        clubMemberList= new ClubMemberList();
        clubMembersTable.setItems(clubMemberList.getClubMembers());

        makeFilteredList(clubMemberList.getClubMembers());


    }


//    public void addAirportButtonPressed() throws IOException {
//        Stage window = new Stage();
//        window.initModality(Modality.APPLICATION_MODAL);
//        window.setTitle("Add New Airport Form");
//        FXMLLoader loader = new FXMLLoader((getClass().getResource("../View/FXML/Administrator/AddClubMemberForm.fxml")));
//        window.setScene(new Scene(loader.load()));
//        Add controller = loader.getController();
//        controller.setItems(clubMemberList.getClubMembers());
//        window.showAndWait();
//    }

    public void removeAirportButtonPressed() throws IOException {
        ObservableList<ClubMember> clubMembers= clubMemberList.getClubMembers();
        ObservableList<ClubMember> selected= clubMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(clubMembers::remove);
        makeFilteredList(clubMembers);
        clubMemberList.updateList(clubMembers);

    }
    public void makeFilteredList(ObservableList<ClubMember> list){
        FilteredList<ClubMember> filteredList= new FilteredList<>(list, p->true);

        searchField.textProperty().addListener((observable, oldValue, newValue)->{
            filteredList.setPredicate(clubMember -> {
                if(newValue==null||newValue.isEmpty()){
                    return true;
                }
                if(clubMember.getName().toLowerCase().contains(newValue.toLowerCase())){
                    return true;
                }
                return false;
            });
        });
        SortedList<ClubMember> sortedList= new SortedList<>(filteredList);
        sortedList.comparatorProperty().bind(clubMembersTable.comparatorProperty());
        clubMembersTable.setItems(sortedList);
    }

    public void removeButtonAppear(MouseEvent mouseEvent) {
        removeButton.setVisible(true);
        editButton.setVisible(true);
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeClubMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(true);
        forsake.setVisible(true);
        confirm.setVisible(true);
    }
    public void confirmButtonPressed(ActionEvent actionEvent) {
        ObservableList<ClubMember> clubMembers= clubMemberList.getClubMembers();
        ObservableList<ClubMember> selected=clubMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(clubMembers::remove);
        makeFilteredList(clubMembers);
        clubMemberList.updateList(clubMembers);

    }

    public void forsakeButtonPressed(ActionEvent actionEvent) throws IOException {
        confirmationLabel.setVisible(false);
        forsake.setVisible(false);
        confirm.setVisible(false);
    }

    public void editButtonPressed() throws IOException {
        ClubMember selectedMember = clubMembersTable.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../View/FXML/Administrator/Edit/E_ClubMember.fxml"));
        loader.load();
        E_ClubMember controller = loader.getController();
        controller.initData(clubMemberList,selectedMember);
        Parent window = loader.getRoot();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Edit Club Member");
        stage.setScene(new Scene(window));
        stage.showAndWait();
    }
}
