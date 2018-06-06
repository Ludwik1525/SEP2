package Controller.Edit;

import Domain.Mediator.DatabaseAdapter;
import Domain.Model.ClubMember;
import Domain.Model.ClubMemberList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class E_ClubMember implements Initializable {

    @FXML AnchorPane editClubMemberPanel;
    @FXML TextField nameField;
    @FXML TextField idField;
    @FXML DatePicker birthdayField;
    @FXML TextField phoneNumberField;
    @FXML TextField emailField;
    @FXML TextField addresField;
    @FXML DatePicker membershipDateField;

    DatabaseAdapter adapter= new DatabaseAdapter();

    private ClubMemberList clubMemberList;
    private ClubMember member;
    private ObservableList<ClubMember> members;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(ClubMemberList clubMemberList, ClubMember member) {
        this.clubMemberList = clubMemberList;
        this.member = member;
        this.members = clubMemberList.getClubMembers();
        nameField.setText(member.getName());
        idField.setText(member.getId());
        birthdayField.setValue(member.getBirthday());
        phoneNumberField.setText(String.valueOf(member.getPhoneNumber()));
        emailField.setText(member.getEmail());
        addresField.setText(member.getAddress());
        membershipDateField.setValue(member.getMembershipDate());
    }

    public void confirmButtonPressed() {
        members.remove(member);
        ClubMember temp = new ClubMember(nameField.getText(), idField.getText(), birthdayField.getValue()
                , Integer.parseInt(phoneNumberField.getText()), emailField.getText(), addresField.getText()
                , membershipDateField.getValue(), true);
        adapter.updateClubMember(temp);
       members.add(temp);
        clubMemberList.updateList(members);
        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();

        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();
        stage.close();
    }
}
