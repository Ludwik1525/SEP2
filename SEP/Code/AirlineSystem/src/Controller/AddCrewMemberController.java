package Controller;

import Domain.Model.CrewMember;
import Domain.Model.Crew;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCrewMemberController  implements Initializable {
    @FXML
    AnchorPane anchorPane;
    @FXML TextField name;
    @FXML TextField position;
    @FXML TextField address;
    @FXML TextField id;
    @FXML TextField phoneNumber;
    @FXML TextField email;
    @FXML DatePicker birthday;
    ObservableList<CrewMember> items;
    public Crew crew = new Crew();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setItems(ObservableList <CrewMember> items) {
        this.items= items;
    }
    public void addCrewMemberFormGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }

    public void addCrewMemberToTheList(ActionEvent actionEvent) {
        items.add(new CrewMember(name.getText(), position.getText(), address.getText(), id.getText(), phoneNumber.getText(), email.getText(), birthday.getValue()));

        crew.updateList(items);

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();

    }
}
