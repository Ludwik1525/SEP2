package Domain.Model;

import java.util.Date;

public class Flight {
    private String number;
    private Date departureTime;
    private Date arrivalTime;
    private  String status;

    public Flight(String number, Date departureTime, Date arrivalTime, String status) {
        this.number = number;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = status;
    }

    public Flight() {

    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return  "Flight number: "+getNumber()+"; Departure time: "+getDepartureTime()+"; Arrival time: "+
                getArrivalTime()+"; Status: "+getStatus();
    }
}
