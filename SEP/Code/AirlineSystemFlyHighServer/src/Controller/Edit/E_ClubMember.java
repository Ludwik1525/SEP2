package Controller.Edit;

import Controller.Controller;
import Controller.Manage.M_ClubMembers;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
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

    private Model modelManager;
    private M_ClubMembers controller;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(M_ClubMembers controller, Model modelManager) {
        this.controller = controller;
        this.modelManager = modelManager;
        nameField.setText(controller.getSelectedMember().getName());
        idField.setText(controller.getSelectedMember().getId());
        birthdayField.setValue(controller.getSelectedMember().getBirthday());
        phoneNumberField.setText(String.valueOf(controller.getSelectedMember().getPhoneNumber()));
        emailField.setText(controller.getSelectedMember().getEmail());
        addresField.setText(controller.getSelectedMember().getAddress());
        membershipDateField.setValue(controller.getSelectedMember().getMembershipDate());
    }

    public void confirmButtonPressed() {
        modelManager.getClubMembers().getClubMembers().remove(controller.getSelectedMember());

        ClubMember temp = new ClubMember(nameField.getText(), idField.getText(), birthdayField.getValue()
                , Integer.parseInt(phoneNumberField.getText()), emailField.getText(), addresField.getText()
                , membershipDateField.getValue(), true);

        modelManager.getClubMembers().getClubMembers().add(temp);
        modelManager.updateClubMember(temp);

        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editClubMemberPanel.getScene().getWindow();
        stage.close();
    }
}
