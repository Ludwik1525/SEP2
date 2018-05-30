package Domain.Model;

import java.time.LocalDate;
import java.util.Date;

public class Flight {
    private String flightNumber;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    Airplane plane;
    Crew crew;
    private String departurePlace;
    private String arrivalPlace;
    Passengers passengers;
    private  String status;





    public Flight(String flightNumber, LocalDate departureTime, LocalDate arrivalTime, Airplane plane, Crew crew, Airport departure, Airport arrival, Passengers passenegers, String status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.plane=plane;
        this.crew=crew;
        this.passengers=passenegers;
        departurePlace=departure.getCity();
        arrivalPlace= arrival.getCity();
        this.status = status;
    }

    public Flight() {

    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }
    public void setDeparturePlace(Airport departure) {
        this.departurePlace = departure.getCity();
    }
    public void setArrivalPlace(Airport arrival) {
        this.arrivalPlace = arrival.getCity();
    }

    public void setNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDate getArrivalTime() {
        return arrivalTime;
    }

    public LocalDate getDepartureTime() {
        return departureTime;
    }
    public String getDeparturePlace() {
        return departurePlace;
    }
    public String getArrivalPlace() {
        return arrivalPlace;
    }
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return  "Flight number: "+getFlightNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }
}
