package Domain.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Flight {

    private int flightNumber;
    private LocalDate departureTime;
    private LocalDate arrivalTime;
    private Airplane plane;
    private String airplaneIdNumber;
    private Crew crew;
    private String departurePlace;
    private String arrivalPlace;
    private PassengerList passengers;
    private  String status;
    private Double price;


//    public Flight(int flightNumber, LocalDate departureTime, LocalDate arrivalTime, String airplaneIdNumber
//            , Crew crew, String departure, String arrival, String status, Double price) {
//        this.flightNumber = flightNumber;
//        this.departureTime = departureTime;
//        this.arrivalTime = arrivalTime;
//        this.airplaneIdNumber = airplaneIdNumber;
//        this.crew=crew;
//        this.passengers= new PassengerList();
//        this.departurePlace=departure;
//        this.arrivalPlace= arrival;
//        this.status = status;
//        this.price = price;
//    }
    public Flight(int flightNumber, LocalDate departureDate, LocalDate arrivalDate, String airplaneIdNumber
            , String departure, String arrival, String status, double price) {
        this.flightNumber = flightNumber;
        this.departureTime = departureDate;
        this.arrivalTime = arrivalDate;
        this.airplaneIdNumber = airplaneIdNumber;
       // this.crew=new Crew();
     //   this.passengers= new PassengerList();
        this.departurePlace=departure;
        this.arrivalPlace= arrival;
        this.status = status;
        this.price = price;
    }

//    public Flight() {
//
//    }

    public void setArrivalTime(LocalDate arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(LocalDate departureTime) {
        this.departureTime = departureTime;
    }

    public void setDeparturePlace(String departure) {
        this.departurePlace = departure;
    }

    public void setArrivalPlace(String arrival) {
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

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getFlightNumber() {
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

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  "Flight number: "+getFlightNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }
}
