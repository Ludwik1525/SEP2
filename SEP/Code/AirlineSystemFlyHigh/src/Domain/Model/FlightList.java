package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FlightList {
    private ObservableList<Flight> flightList;
    LocalDate date1 = LocalDate.of(1999,02,03);
    Airport airport= new Airport("code", "name", "city", "postcode", "country", 180);
    Airplane airplane= new Airplane("IDNumber", "model", 20, date1, date1);
    PassengerList passengerList = new PassengerList();
    Crew crew= new Crew();
    public FlightList() {
        System.out.println(passengerList.getPassengers().toString());
        flightList = FXCollections.observableArrayList(
                new Flight("flightNumber", date1, date1, airplane.getIDNumber(), crew, airport, airport,  "status")
        );

    }

    public ObservableList<Flight> getFlights() {
        return flightList;
    }


    public void updateList(ObservableList <Flight> flights) {
        flightList= flights;
    }
}
