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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClubMembersController implements Initializable {
    @FXML
    AnchorPane anchorPane;

    ClubMemberList clubMemberList;

    @FXML protected TableView<ClubMember> clubMembersTable;
    @FXML protected TableColumn<ClubMember, String> name;
    @FXML protected TableColumn<ClubMember, String> id;
    @FXML protected TableColumn<ClubMember, String> idType;
    @FXML protected TableColumn<ClubMember, String> nationality;
    @FXML protected TableColumn<ClubMember, LocalDate> birthday;
    @FXML protected TableColumn<ClubMember, String> phoneNumber;
    @FXML protected TableColumn<ClubMember, String> email;
    @FXML protected TableColumn<ClubMember, String> address;
    @FXML protected TableColumn<ClubMember, LocalDate> membershipDate;
    @FXML private Button removeButton;
    @FXML private TextField searchField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("name"));
        id.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("id"));
        idType.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("idType"));
        nationality.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("nationality"));
        birthday.setCellValueFactory(new PropertyValueFactory<ClubMember, LocalDate>("birthday"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("email"));
        address.setCellValueFactory(new PropertyValueFactory<ClubMember, String>("address"));
        membershipDate.setCellValueFactory(new PropertyValueFactory<ClubMember, LocalDate>("membershipDate"));

        clubMemberList= new ClubMemberList();
        clubMembersTable.setItems(clubMemberList.getClubMembers());

        clubMembersTable.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        id.setCellFactory(TextFieldTableCell.forTableColumn());
        idType.setCellFactory(TextFieldTableCell.forTableColumn());
        nationality.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellFactory(TextFieldTableCell.forTableColumn());

        clubMembersTable.getColumns().clear();
        clubMembersTable.getColumns().addAll(name, id, idType, nationality, birthday, phoneNumber, email, address, membershipDate);

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
    }

    public void goBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/Administrator/AdministratorMain.fxml"))));
    }


    public void removeClubMemberButtonPressed(ActionEvent actionEvent) throws IOException {
        ObservableList<ClubMember> clubMembers= clubMemberList.getClubMembers();
        ObservableList<ClubMember> selected= clubMembersTable.getSelectionModel().getSelectedItems();
        selected.forEach(clubMembers::remove);
        makeFilteredList(clubMembers);
        clubMemberList.updateList(clubMembers);
    }
}
