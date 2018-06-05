package Domain.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class FlightList {
    private ObservableList<Flight> flightList;
    LocalDate date1 = LocalDate.of(2018,06,23);
    LocalDate date2 = LocalDate.of(2018,06,30);
    Airport london = new Airport("LCY", "London City Airport", "London", "postcode", "England", 150);
    Airport stockholm = new Airport("ARN", "Arlanda Airport", "Stockholm", "postcode", "Sweden", 190);
    Airport copenhagen = new Airport("CPH", "Copenhagen Airport", "Copenhagen", "postcode", "Denmark", 190);
    Airport oslo = new Airport("OSL", "Oslo Airport", "Oslo", "postcode", "Norway", 190);
    Airplane airplane= new Airplane("IDNumber", "model", 20, date1, date1);
    PassengerList passengerList = new PassengerList();
    Crew crew= new Crew();
    public FlightList() {
        System.out.println(passengerList.getPassengers().toString());
        flightList = FXCollections.observableArrayList(
                new Flight("flightNumber", date1, date1, airplane.getIDNumber(), crew, copenhagen, london,  "status",150.0),
                new Flight("anotherOne", date2, date2, airplane.getIDNumber(), crew, stockholm, oslo,  "status",150.0)
        );

    }

    public ObservableList<Flight> getFlights() {
        return flightList;
    }


    public void updateList(ObservableList <Flight> flights) {
        flightList= flights;
    }
}
