package Controller;

import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.ClubMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable {

    @FXML AnchorPane anchorPane;
    @FXML TextField name;
    @FXML TextField idNumber;
    @FXML DatePicker birthdate;
    @FXML TextField phoneNumber;
    @FXML TextField email;
    @FXML TextField address;
    LocalDate membershipDate;
    private Model modelManager;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         membershipDate= LocalDate.of(Calendar.YEAR, Calendar.DAY_OF_MONTH, Calendar.MONTH);
         modelManager = new ModelManager();
    }

    public void register(ActionEvent actionEvent) {
        ClubMember temp = new ClubMember(name.getText(), idNumber.getText(), birthdate.getValue()
                , Integer.parseInt(phoneNumber.getText()), email.getText(), address.getText()
                , membershipDate, true);

        modelManager.addClubMember(temp);


        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.close();
    }

    public void RegistrationGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/LogIn.fxml"))));
    }


}
