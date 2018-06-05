package Controller.Edit;

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
    Crew crew;
    CrewMember crewMember;
    ObservableList<CrewMember> crewMembers;



    public void initData(CrewMember crewMember, Crew crew) {
        this.crew = crew;
        this.crewMember = crewMember;
        this.crewMembers = crew.getCrewMembers();
        nameField.setText(crewMember.getName());
        idField.setText(crewMember.getId());
        birthdayField.setValue(crewMember.getBirthdate());
        phoneNumberField.setText(String.valueOf(crewMember.getPhoneNumber()));
        emailField.setText(crewMember.getEmail());
        addresField.setText(crewMember.getAddress());
        positionField.setText(crewMember.getPosition());
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void confirmButtonPressed() {
        crewMembers.remove(crewMember);
        crewMembers.add(new CrewMember(nameField.getText(),positionField.getText(),addresField.getText()
                , idField.getText(),Integer.parseInt(phoneNumberField.getText()), emailField.getText(), birthdayField.getValue()));
        crew.updateList(crewMembers);
        Stage stage = (Stage) editCrewMemberPanel.getScene().getWindow();
        stage.close();
    }

    public void cancelButtonPressed() {
        Stage stage = (Stage) editCrewMemberPanel.getScene().getWindow();
        stage.close();
    }
}
