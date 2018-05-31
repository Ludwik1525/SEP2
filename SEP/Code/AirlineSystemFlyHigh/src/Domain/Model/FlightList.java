package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FlightList {
    private ObservableList<Flight> flightList;
    LocalDate date1 = LocalDate.of(Integer.parseInt("1999"), Integer.parseInt("02"), Integer.parseInt("03"));
    Airport airport= new Airport("code", "name", "city", "postcode", "country", "numberOfGates");
    Airplane airplane= new Airplane("IDNumber", "model", "numberOfSeats", date1, date1);
    PassengerList passengerList = new PassengerList();
    Crew crew= new Crew();
    public FlightList() {
        flightList = FXCollections.observableArrayList(
                new Flight("flightNumber", date1, date1, airplane.getIDNumber(), crew, airport,airport, passengerList, "status")

        );

    }

    public ObservableList<Flight> getFlights() {
        return flightList;
    }


    public void updateList(ObservableList <Flight> flights) {
        flightList= flights;
    }
}
