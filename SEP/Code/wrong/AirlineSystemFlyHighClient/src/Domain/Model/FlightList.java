package Domain.Model;

import Domain.Mediator.DatabaseAdapter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FlightList {
    private ObservableList<Flight> flightList;
    DatabaseAdapter adapter= new DatabaseAdapter();
    public FlightList() {
        flightList = adapter.loadFlights();

    }

    public ObservableList<Flight> getFlights() {
        return flightList;
    }


    public void updateList(ObservableList <Flight> flights) {
        flightList= flights;
    }
}
