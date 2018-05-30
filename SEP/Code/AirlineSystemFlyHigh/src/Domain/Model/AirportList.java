package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class AirportList {
    private ObservableList<Airport> airportList;

    public AirportList() {
        airportList = FXCollections.observableArrayList(
                new Airport("code", "name", "city", "postcode", "country", "numberOfGates"),
                new Airport("code", "name", "city", "postcode", "country", "numberOfGates")
        );

    }

    public ObservableList<Airport> getAirports() {
        return airportList;
    }


    public void updateList(ObservableList <Airport> airports) {
        airportList= airports;
    }
}
