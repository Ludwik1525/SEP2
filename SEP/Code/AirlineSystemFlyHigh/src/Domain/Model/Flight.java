package Domain.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Flight {

    private String flightNumber;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private Airplane plane;
    private String airplaneIdNumber;
    private Crew crew;
    private Airport departurePlace;
    private Airport arrivalPlace;
    private PassengerList passengers;
    private  String status;
    private Double price;

    public Flight(String flightNumber, LocalDate departureTime, LocalDate arrivalTime, String airplaneIdNumber
            , Crew crew, Airport departure, Airport arrival, String status, Double price) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplaneIdNumber = airplaneIdNumber;
        this.crew=crew;
        this.passengers= new PassengerList();
        this.departurePlace=departure;
        this.arrivalPlace= arrival;
        this.status = status;
        this.price = price;
    }
    public Flight(String flightNumber, LocalDate departureTime, LocalDate arrivalTime, String airplaneIdNumber
            , Airport departure, Airport arrival, String status, Double price) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.airplaneIdNumber = airplaneIdNumber;
        this.crew=new Crew();
        this.passengers= new PassengerList();
        this.departurePlace=departure;
        this.arrivalPlace= arrival;
        this.status = status;
        this.price = price;
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
        this.departurePlace = departure;
    }

    public void setArrivalPlace(Airport arrival) {
        this.arrivalPlace = arrival;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    public Airport getDeparturePlace() {
        return departurePlace;
    }

    public Airport getArrivalPlace() {
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

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "Flight number: "+getFlightNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }
}
