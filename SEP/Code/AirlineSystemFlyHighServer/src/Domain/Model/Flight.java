package Domain.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Flight {

    private String flightNumber;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private Airplane plane;
    private String airplaneIdNumber;
    private Crew crew;
    private Airport departurePlace;
    private Airport arrivalPlace;
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
    public Flight(String flightNumber, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate,
                  LocalTime arrivalTime, String airplaneIdNumber, Airport departure, Airport arrival, String status, double price) {
        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.airplaneIdNumber = airplaneIdNumber;
       // this.crew=new Crew();
        this.passengers= new PassengerList();
        this.departurePlace=departure;
        this.arrivalPlace= arrival;
        this.status = status;
        this.price = price;
    }

//    public Flight() {
//
//    }


    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
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

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
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

    public void addPasanger(Passenger passenger) {
        passengers.addPassenger(passenger);
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

    public String getArrivalDateTime() {
        return getArrivalDate().toString()+" "+getArrivalTime().toString();
    }
    public String getDepartureDateTime() {
        return getDepartureDate().toString()+" "+getDepartureTime().toString();
    }

    @Override
    public String toString() {
        return  "Flight number: "+getFlightNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }

    private Airport searchAirport(String shortName) {
        AirportList airportList = new AirportList();
        for (int i = 0; i < airportList.getAirports().size(); i++) {
            if (airportList.getAirports().get(i).getShortInfo().equals(shortName))
                return airportList.getAirports().get(i);
        }
        return null;
    }
}
