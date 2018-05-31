package Domain.Model;

import java.time.LocalDate;
import java.util.Date;

public class Flight {

    private String flightNumber;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private Airplane plane;
    private String airplaneIdNumber;
    private Crew crew;
    private String departurePlace;
    private String arrivalPlace;
    private PassengerList passengers;
    private  String status;

    public Flight(String flightNumber, LocalDate departureTime, LocalDate arrivalTime, String airplaneIdNumber, Crew crew, Airport departure, Airport arrival, PassengerList passenegers, String status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplaneIdNumber = airplaneIdNumber;
        this.crew=crew;
        this.passengers=passenegers;
        this.departurePlace=departure.getCity();
        this.arrivalPlace= arrival.getCity();
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

    public void setAirplaneIdNumber(String airplaneIdNumber) {
        this.airplaneIdNumber = airplaneIdNumber;
    }

    public void setPlane(Airplane plane) {
        this.plane = plane;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public void setPassengers(PassengerList passengers) {
        this.passengers = passengers;
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

    public PassengerList getPassengers() {
        return passengers;
    }

    public Airplane getPlane() {
        return plane;
    }

    public Crew getCrew() {
        return crew;
    }

    public String getAirplaneIdNumber() {
        return airplaneIdNumber;
    }

    @Override
    public String toString() {
        return  "Flight number: "+getFlightNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }
}
