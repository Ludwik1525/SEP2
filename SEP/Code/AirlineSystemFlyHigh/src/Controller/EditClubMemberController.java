package Controller;

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

public class EditClubMemberController implements Initializable {

    @FXML AnchorPane editClubMemberPanel;
    @FXML TextField nameField;
    @FXML TextField idField;
    @FXML DatePicker birthdayField;
    @FXML TextField phoneNumberField;
    @FXML TextField emailField;
    @FXML TextField addresField;
    @FXML DatePicker membershipDateField;

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
        phoneNumberField.setText(member.getPhoneNumber());
        emailField.setText(member.getEmail());
        addresField.setText(member.getAddress());
        membershipDateField.setValue(member.getMembershipDate());
    }

    public void confirmButtonPressed() {
        members.remove(member);
        members.add(new ClubMember(nameField.getText(), idField.getText(), birthdayField.getValue()
                        , phoneNumberField.getText(), emailField.getText(), addresField.getText()
                , membershipDateField.getValue()));
        clubMemberList.updateList(members);
        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();
        stage.close();
    }
}
