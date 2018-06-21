package Controller.Edit;

import Controller.Manage.M_CrewMembers;
import Domain.Mediator.DatabaseAdapter;
import Domain.Mediator.Model;
import Domain.Model.Crew;
import Domain.Model.CrewMember;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class E_CrewMember implements Initializable {

    @FXML AnchorPane editCrewMemberPanel;
    @FXML TextField nameField;
    @FXML TextField idField;
    @FXML DatePicker birthdayField;
    @FXML TextField phoneNumberField;
    @FXML TextField emailField;
    @FXML TextField addresField;
    @FXML TextField positionField;
    private M_CrewMembers controller;
    private Model modelManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(M_CrewMembers controller, Model modelManager) {
        this.modelManager = modelManager;
        this.controller = controller;
        nameField.setText(controller.getSelectedMember().getName());
        idField.setText(controller.getSelectedMember().getId());
        birthdayField.setValue(controller.getSelectedMember().getBirthdate());
        phoneNumberField.setText(controller.getSelectedMember().getPhoneNumber()+"");
        emailField.setText(controller.getSelectedMember().getEmail());
        addresField.setText(controller.getSelectedMember().getAddress());
        positionField.setText(controller.getSelectedMember().getPosition());
    }


    public void confirmButtonPressed() {
        modelManager.getCrewMembers().getCrewMembers().remove(controller.getSelectedMember());

        modelManager.getCrewMembers().getCrewMembers().add(new CrewMember(nameField.getText(),positionField.getText(),addresField.getText()
                , idField.getText(),Integer.parseInt(phoneNumberField.getText()), emailField.getText(), birthdayField.getValue()));

        modelManager.updateCrewMember(new CrewMember(nameField.getText(),positionField.getText(),addresField.getText()
                , idField.getText(),Integer.parseInt(phoneNumberField.getText()), emailField.getText(), birthdayField.getValue()));

        Stage stage = (Stage) editCrewMemberPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editCrewMemberPanel.getScene().getWindow();
        stage.close();
    }
}
