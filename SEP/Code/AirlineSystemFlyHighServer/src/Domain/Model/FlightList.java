package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FlightList {
    private ObservableList<Flight> flightList;

    public FlightList() {
        flightList = FXCollections.observableArrayList();
    }

    public FlightList(ObservableList<Flight> flightList) {
        this.flightList = flightList;
    }

    public ObservableList<Flight> getFlights() {
        return flightList;
    }


    public void updateList(ObservableList <Flight> flights) {
        flightList= flights;
    }
}
