package Controller;

import Domain.Mediator.Model;
import Domain.Mediator.ModelManager;
import Domain.Model.Airport;
import Domain.Model.Flight;
import Domain.Model.FlightList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class BookFlightController implements Initializable{

    @FXML private AnchorPane anchorPane;
    @FXML private Button bookFlightButton;
    @FXML private TableView<Flight> flightsTable;
    @FXML private TableColumn<Flight, String> flightNumberColumn;
    @FXML private TableColumn<Flight, Airport> departurePlaceColumn;
    @FXML private TableColumn<Flight, LocalDate> departureTimeColumn;
    @FXML private TableColumn<Flight, Airport> arrivalPlaceColumn;
    @FXML private TableColumn<Flight, LocalDate> arrivalTimeColumn;
    @FXML private TableColumn<Flight, Double> priceColumn;
    @FXML private Button backButton;
    private Model modelManager;
    private LocalDate departureDate;
    private String departurePlace;
    private String arrivalPlace;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        modelManager = new ModelManager();

        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) anchorPane.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/FXML/UserMain.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        bookFlightButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Flight selectedFlight = flightsTable.getSelectionModel().getSelectedItem();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("../View/FXML/BookFlightForm.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                BookFlightFormController controller = loader.getController();
                controller.initData(BookFlightController.this,modelManager);
                Parent window = loader.getRoot();
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Book flight");
                stage.setScene(new Scene(window));
                stage.showAndWait();
            }
        });
    }

    private ObservableList<Flight>  getFlights() {

        ObservableList<Flight> flights = FXCollections.observableArrayList();
        for (int i = 0; i <modelManager.getFlights().getFlights().size() ; i++) {
            if ((modelManager.getFlights().getFlights().get(i).getDepartureDate().equals(departureDate))
                    && (modelManager.getFlights().getFlights().get(i).getDeparturePlace().getShortInfo().equals(departurePlace))
                    &&(modelManager.getFlights().getFlights().get(i).getArrivalPlace().getShortInfo().equals(arrivalPlace))) {
                flights.add(modelManager.getFlights().getFlights().get(i));
            }
        }
        return flights;
    }

    public void parseData(LocalDate departureDate, String departurePlace, String arrivalPlace) {

        this.departureDate = departureDate;
        this.departurePlace = departurePlace;
        this.arrivalPlace = arrivalPlace;

        flightNumberColumn.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightNumber"));
        departurePlaceColumn.setCellValueFactory(new PropertyValueFactory<Flight, Airport>("departurePlace"));
        departureTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, LocalDate>("departureTime"));
        arrivalPlaceColumn.setCellValueFactory(new PropertyValueFactory<Flight, Airport>("arrivalPlace"));
        arrivalTimeColumn.setCellValueFactory(new PropertyValueFactory<Flight, LocalDate>("arrivalTime"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<Flight, Double>("price"));

        flightsTable.setItems(getFlights());
    }

    public void bookFlightButtonPressed() throws IOException {


    }

    public Flight getSelectedFlight() {
        return flightsTable.getSelectionModel().getSelectedItem();
    }
}
