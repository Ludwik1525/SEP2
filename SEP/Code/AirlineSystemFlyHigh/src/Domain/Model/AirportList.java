package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class AirportList {
    private ObservableList<Airport> airportList;

    public AirportList() {
        airportList = FXCollections.observableArrayList(
                new Airport("code", "name", "city", "postcode", "country", 150),
                new Airport("RandomCode", "othername", "city", "postcode", "country", 190)
        );

    }

    public ObservableList<Airport> getAirports() {
        return airportList;
    }


    public void updateList(ObservableList <Airport> airports) {
        airportList= airports;
    }
}
