package Controller.Manage;

import Domain.Model.AirportList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class M_UserMain {
    @FXML AnchorPane anchorPane;
    @FXML AnchorPane personalInfo;
    @FXML private DatePicker returnDatePicker;
    @FXML private Label returnDateLabel;
    @FXML ChoiceBox <String> countryFrom=new ChoiceBox<>();
    @FXML ChoiceBox <String> airportFrom=new ChoiceBox<>();
    @FXML ChoiceBox <String> countryTo=new ChoiceBox<>();
    @FXML ChoiceBox <String> airportTo=new ChoiceBox<>();

    AirportList airportList= new AirportList();

    public void getAirports(){
        for(int i=0; i<airportList.getLength(); i++){
            countryFrom.getItems().add(airportList.getCountry(i));
            countryTo.getItems().add(airportList.getCountry(i));
        }countryFrom.getSelectionModel().select(0);
        countryTo.getSelectionModel().select(0);
    }
    public void filterAirportsFrom(){
        if(!countryFrom.getSelectionModel().isEmpty()){
            airportFrom.getItems().clear();
            for(int i=0; i<airportList.getLength();i++){
                if(countryFrom.getValue().equals(airportList.getCountry(i))){
                    airportFrom.getItems().add(airportList.getCity(i));
                    System.out.println("added");
                }
            }
        }
            }
    public void filterAirportsTo(){
        if(!countryTo.getSelectionModel().isEmpty()){
            airportTo.getItems().clear();
            for(int i=0; i<airportList.getLength();i++) {
                if (countryTo.getValue().equals(airportList.getCountry(i))) {
                    airportTo.getItems().add(airportList.getCity(i));
                }
            }
        }
    }

    public void ReturnDateChangeVisibility() {
        if (returnDatePicker.isVisible() == true) {
            returnDateLabel.setVisible(false);
            returnDatePicker.setVisible(false);
        } else {
            returnDateLabel.setVisible(true);
            returnDatePicker.setVisible(true);
        }

    }

    public void UserMainGoBack() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../../View/FXML/LogIn.fxml"))));
    }

    public void bookFlightButtonPressed(ActionEvent actionEvent) {
        personalInfo.setVisible(true);
    }
}
